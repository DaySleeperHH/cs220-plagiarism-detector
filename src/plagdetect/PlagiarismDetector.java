package plagdetect;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class PlagiarismDetector implements IPlagiarismDetector {
	private int n = 4;
	private Map<String,Map<String,Integer>> result;
	private Map<String, Set<String>> ngram;
	public PlagiarismDetector(int n) {
		// TODO implement this method
		result = new HashMap<String,Map<String,Integer>>();
		ngram = new HashMap<String,Set<String>>();
	}
	
	@Override
	public int getN() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public Collection<String> getFilenames() {
		// TODO Auto-generated method stub
		
		return ngram.keySet();
	}

	@Override
	public Collection<String> getNgramsInFile(String filename) {
		// TODO Auto-generated method stub
		return ngram.get(filename);
	}

	@Override
	public int getNumNgramsInFile(String filename) {
		// TODO Auto-generated method stub'
		
		return ngram.get(filename).size();
	}

	@Override
	public Map<String, Map<String, Integer>> getResults() {
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public void readFile(File file) throws IOException {
		// TODO Auto-generated method stub
		// most of your work can happen in this method
		Scanner s = new Scanner(file);
		
		while(s.hasNextLine()) {
		 
		s.nextLine().split(" ");
		
		}
		String[] words = s.nextLine().split(" ");
		for(int i=0; i <words.length - n+1;i++) {
			
		}
	    
	}

	@Override
	public int getNumNGramsInCommon(String file1, String file2) {
		// TODO Auto-generated method stub
		int count = 0;
		for (String filename1: ngram.keySet()) {
			for (String filename2: ngram.keySet()) {
				if (filename1.equals(filename2)) continue;	
				var val1 = ngram.get(filename1);
				var val2 = ngram.get(filename2);
				for (String ngram : val1) {
					if (val2.contains(ngram)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	@Override
	public Collection<String> getSuspiciousPairs(int minNgrams) {
		// TODO Auto-generated method stub
		
		return null ;
	}

	@Override
	public void readFilesInDirectory(File dir) throws IOException {
		// delegation!
		// just go through each file in the directory, and delegate
		// to the method for reading a file
		for (File f : dir.listFiles()) {
			readFile(f);
			System.out.println(f.getName());
			
		}
		
	}
}
