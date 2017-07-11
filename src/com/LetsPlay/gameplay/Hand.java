/*
 * 	As the name implies, the Hand class is modeled after the human hand which is the primary 
 * tool for tile placement. In addition to its obvious uses according to the game, this class
 * also has a short term storage. This is to enable the proper undoing of any unwanted plays made 
 * during gameplay. As with all other classes, it is still under active development hence it may
 * be removed.   
 */

package com.LetsPlay.gameplay;

import java.util.Enumeration;
import java.util.Hashtable;
import com.LetsPlay.Main;
import com.LetsPlay.ui.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;

public class Hand {
		// Holds the Tile currently being dragged.
		private static Tile tile;
		
		// Stores the location of any board grid element holding a tile. 
		private static Hashtable<Canvas, int[]> board_grid_element = new Hashtable<Canvas, int[]>();
		
		// Stores the keys from board_grid_element to enable it to be sequencially accessed.
		private static Enumeration<Canvas> keys;
		
		// Records the Tiles placed on each board grid element.
		private static Hashtable<Canvas,Tile> current_play = new Hashtable<Canvas,Tile>();
		
		// Record the board grid element and its location when a MouseDragReleased event is fired on it.
		public static void record_play(Canvas grid_released) {
			int coordinates[] = new int[2];
			coordinates[0] = GridPane.getColumnIndex(grid_released);
			coordinates[1] = GridPane.getRowIndex(grid_released);
			board_grid_element.put(grid_released, coordinates);
			current_play.put(grid_released, tile);
			keys = board_grid_element.keys();
		}
		public static Tile getTile() {
			return tile;
		}
		public static void setTile(Tile tile) {
			Hand.tile = tile;
		}
		
		// Returns the Tiles to their previous location in the scene.
		/*
		 *  Note: when the Tiles are returned to their respective rack,
		 *  A new tile is created using the information of the old tile.
		 *  This is because the old tile no longer responds to MouseEvents.
		 *  Will look into this problem later.
		 */
		
		public static void undo_play(){
			while (Hand.keys.hasMoreElements()){
				Canvas tempCanvas = Hand.keys.nextElement();
				int temp[] = Hand.board_grid_element.get(tempCanvas);
				Tile temp2 = Hand.current_play.get(tempCanvas);
				Main.rack1.getChildren().add(new Tile(temp2.letter));
				Main.board.getChildren().remove(temp2);
				Main.board.add(tempCanvas, temp[0], temp[1]);
			}
			board_grid_element.clear();
			current_play.clear();
		}
}
