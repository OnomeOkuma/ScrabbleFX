/*  This class is responsible for creating the Tiles needed to generate the scrabble board.
 * it contains 5 methods provides the required functionality. it does this by creating a Canvas object,
 * drawing on it and returning the said object.
 * 
 * Note: this class would be refactored extensively tomorrow.
 */
package com.LetsPlay.ui;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class BoardGridTilesFactory {
			
			public BoardGridTilesFactory(){
			}
			//Note: All methods in this class accept two string parameters to enable it create
			//a unique id for the return object.
			
			//Creates the Double Letter Score Tile. 
			// It returns a Canvas object.
			public Canvas createDoubleLetterScore(String rowId, String columnId){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.CYAN);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				if (columnId == null){
						boardTile.setId("Triple Letter Score " + rowId );
					} else if (rowId == null){
								boardTile.setId("Triple Letter Score " + columnId );
					} else {
						boardTile.setId("Triple Letter Score " + rowId + columnId );
					}
				return boardTile;
			}
			
			//Creates the Triple Letter Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleLetterScore(String rowId, String columnId){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.BLUE);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				if (columnId == null){
					boardTile.setId("Triple Letter Score " + rowId );
				} else if (rowId == null){
							boardTile.setId("Triple Letter Score " + columnId );
				} else {
					boardTile.setId("Triple Letter Score " + rowId + columnId );
				}
				return boardTile;
			}
			
			//Creates the Double Word Tile.
			// It returns a Canvas object.
			public Canvas createDoubleWordScore(String rowId, String columnId){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.PINK);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				if (columnId == null){
					boardTile.setId("Triple Letter Score " + rowId );
				} else if (rowId == null){
							boardTile.setId("Triple Letter Score " + columnId );
				} else {
					boardTile.setId("Triple Letter Score " + rowId + columnId );
				}
				return boardTile;
			}
			
			//Creates the Triple Word Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleWordScore(String rowId, String columnId){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.RED);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				if (columnId == null){
					boardTile.setId("Triple Letter Score " + rowId );
				} else if (rowId == null){
							boardTile.setId("Triple Letter Score " + columnId );
				} else {
					boardTile.setId("Triple Letter Score " + rowId + columnId );
				}
		
				return boardTile;
			}
			
			//Creates an Empty Tile.
			// It returns a Canvas object.
			public Canvas createEmptyBoardTile(String rowId, String columnId){
				Canvas boardTile = new Canvas(39.55, 36.6);
				GraphicsContext draw = boardTile.getGraphicsContext2D();
				draw.setFill(Color.SNOW);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				if (columnId == null){
					boardTile.setId("Triple Letter Score " + rowId );
				} else if (rowId == null){
							boardTile.setId("Triple Letter Score " + columnId );
				} else {
					boardTile.setId("Triple Letter Score " + rowId + columnId );
				}
				
				return boardTile;
			}
			
}
