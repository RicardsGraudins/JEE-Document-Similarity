package ie.gmit.sw;

import java.io.IOException;

import com.db4o.*;

//Singleton - only one object gets created to handle database services.
public class DatabaseHandler {
	private static DatabaseHandler firstInstance = null;
	static boolean firstThread = true;
	private static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	private ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	private DatabaseService dbImpl = new DatabaseImpl();
	
	private DatabaseHandler(){ }
	
	public static DatabaseHandler getInstance() {
		//If threads try to create instances of this class
		if(firstInstance == null){
			
			firstThread = false;
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//catch
		}//if
		
		//Synchronized when first object is created
		synchronized(DatabaseHandler.class){
			if(firstInstance == null){
				//lazy instantiation
				firstInstance = new DatabaseHandler();
			}//if
		}//synchronized
		return firstInstance;
	}//getInstance

	//Save the Document object
	public void storeDocument(Document document) throws IOException {
		//dbImpl.storeDocument(db, document);
		dbImpl.retrieveAll(db);
		//db.close();
	}//storeDocument
	
	//Retrieve specific Document object with id
	public Document retrieveDocument(String id) throws IOException {
		Document doc = new Document("", "");
		doc = dbImpl.retrieveDocumentById(db, id);
		db.close();
		return doc;
	}//retrieveDocument
}//DatabaseHandler