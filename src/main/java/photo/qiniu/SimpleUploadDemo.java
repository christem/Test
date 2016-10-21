package photo.qiniu;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class SimpleUploadDemo {
    // 设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = "t9NZXPGfQqoapRzW-QVy5F0x5xkMAR9r0CPnfB2n";

    private static String SECRET_KEY = "a5Dyw47BTbGOLyKPeRiTepEfo7ueMaR0qKQUF4B1";
    // 要上传的空间
    String bucketname = "lifeixphoto-test";
    // 上传到七牛后保存的文件名
    String key = "2015101007379.jpg";
    // 上传文件的路径
    String filePath = "D:\\photo\\1\\" + key;

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 创建上传对象
    UploadManager uploadManager = new UploadManager();

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
	return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
	try {
	    // 调用put方法上传
	    Response res = uploadManager.put(filePath, key, getUpToken());
	    // 打印返回的信息
	    System.out.println(res.bodyString());
	} catch (QiniuException e) {
	    Response r = e.response;
	    // 请求失败时打印的异常的信息
	    System.out.println(r.toString());
	    try {
		// 响应的文本信息
		System.out.println(r.bodyString());
	    } catch (QiniuException e1) {
		e1.printStackTrace();
	    }
	}
    }

    public static void main(String args[]) throws IOException {
	new SimpleUploadDemo().upload();
    }

}
