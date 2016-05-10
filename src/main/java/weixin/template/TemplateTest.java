package weixin.template;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class TemplateTest {

    // 凭证获取（GET）
    public final static String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    public static String sendUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    public static void main(String args[]) {
	String appId = "wxd78f00d036377692";
	String appSecret = "64283b4988a57606a86ee97edc3ddc1e";
	String openId = "o3lVhwlGd5Np9UUTO2g6owysUkaY";

	// sendMess(appId, appSecret, openId);

	send_template_message(appId, appSecret, openId);
    }

    /**
     * 获取接口访问凭证
     *
     * @param appid
     *            凭证
     * @param appsecret
     *            密钥
     * @return
     */
    public static WxToken getToken(String appid, String appsecret) {
	WxToken token = null;
	String requestUrl = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
	// 发起GET请求获取凭证
	JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

	if (null != jsonObject) {
	    try {
		token = new WxToken();
		token.setAccessToken(jsonObject.getString("access_token"));
		token.setExpiresIn(jsonObject.getInt("expires_in"));
	    } catch (Exception e) {
		token = null;
		// 获取token失败
		e.printStackTrace();
	    }
	}
	return token;
    }

    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
	JSONObject jsonObject = null;
	StringBuffer buffer = new StringBuffer();
	try {
	    // 创建SSLContext对象，并使用我们指定的信任管理器初始化
	    TrustManager[] tm = { new MyX509TrustManager() };
	    SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
	    sslContext.init(null, tm, new java.security.SecureRandom());
	    // 从上述SSLContext对象中得到SSLSocketFactory对象
	    SSLSocketFactory ssf = sslContext.getSocketFactory();

	    URL url = new URL(requestUrl);
	    HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
	    httpUrlConn.setSSLSocketFactory(ssf);

	    httpUrlConn.setDoOutput(true);
	    httpUrlConn.setDoInput(true);
	    httpUrlConn.setUseCaches(false);
	    // 设置请求方式（GET/POST）
	    httpUrlConn.setRequestMethod(requestMethod);

	    if ("GET".equalsIgnoreCase(requestMethod))
		httpUrlConn.connect();

	    // 当有数据需要提交时
	    if (null != outputStr) {
		OutputStream outputStream = httpUrlConn.getOutputStream();
		// 注意编码格式，防止中文乱码
		outputStream.write(outputStr.getBytes("UTF-8"));
		outputStream.close();
	    }

	    // 将返回的输入流转换成字符串
	    InputStream inputStream = httpUrlConn.getInputStream();
	    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
	    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

	    String str = null;
	    while ((str = bufferedReader.readLine()) != null) {
		buffer.append(str);
	    }
	    bufferedReader.close();
	    inputStreamReader.close();
	    // 释放资源
	    inputStream.close();
	    inputStream = null;
	    httpUrlConn.disconnect();
	    jsonObject = JSONObject.fromObject(buffer.toString());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return jsonObject;
    }

    /**
     * 发送模板消息 appId 公众账号的唯一标识 appSecret 公众账号的密钥 openId 用户标识
     */
    public static void send_template_message(String appId, String appSecret, String openId) {
	WxToken token = getToken(appId, appSecret);
	String access_token = token.getAccessToken();// TiM8vdmDuBaOq7kIo6FHDguu_XcHEBw3vBSUCyundiMsbsx0tEiZc6w_XUyNiLRyiscSHKhiMrvCv_UbmhT_98L5NzKLhiyjr-nAcU14AQYeEZHccAD0nrgeCy53hxyYGPZdAHANWG

	String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
	WxTemplate temp = new WxTemplate();
	temp.setUrl("http://weixin.qq.com/download");
	temp.setTouser(openId);
	temp.setTopcolor("#000000");
	//
	temp.setTemplate_id("esYUaDrrAEwz8gC2taiZ69eir2KZysa-emd14SIsamo");
	Map<String, TemplateData> m = new HashMap<String, TemplateData>();
	TemplateData first = new TemplateData();
	first.setColor("#000000");
	first.setValue("订单详情：您在4月13日的比赛[曼城VS巴黎圣日耳曼]中选择[让球胜平负]玩法,下注5龙筹.");
	m.put("first", first);

	TemplateData keyword1 = new TemplateData();
	keyword1.setColor("#000000");
	keyword1.setValue("2016/4/11 17:00:00 ");
	m.put("keyword1", keyword1);

	TemplateData keyword2 = new TemplateData();
	keyword2.setColor("#000000");
	keyword2.setValue("NO00000001");
	m.put("keyword2", keyword2);

	TemplateData remark = new TemplateData();
	remark.setColor("#000000");
	remark.setValue("比赛结果：竞猜胜利，竞赢5龙筹");
	m.put("remark", remark);
	temp.setData(m);

	String jsonString = JSONObject.fromObject(temp).toString();

	JSONObject jsonObject = httpRequest(url, "POST", jsonString);

	System.out.println(jsonObject);
	int result = 0;
	if (null != jsonObject) {
	    if (0 != jsonObject.getInt("errcode")) {
		result = jsonObject.getInt("errcode");
		System.out.println("result:" + result);
	    }
	}
    }

}
