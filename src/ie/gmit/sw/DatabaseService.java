package ie.gmit.sw;

import java.io.IOException;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
/*DatabaseService is an abstraction that defines what an implementing class must do,
* but not how it will do it. This interface exposes the database methods a user can invoke.
* All the methods throw IOException in case we can't find the db4o file.
*/
public interface DatabaseService {
	public void accessDb4o() throws IOException;
	public void deleteDb() throws IOException;
	public void retrieveAll(ObjectContainer db) throws IOException;
	public void retrieveDocument(ObjectContainer db, Document d) throws IOException;
	public void storeDocument(ObjectContainer db, Document d) throws IOException;
	public void deleteDocument(ObjectContainer db, Document d) throws IOException;
	public void updateDocument(ObjectContainer db, Document d, String id) throws IOException;
	public void listResult(@SuppressWarnings("rawtypes") ObjectSet result);
}//DatabaseService