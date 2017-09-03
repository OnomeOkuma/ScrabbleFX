/* This class implements the Trie data structure for holding the dictionary.
 * I have to admit that the Dawg class name is actually a misnormer because the implementation 
 * details shows that a trie was implemented instead. As development continues, this issue would be addressed. 
 */
package com.LetsPlay.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Dawg {
		private DawgNode root;
		private DawgNode current_node; 
		
		
		/* Constructor statement. Reads and saves the content of the text file containing
		 * the list of official scrabble word. 
		 */
		public Dawg(){
			// Initialize and set the root node.
			this.root = new DawgNode();
			this.root.character = ' ';
			try {
				
				// Open the text file and set its delimiter. 
				Scanner reader = new Scanner(new File("/home/onome/Wordlist/WordList.txt"));
				reader.useDelimiter("\n");
				
				// While words are still present in the textfile
				while (reader.hasNext()){
					
					// Read the first word and set the current node to the root node.
					String word = reader.next();
					this.current_node = this.root;
					
					// For each character in the word 
					for (int counter = 0; counter < word.length(); counter++){
						
						if (this.current_node.isCharContained(word.charAt(counter))){
							
							// if the character is a child, replace the current node with this child.  
							this.current_node = this.current_node.getNode(word.charAt(counter));
							
						}else{ 
							
							// Otherwise, make the character a child and replace the current node with it.
							this.current_node.addChild(word.charAt(counter));
							this.current_node = this.current_node.getNode(word.charAt(counter));
							
						}
						
						// Call the current node completeWord() function when the last character is reached. 
						if (counter == (word.length()-1)){
							this.current_node.terminalNode();
						}
					}
					
				}
				
				reader.close();
			} catch (FileNotFoundException e) {
				
				System.out.println("File Not Found" + "\n");
				e.printStackTrace();
			}
			
		}
		
		
		// Returns true if the parameter is contained in the Dawg.
		public boolean isWordContained(String word){
				
			this.current_node = this.root;
			int counter = 0;
			
			while (counter < word.length()){
				
				// Checks each character of the parameter to see if they are contained in each node
				// as the tree is transversed.
				if (this.current_node.isCharContained(word.charAt(counter))){
					
					// Gets the node holding that character if the test returns true.
					this.current_node = this.current_node.getNode(word.charAt(counter));
					
					// Increment and run the test again.
					++counter;
					
				// Otherwise, the word parameter is not present.
				} else return false;
				
			}
			
			// On getting to the end of the parameter, Check if the last character has a null value as one of its decendants.
			if (counter == word.length() && this.current_node.isTerminalNode()){
				return true;
			}
			
			// Added to prevent Eclipse disturbance. otherwise this is suppose to be in an else statement. 
			return false;
		}
		
		
		// Returns an ArrayList of Characters that are edges of the particular node or null if
		// there are no edges from this node. 
		public ArrayList<Character> nodeEdges(String partialword){
			this.current_node = this.root;
			ArrayList<Character> result = new ArrayList<Character>();
			
			// Goes through the path of the partialword variable in the Dawg.
			for (int counter = 0; counter < partialword.length(); counter++){
				if (this.current_node.isCharContained(partialword.charAt(counter))){
					this.current_node = this.current_node.getNode(partialword.charAt(counter));
				}else return null;
			}
			
		
			Iterator<DawgNode> iterator = this.current_node.getChildren().iterator();
			while(iterator.hasNext()){
				DawgNode temp2 = iterator.next();
				if(temp2 != null)
					result.add(temp2.character);
			}
			
			return result;
		}
		
		
}
