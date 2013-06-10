package lookout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lookout {
	
	private String filename;
	
	private static Scanner scanner = new Scanner(System.in);
	
	public Lookout(String filename) {
		this.filename = filename;
	}
	
	public void replaceFunction() {
		BufferedReader br = null;
		try {
			String input;
			br = new BufferedReader(new FileReader(this.filename));
 
			while ((input = br.readLine()) != null) {
				input.trim();
				wrapperReplace(input);
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
	
	public void wrapperReplace(String input) {
		if(input == null || input == "") {
			System.out.println("null string");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			String s;
			br = new BufferedReader(new FileReader(new File(args[0])));
 
			while ((s = br.readLine()) != null) {
				s.trim();
				
			String[] splitInput = s.split("[;\\,]");
			HashMap<Integer, Integer> rPoints = new HashMap<Integer, Integer>();
			 
			String outputString = splitInput[0];
			
			int currLength = outputString.length();
			int i = 1;
			//while(i<splitInput.length) {   						//for(i=1; i<splitInput.length;i= i+2) 
				String findString = splitInput[i];
				String replaceString = splitInput[i+1];
				int currIndex = 0, lastReplacedIndex =0;
				int startIndex = -1;
				
				while(true) {
					if(currIndex + findString.length() > currLength) {
						i = i+2;
						if(i<splitInput.length) {
							findString = splitInput[i];
							replaceString = splitInput[i+1];
							currIndex = 0;
						}
						else {
							/*for(Map.Entry<Integer, Integer> entry : rPoints.entrySet()) {
								System.out.println("Key: " +entry.getKey()+ "||"+ entry.getValue());
							}*/
							System.out.println("Final Result :"+outputString);
							return;
						}
					}
					else {
						if(rPoints.containsKey(currIndex)) {
							int offset = rPoints.get(currIndex);
							currIndex += offset;
						}
						int tmpIndex = currIndex;
						int tmpLength = currIndex+findString.length();
						/*for(int k=tmpIndex; k< tmpLength; k++) {
							if(rPoints.containsKey(k)) {
								int offset = rPoints.get(k);
								currIndex += offset;
							}
						}*/
						String sub = outputString.substring(currIndex, currIndex+findString.length());
						if(sub.equals(findString)) {
							startIndex = currIndex;
							rPoints.put(startIndex,replaceString.length());
							StringBuffer tmp = new StringBuffer();
							tmp.append(outputString.substring(0, startIndex));
							tmp.append(replaceString);
							tmp.append(outputString.substring(startIndex+findString.length()));
							outputString = tmp.toString();
							System.out.println(splitInput.length);
							
							System.out.println(findString +"||"+ replaceString);
							System.out.println(outputString);
							currLength = outputString.length();
							currIndex += replaceString.length();
							lastReplacedIndex = currIndex;
							
						}
						else {
							startIndex = -1;
						}
						currIndex++;
	
					}
				}	
			//}System.out.println("Result :"+outputString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
	}

}
