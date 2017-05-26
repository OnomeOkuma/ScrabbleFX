/* This class creates the board layout. Its methods will create a canvas on which
 * the details of each grid in the board will be drawn upon. This class would be refactored 
 * as the project grows to reflect its function.
 */
package ui_Components;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Board_tilesFactory {
			
			public Board_tilesFactory(){
			}
			
			//This function is temporary. It would be fleshed out to reflect its true purpose
			public Canvas create_board_grid(){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.CYAN);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				return boardTile;
			}
}
