package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import com.db4o.*;

//Implementation of DatabaseService
@SuppressWarnings("rawtypes")
public class DatabaseImpl implements DatabaseService {
	public static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	
	@Override
	public void accessDb4o() throws IOException {
		 ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		 try {
			 // db4o code...
			 System.out.println("Accessing database...");
		 } finally {
			 db.close();
		 }//finally
	}//accessDb4o

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
		 Document d = new Document(0, null);
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
	public void deleteDocument(ObjectContainer db, Document d) throws IOException {
		ObjectSet result = db.queryByExample(d);
		Document found = (Document) result.next();
		db.delete(found);
		System.out.println("Deleted document with ID: " + found.getDocId());
	}//deleteDocument

	//Update specific Document object
	@Override
	public void updateDocument(ObjectContainer db, Document d, int id) throws IOException {
		ObjectSet result = db.queryByExample(d);
		Document found = (Document) result.next();
		found.setDocId(id);
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
}//DatabaseImpl