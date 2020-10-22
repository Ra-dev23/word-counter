package Javatest1;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
public class WordCounterApp {
	public static void main(String[] args) {
		
		System.out.println("The Word Counter application\n");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Please enter the text:");
			System.out.println();
			//define a string that contains text
			 
			String text = sc.nextLine();
			System.out.println();
			
			//process the string
			text = text.replace(",", ""); //remove commas
			text = text.replace(".", ""); //remove periods
			text = text.replace(":", "");
			text = text.replace(";", "");
			text = text.replace("-", "");
			text = text.replace("!", " ");
			text = text.toLowerCase(); //convert to lower case
			
			//split the string into an array
			String[] words = text.split(" ");
			
			//define a map and fill it with words and their counts
			Map<String, Integer> wordMap = new TreeMap<>();
			int count;
			for(String word : words) { 
				if(wordMap.containsKey(word)) { //word is in map
					count = wordMap.get(word);
					count++;
					wordMap.put(word, count);
					} else {   //new word for map
						wordMap.put(word,  1);
					}
			}
			//print the entries
			for(@SuppressWarnings("rawtypes") Map.Entry entry : wordMap.entrySet()) {
				System.out.printf("%-20s%2d%n", "  " + entry.getKey() + " :", entry.getValue());
			}
		}
		
	}
}
