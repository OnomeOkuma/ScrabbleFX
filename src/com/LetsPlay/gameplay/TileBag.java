/* This class handles the generation of random tiles to emulate the real life process of picking
 * scrabble tiles randomly from a tile bag.
 * it is placed in a new package that handles the gameplay mechanics.
 * it is unfinished and would be expanded on tomorrow.
 */

package com.LetsPlay.gameplay;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class TileBag {
			
			//Data structure holding the information regarding each tile.
			private HashMap<Integer, int[]> tile_attributes = new HashMap<Integer, int[]>(35);
	
			//Number of tiles available at the start of a game.
			private int number_of_tiles = 100;
			
	
			private final int number_of_tile_index = 0;
	
			private final int tile_value_index = 1;
			
			private Random random_generator = new Random();
			private String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"
										, "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "ZL"};
			
			/*
			 * Information related to each tile. The first array element indicates the tile 
			 * distribution. The second array element indicates the tile weight.
			 */
			private  int A[] = {9, 1};
			private  int B[] = {2, 3};
			private  int C[] = {2, 3};
			private  int D[] = {4, 2};
			private  int E[] = {12, 1};
			private  int F[] = {2, 4};
			private  int G[] = {3, 2};
			private  int H[] = {2, 4};
			private  int I[] = {9, 1};
			private  int J[] = {1, 8};
			private  int K[] = {1, 5};
			private  int L[] = {4, 1};
			private  int M[] = {2, 3};
			private  int N[] = {6, 1};
			private  int O[] = {8, 1};
			private  int P[] = {2, 3};
			private  int Q[] = {1, 10};
			private  int R[] = {6, 1};
			private  int S[] = {4, 1};
			private  int T[] = {6, 1};
			private  int U[] = {4, 1};
			private  int V[] = {2, 4};
			private  int W[] = {2, 4};
			private  int X[] = {1, 8};
			private  int Y[] = {2, 4};
			private  int Z[] = {1, 10};

			//this represents the attributes of the blank tile
			private final int ZL[] = {2, 0};
			
			public TileBag(){
				
				// During initialization, attributes of all tiles are placed in the 
				// tile_attribute object for easy access.
					this.tile_attributes.put(0, this.A);
					this.tile_attributes.put(1, this.B);
					this.tile_attributes.put(2, this.C);
					this.tile_attributes.put(3, this.D);
					this.tile_attributes.put(4, this.E);
					this.tile_attributes.put(5, this.F);
					this.tile_attributes.put(6, this.G);
					this.tile_attributes.put(7, this.H);
					this.tile_attributes.put(8, this.I);
					this.tile_attributes.put(9, this.J);
					this.tile_attributes.put(10, this.K);
					this.tile_attributes.put(11, this.L);
					this.tile_attributes.put(12, this.M);
					this.tile_attributes.put(13, this.N);
					this.tile_attributes.put(14, this.O);
					this.tile_attributes.put(15, this.P);
					this.tile_attributes.put(16, this.Q);
					this.tile_attributes.put(17, this.R);
					this.tile_attributes.put(18, this.S);
					this.tile_attributes.put(19, this.T);
					this.tile_attributes.put(20, this.U);
					this.tile_attributes.put(21, this.V);
					this.tile_attributes.put(22, this.W);
					this.tile_attributes.put(23, this.X);
					this.tile_attributes.put(24, this.Y);
					this.tile_attributes.put(25, this.Z);
					this.tile_attributes.put(26, this.ZL);
			}
			
			/* Returns random tiles.   
			 */
			public String getTile(){
			
					//Necessary to ensure that a new integer can be gotten from the Random sequence if the previous
					//integer returned fails any test below.
					 while (true){
						 
						 //Get the next integer in the Random object sequence. 
						 //A bound of 30 was used to ensure that the values picked are more likely to be between 0 - 27 (exclusive).
						 
						 int tile_picked = this.random_generator.nextInt(30);
						
						 //checks if it meets the requirement.
						 if (tile_picked < 27){
							
							//Get the tile attributes from the tile_attributes object.
							int tile_attribute[] = this.tile_attributes.get(tile_picked);
							
									//Checks if the tile is still available in the bag. 
									if (tile_attribute[this.number_of_tile_index] > 0){
										
											//Gets the number of the said tile available.
											int temp2 = tile_attribute[this.number_of_tile_index];
											
											
											//Reduce that number by 1.
											tile_attribute[this.number_of_tile_index] = --temp2;
											
											//Returns it to the tile_attributes object. Just like picking a tile from a tile bag.
											this.tile_attributes.put(tile_picked, tile_attribute );
											
											
											//Reduce the number of total tiles available by 1.
											this.number_of_tiles--;
											
						
											return this.letters[tile_picked];
											
									}
									
						 }
					 }
					 
			}
			
			//Returns the weight associated with the specified tile.
			public int getTileWeight(String letter) {

						int temp = Arrays.binarySearch(this.letters, letter);
							
						//this is because the letter's position is always on the same index.
						int temp1[] = this.tile_attributes.get(temp);
						
						return Array.getInt(temp1, this.tile_value_index);
			}
			
			//Returns the number of tiles available.
			public int getNumber_of_tiles() {
				return this.number_of_tiles;
			}

			
			
}
