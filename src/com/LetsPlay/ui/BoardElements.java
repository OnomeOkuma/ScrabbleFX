/*  This class is responsible for creating the Tiles needed to generate the scrabble board.
 * the 6 methods provides the required functionality.
 * 
 */
package com.LetsPlay.ui;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

public class BoardElements {
			
			private Tooltip double_letter_label = new Tooltip("Double Letter Score");
			private Tooltip triple_letter_label = new Tooltip("Triple Letter Score");
			private Tooltip double_word_label = new Tooltip("Double Word Score");
			private Tooltip triple_word_label = new Tooltip("Triple Word Score");
			
			public BoardElements(){
			}
			/*	All methods except createGameTile() accepts a single argument to set the id of the returned canvas 
			 * object. This is to enable the data structure representing the board adequately carry out its
			 * function. 
			 */
			
			//Creates the Double Letter Score Tile. 
			// It returns a Canvas object.
			public Canvas createDoubleLetterScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.CYAN);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, this.double_letter_label);
				return board_tile;
			}
			
			//Creates the Triple Letter Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleLetterScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.BLUE);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, this.triple_letter_label);
				return board_tile;
			}
			
			//Creates the Double Word Tile.
			// It returns a Canvas object.
			public Canvas createDoubleWordScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.PINK);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, this.double_word_label);
				return board_tile;
			}
			
			//Creates the Triple Word Score Tile.
			// It returns a Canvas object.
			public Canvas createTripleWordScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.RED);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, this.triple_word_label);
				return board_tile;
			}
			
			//Creates an Empty Tile.
			// It returns a Canvas object.
			public Canvas createEmptyBoardTile(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				draw.setFill(Color.SNOW);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				return board_tile;
			}
			
			
}
