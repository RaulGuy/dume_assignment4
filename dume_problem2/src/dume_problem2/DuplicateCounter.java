package dume_problem2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
	public HashMap<String, Integer> wordCounter = new HashMap <String, Integer>();

	public void count(String dataFile) {
	    try {
	        File data = new File(dataFile);
	        Scanner reader = new Scanner(data);
	        while (reader.hasNextLine()) {
	          String line = reader.nextLine();
	          String[] words = line.split(" ");
	          for(int i = 0; i < words.length; i++) {
		          if(wordCounter.containsKey(words[i].toLowerCase())) {
		        	  int v = wordCounter.get(words[i].toLowerCase()) + 1;
		        	  wordCounter.replace(words[i].toLowerCase(), v);
		          }else {
		        	  wordCounter.put(words[i].toLowerCase(), 1);
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
	        
	        for (String data : wordCounter.keySet()) {
	        	String key = data.toString();
	        	String value = wordCounter.get(data).toString();
	        	writer.write(key + ' ' + value);
	        	writer.newLine();
	        }
	        writer.close();
	      } catch (IOException e) {
	    	  System.out.println("An error has occured.");
		      e.printStackTrace();
		}
	}
	
}
