/*  This class is responsible for creating the grids needed to generate the scrabble board.
 * the 6 methods provides the required functionality.
 */
package com.LetsPlay.ui;


import com.LetsPlay.Main;
import com.LetsPlay.gameplay.Hand;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BoardElements {
			
			// Tooltip components attached to each grid for clarity.
			private static Tooltip double_letter_label = new Tooltip("Double Letter Score");
			private static Tooltip triple_letter_label = new Tooltip("Triple Letter Score");
			private static Tooltip double_word_label = new Tooltip("Double Word Score");
			private static Tooltip triple_word_label = new Tooltip("Triple Word Score");
			
			// Creates the Double Letter Score Grid element. 
			// It returns a Canvas object.
			public static Canvas createDoubleLetterScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				
				//Color for a Double Letter Grid element. 
				draw.setFill(Color.CYAN);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, BoardElements.double_letter_label);
				board_tile.setOnMouseDragEntered(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.GRAY);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragExited(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.CYAN);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragReleased(event -> {
					int column = GridPane.getColumnIndex(board_tile);
					int row = GridPane.getRowIndex(board_tile);
					Hand.record_play(board_tile);
					Main.board.getChildren().remove(board_tile);
					Main.board.add(Hand.getTile(), column, row);
				});
				return board_tile;
			}
			
			// Creates the Triple Letter Score Grid element.
			// It returns a Canvas object.
			public static Canvas createTripleLetterScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				
				// Color for a Triple Letter Grid element.
				draw.setFill(Color.BLUE);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, BoardElements.triple_letter_label);
				board_tile.setOnMouseDragEntered(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.GRAY);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragExited(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.BLUE);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragReleased(event -> {
					int column = GridPane.getColumnIndex(board_tile);
					int row = GridPane.getRowIndex(board_tile);
					Hand.record_play(board_tile);
					Main.board.getChildren().remove(board_tile);
					Main.board.add(Hand.getTile(), column, row);
				});
				return board_tile;
			}
			
			//Creates the Double Word Grid element.
			// It returns a Canvas object.
			public static Canvas createDoubleWordScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				
				//Color for a Double Word Grid Element.
				draw.setFill(Color.PINK);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, BoardElements.double_word_label);
				board_tile.setOnMouseDragEntered(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.GRAY);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragExited(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.PINK);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragReleased(event -> {
					int column = GridPane.getColumnIndex(board_tile);
					int row = GridPane.getRowIndex(board_tile);
					Hand.record_play(board_tile);
					Main.board.getChildren().remove(board_tile);
					Main.board.add(Hand.getTile(), column, row);
				});
				return board_tile;
			}
			
			// Creates the Triple Word Score Grid element.
			// It returns a Canvas object.
			public static Canvas createTripleWordScore(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				
				// Color for the Triple Word Grid element.
				draw.setFill(Color.RED);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				Tooltip.install(board_tile, BoardElements.triple_word_label);
				board_tile.setOnMouseDragEntered(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.GRAY);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragExited(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.RED);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragReleased(event -> {
					int column = GridPane.getColumnIndex(board_tile);
					int row = GridPane.getRowIndex(board_tile);
					Hand.record_play(board_tile);
					Main.board.getChildren().remove(board_tile);
					Main.board.add(Hand.getTile(), column, row);
				});
				
				return board_tile;
			}
			
			// Creates a Scoreless Grid element.
			// It returns a Canvas object.
			public static Canvas createEmptyBoardTile(){
				Canvas board_tile = new Canvas(39.55, 36.6);
				GraphicsContext draw = board_tile.getGraphicsContext2D();
				
				// Color for the Scoreless Grid element. 
				draw.setFill(Color.SNOW);
				draw.fillRect(0.0, 0.0, 39.55, 36.6);
				board_tile.setOnMouseDragEntered(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.GRAY);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragExited(event -> {
					GraphicsContext temp = board_tile.getGraphicsContext2D();
					temp.setFill(Color.SNOW);
					temp.fillRect(0.0, 0.0, 39.55, 36.6);
				});
				board_tile.setOnMouseDragReleased(event -> {
					int column = GridPane.getColumnIndex(board_tile);
					int row = GridPane.getRowIndex(board_tile);
					Hand.record_play(board_tile);
					Main.board.getChildren().remove(board_tile);
					Main.board.add(Hand.getTile(), column, row);
				});
				return board_tile;
			}
			
			
}
