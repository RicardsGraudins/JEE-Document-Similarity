package ie.gmit.sw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jaccard {
	
	//Create Shingles
	public List<Shingle> createShingles(Document document, int id){
		String threeWords = "";
		int counter = 0;
		Shingle s = new Shingle(0,0);
		List<Shingle> shingles = new ArrayList<Shingle>();
		
		//split the text into array of strings
		String[] words = document.getDocument().split(" ");
		
		//split the words array into shingles with 3 words each
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
		
		//return shingle list
		return shingles;
	}//createShingles
	
	//create list with hash codes only
	public List<Integer> createHashCodes(Document document){
		String threeWords = "";
		int counter = 0;
		int temp = 0;
		
		List<Integer> hashCodes = new ArrayList<Integer>();
		
		//split the text into array of strings
		String[] words = document.getDocument().split(" ");
		
		//change every 3 words to hash code
		for(int i = 0; i < words.length; i++){
			//System.out.println(words[i]);
			counter++;
			threeWords = threeWords + " " + words[i];
			if(counter == 3){
				//System.out.println(threeWords);
				threeWords = threeWords.toLowerCase();
				temp = threeWords.hashCode();
				hashCodes.add(temp);
				threeWords = "";
				counter = 0;
			}//if
		}//for
		
		return hashCodes;
	}//createHashCodes
	
	//4.1 Jaccard method - Slow, only use on small documents
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
}//Jaccard