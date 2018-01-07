package ie.gmit.sw;

import java.io.IOException;

import com.db4o.*;

public class Runner {	
	public static void main(String[] args) throws IOException {
		//Testing -- delete later
		final String DB4OFILENAME = "C:/Users/Richard/Jaccard/JACCARD/Resources/JaccardDB.db4o";
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4OFILENAME);
		DatabaseImpl dbImpl = new DatabaseImpl();
		dbImpl.retrieveAll(db);
	}//main
}//Runner