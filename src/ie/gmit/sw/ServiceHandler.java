package ie.gmit.sw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

@SuppressWarnings("serial")
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
                 maxFileSize=1024*1024*10,
                 maxRequestSize=1024*1024*50)
public class ServiceHandler extends HttpServlet {
	@SuppressWarnings("unused")
	private String environmentalVariable = null;
	private static long jobNumber = 0;
	//shared variables
	public static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	//
	//
	
	public ServiceHandler(){
		super();
	}
	
	//public void init() throws ServletException {
	//	ServletContext ctx = getServletContext();
	//	environmentalVariable = ctx.getInitParameter("SOME_GLOBAL_OR_ENVIRONMENTAL_VARIABLE");
	//}//init

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		DatabaseImpl dbImpl = new DatabaseImpl();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
		
		
		/* 
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
		while ((line = br.readLine()) != null) {
			out.print(line);
		}
		*/
		//ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		//DatabaseImpl dbImpl = new DatabaseImpl();
		//Save the uploaded document to db4o
		/*
		Document d = new Document(title, line);
		dbImpl.storeDocument(db, d);
		dbImpl.retrieveAll(db);
		System.out.println("============================================");
		dbImpl.retrieveDocument(db, d);
		*/
		//out.print("</font>");	
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}//doPost
}//ServiceHandler