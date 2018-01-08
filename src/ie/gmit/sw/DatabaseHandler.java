package ie.gmit.sw;

import java.io.IOException;
import com.db4o.*;

/**
 *DatabaseHandler - Singleton - only one object gets created to handle database services.
 */
public class DatabaseHandler {
	
	/** The first instance. */
	private static DatabaseHandler firstInstance = null;
	
	/** The first thread. */
	static boolean firstThread = true;
	
	/** DB4OFILENAME is the path to the db4o file. */
	private static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	
	/** The db variable is an instance of ObjectContainer and represents the database. */
	private ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
	
	/** dbImpl is an instance of DatabaseImpl*/
	private DatabaseService dbImpl = new DatabaseImpl();
	
	/**
	 * Instantiates a new DatabaseHandler.
	 * Only Singleton able to instantiate this class.
	 */
	private DatabaseHandler(){ }
	
	/**
	 * Get the single instance of DatabaseHandler.
	 *
	 * @return Single instance of DatabaseHandler.
	 */
	public static DatabaseHandler getInstance() {
		//If threads try to create instances of this class...
		if(firstInstance == null){
			
			firstThread = false;
			
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//catch
		}//if
		
		//Synchronized when first object is created.
		synchronized(DatabaseHandler.class){
			if(firstInstance == null){
				//lazy instantiation.
				firstInstance = new DatabaseHandler();
			}//if
		}//synchronized
		return firstInstance;
	}//getInstance

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#storeDocument(com.db4o.ObjectContainer, ie.gmit.sw.Document)
	 */
	//Save the Document object.
	public void storeDocument(Document document) throws IOException {
		//dbImpl.storeDocument(db, document);
		dbImpl.retrieveAll(db);
		//db.close();
	}//storeDocument
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#retrieveDocument(com.db4o.ObjectContainer, ie.gmit.sw.Document)
	 */
	//Retrieve specific Document object with id.
	public Document retrieveDocument(String id) throws IOException {
		Document doc = new Document("", "");
		doc = dbImpl.retrieveDocumentById(db, id);
		db.close();
		return doc;
	}//retrieveDocument
}//DatabaseHandler