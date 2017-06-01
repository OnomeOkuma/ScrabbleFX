/*  This class is responsible for creating the Tiles needed to generate the scrabble board.
 * the 6 methods provides the required functionality.
 * 
 */
package com.LetsPlay.ui;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;

public class TilesFactory {
			
			public TilesFactory(){
			}
			/*	All methods except createGameTile() accepts a single argument to set the id of the returned canvas 
			 * object. This is to enable the data structure representing the board adequately carry out its
			 * function. 
			 */
			
			//Creates the Double Letter Score Tile. 
			// It returns a Canvas object.
			public Canvas createDoubleLetterScore(String id){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.CYAN);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				board_tile.setId(id);
				return board_tile;
			}
			
			//Creates the Triple Letter Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleLetterScore(String id){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.BLUE);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				board_tile.setId(id);
				return board_tile;
			}
			
			//Creates the Double Word Tile.
			// It returns a Canvas object.
			public Canvas createDoubleWordScore(String id){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.PINK);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				board_tile.setId(id);
				return board_tile;
			}
			
			//Creates the Triple Word Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleWordScore(String id){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.RED);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				board_tile.setId(id);
				return board_tile;
			}
			
			//Creates an Empty Tile.
			// It returns a Canvas object.
			public Canvas createEmptyBoardTile(String id){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.SNOW);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				board_tile.setId(id);
				return board_tile;
			}
			
			//
			public Canvas createGameTile(String id, int tile_weight){
				Canvas game_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = game_tile.getGraphicsContext2D();
				draw.setFont(Font.font("Ubuntu Light", 22));
				draw.setFontSmoothingType(FontSmoothingType.LCD);
				
				if (id != "ZL"){
							draw.fillText(id, 10.0, 26.0);
						}
				
				draw.setFont(Font.font("Ubuntu Light", 11));
				draw.setFontSmoothingType(FontSmoothingType.LCD);
				draw.fillText(Integer.toString(tile_weight), 28.0, 28.5);
				

				draw.setFill(Color.BLACK);
				draw.fillRect(0, 0, 39.55, 3.0);
				draw.fillRect(0, 0, 3.0, 36.6);
				draw.fillRect(0, 33.6, 39.55, 3.0);
				draw.fillRect(36.55, 0.0, 3.0, 36.6);
				
				draw.setFill(Color.AQUA);
				draw.fillRect(3.0, 3.0, 36.55, 3.0);
				game_tile.setId(id + " " + Integer.toString(tile_weight));
				return game_tile;
			}
			
}
