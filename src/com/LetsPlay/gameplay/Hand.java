/*
 * 	As the name implies, the Hand class is modeled after the human hand which is the primary 
 * tool for tile placement. In addition to its obvious uses according to the game, this class
 * also has a short term storage. This is to enable the proper undoing of any unwanted plays made 
 * during gameplay. As with all other classes, it is still under active development hence it may
 * be removed.   
 */

package com.LetsPlay.gameplay;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Stack;

import com.LetsPlay.ui.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class Hand {
		
		
		public static Stack<Tile> tiles_played = new Stack<Tile>();
		
		// Holds the Tile currently being dragged.
		private static Tile tile;
		
		// Stores the order in which the board grif elements  are replaced using a First-In-First-Out arrangement.  
		private static ArrayDeque<Canvas> board_grid_element = new ArrayDeque<Canvas>();

		// Records the Tiles placed on each board grid element.
		private static Hashtable<Canvas,Tile> current_play = new Hashtable<Canvas,Tile>();
		
		// Record the board grid element when a MouseDragReleased event is fired on it.
		public static void record_play(Canvas grid_released) {
			
			// Adds the grid to the FIFO.
			board_grid_element.add(grid_released);
			
			// Records the Tile placed on the board grid element.
			current_play.put(grid_released, tile);
			
			tiles_played.push(tile);
		}
		
		// Getter method.
		public static Tile getTile() {
			return tile;
		}
		
		// Setter method. 
		public static void setTile(Tile tile) {
			Hand.tile = tile;
		}
		
		// Returns the Tiles to their previous location in the scene.
		// This method is primarily used by the undo_button Node.
		
		/*
		 *  Note: when the Tiles are returned to their respective rack,
		 *  A new tile is created using the information of the old tile.
		 *  This is because the old tile no longer responds to MouseEvents.
		 *  Will look into this problem later.
		 *  
		 */
		
		public static void undo_play(){
			
			// Execute as long as the queue isn't empty. 
			while (!Hand.board_grid_element.isEmpty()){	
				
				// Remove the oldest play in the queue.
				Canvas canvas = Hand.board_grid_element.removeFirst();
				
				// Get the Tile placed there.
				Tile tile = Hand.current_play.get(canvas);
				
				// Get its location on the board.
				int coordinates[] = new int[2];
				coordinates[0] = GridPane.getColumnIndex(tile);
				coordinates[1] = GridPane.getRowIndex(tile);
				
				// Return the Tile back to its rack
				GameSession.rack1.getChildren().add(new Tile (tile.letter));
				
				// Remove it from the board.
				GameSession.board.getChildren().remove(tile);
				
				// Return the grid element back to its place in the board. 
				GameSession.board.add(canvas, coordinates[0], coordinates[1]);
					
			}
			
			// Clear short term memory.
			current_play.clear();
			tiles_played.clear();
			board_grid_element.clear();
		}
		
		public static void resetState(){
			current_play.clear();
			tiles_played.clear();
			board_grid_element.clear();
		}
}
