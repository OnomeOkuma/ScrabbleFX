/*  This class is responsible for creating the Tiles needed to generate the scrabble board.
 * it contains 5 methods provides the required functionality. it does this by creating a Canvas object,
 * drawing on it and returning the said object.
 */
package ui_Components;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class BoardGridTilesFactory {
			
			public BoardGridTilesFactory(){
			}
			
			//Creates the Double Letter Score Tile.
			// It returns a Canvas object.
			public Canvas createDoubleLetterScore(){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.CYAN);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				boardTile.setId("Double Letter Score");
				return boardTile;
			}
			
			//Creates the Triple Letter Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleLetterScore(){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.BLUE);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				boardTile.setId("Triple Letter Score");
				return boardTile;
			}
			
			//Creates the Double Word Tile.
			// It returns a Canvas object.
			public Canvas createDoubleWordScore(){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.PINK);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				boardTile.setId("Double Word Score");
				return boardTile;
			}
			
			//Creates the Triple Word Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleWordScore(){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.RED);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				boardTile.setId("Triple Word Score");
				return boardTile;
			}
			
			//Creates an Empty Tile.
			// It returns a Canvas object.
			public Canvas createEmptyBoardLayout(){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.SNOW);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				boardTile.setId("Empty Board Layout");
				return boardTile;
			}
			
}
