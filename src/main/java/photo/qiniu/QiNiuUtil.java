package photo.qiniu;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class QiNiuUtil {

    private static String ACCESS_KEY = "t9NZXPGfQqoapRzW-QVy5F0x5xkMAR9r0CPnfB2n";

    private static String SECRET_KEY = "a5Dyw47BTbGOLyKPeRiTepEfo7ueMaR0qKQUF4B1";

    // ------------------图片水印(水印样式来源于mybucket中的sy1样式)-------------------
    // 体育水印
    String fops = "imageView2/2/w/590/interlace/0/q/75|watermark/1/image/aHR0cDovL2xpZmVpeHBob3RvLnFpbml1ZG4uY29tL3RpeXUtd2F0ZXIyLnBuZw==/dissolve/70/gravity/SouthEast/dx/10/dy/10";

    private static final String RETURN_BODY = "{\"key\": $(key),\"width\": $(imageInfo.width),\"height\": $(imageInfo.height)}";
    /**
     * 设置token过期时间
     */
    private static final Long EXPIRES = 3600L;

    private static final Long MAX_FILE_SIZE = 10 * 1024 * 1024L;

    private static final String MIME_LIMIT = "image/*;audio/*;video/*";

    private static Map<String, String> tokenMap = new HashMap<String, String>();

    private static Map<String, Long> tokenTimeMap = new HashMap<String, Long>();
    // 密钥配置
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private StringMap getStringMap() {
	// 设置七牛上传策略
	StringMap map = new StringMap();
	map.put("returnBody", RETURN_BODY);
	map.put("fsizeLimit", MAX_FILE_SIZE);
	map.put("mimeLimit", MIME_LIMIT);
	return map;
    }

    private String getToken(String bucketName) {
	long curTime = System.currentTimeMillis();
	synchronized (tokenMap) {
	    String token = tokenMap.get(bucketName);
	    Long tokenTime = tokenTimeMap.get(bucketName);
	    if (token != null && tokenTime != null && curTime - tokenTime < EXPIRES * 1000) {
		return token;
	    }
	    StringMap map = getStringMap();
	    token = auth.uploadToken(bucketName, null, EXPIRES, map);
	    tokenTimeMap.put(bucketName, curTime);
	    tokenMap.put(bucketName, token);
	    return token;
	}
    }

    /**
     * 获取七牛token 简单
     * 
     * @param bucketName
     * @return
     */
    public String getUpToken(String bucketName) {
	return getUpToken(bucketName, null, -1);
    }

    /**
     * 获取七牛token 覆盖
     * 
     * @param bucketName
     * @return
     */
    public String getCoverUpToken(String bucketName, String key, Integer waterType) {
	if (waterType == -1) {
	    return getToken(bucketName);
	}
	StringMap map = getStringMap();
	// 上传策略中设置persistentOps字段和persistentPipeline字段
	if (waterType == 1) {
	    // bucketname为空间的名称，key为保存的文件名称
	    String urlbase64 = UrlSafeBase64.encodeToString(bucketName + ":" + key);
	    String pfops = fops + "|saveas/" + urlbase64;
	    map.putNotEmpty("persistentOps", pfops);
	    map.putNotEmpty("persistentPipeline", "lifeix_pipeline");// 设置七牛处理队列加快处理速度，必须传
	}
	return auth.uploadToken(bucketName, key, EXPIRES, map);
    }

    /**
     * 获取七牛token 加水印
     * 
     * @param bucketName
     * @param key
     * @param waterType
     * @return
     */
    public String getUpToken(String bucketName, String key, Integer waterType) {

	if (waterType == -1) {
	    return getToken(bucketName);
	}
	StringMap map = getStringMap();
	// 上传策略中设置persistentOps字段和persistentPipeline字段
	if (waterType == 1) {
	    // bucketname为空间的名称，key为保存的文件名称
	    String urlbase64 = UrlSafeBase64.encodeToString(bucketName + ":" + key);
	    String pfops = fops + "|saveas/" + urlbase64;
	    map.putNotEmpty("persistentOps", pfops);
	    map.putNotEmpty("persistentPipeline", "lifeix_pipeline");// 设置七牛处理队列加快处理速度，必须传
	}
	return auth.uploadToken(bucketName, null, EXPIRES, map);
    }

    /**
     * 七牛上传
     * 
     * @param inputStream
     * @param token
     * @param filename
     * @return
     * @throws IOException
     */
    public Response upload(InputStream inputStream, String token, String filename) throws IOException {
	// 创建上传对象
	UploadManager uploadManager = new UploadManager();
	Response res = null;
	try {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[4096];
	    int n = 0;

	    try {
		while (-1 != (n = inputStream.read(buffer))) {
		    output.write(buffer, 0, n);
		}
		byte[] ret = output.toByteArray();
		res = uploadManager.put(ret, filename, token);
	    } catch (IOException e) {
		e.printStackTrace();
	    }

	    // 打印返回的信息
	    System.out.println(res.bodyString());
	} catch (QiniuException e) {
	    res = e.response;
	    // 请求失败时打印的异常的信息
	    System.out.println(res.toString());
	    try {
		// 响应的文本信息
		System.out.println(res.bodyString());
	    } catch (QiniuException e1) {
		// ignore
		e1.printStackTrace();
	    }
	} finally {
	    inputStream.close();
	}
	return res;
    }

    public static void main(String args[]) throws IOException {

	// 访问地址：http://photo.test.l99.com/test071505.jpg

	String filename = "test071506.jpg";
	QiNiuUtil util = new QiNiuUtil();
	String token = util.getCoverUpToken("lifeixphoto-test", filename, 1);
	File file = new File("D:\\photo\\2\\2013082208595.jpg");
	InputStream inputStream = new FileInputStream(file);
	util.upload(inputStream, token, filename);

    }
}