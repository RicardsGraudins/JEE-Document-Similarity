package ie.gmit.sw;

import java.io.IOException;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 * The interface DatabaseService is an abstraction that defines what an implementing class must do,
 * but not how it will do it. This interface exposes the database methods a user can invoke.
 * All the methods throw IOException in case we can't find the db4o file.
 */
public interface DatabaseService {
	
	/**
	 * Delete the database file.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteDb() throws IOException;
	
	/**
	 * Retrieve all Document objects.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void retrieveAll(ObjectContainer db) throws IOException;
	
	/**
	 * Retrieve a Document object from the database by passing in an Document.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @param d The d variable represents the document object passed in.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void retrieveDocument(ObjectContainer db, Document d) throws IOException;
	
	/**
	 * Retrieve a Document object from the database by id.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @param id The id of the Document to be retrieved.
	 * @return The Document object with id.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Document retrieveDocumentById(ObjectContainer db, String id) throws IOException;
	
	/**
	 * Store/save a Document object in the database.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @param d The d variable represents the document to save.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void storeDocument(ObjectContainer db, Document d) throws IOException;
	
	/**
	 * Delete a Document object from the database by id.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @param id The id of the Document to be deleted.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void deleteDocument(ObjectContainer db, String id) throws IOException;
	
	/**
	 * Update a Document object in the database with id - change id to newId.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @param id The id of the Document to be updated.
	 * @param newId The new id of the Document with id.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void updateDocument(ObjectContainer db, String id, String newId) throws IOException;
	
	/**
	 * Count the number of objects in the database.
	 *
	 * @param db The db variable is an instance of ObjectContainer and represents the database.
	 * @return The int count of all objects in the database.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public int countDocuments(ObjectContainer db) throws IOException;
	
	/**
	 * List result outputs the query result.
	 *
	 * @param result The result containing the contents of ObjectSet
	 */
	public void listResult(@SuppressWarnings("rawtypes") ObjectSet result);
}//DatabaseService