package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Common {

    public void download() {
	try {
	    String filePath = "D:\1.txt";
	    File file = new File(filePath);
	    String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);// 得到文件名
	    fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");// 把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
	    response.setContentType("application/octet-stream");// 告诉浏览器输出内容为流
	    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);// Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
	    String len = String.valueOf(file.length());
	    response.setHeader("Content-Length", len);// 设置内容长度
	    OutputStream out = response.getOutputStream();
	    FileInputStream in = new FileInputStream(file);
	    byte[] b = new byte[1024];
	    int n;
	    while ((n = in.read(b)) != -1) {
		out.write(b, 0, n);
	    }
	    in.close();
	    out.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {

    }
}
