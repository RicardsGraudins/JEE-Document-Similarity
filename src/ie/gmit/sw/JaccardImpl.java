package ie.gmit.sw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/**
 * Implementation of Jaccard - code for all the methods exposed by Jaccard.
 */
public class JaccardImpl implements Jaccard {
	
	/** The max amount of hashes. */
	private final int MAX_HASH = 200;
	
	/** The hashes TreeSet consisting of random numbers. */
	private TreeSet<Integer> hashes = new TreeSet<Integer>();
	
	/** The Integer list consisting of Min Hashes. */
	private List<Integer> newDocument = new ArrayList<Integer>();
	
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
	 * @see ie.gmit.sw.Jaccard#generateRandomNumbers()
	 */
	//Generate Random numbers
	@Override
	public TreeSet<Integer> generateRandomNumbers(){
		hashes = new TreeSet<Integer>();
		Random random = new Random();
		
		for(int i = 0; i < MAX_HASH; i++){
			hashes.add(random.nextInt());
		}//for
		return hashes;
	}//generateRandomNumbers
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Jaccard#generateMinHashes(java.util.List)
	 */
	//Generate Min Hashes
	@Override
	public List<Integer> generateMinHashes(List<Shingle> shingles){
		List<Shingle> s = shingles;
		List<Integer> temp = new ArrayList<Integer>();
		
		//XOR the integer word values with the hashes
		for (Integer hash: hashes){
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < s.size(); i++){
				//Bitwise XOR the string hashCode with the hash
				int minHash = s.get(i).getHashCode()^hash;
				if(minHash < min){
					min = minHash;
				}//if
			}//for
			//Only store the shingle with the minimum hash for each hash function
			temp.add(min);
		}//for
		
		return temp;
	}//generateMinHashes
	
	/* (non-Javadoc)
	 * @see ie.gmit.sw.Jaccard#calculateJaccard(java.util.List)
	 */
	public double calculateJaccard(List<Shingle> shingles){
		double result = 0;
		
		hashes = generateRandomNumbers();
		System.out.println("\ngenerateRandomNumbers");
		System.out.println("=====================");
		Iterator<Integer> itr = hashes.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		newDocument = generateMinHashes(shingles);
		System.out.println("\ngenerateMinHashes");
		System.out.println("=================");
		System.out.println(Arrays.toString(newDocument.toArray()));
		
		
		return result;
	}//calculateJaccard
}//JaccardImpl