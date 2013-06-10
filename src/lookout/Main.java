package lookout;

import java.io.*;
import java.util.*;

public class Main {

	public static void performSub(String input) {
		String[] splitInput = input.split("[;\\,]");
		String inputString = splitInput[0];
	
		LinkedList <String> nonReplacedList = new LinkedList<String>();
		LinkedList <Integer> posList = new LinkedList<Integer>();
		
		int i=1, currIndex = 0, listIndex = 0, startIndex = -1;
		int currLength = inputString.length();
		
		String findString = splitInput[i];
		String replaceString = splitInput[i+1];
		String outputString = new String(inputString);
		
		nonReplacedList.add(inputString);
		posList.add(currIndex);
		
		while(i<splitInput.length) {
			while(!nonReplacedList.isEmpty()) {
				int firstIndex = inputString.indexOf(findString);
				if(firstIndex != -1) {
					 StringBuffer tmp = new StringBuffer();
					 //tmp.append(inputString,);
				}
			}
			i+=2;
			findString = splitInput[i];
			replaceString = splitInput[i+1];
		}	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			String input;
			br = new BufferedReader(new FileReader(new File(args[0])));
 
			while ((input = br.readLine()) != null) {
				input.trim();
				performSub(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) { 
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
