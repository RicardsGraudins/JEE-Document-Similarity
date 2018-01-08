package ie.gmit.sw;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Worker - Instantiates other classes and executes their methods.
 */
@SuppressWarnings("unused")
public class Worker {
	
	/** The Document object passed. */
	private static Document document;
	
	/** The Document object retrieved from the database. */
	private static Document document2;
	
	/** The list shingles contains Shingle objects of document. */
	private static List<Shingle> shingles = new ArrayList<Shingle>();
	
	/** The list shingles2 contains Shingle objects of document2. */
	private static List<Shingle> shingles2 = new ArrayList<Shingle>();
	
	/** The list hashCodes contains Integer (hashCodes) of document. */
	private static List<Integer> hashCodes = new ArrayList<Integer>();
	
	/** The list hashCodes2 contains Integer (hashCodes) of document2. */
	private static List<Integer> hashCodes2 = new ArrayList<Integer>();
	
	/**
	 * Worker Constructor.
	 * Instantiates a new worker.
	 *
	 * @param document The Document object passed in.
	 */
	public Worker(Document document){
		Worker.document = document;
	}//Worker

	/**
	 * The main method.
	 *
	 * @param args The arguments passed in.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		//Store new document in database.
		DatabaseHandler database = DatabaseHandler.getInstance();
		database.storeDocument(document);
		
		//Create shingles.
		Jaccard jaccard = new JaccardImpl();
		//shingles = jaccard.createShingles(document, 0);
		//System.out.println(Arrays.toString(shingles.toArray()));
		
		//Retrieve different document from DB to compare against.
		document2 = database.retrieveDocument("Road");
		// Create shingles.
		//shingles2 = jaccard.createShingles(document2, 1);
		//System.out.println(Arrays.toString(shingles2.toArray()));
		
		//Generate hash codes for the 2 documents.
		hashCodes = jaccard.createHashCodes(document);
		hashCodes2 = jaccard.createHashCodes(document2);
		
		//Create 2 integer arrays from hashCodes & hashCodes array lists.
		Integer[] a = hashCodes.toArray(new Integer[hashCodes.size()]);
		Integer[] b = hashCodes2.toArray(new Integer[hashCodes2.size()]);
		
		//Calculate Jaccard Similarity.
		double similarity = jaccard.jaccardSimilarity(a, b);
		DecimalFormat df = new DecimalFormat("#%");
		//System.out.println(similarity);
		System.out.println("Similarity: " + df.format(similarity));
	}//main
}//Worker