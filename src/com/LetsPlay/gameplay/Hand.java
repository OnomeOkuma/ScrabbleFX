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

import com.LetsPlay.ui.Tile;
import com.LetsPlay.util.PlayedTiles;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class Hand {
		
	public static int number_of_plays = 0;
		// Holds the Tile currently being dragged.
		private static Tile tile;
		
		// Holds all tiles currently being played.
		public static PlayedTiles tiles_played = new PlayedTiles();
		
		// Holds the board grid elements in the order in which the tiles are placed on it. 
		private static ArrayDeque<Canvas> board_grid_element = new ArrayDeque<Canvas>();
		
		// Records the Tiles placed on each board grid element.
		private static Hashtable<Canvas,Tile> current_play = new Hashtable<Canvas,Tile>();
		
		// Handles the graphical problem of placing a tile on the board.
		public static void play(Canvas grid_released) {
			
			// Replace the given Canvas with the current Tile being held.
			int column = GridPane.getColumnIndex(grid_released);
			int row = GridPane.getRowIndex(grid_released);
			GameSession.board.getChildren().remove(grid_released);
			GameSession.board.addTile(Hand.tile, column, row);
			
			// Record the information about the play.
			current_play.put(grid_released, tile);
			tiles_played.add(tile, row, column);
			board_grid_element.add(grid_released);
			number_of_plays++;
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
			
			while (!Hand.board_grid_element.isEmpty()){
				
				// Get the next board grid element in the keys property 
				Canvas tempCanvas = Hand.board_grid_element.removeFirst();
				
				// Get the Tile placed on the board grid element.
				Tile temp2 = Hand.current_play.get(tempCanvas);
				
				// Place the Tile on its rack. Refer to the Note above.
				GameSession.player.player_rack.getChildren().add(new Tile(temp2.letter));
				
				// Remove it from the board.
				GameSession.board.removeTile(temp2);
				
				// Add the board grid element back.
				GameSession.board.add(tempCanvas, GridPane.getColumnIndex(temp2), GridPane.getRowIndex(temp2));
				
				number_of_plays--;
			}
		
		}
		
		// Clears the internal state of this class. Used after making a play, valid or not.
		public static void resetState(){
			board_grid_element.clear();
			current_play.clear();
			tiles_played.clear();
			number_of_plays = 0;
		}
}
