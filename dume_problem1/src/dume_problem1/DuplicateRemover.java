package dume_problem1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DuplicateRemover {
	
	public List<String> uniqueWords = new LinkedList<String>();

	public void remove(String dataFile) {
	    try {
	        File data = new File(dataFile);
	        Scanner reader = new Scanner(data);
	        while (reader.hasNextLine()) {
	          String line = reader.nextLine();
	          String[] words = line.split(" ");
	          for(int i = 0; i < words.length; i++) {
		          if(uniqueWords.contains(words[i].toLowerCase())) {
		        	  
		          }else {
		        	  uniqueWords.add(words[i].toLowerCase());
		          }
	          }

	        }
	        reader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("File not found.");
	        e.printStackTrace();
	      }
	}
	
	public void write(String outputFile) {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
	        
	        for (int i = 0; i < uniqueWords.size(); i++) {
	        	String word = uniqueWords.get(i);
	        	writer.write(word);
	        	writer.newLine();
	        }
	        writer.close();
	      } catch (IOException e) {
	    	  System.out.println("An error has occured.");
		      e.printStackTrace();
		}
	}
	
}
