/* This class represents the bag containing the tiles in a scrabble game.
 * It solves the problem of selecting tile randomly from the bag by making extensive
 * use of the Random class.
 */

package com.LetsPlay.gameplay;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.LetsPlay.ui.Tile;

public class TileBag {
			// Property used to simulate the random behaviour of tile selection.
			private Random random = new Random();
			
			private String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"
										, "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " "};
			
			// Property holding the distribution of each tile.  
			private HashMap<String, Integer> tile_distribution = new HashMap<String, Integer>();
			
			/* Property holding all Tile objects generated.
			 * Note: A size of 101 was selected to ensure all 100 Tile objects
			 * are available while preventing an IndexOutOfBoundsException.
			 */   
			private ArrayList<Tile> tile_bag = new ArrayList<Tile>(100);
			
			// Total number of Tile object available at anytime.
			private int size;
			
			/*Constructor statement.
			 */
			public TileBag(){
					//populate the tile_distribution object with key/value pairs.
					this.tile_distribution.put("A", 9);
					this.tile_distribution.put("B", 2);
					this.tile_distribution.put("C", 2);
					this.tile_distribution.put("D", 4);
					this.tile_distribution.put("E", 12);
					this.tile_distribution.put("F", 2);
					this.tile_distribution.put("G", 3);
					this.tile_distribution.put("H", 2);
					this.tile_distribution.put("I", 9);
					this.tile_distribution.put("J", 1);
					this.tile_distribution.put("K", 1);
					this.tile_distribution.put("L", 4);
					this.tile_distribution.put("M", 2);
					this.tile_distribution.put("N", 6);
					this.tile_distribution.put("O", 8);
					this.tile_distribution.put("P", 2);
					this.tile_distribution.put("Q", 1);
					this.tile_distribution.put("R", 6);
					this.tile_distribution.put("S", 4);
					this.tile_distribution.put("T", 6);
					this.tile_distribution.put("U", 4);
					this.tile_distribution.put("V", 2);
					this.tile_distribution.put("W", 2);
					this.tile_distribution.put("X", 1);
					this.tile_distribution.put("Y", 2);
					this.tile_distribution.put("Z", 1);
					this.tile_distribution.put(" ", 2);
					
					// Executes while the size of tile_distribution is greater than zero.
					while(this.tile_distribution.size() > 0){
						
						// Gets the next random integer, less than 27, in the random sequence.
						int temp = this.random.nextInt(27);
						
						// A letter is selected from the letters array using the random digit.
						String temp2 = this.letters[temp];
						
						// Executes if the tile_distribution contains the letter.
						if (this.tile_distribution.containsKey(temp2)){
							
							// Creates the number of Tile objects, for the letter, 
							// and add it to the tile_bag property to enable random selection.
							for (int counter = 0; counter < this.tile_distribution.get(temp2); counter++){
								this.tile_bag.add(new Tile(temp2));
								}
							
							// Removes the letter from the tile_distribution because it's number
							// of Tile objects has been created.
							this.tile_distribution.remove(temp2);
							}
						}
					
					// Get the total number of Tile objects available.  
					this.size = this.tile_bag.size();
			}
			
			// Returns a Tile object chosen at random.
			public Tile getTile(){
					// Gets a random number bounded by the number of Tiles available plus 1.
					int temp = this.random.nextInt(this.size);
					
					// Pick the Tile from the ArrayList using the number as index.
						Tile temp2 = this.tile_bag.get(temp);
					
						
					
					// Removes the Tile from the ArrayList to simulate its removal from
					// the Tile bag
					this.tile_bag.remove(temp);
					
					// Compute the new total of Tiles available.
					this.size = this.tile_bag.size();
					
					// Return Tile.
					return temp2;
			}
			
			// Returns the total number of Tiles available.
			public int getTileTotal(){
				return this.size;
				}
			
			// This method simulate the behaviour of returning a Tile back,
			// For example when a player misses a turn.
			public void returnTile(ArrayList<Tile> tile){
				this.tile_bag.addAll(tile);
				this.size = this.tile_bag.size();
			}
		}

