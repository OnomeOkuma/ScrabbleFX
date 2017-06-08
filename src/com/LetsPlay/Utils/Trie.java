package com.LetsPlay.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {
		private HashMap<StringBuffer, ArrayList<Character>> word_search = new HashMap<StringBuffer, ArrayList<Character>>(200000);
		private ArrayList<StringBuffer> complete_words = new ArrayList<StringBuffer>();
		
		public HashMap<StringBuffer, ArrayList<Character>> getWord_search() {
			return this.word_search;
		}

		public ArrayList<StringBuffer> getComplete_words() {
			return this.complete_words;
		}

		private File word_list_location = new File("/home/onome/Wordlist/A Words.txt");
		
		public Trie(){
		}
	
		private StringBuffer createTrie(StringBuffer partialword, char nextalphabet){
			
			//Checks if it is null and if the null key has values associated with it.
			//This matches with the trie data structure where the bottom of the trie 
			//is null. 
			if (partialword == null){
				if(this.word_search.containsKey(partialword)){
					ArrayList<Character> temp = this.word_search.get(partialword);
				
					//Checks if the list returned has the character parameter.
					//if its not, it adds the character to the StringBuffer,
					//puts it back in this.wordsearch, Create a new StringBuffer with the
					//character and returns it.  
					if (temp.contains(nextalphabet)){
						
						StringBuffer temp2 = new StringBuffer(Character.toString(nextalphabet));
						return temp2;
						
					} else {
						
							temp.add(nextalphabet);
							this.word_search.put(null, temp);
							StringBuffer temp2 = new StringBuffer(Character.toString(nextalphabet));
							return temp2;
							
					}
				
				//this runs when the null key has no associated value. it creates 
				//a new list, stores the character and returns a StringBuffer created with 
				//the character.
			} else{
				
					ArrayList<Character> temp = new ArrayList<Character>(26);
					temp.add(nextalphabet);
					this.word_search.put(null, temp);
					StringBuffer temp2 = new StringBuffer(Character.toString(nextalphabet));
					return temp2;
					
				}
			
			//this runs when partialword != null. it starts by checking if partialword is a key.
			//if yes, it checks if the character is on the list. if it is, append the character to 
			//partialword and return it. Otherwise, add it to the list, put it back in word_search, append
			//it to partialword and return it.
			} else{
				if(this.word_search.containsKey(partialword)){
					ArrayList<Character> temp = this.word_search.get(partialword);
				 
						if (temp.contains(nextalphabet)){
						
							partialword.append(nextalphabet);
							//debug
							if(this.word_search.size() < 100){
								System.out.println(partialword);
								System.out.println(this.word_search.size() + "\n");
								StringBuffer debug = new StringBuffer("abductor");
								System.out.println(this.word_search.get(debug));
							}
							return partialword;
						
						} else {
						
								temp.add(nextalphabet);
								this.word_search.put(partialword, temp);
								partialword.append(nextalphabet);
								//debug
								if(this.word_search.size() < 100){
									System.out.println(partialword);
									System.out.println(this.word_search.size() + "\n");
									StringBuffer debug = new StringBuffer("abductor");
									System.out.println(this.word_search.get(debug));
								}
								return partialword;
						
							}
				
				
					} else {
						 
							ArrayList<Character> temp = new ArrayList<Character>(26);
							temp.add(nextalphabet);
							this.word_search.put(partialword, temp);
							//debug
							if(this.word_search.size() < 100){
								System.out.println(partialword);
								System.out.println(this.word_search.size() + "\n");
								StringBuffer debug = new StringBuffer("abductor");
								System.out.println(this.word_search.get(debug));
								}
							}
							partialword.append(nextalphabet);
							return partialword;
						
						}

				}
		
		
		public void trie_Init(){
			try {
				Scanner reader = new Scanner(this.word_list_location);
				reader.useDelimiter("\n");
				
				while (reader.hasNext()){
					StringBuffer partialword = null;
					StringBuffer word = new StringBuffer(reader.next());
					
					for (int counter = 0; counter < word.length(); counter++){
						StringBuffer temp = this.createTrie(partialword, word.charAt(counter));
						partialword = temp;
					}
					this.complete_words.add(partialword);
				}
				
				reader.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.err.print("WordList not found. Please find it");
				System.exit(2);
			}
		}
		
		
}
