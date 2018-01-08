package ie.gmit.sw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*50)
public class ServiceHandler extends HttpServlet {
	@SuppressWarnings("unused")
	private String environmentalVariable = null;
	private static long jobNumber = 0;
	
	public ServiceHandler(){
		super();
	}

	@SuppressWarnings("static-access")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html"); 	
		PrintWriter out = resp.getWriter(); 
		String title = req.getParameter("txtTitle");
		String taskNumber = req.getParameter("frmTaskNumber");
		Part part = req.getPart("txtDocument");

		out.print("<html><head><title>A JEE Application for Measuring Document Similarity</title>");		
		out.print("</head>");		
		out.print("<body>");		

		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			jobNumber++;
		}else{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/poll");
			dispatcher.forward(req,resp);
		}
		
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<H3>Document Title: " + title + "</H3>");
		
		out.print("<form name=\"frmRequestDetails\" action=\"poll\">");
		out.print("<input name=\"txtTitle\" type=\"hidden\" value=\"" + title + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
		out.print("</script>");
		
		out.print("<h3>Uploaded Document</h3>");	
		out.print("<font color=\"0000ff\">");
		BufferedReader br = new BufferedReader(new InputStreamReader(part.getInputStream()));
		String line = null;
		String unfilteredText = "";
		while ((line = br.readLine()) != null) {
			out.print(line);
			unfilteredText = unfilteredText + line;
		}//while
		
		//Replace all special characters with space
		String text = unfilteredText.replaceAll("[^a-zA-Z0-9]+"," ");
		Document document = new Document(title, text);
		//Start new worker
		Worker worker = new Worker(document);
		worker.main(null);
		
		out.print("</font>");	
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}//doPost
}//ServiceHandler