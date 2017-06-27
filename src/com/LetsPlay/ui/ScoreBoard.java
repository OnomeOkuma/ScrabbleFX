/* 	The ScoreBoard class handles the presentation of players score and player names.
 * It was created because EventHandlers would change scores based on gameplay
 * and change names based on information supplied before the game starts.
 * 	Because of this, it has 4 JavaFx nodes properties that are private to this class. 
 * Thus it can only be modified by the methods made available.
 * 		Note: Changes would be made to this class too.    
 */
package com.LetsPlay.ui;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ScoreBoard extends VBox{
			private Text player_name1 = new Text();
			private Text player_name2 = new Text();
			private Canvas player_1_score = new Canvas(80, 40); 
			private Canvas player_2_score = new Canvas(80, 40);

			//Constructor Statement.
			public ScoreBoard(){
					super(4.55);
					this.player_name1.setFont(new Font ("Ubuntu light", 15.5));
					this.player_name2.setFont(new Font ("Ubuntu light", 15.5));
					this.getChildren().add(this.player_name1);
					this.getChildren().add(this.player_1_score);
					this.getChildren().add(this.player_name2);
					this.getChildren().add(this.player_2_score);
			}
			
			// Sets the score of the game. It uses the Boolean argument to determine
			// whose score to change. 
			public void set_score(String score, Boolean player ){
				if (player == true){
					GraphicsContext temp = this.player_1_score.getGraphicsContext2D();
					temp.setFont(new Font("Ubuntu light", 20));
					temp.fillText(score, 12.56, 15);
				} else {
					GraphicsContext temp = this.player_2_score.getGraphicsContext2D();
					temp.setFont(new Font("Ubuntu light", 20));
					temp.fillText(score, 12.56, 15);
				}
			}
			
			// Sets the Player Name. It uses the Boolean argument to determine
			// whose name to set. 
			public void set_player_name(String playername, Boolean player){
				if(player == true){
					this.player_name1.setText(playername);
				} else {
					this.player_name2.setText(playername);
				}
			}
			
}
