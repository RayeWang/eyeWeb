<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="org.eclipse.jetty.util.security.Credential.MD5"%>
<%@page import="java.io.File"%>
<%@ page contentType="image/jpeg"
	import="java.io.OutputStream,java.io.InputStream,java.net.URL,java.net.URLConnection"
	language="java"%>
<%
	//response.reset();
	try {
		OutputStream os = response.getOutputStream();
		String picPath = request.getQueryString();
		picPath = picPath.substring(4, picPath.length());
		String Save_Location=getServletContext().getRealPath("/");
		File file = new File(Save_Location+"//tempimg//"+MD5.digest(picPath).substring(4)+".jpg");
		if(file.exists()){
			FileInputStream fis = new FileInputStream(file);
			int len;
			byte[] b = new byte[1024];
			while ((len = fis.read(b)) != -1) { // 循环读取
				os.write(b, 0, len); // 写入到输出流
			}
			os.flush();
			fis.close();
			os.close();
			out.clear();
			out = pageContext.pushBody();
		}else{
			URLConnection u = new URL(picPath).openConnection();
			InputStream in = u.getInputStream();
			FileOutputStream fos = new FileOutputStream(file);
			if (null != in) {
				int len;
				byte[] b = new byte[1024];
				while ((len = in.read(b)) != -1) { // 循环读取
					os.write(b, 0, len); // 写入到输出流
					fos.write(b, 0, len);
				}
				fos.flush();
				fos.close();
				os.flush();
				in.close();
			}
			os.close();
			out.clear();
			out = pageContext.pushBody();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>