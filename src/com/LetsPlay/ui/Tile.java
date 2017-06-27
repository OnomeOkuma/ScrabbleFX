/* Class representing a Single Tile object. This class enables
 * us manipulate a Tile object as we would a physical Tile.
 */
package com.LetsPlay.ui;

import java.io.Serializable;
import java.util.Hashtable;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;

public class Tile extends Canvas implements Serializable{
			/**
	 * 
	 */
	private static final long serialVersionUID = 4290494497449372710L;

			// Property holding the Tile letter/Tile weight mapping for 
			// easy initialization of the Tile object.
			private final Hashtable<String, Integer> tileweight = new Hashtable<String, Integer>(26);
			
			// Letter on Tile.
			final String letter;
			
			// Score on Tile.
			final int score;
			
			public Tile(String letter){
				
				super(39.55,36.6);
				
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
				
				//Set the letter and score.
				this.letter = letter;
				this.score = this.tileweight.get(letter);
				
				//GraphicsContext to draw the necessary information.
				GraphicsContext temp = this.getGraphicsContext2D();
				temp.setFont(Font.font("Ubuntu Light", 22));
				temp.setFontSmoothingType(FontSmoothingType.LCD);
				temp.fillText(this.letter, 10.0, 26.0);
				
				temp.setFont(Font.font("Ubuntu Light", 11));
				temp.setFontSmoothingType(FontSmoothingType.LCD);
				temp.fillText(Integer.toString(this.score), 28.0, 28.5);
				

				temp.setFill(Color.BLUE);
				temp.fillRect(0, 0, 39.55, 3.0);
				temp.fillRect(0, 0, 3.0, 36.6);
				temp.fillRect(0, 33.6, 39.55, 3.0);
				temp.fillRect(36.55, 0.0, 3.0, 36.6);
				
				temp.setFill(Color.AQUA);
				temp.fillRect(3.0, 3.0, 36.55, 3.0);
				this.tileweight.clear();
				this.setOnMousePressed(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						setMouseTransparent(true);
						event.consume();
					}
					
				});
				this.setOnDragDetected(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						startFullDrag();
						System.out.println("Lord Celebrimbor");
					}
					
				});
				this.setOnMouseReleased(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						// TODO Auto-generated method stub
						setMouseTransparent(false);
						event.consume();
					}
						
				});
			}
			
}
