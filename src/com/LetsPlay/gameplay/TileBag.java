/* This class handles everything related to generating the gameplay tiles randomly.
 * it is placed in a new package that handles the gameplay mechanics.
 * it is unfinished and would be expanded on tomorrow.
 */

package com.LetsPlay.gameplay;


import java.util.*;

public class TileBag {
			private HashMap<Integer, int[]> tile_attributes = new HashMap<Integer, int[]>(35);
			@SuppressWarnings("unused")
			private int number_of_tiles = 28;
			
			@SuppressWarnings("unused")
			private final int number_of_letter = 0;
			@SuppressWarnings("unused")
			private final int tile_weight = 1;
			
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
			
			public String getTile(){
					 while (true){
						 int temp = this.random_generator.nextInt(45);
						 if (temp <= 25){
							 System.out.println(temp);
							return this.letters[temp];
						 }
					 }
					 
			}
			
		//	public int getTileWeight(String letter) {
					
			//}
			
			
}
