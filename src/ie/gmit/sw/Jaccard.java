package ie.gmit.sw;

import java.util.List;
/**
 * The interface Jaccard exposes methods a user can invoke that are relevant
 * to finding the Jaccard similarity & minHash.
 */
public interface Jaccard {
	
	/**
	 * Creates Shingles for the Document object passed in.
	 *
	 * @param document The document variable of type Document to create Shingles from.
	 * @param id The id of the shingles.
	 * @return The list containing Shingle objects.
	 */
	public List<Shingle> createShingles(Document document, int id);
	
	/**
	 * Creates the hash codes for the Document object passed in.
	 *
	 * @param document The document variable of type Document to create hashCodes from.
	 * @return The list containing the hashCodes.
	 */
	public List<Integer> createHashCodes(Document document);
	
	/**
	 * Calculate Jaccard similarity of 2 sets by passing in 2 Integer arrays.
	 *
	 * @param a The a variable represents the first Integer array.
	 * @param b The b variable represents the second Integer array.
	 * @return The double result of the calculation.
	 */
	public double jaccardSimilarity(Integer[] a, Integer[] b);
	
	/**
	 * Calculate the minHash by passing in 2 Lists containing Shingle objects.
	 *
	 * @param Shingles The shingles variable represents the first list containing Shingle objects.
	 * @param Shingles2 The shingles2 variable represents the second list containing Shingle objects.
	 */
	public void minHash(List<Shingle> Shingles, List<Shingle> Shingles2);
}//Jaccard