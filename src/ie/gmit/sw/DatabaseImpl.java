package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import com.db4o.*;
import com.db4o.ext.StoredClass;
/**
 * Implementation of DatabaseService - code for all the methods exposed by DatabaseService.
 */
@SuppressWarnings("rawtypes")
public class DatabaseImpl implements DatabaseService {
	
	/** DB4OFILENAME is the path to the db4o file. */
	public static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#deleteDb()
	 */
	//Delete the db4o file.
	@Override
	public void deleteDb() throws IOException {
		System.out.println("Deleting database...");
			File file = new File(DB4OFILENAME);
			file.delete();
	}//deleteDb

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#retrieveAll(com.db4o.ObjectContainer)
	 */
	//Retrieve all Document objects.
	@Override
	public void retrieveAll(ObjectContainer db) throws IOException {
		System.out.println("Retrieving all documents...");
		 Document d = new Document(null, null);
		 ObjectSet result = db.queryByExample(d);
		 listResult(result);
	}//retrieveAll

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#retrieveDocument(com.db4o.ObjectContainer, ie.gmit.sw.Document)
	 */
	//Retrieve a specific Document object.
	@Override
	public void retrieveDocument(ObjectContainer db, Document d) throws IOException {
		ObjectSet result = db.queryByExample(d);
		listResult(result);
	}//retrieveDocument

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#storeDocument(com.db4o.ObjectContainer, ie.gmit.sw.Document)
	 */
	//Save the Document object.
	@Override
	public void storeDocument(ObjectContainer db, Document d) throws IOException {
		db.store(d);
		System.out.println("Saved document with ID: " + d.getDocId());
	}//storeDocument

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#deleteDocument(com.db4o.ObjectContainer, java.lang.String)
	 */
	//Delete a specific Document object.
	@Override
	public void deleteDocument(ObjectContainer db, String id) throws IOException {
		Document d = new Document(id, null);
		ObjectSet result = db.queryByExample(d);
		Document found = (Document) result.next();
		db.delete(found);
		System.out.println("Successfully deleted.");
	}//deleteDocument

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#updateDocument(com.db4o.ObjectContainer, java.lang.String, java.lang.String)
	 */
	//Update a specific Document object.
	@Override
	public void updateDocument(ObjectContainer db,String id, String newId) throws IOException {
		Document d = new Document(id, null);
		ObjectSet result = db.queryByExample(d);
		Document found = (Document) result.next();
		db.delete(found);
		found.setDocId(newId);
		db.store(found);
		System.out.println("Updated ID to: " + found.getDocId());
	}//updateDocument

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#listResult(com.db4o.ObjectSet)
	 */
	//Output db4o content.
	@Override
	public void listResult(ObjectSet result) {
		 System.out.println(result.size());
		 while(result.hasNext()) {
			 System.out.println(result.next());
		 }//while
	}//listResult

	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#retrieveDocumentById(com.db4o.ObjectContainer, java.lang.String)
	 */
	//Retrieve Document object from db4o based on id and return Document object.
	@Override
	public Document retrieveDocumentById(ObjectContainer db, String id) throws IOException {
		System.out.println("Retrieving document with ID: " + id);
		Document d = new Document(id, null);
		ObjectSet result = db.queryByExample(d);
		Document found = (Document) result.next();
		d.setDocument(found.getDocument());
		return d;
	}//retrieveDocumentById
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.DatabaseService#countDocuments(com.db4o.ObjectContainer)
	 */
	//Count how many documents are stored in the database.
	@Override
	public int countDocuments(ObjectContainer db) throws IOException {
	    int numberOfObjects = 0;
	    for(StoredClass storedClass : db.ext().storedClasses()){
	        //filter out db4o internal objects and objects which have a parent-class
	        if(!storedClass.getName().startsWith("com.db4o") &&
	                null == storedClass.getParentStoredClass()) {
	            numberOfObjects += storedClass.instanceCount();
	        }//if
	    }//for
	    System.out.println("Number of objects stored is: " + numberOfObjects);
	    return numberOfObjects;
	}//countDocuments
}//DatabaseImpl