/*This is a class for creating the Scrabble board grid. It does this by creating tiles
 * which would then be added by the Board object in the Main.java file. 
 * */
package scene_Components;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Board_tilesFactory {
			
			public Board_tilesFactory(){
			}
			
			public Canvas Create_tiles(Color color){
				Canvas BoardTile = new Canvas(42.74, 42.74);
				GraphicsContext draw = BoardTile.getGraphicsContext2D();
				draw.setFill(color);
				draw.fillRect(0, 0, 42.74, 39.41);
				return BoardTile;
			}
}
