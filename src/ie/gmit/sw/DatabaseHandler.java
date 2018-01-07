package ie.gmit.sw;

import java.io.IOException;

import com.db4o.*;
import com.db4o.ext.StoredClass;

//Singleton
public class DatabaseHandler {
	private static DatabaseHandler firstInstance = null;
	static boolean firstThread = true;
	private static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	private ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	private DatabaseImpl dbImpl = new DatabaseImpl();
	
	private DatabaseHandler(){ }
	
	public static DatabaseHandler getInstance() {
		if(firstInstance == null){
			
			firstThread = false;
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//catch
		}//if
		
		synchronized(DatabaseHandler.class){
			if(firstInstance == null){
				firstInstance = new DatabaseHandler();
			}//if
		}//synchronized
		return firstInstance;
	}//getInstance

	
	public void storeDocument(Document document) throws IOException {
		//dbImpl.storeDocument(db, document);
		dbImpl.retrieveAll(db);
		//db.close();
	}//storeDocument
	
	public Document retrieveDocument(String id){
		Document doc = new Document("", "");
		doc = dbImpl.retrieveDocumentById(db, id);
		db.close();
		return doc;
	}//retrieveDocument
		
	/*
	public void test5() throws IOException {
	    int numberOfObjects = 0;
	    for(StoredClass storedClass : db.ext().storedClasses()){
	        // filter out db4o internal objects
	        // and filter out object which have a parent-class, because these are in the count of the parent
	        if(!storedClass.getName().startsWith("com.db4o") &&
	                null==storedClass.getParentStoredClass()) {
	            numberOfObjects += storedClass.instanceCount();
	        }
	    }
	    System.out.println("Number of objects stored "+numberOfObjects);
	}//test5
	*/
}//DatabaseHandler