package ie.gmit.sw;

import java.io.IOException;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Runner {
	public static final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
	//Testing db4o
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		DatabaseImpl dbImpl = new DatabaseImpl();
		try {
			//ds.deleteDb();
			//dbImpl.accessDb4o();
			Document d = new Document(1, "Road not taken");
			dbImpl.storeDocument(db, d);
			dbImpl.retrieveAll(db);
			//dbImpl.deleteDb();
			//dbImpl.retrieveAll(db);
			System.out.println("=================");
			dbImpl.retrieveDocument(db, d);
			//dbImpl.deleteDocument(db, d);
			//dbImpl.updateDocument(db, d, 3);
			dbImpl.retrieveAll(db);
			db.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
	}//Main
}//Runner