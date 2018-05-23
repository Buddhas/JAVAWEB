package com.servletSmartUpload;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class servletSmartUpload
 */
@WebServlet("/servletSmartUpload")
public class servletSmartUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletSmartUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path ="D:";  
		SmartUpload smartUpload = new SmartUpload(); 
		smartUpload.setCharset("UTF-8");
		smartUpload.initialize(this.getServletConfig(),request,response); 
		try {  
		      //设定上传限制  
		      //限制每个上传文件的最大长度;将最大设定为1024*1024*20  
		      smartUpload.setMaxFileSize(1024*1024*10);     
		      //限制总上传数据的长度  
		      smartUpload.setTotalMaxFileSize(1024*1024*20);  
		      //限制允许上传的文件类型、允许doc、txt、bat文件  
		      smartUpload.setAllowedFilesList("doc,txt,bat,pdf,jpg");  
		      //限制禁止上传的文件类型,禁止exe、jsp、和没有扩展名的文件  
		      smartUpload.setDeniedFilesList("exe,jsp,,");  
		      //上传文件  
		      smartUpload.upload();  
		      //将文件保存到指定的目录下  
		      smartUpload.save(path);  
		    } catch (SQLException e) {  
		      e.printStackTrace();  
		    } catch (SmartUploadException e) {  
		      e.printStackTrace();  
		    }  
		for (int i = 0; i < smartUpload.getFiles().getCount(); i++) {  
		      com.jspsmart.upload.File  myFile =smartUpload.getFiles().getFile(i);  
		      //若文件表单中的文件选项没有选择文件则继续  
		      if(myFile.isMissing())  
		        continue;  
		      //显示当前文件的信息  
		      response.setContentType("text/html;charset=utf-8");  
		      PrintWriter out = response.getWriter();  
		      out.println("<table border='1'>");  
		      out.println("<tr><td>表单选项</td><td>"+myFile.getFieldName()+"</td></tr>");  
		      out.println("<tr><td>文件长度:</td><td>"+myFile.getSize()+"</td></tr>");  
		      out.println("<tr><td>文件名</td><td>"+myFile.getFileName()+"</td></tr>");  
		      out.println("<tr><td>文件扩展名</td><td>"+myFile.getFileExt()+"</td></tr>");  
		      out.println("<tr><td>文件全名</td><td>"+myFile.getFilePathName()+"</td></tr>");  
		      out.println("</table><br>");  
		    }  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
