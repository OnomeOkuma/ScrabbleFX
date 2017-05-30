/* This class handles the generation of random tiles to emulate the real life process of picking
 * scrabble tiles randomly from a tile bag.
 * it is placed in a new package that handles the gameplay mechanics.
 * it is unfinished and would be expanded on tomorrow.
 */

package com.LetsPlay.gameplay;


import java.util.*;

public class TileBag {
	
			private HashMap<Integer, int[]> tile_attributes = new HashMap<Integer, int[]>(35);
	

			private int number_of_tiles = 28;
			
	
			private final int tile_amount_index = 0;
	
			private final int tile_weight_index = 1;
			
			private Random random_generator = new Random();
			private String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"
										, "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

			private final int A[] = {2, 2};
			private final int B[] = {2, 3};
			private final int C[] = {3, 6};
			private final int D[] = {4, 2};
			private final int E[] = {3, 6};
			private final int F[] = {7, 8};
			private final int G[] = {6, 4};
			private final int H[] = {9, 3};
			private final int I[] = {4, 5};
			private final int J[] = {1, 0};
			private final int K[] = {12, 9};
			private final int L[] = {1, 6};
			private final int M[] = {2, 2};
			private final int N[] = {3, 6};
			private final int O[] = {8, 9};
			private final int P[] = {4, 7};
			private final int Q[] = {1, 1};
			private final int R[] = {3, 5};
			private final int S[] = {6, 8};
			private final int T[] = {3, 8};
			private final int U[] = {4, 0};
			private final int V[] = {3, 6};
			private final int W[] = {5, 9};
			private final int X[] = {4, 9};
			private final int Y[] = {1, 3};
			private final int Z[] = {4, 0}; 
			
			public TileBag(){
				
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
					
			}
			
			/*This tile generates tiles randomly.   
			 */
			public String getTile(){
			
					//Necessary to ensure that a new integer can be gotten from the Random sequence, if the previous
					//one failed any of the below tests.
					 while (true){
						 
						 //Get the next integer in the Random object sequence. 
						 //A bound of 30 was used to ensure that the values generated are picked, more often from 0 - 25 
						 //range.
						 int temp = this.random_generator.nextInt(30);
						 
						 //checks if it meets the requirement.
						 if (temp <= 25){
							
							//Get the tile attributes from the tile_attributes object.
							int temp1[] = this.tile_attributes.get(temp);
									
									//Checks if the tile is still available in the bag. 
									if (temp1[this.tile_amount_index] > 0){
										
											//Gets the number of the said tile available.
											int temp2 = temp1[this.tile_amount_index];
											
											//Reduce that number by 1.
											temp1[this.tile_amount_index] = temp2--;
											
											//Return it to the tile_attributes object. Just like picking a tile from a tile bag.
											this.tile_attributes.put(temp, temp1 );
											
											//Reduce the number of total tiles available by 1.
											this.number_of_tiles--;
											return this.letters[temp];
											
									}
									
						 }
					 }
					 
			}
			
			//This returns the weight associated with the specified letter
			public int getTileWeight(String letter) {
						
						int temp = Arrays.binarySearch(this.letters, letter);
						
						//this is because the letter's position is always on the same index.
						int temp1[] = this.tile_attributes.get(temp);
						
						return temp1[this.tile_weight_index];
			}
			
			
}
