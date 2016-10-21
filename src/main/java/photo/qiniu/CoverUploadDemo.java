package photo.qiniu;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class CoverUploadDemo {
    // 设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = "t9NZXPGfQqoapRzW-QVy5F0x5xkMAR9r0CPnfB2n";

    private static String SECRET_KEY = "a5Dyw47BTbGOLyKPeRiTepEfo7ueMaR0qKQUF4B1";
    // 要上传的空间
    String bucketname = "lifeixphoto-test";
    // 上传到七牛后保存的文件名
    String key = "2015101007378.jpg";
    // 上传文件的路径
    String filePath = "D:\\photo\\1\\2015101007375.jpg";

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 创建上传对象
    UploadManager uploadManager = new UploadManager();

    private static final String RETURN_BODY = "{\"key\": $(key),\"width\": $(imageInfo.width),\"height\": $(imageInfo.height)}";
    /**
     * 设置token过期时间
     */
    private static final Long EXPIRES = 2 * 3600L;

    private static final Long MAX_FILE_SIZE = 10 * 1024 * 1024L;

    private static final String MIME_LIMIT = "image/*;audio/*;video/*";

    String fops = "imageView2/2/w/590/interlace/0/q/75|watermark/1/image/aHR0cDovL2xpZmVpeHBob3RvLnFpbml1ZG4uY29tL3RpeXUtd2F0ZXIyLnBuZw==/dissolve/70/gravity/SouthEast/dx/10/dy/10";

    // 覆盖上传
    public String getUpToken() {
	// <bucket>:<key>，表示只允许用户上传指定key的文件。在这种格式下文件默认允许“修改”，已存在同名资源则会被本次覆盖。
	// 第三个参数是token的过期时间
	StringMap map = new StringMap();
	// // 可以对转码后的文件进行使用saveas参数自定义命名，当然也可以不指定文件会默认命名并保存在当前空间。
	// // saveBucket+":"+saveKey
	String urlbase64 = UrlSafeBase64.encodeToString(bucketname + ":" + key); // bucketname为空间的名称，key为保存的文件名称
	String pfops = fops + "|saveas/" + urlbase64;
	map.putNotEmpty("persistentOps", pfops);
	map.putNotEmpty("persistentPipeline", "lifeix_pipeline");
	//
	// map.put("returnBody", RETURN_BODY);
	// map.put("expires", EXPIRES);
	// map.put("insertOnly", 0);
	// map.put("fsizeLimit", MAX_FILE_SIZE);
	// map.put("mimeLimit", MIME_LIMIT);

	return auth.uploadToken(bucketname, null, 3600, map);
    }

    public void upload() throws IOException {
	try {
	    // 调用put方法上传，这里指定的key和上传策略中的key要一致
	    Response res = uploadManager.put(filePath, null, getUpToken());
	    // 打印返回的信息
	    System.out.println(res.bodyString());
	} catch (QiniuException e) {
	    Response r = e.response;
	    // 请求失败时打印的异常信息
	    System.out.println(r.toString());
	    try {
		// 响应的文本信息
		System.out.println(r.bodyString());
	    } catch (QiniuException e1) {
		// ignore
	    }
	}
    }

    public static void main(String args[]) throws IOException {
	new CoverUploadDemo().upload();
    }
}
