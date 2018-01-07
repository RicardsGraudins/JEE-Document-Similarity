package ie.gmit.sw;

import java.io.IOException;
import java.util.*;

public class Worker {
	private static Document document;
	private static Document document2;
	private static List<Shingle> shingles = new ArrayList<Shingle>();
	private static List<Shingle> shingles2 = new ArrayList<Shingle>();
	private static List<Integer> hashCodes = new ArrayList<Integer>();
	private static List<Integer> hashCodes2 = new ArrayList<Integer>();
	
	public Worker(Document document){
		Worker.document = document;
	}//Worker

	public static void main(String[] args) throws IOException {
		//1. Store in Database..
		//Instantiate DatabaseHandler - should only accept one document at this point. - Singleton also
		DatabaseHandler database = DatabaseHandler.getInstance();
		database.storeDocument(document);
		
		//2. Create shingles
		//Instantiate Jaccard
		Jaccard jaccard = new Jaccard();
		//shingles = jaccard.createShingles(document, 0);
		//System.out.println(Arrays.toString(shingles.toArray()));
		
		//3. Retrieve different document from DB
		document2 = database.retrieveDocument("Road");
		// Create shingles
		//shingles2 = jaccard.createShingles(document2, 1);
		//System.out.println(Arrays.toString(shingles2.toArray()));
		
		hashCodes = jaccard.createHashCodes(document);
		hashCodes2 = jaccard.createHashCodes(document2);
		
		Integer[] a = hashCodes.toArray(new Integer[hashCodes.size()]);
		Integer[] b = hashCodes2.toArray(new Integer[hashCodes2.size()]);
		
		double similarity = jaccard.jaccardSimilarity(a, b);
		System.out.println(similarity);
	}//main
}//Worker