/* Class representing a Single Tile object. This class enables
 * us manipulate a Tile object as we would a physical Tile.
 */
package com.LetsPlay.ui;

import java.io.Serializable;
import java.util.Hashtable;

import com.LetsPlay.gameplay.Hand;

import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;

public class Tile extends Pane implements Serializable{
			/**
	 * 
	 */
	private static final long serialVersionUID = 4290494497449372710L;

			// Property holding the Tile letter/Tile weight mapping for 
			// easy initialization of the Tile object.
			private final Hashtable<String, Integer> tileweight = new Hashtable<String, Integer>(26);
			
			// Letter on Tile.
			public final String letter;
			
			// Score on Tile.
			final int score;
			
			public Tile(String letter){
				// Constructor statement.
				super();
				
				// Set the width, height, effect and style of the Tile.
				this.setWidth(39.55);
				this.setHeight(36.6);
				this.setEffect(new DropShadow(1.80, 0.0, 0.0, Color.GREY));
				this.setStyle("-fx-background-color: #fffacd");
				
				// Populate the tileweight property with its key/value pairs.
				this.tileweight.put("A", 1);
				this.tileweight.put("B", 3);
				this.tileweight.put("C", 3);
				this.tileweight.put("D", 2);
				this.tileweight.put("E", 1);
				this.tileweight.put("F", 4);
				this.tileweight.put("G", 2);
				this.tileweight.put("H", 4);
				this.tileweight.put("I", 1);
				this.tileweight.put("J", 8);
				this.tileweight.put("K", 5);
				this.tileweight.put("L", 1);
				this.tileweight.put("M", 3);
				this.tileweight.put("N", 1);
				this.tileweight.put("O", 1);
				this.tileweight.put("P", 3);
				this.tileweight.put("Q", 10);
				this.tileweight.put("R", 1);
				this.tileweight.put("S", 1);
				this.tileweight.put("T", 1);
				this.tileweight.put("U", 1);
				this.tileweight.put("V", 4);
				this.tileweight.put("W", 4);
				this.tileweight.put("X", 8);
				this.tileweight.put("Y", 4);
				this.tileweight.put("Z", 10);
				this.tileweight.put(" ", 0);
				
				// Set the letter and score.
				this.letter = letter;
				this.score = this.tileweight.get(letter);
				
				// Create the canvas.
				Canvas temp = new Canvas(39.55,36.6);
				// GraphicsContext to draw the necessary information.
				GraphicsContext temp2 = temp.getGraphicsContext2D();
				temp2.setFont(Font.font("Ubuntu Light", 22));
				temp2.setFontSmoothingType(FontSmoothingType.LCD);
				temp2.setFill(Color.BLACK);
				temp2.fillText(this.letter, 10.0, 26.0);
				temp2.setFont(Font.font("Ubuntu Light", 11));
				temp2.setFontSmoothingType(FontSmoothingType.LCD);
				temp2.fillText(Integer.toString(this.score), 26.6, 28.5);
				
				// Add the canvas to the Pane object to create the Tile.
				this.getChildren().add(temp);
				this.tileweight.clear();
				
				// Action when mouse is pressed.
				this.setOnMousePressed(event -> {
						setMouseTransparent(true);
						Hand.setTile(this);
					});
				
				// Action when mouse is dragged.
				this.setOnMouseDragged(event -> {
					this.setCursor(Cursor.CLOSED_HAND);
				});
				
				// Action when mouse is released.
				this.setOnMouseReleased(event -> {
					setMouseTransparent(false);
				});
				
				// Action when mouse enters this object.
				this.setOnMouseEntered(event -> {
					this.setStyle("-fx-background-color: #f0fff0;");
					this.setCursor(Cursor.CROSSHAIR);
				});
				
				//Action when mouse leaves this object.
				this.setOnMouseExited(event -> {
					this.setStyle("-fx-background-color: #fffacd");
					this.setCursor(Cursor.DEFAULT);
				});
				
				this.setOnDragDetected(event -> {
					this.startFullDrag();
				});
		
			}
			
}
