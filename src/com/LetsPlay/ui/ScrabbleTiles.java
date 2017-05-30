/* The ScrabbleTiles class is responsible for creating the scrabble tiles. 
 * More methods would be added to it tomorrow because i am tired, i did not sleep well last night.
 * 
 * Note: Today, May 29th 2017, it was decided that this class would be merged with the BoardGridTilesFactory class.
 * this is because they both serve the same function and it would be less verbose to do that using the BoardGridTilesFactory class.
 * 
 */


package com.LetsPlay.ui;

import com.LetsPlay.gameplay.TileBag;

import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;


public class ScrabbleTiles {
			
			private Font LETTER_SIZE = new Font(22);
			private Font NUMBER_SIZE = new Font(11);
			private TileBag tilebag = new TileBag();
			public ScrabbleTiles(){
				System.out.println(Font.getFamilies().toString());
			}
			
			public Canvas TileA(){
				Canvas canvas = new Canvas(39.55, 36.6);
				GraphicsContext draw = canvas.getGraphicsContext2D();
				draw.setFont(this.LETTER_SIZE);
				draw.setFontSmoothingType(FontSmoothingType.LCD);
				
				
				draw.fillText(this.tilebag.getTile(), 10.0, 26.0);
				draw.setFont(this.NUMBER_SIZE);
				draw.setFontSmoothingType(FontSmoothingType.LCD);
				draw.fillText("1", 28.0, 28.5);
				

				draw.setFill(Color.BLUE);
				draw.fillRect(0, 0, 39.55, 3.0);
				draw.fillRect(0, 0, 3.0, 36.6);
				draw.fillRect(0, 33.6, 39.55, 3.0);
				draw.fillRect(36.55, 0.0, 3.0, 36.6);
				
				draw.setFill(Color.AQUA);
				draw.fillRect(3.0, 3.0, 36.55, 3.0);
				return canvas;
			}
			
			public Canvas TileB(){
				Canvas canvas = new Canvas(39.55, 36.6);
				GraphicsContext draw = canvas.getGraphicsContext2D();
				draw.setFont(Font.font("Ubuntu Light", 22));
				draw.setFontSmoothingType(FontSmoothingType.LCD);
				
				
				draw.fillText(this.tilebag.getTile(), 9.0, 26.0);
				draw.setFont(this.NUMBER_SIZE);
				draw.setFontSmoothingType(FontSmoothingType.LCD);
				draw.fillText(Integer.toString(this.tilebag.getTileWeight("K")), 27.0, 28.5);
				

				draw.setFill(Color.VIOLET);
				draw.fillRect(0, 0, 39.55, 3.0);
				draw.fillRect(0, 0, 3.0, 36.6);
				draw.fillRect(0, 33.6, 39.55, 3.0);
				draw.fillRect(36.55, 0.0, 3.0, 36.6);
				
				draw.setFill(Color.AQUA);
				draw.fillRect(3.0, 3.0, 36.55, 3.0);
				return canvas;
			}
			
		
			
}
