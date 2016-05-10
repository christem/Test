package freemaker;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @title 基于Freemarker替换Java字符串定义变量
 * 
 */
public class FreemarkerUtil {

    private Configuration freemarker_cfg = null;

    /**
     * 获取freemarker的配置. freemarker本身支持classpath,目录和从ServletContext获取.
     */
    protected Configuration getFreeMarkerCFG() {
	if (null == freemarker_cfg) {
	    // Initialize the FreeMarker configuration;
	    // - Create a configuration instance
	    freemarker_cfg = new Configuration();

	    // - FreeMarker支持多种模板装载方式,可以查看API文档,都很简单:路径,根据Servlet上下文,classpath等等

	    // htmlskin是放在classpath下的一个目录
	    freemarker_cfg.setClassForTemplateLoading(this.getClass(), "/htmlskin");
	}

	return freemarker_cfg;
    }

    /**
     * 生成静态文件.
     *
     * @param templateFileName
     *            模板文件名,相对htmlskin路径,例如"/tpxw/view.ftl"
     * @param propMap
     *            用于处理模板的属性Object映射
     * @param htmlFilePath
     *            要生成的静态文件的路径,相对设置中的根路径,例如 "/tpxw/1/2005/4/"
     * @param htmlFileName
     *            要生成的文件名,例如 "1.htm"
     */
    public boolean geneHtmlFile(String templateFileName, Map propMap, String htmlFilePath, String htmlFileName) {
	String sRootDir = "d:/htmlfile";

	try {
	    StringTemplateLoader stringLoader = new StringTemplateLoader();
	    stringLoader.putTemplate("test", templateFileName);
	    @SuppressWarnings("deprecation")
	    Configuration cfg = new Configuration();
	    cfg.setTemplateLoader(stringLoader);
	    Template t = cfg.getTemplate("test");


	    // 如果根路径存在,则递归创建子目录
	    creatDirs(sRootDir, htmlFilePath);

	    File afile = new File(sRootDir + "/" + htmlFilePath + "/" + htmlFileName);

	    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(afile)));

	    t.process(propMap, out);
	} catch (TemplateException e) {
	    e.printStackTrace();
	    return false;
	} catch (IOException e) {
	    e.printStackTrace();
	    return false;
	}

	return true;
    }

    /**
     * 创建多级目录
     *
     * @param aParentDir
     *            String
     * @param aSubDir
     *            以 / 开头
     * @return boolean 是否成功
     */
    public static boolean creatDirs(String aParentDir, String aSubDir) {
	File aFile = new File(aParentDir);
	if (aFile.exists()) {
	    File aSubFile = new File(aParentDir + aSubDir);
	    if (!aSubFile.exists()) {
		return aSubFile.mkdirs();
	    } else {
		return true;
	    }
	} else {
	    return false;
	}
    }

    /**
     * 基于Map类型
     * 
     * @param input
     *            替换 key/value
     * @param templateName
     *            模板名
     * @param templateStr
     *            对应模板字符串
     * @return
     */
    public static String freemarkerProcess(Map<String, Object> input, String templateName, String templateStr) {

	if (input == null || input.isEmpty()) {
	    return null;
	}

	StringTemplateLoader stringLoader = new StringTemplateLoader();
	stringLoader.putTemplate(templateName, templateStr);
	@SuppressWarnings("deprecation")
	Configuration cfg = new Configuration();
	cfg.setTemplateLoader(stringLoader);
	try {
	    Template templateCon = cfg.getTemplate(templateName);
	    StringWriter writer = new StringWriter();
	    templateCon.process(input, writer);
	    return writer.toString();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (TemplateException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public static void main(String[] args) {
	/**
	 * 简单的模板填充数据
	 */
	// Long time1 = System.currentTimeMillis();
	// String template =
	// "你好${姓名!''}，今天是${date?string('yyyy-MM-dd')}.${姓名!''}${姓名!''}${姓名!''}${姓名!''}${姓名!''}${姓名!''}${姓名!''}${姓名!''}";
	// // 变量参考freemarker语法
	// Map<String, Object> m = new HashMap<String, Object>();
	// m.put("姓名", "sy");
	// m.put("date", new Date());
	// System.out.println(freemarkerProcess(m, "消息提醒", template));
	// System.out.println(System.currentTimeMillis() - time1);
	//
	// Long time2 = System.currentTimeMillis();
	// String template2 = "你好%s，今天是%s%s%s%s%s%s%s%s%s"; // 变量参考freemarker语法
	// SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd");
	// System.out.println(String.format(template2, "sy",
	// formatDateTime.format(new Date()), "sy", "sy", "sy", "sy", "sy",
	// "sy", "sy", "sy"));
	// System.out.println(System.currentTimeMillis() - time2);

	/**
	 * 生成html
	 */
	Long time1 = System.currentTimeMillis();
	NewsItem aItem = new NewsItem();
	aItem.setTitle("测试Freemaker");
	aItem.setShowContent(100);
	aItem.setAddtime(new Date());

	FreemarkerUtil test = new FreemarkerUtil();

	Map root = new HashMap();
	root.put("newsitem", aItem);

	String sGeneFilePath = "/test/";

	String sFileName = "1.htm";

	String templateStr = "<html>" + "<head>" + "<title>查看文章: ${newsitem.title?string} </title>" + "</head>" + "<body>"
	        + "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\">" + "<tr><td>"
	        + "<table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"6\" >" + " <tr>"
	        + "      <td height=\"10\" align=\"left\" colspan=2 ></td>" + "    </tr>" + "    <tr>"
	        + "        <td align=\"left\" width=\"538\" >"
	        + "        <strong>${newsitem.title}</strong> ${newsitem.title?string}( ${newsitem.addtime?date} )"
	        + "          </td>" + "          <td align=\"right\">" + "   <a href=\"index.jsp\">返回</a>"
	        + "   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "          </td>" + "    </tr>"
	        + "    <tr>                     " + "         <td align=\"left\" valign=top colspan=2>"
	        + "         <hr align=\"left\"  width=\"95%\" size=\"1\" noshade color=\"#cc0000\" >" + "         </td>"
	        + "    </tr>" + "    <tr>                    " + "      <td colspan=2>${newsitem.showContent}" + "   </td>"
	        + "    </tr>" + "</table>                     " + "<br>" + "</td></tr>" + "</table>" + "</body>" + "</html>";

	boolean bOK = test.geneHtmlFile(templateStr, root, sGeneFilePath, sFileName);
	System.out.println(System.currentTimeMillis() - time1);
    }

    /*
    "<html>"+
    "<head>"+
    "<title>查看文章: ${newsitem.title} </title>"+
    "</head>"+
    "<body>"+
    "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\">"+
    "<tr><td>"+
    "<table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"6\" >"+
    " <tr>"+
    "      <td height=\"10\" align=\"left\" colspan=2 ></td>"+
    "    </tr>"+
    "    <tr>"+
    "        <td align=\"left\" width=\"538\" >"+
    "        <strong>${newsitem.title}</strong> ( ${newsitem.addtime} )"+
    "          </td>"+
    "          <td align=\"right\">"+
    "   <a href=\"index.jsp\">返回</a>"+
    "   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
    "          </td>"+
    "    </tr>"+
    "    <tr>                     "+
    "         <td align=\"left\" valign=top colspan=2>"+
    "         <hr align=\"left\"  width=\"95%\" size=\"1\" noshade color=\"#cc0000\" >"+
    "         </td>"+
    "    </tr>"+
    "    <tr>                    "+
    "      <td colspan=2>${newsitem.showContent}"+
    "   </td>"+
    "    </tr>"+
    "</table>                     "+
    "<br>"+
    "</td></tr>"+
    "</table>"+
    "</body>"+
    "</html>
    */

}
