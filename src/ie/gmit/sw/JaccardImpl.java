package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementation of Jaccard - code for all the methods exposed by Jaccard.
 */
public class JaccardImpl implements Jaccard {
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Jaccard#createShingles(ie.gmit.sw.Document, int)
	 */
	@Override
	//Create Shingles.
	public List<Shingle> createShingles(Document document, int id){
		String threeWords = "";
		int counter = 0;
		Shingle s = new Shingle(0,0);
		List<Shingle> shingles = new ArrayList<Shingle>();
		
		//Split the text into array of strings.
		String[] words = document.getDocument().split(" ");
		
		//Split the words array into shingles with 3 words each.
		for(int i = 0; i < words.length; i++){
			//System.out.println(words[i]);
			counter++;
			threeWords = threeWords + " " + words[i];
			if(counter == 3){
				//System.out.println(threeWords);
				threeWords = threeWords.toLowerCase();
				s.setDocId(id);
				s.setHashCode(threeWords.hashCode());
				shingles.add(s);
				//System.out.println(s.toString());
				threeWords = "";
				counter = 0;
			}//if
		}//for
		
		//Return shingle list.
		return shingles;
	}//createShingles
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Jaccard#createHashCodes(ie.gmit.sw.Document)
	 */
	//Create list with hash codes only.
	@Override
	public List<Integer> createHashCodes(Document document){
		String threeWords = "";
		int counter = 0;
		int hash = 0;
		
		List<Integer> hashCodes = new ArrayList<Integer>();
		
		//Split the text into array of strings.
		String[] words = document.getDocument().split(" ");
		
		//Change every 3 words to hash code.
		for(int i = 0; i < words.length; i++){
			//System.out.println(words[i]);
			counter++;
			threeWords = threeWords + " " + words[i];
			if(counter == 3){
				//System.out.println(threeWords);
				threeWords = threeWords.toLowerCase();
				hash = threeWords.hashCode();
				hashCodes.add(hash);
				threeWords = "";
				counter = 0;
			}//if
		}//for
		
		//Return list.
		return hashCodes;
	}//createHashCodes
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Jaccard#jaccardSimilarity(java.lang.Integer[], java.lang.Integer[])
	 */
	//Jaccard similarity - slow, only use on small documents.
	//Pass in 2 integer arrays consisting of hash codes create
	//2 sets from the arrays and compare them.
	@Override
	public double jaccardSimilarity(Integer[] a, Integer[] b){
	    Set<Integer> s1 = new HashSet<Integer>();
	    
	    for (int i = 0; i < a.length; i++) {
	        s1.add(a[i]);
	    }//for
	    
	    Set<Integer> s2 = new HashSet<Integer>();
	    for (int i = 0; i < b.length; i++) {
	        s2.add(b[i]);
	    }//for
	    
	    int sa = s1.size();
	    int sb = s2.size();
	    s1.retainAll(s2);
	    int intersection = s1.size();
	    return 1d / (sa + sb - intersection) * intersection;
	}//jaccardSimilarity

	/* (non-Javadoc)
	 * @see ie.gmit.sw.Jaccard#minHash(java.util.List, java.util.List)
	 */
	@Override
	public void minHash(List<Shingle> Shingles, List<Shingle> Shingles2) {

	}//minHash
}//JaccardImpl