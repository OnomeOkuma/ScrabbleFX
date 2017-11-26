/* 	The ScoreBoard class handles the presentation of players score and player names.
 * It was created because EventHandlers would change scores based on gameplay
 * and change names based on information supplied before the game starts.
 * 	Because of this, it has 4 JavaFx nodes properties that are private to this class. 
 * Thus it can only be modified by the methods made available.
 * 		Note: Changes would be made to this class too.    
 */
package com.LetsPlay.ui;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ScoreBoard extends VBox{
	
			private Pane background = new Pane();
			private Label playerscore = new Label("25");
			private Label playername = new Label("Unknown");
			private int Score = 0;
			
			public ScoreBoard(){
				super(5);
				this.setPrefSize(100, 60);
				this.background.setPrefSize(100, 40);
				this.background.setStyle("-fx-background-color: #ffff00");
				this.background.getChildren().add(this.playerscore);
				this.playerscore.setTextOverrun(OverrunStyle.WORD_ELLIPSIS);
				this.playerscore.setFont(new Font(20.00));
				this.playerscore.setAlignment(Pos.CENTER);
				this.playername.setTextOverrun(OverrunStyle.WORD_ELLIPSIS);
				this.playername.setFont(new Font(17.00));
				this.playername.setAlignment(Pos.CENTER);
				
				this.getChildren().add(this.playername);
				this.getChildren().add(this.background);
			}
			
			public void setName(String name){
				this.playername.setText(name);
			}
			
			public void setScore(int score){
				this.Score += score; 
				this.playerscore.setText(Integer.toString(this.Score));
			}
			
			public void restart(){
				this.Score = 0;
				this.playerscore.setText(Integer.toString(this.Score));
			}
}
