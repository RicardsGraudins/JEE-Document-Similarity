package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import com.db4o.*;

//Implementation of DatabaseService
@SuppressWarnings("rawtypes")
public class DatabaseImpl implements DatabaseService {
	public static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	//Delete the database
	@Override
	public void deleteDb() throws IOException {
		System.out.println("Deleting database...");
			File file = new File(DB4OFILENAME);
			file.delete();
	}//deleteDb

	//Retrieve all Document objects
	@Override
	public void retrieveAll(ObjectContainer db) throws IOException {
		System.out.println("Retrieving all documents...");
		 Document d = new Document(null, null);
		 ObjectSet result = db.queryByExample(d);
		 listResult(result);
	}//retrieveAll

	//Retrieve specific Document object
	@Override
	public void retrieveDocument(ObjectContainer db, Document d) throws IOException {
		ObjectSet result = db.queryByExample(d);
		listResult(result);
	}//retrieveDocument

	//Save the Document object to file DB40FILENAME
	@Override
	public void storeDocument(ObjectContainer db, Document d) throws IOException {
		db.store(d);
		System.out.println("Saved document with ID: " + d.getDocId());
	}//storeDocument

	//Delete specific Document object
	@Override
	public void deleteDocument(ObjectContainer db, String id) throws IOException {
		Document d = new Document(id, null);
		ObjectSet result = db.queryByExample(d);
		Document found = (Document) result.next();
		db.delete(found);
		System.out.println("Successfully deleted.");
	}//deleteDocument

	//Update specific Document object
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

	//Output db4o content
	@Override
	public void listResult(ObjectSet result) {
		 System.out.println(result.size());
		 while(result.hasNext()) {
			 System.out.println(result.next());
		 }//while
	}//listResult

	//Retrieve Document object from db4o based on id and return Document object
	@Override
	public Document retrieveDocumentById(ObjectContainer db, String id) {
		//create Document object with ID we're searching for..
		Document d = new Document(id, null);
		//query the database...
		ObjectSet result = db.queryByExample(d);
		//cast to Document
		Document found = (Document) result.next();
		//Set document string to that of found.getDocument()
		d.setDocument(found.getDocument());
		//return Document object
		return d;
	}//retrieveDocumentObj
}//DatabaseImpl