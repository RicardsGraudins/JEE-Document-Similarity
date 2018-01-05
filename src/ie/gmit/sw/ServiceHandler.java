package ie.gmit.sw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
	private static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	private BlockingQueue<Shingle> queue = new ArrayBlockingQueue<Shingle>(200);
	
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
		}
		
		//Remove all the special characters and replace with space
		System.out.println("================================================");
		String text = unfilteredText.replaceAll("[^a-zA-Z0-9]+"," ");
		System.out.println(text);
		
		//test
		String threeWords = "";
		int counter = 0;
		Shingle s = new Shingle(0,0);
		
		//split the text into array of strings
		String[] words = text.split(" ");
		
		//split the words array into shingles with 3 words each
		for(int i = 0; i < words.length; i++){
			//System.out.println(words[i]);
			counter++;
			threeWords = threeWords + " " + words[i];
			if(counter == 3){
				System.out.println(threeWords);
				threeWords = threeWords.toLowerCase();
				s.setDocId(0);
				s.setHashCode(threeWords.hashCode());
				try {
					queue.put(s);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(s.toString());
				threeWords = "";
				counter = 0;
			}
		}
		System.out.println("===========================");
		System.out.println(queue.remainingCapacity());
		System.out.println(queue.toString());
		queue.clear();
		/*
		//Save the document...
		Document d = new Document(title, text);
		dbImpl.storeDocument(db, d);
		dbImpl.retrieveDocument(db, d);
		System.out.println("=======================");
		
		//Load up a document from DB to compare against..
		Document d2 = new Document("", "");
		d2 = dbImpl.retrieveDocumentById(db, title);
		System.out.println("===========d2=============");
		System.out.println(d2.toString());
		
		//Update the document id
		System.out.println("============Update==========");
		dbImpl.updateDocument(db, title, "Road2");
		
		//Delete the document
		System.out.println("========delete============");
		dbImpl.deleteDocument(db, "Road2");
		
		//Retrieve all documents..
		System.out.println("=========retrieve===========");
		dbImpl.retrieveAll(db);
		*/
		
		out.print("</font>");	
	}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}//doPost
}//ServiceHandler