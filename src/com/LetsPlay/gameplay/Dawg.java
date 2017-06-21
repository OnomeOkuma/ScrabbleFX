/* Custom implementation of the Dawg Data Structure.
 * 	
 * 	The word_search property holds the mapping of a partial word with the
 * ArrayList of all possible characters that can be appended to the partial word.
 * 
 * 	The complete_word property holds a list of all complete words available in
 * the given wordlist. 
 * 
 *   On initialization, the words in the specified file is used to create the Dawg.  
 *  
 *  Note: Refactoring would take place as more functions are added to this class. 
 */


package com.LetsPlay.gameplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dawg {
		private HashMap<String, ArrayList<Character>> word_search = new HashMap<String, ArrayList<Character>>(200000);
		private ArrayList<String> complete_words = new ArrayList<String>();
		
		//this variable is temporary. It would be used until a permanent solution is implemented.
		private File word_list_location = new File("/home/onome/Wordlist/WordList.txt");
		
		//A private function that is used internally to add words to the trie.
		private void createDawg(String word_to_add){
			
					/*This variable holds the partial word being built,
					 *which would be used as keys for the word_search property.
					 */
					String partialword = new String();
					
					//Starts a loop that goes through the string parameter provided
					for (int counter = 0; counter < word_to_add.length(); counter++){
						
						//Picks a character to add to the word_search property.
						char temp = word_to_add.charAt(counter);
						
						/*Checks if that is the first character.
						 *If true, the search starts from null, which is the root of
						 *the Dawg and the first key in the word_search
						 *property.
						 */
							
						if(counter == 0){
							 /*checks if null key has been mapped.
							  *if false, a new value is created, the character is added
							  *and the null key is mapped.
							  */
							if (this.word_search.containsKey(null) == false ){
								ArrayList<Character> temp2 = new ArrayList<Character>(5);
								temp2.add(temp);
								this.word_search.put(null, temp2);
								partialword = partialword.concat(Character.toString(temp));
								
								/*Otherwise, get the value of the key mapping.
								 */
							}else{
								ArrayList<Character>temp2 = this.word_search.get(null);
								
								//checks if the character is part of the list.
								if (temp2.contains(temp)){
									
										//build the partial word
										partialword = partialword.concat(Character.toString(temp));
										
									}else {
										
										//add the character to the returned value and place it
										//back. Also build the partial word.
										temp2.add(temp);
										this.word_search.put(null, temp2);
										partialword = partialword.concat(Character.toString(temp));
										
										}
									}
							
							//Repeat the previous steps replacing the null key with 
							//the partialword key.
						}else{
								if (this.word_search.containsKey(partialword) == false){
									
									ArrayList<Character> temp2 = new ArrayList<Character>(5);
									temp2.add(temp);
									this.word_search.put(partialword, temp2);
									partialword = partialword.concat(Character.toString(temp));
									
								}else{
									ArrayList<Character>temp2 = this.word_search.get(partialword);
									
									if(temp2.contains(temp)){
										
										partialword = partialword.concat(Character.toString(temp));
										
										}else {
											
											temp2.add(temp);
											this.word_search.put(partialword, temp2);
											partialword = partialword.concat(Character.toString(temp));
											
											}
								}
									
							}
					}
				}
		
		//
		public Dawg(){
			try {
				Scanner reader = new Scanner(this.word_list_location);
				reader.useDelimiter("\n");
				while (reader.hasNext()){
					String temp = reader.next();
					this.createDawg(temp);
					this.complete_words.add(temp);
				}
				reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Checks if the String parameter is a complete word in the Dawg.
		public boolean isCompleteWord(String word){
					return this.complete_words.contains(word);
			}
		
		//Checks if the String parameter is a node in the Dawg.
		public boolean containPartialWord(String partialword){
					return this.word_search.containsKey(partialword);
			}
		
		//Returns the list of edges from the node provided.
		public ArrayList<Character> getCharacterList(String partialword){
					return this.word_search.get(partialword);
		}
		
		//Returns the String values contained in this Dawg.
		@Override
		public String toString(){
			return this.complete_words.toString();
		}
		
		}
	
