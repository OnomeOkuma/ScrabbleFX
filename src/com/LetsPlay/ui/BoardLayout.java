/*	This class creates the scrabble board by making use of a GridPane and the TilesFactory class.
 * This class was created because it is going to have EventHandlers added to it that would take care of 
 * all events generated by this board.
 * 
 * 	it is evolving, therefore methods and properties would be added to it as the project 
 * grows.
 */
package com.LetsPlay.ui;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class BoardLayout extends GridPane {
				private ObservableList<Node> previous_state;
				private ObservableList<Node> current_state;
				private ObservableList<Node> state_on_initilization;
				//Constructor statement.
				public BoardLayout(){
					//Sets the dimensions of the board
					this.setPrefSize(593.50, 549);
					this.setGridLinesVisible(false);
					
					//Creating the board
					TilesFactory boardtiles = new TilesFactory();
					for(int rowindex = 0; rowindex < 15; rowindex++){
						for(int columnindex = 0; columnindex < 15; columnindex++){
							switch (rowindex){
							//Note: Some rows repeats.
							
							//Creates row 0 of the board.
							case 0:	switch (columnindex){
											case 0: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 3: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 7: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 11: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 14: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;					
											} break;
							
							//Creates row 1 of the board.
							case 1: switch (columnindex){
											case 1: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 5: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 9: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 13: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;	
											} break;
							
							//Creates row 2 of the board.
							case 2: switch (columnindex){
											case 2: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 6: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 8: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 12: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;
											
							//Creates row 3 of the board.				
							case 3: switch (columnindex){
											case 0: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 3: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 7: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 11: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 14: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;					
											} break;
									
							//Creates row 4 of the board.							
							case 4: switch (columnindex){
											case 4: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 10: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;
											
							//Creates row 5 of the board.											
							case 5: switch (columnindex){
											case 1: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 5: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 9: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 13: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;
							
							//Creates row 6 of the board.				
							case 6: switch (columnindex){
											case 2: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 6: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 8: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 12: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;			
											
							//Creates row 7 of the board.				
							case 7: switch (columnindex){
											case 0: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 3: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 7: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 11: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 14: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;	
											} break;
											
							//Creates row 8 of the board.					
							case 8: switch (columnindex){
											case 2: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 6: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 8: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 12: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;				
								
							//Creates row 9 of the board.			
							case 9: switch (columnindex){
											case 1: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 5: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 9: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 13: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;				
											
							//Creates row 10 of the board.				
							case 10: switch (columnindex){
											case 4: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 10: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;				
							
							//Creates row 11 of the board.				
							case 11: switch (columnindex){
											case 0: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 3: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 7: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 11: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 14: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;					
											} break;					
											
							//Creates row 12 of the board.				
							case 12: switch (columnindex){
											case 2: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 6: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 8: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 12: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;
											
							//Creates row 13 of the board.				
							case 13: switch (columnindex){
											case 1: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 5: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 9: this.add(boardtiles.createTripleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 13: this.add(boardtiles.createDoubleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;	
											} break;
							
							//Creates row 14 of the board.				
							case 14: switch (columnindex){
											case 0: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 3: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 7: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 11: this.add(boardtiles.createDoubleLetterScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											case 14: this.add(boardtiles.createTripleWordScore(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex);break;
											default: this.add(boardtiles.createEmptyBoardTile(Integer.toString(rowindex) + " " + Integer.toString(columnindex)), columnindex, rowindex); break;
											} break;
							default: break;
									
						}
							
									
											
						}
					}
					this.state_on_initilization.addAll(this.getChildren());
					
				}

				
}
