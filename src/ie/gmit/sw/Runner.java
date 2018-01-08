package ie.gmit.sw;

import java.io.IOException;
import com.db4o.*;

/**
 * Using Runner class as a means of quickly testing db4o methods - Ignore it.
 */
//Using Runner class as a means of quickly testing db4o methods - Ignore it.
public class Runner {	
	
	/**
	 * The main method.
	 *
	 * @param args The arguments passed in.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		DatabaseImpl dbImpl = new DatabaseImpl();
		dbImpl.retrieveAll(db);
		//dbImpl.deleteDocument(db, "Test");
		dbImpl.countDocuments(db);
	}//main
}//Runner