/*		This class creates the scrabble board by making use of a GridPane and the create_board_grid()
 * function from the Board_tilesFactory class. This class was created because it is going to have 
 * EventHandlers added to it that would take care of all events generated by this board.
 *  	
 *  	This class is still evolving so methods and properties would be added to it as the project 
 *  grows.
 *  	Note: The Tiles created on the board are temporary. This is to enable the author visualize 
 *  the dimensions of the board.  
 */
package ui_Components;

import javafx.scene.layout.GridPane;

public class BoardLayout extends GridPane {
				public BoardLayout(){
					//Sets the dimensions of the board
					this.setPrefSize(593.50, 549);
					this.setGridLinesVisible(true);
					
					//Creating the board and each player racks.
					//Note: This is temporary. it would be fleshed out to reflect a 
					//real scrabble board
					Board_tilesFactory boardtiles = new Board_tilesFactory();
					for(int rowindex = 0; rowindex < 15; rowindex++){
						for(int columnindex = 0; columnindex < 15; columnindex++){
							this.add(boardtiles.create_board_grid(), columnindex, rowindex);
						}
					}
				}
				
}
