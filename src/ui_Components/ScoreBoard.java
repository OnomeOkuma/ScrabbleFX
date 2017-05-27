/* 		The ScoreBoard class handles the presentation of players score and player names.
 * It was created because EventHandlers would change scores based on gameplay
 * and change names based on information supplied before the game starts.
 * 		Because of this, it has 4 JavaFx nodes properties that are private to this class. 
 * Thus it can only be modified by the methods made available.
 * 		Note: Changes would be made to this class too.    
 */
package ui_Components;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class ScoreBoard extends VBox{
			private Label player_name1 = new Label();
			private Label player_name2 = new Label();
			private TextField player_1_score = new TextField("300");
			private TextField Player_2_score = new TextField("200");

			//Constructor Statement.
			public ScoreBoard(){
					this.setSpacing(5);
					this.player_1_score.setEditable(false);
					this.player_1_score.setPrefWidth(90);
					this.Player_2_score.setEditable(false);
					this.Player_2_score.setPrefWidth(90);
					this.getChildren().add(this.player_name1);
					this.getChildren().add(this.player_1_score);
					this.getChildren().add(this.player_name2);
					this.getChildren().add(this.Player_2_score);
			}
			
			// Sets the score of the game. It uses the Boolean argument to determine
			// whose score to change. 
			public void set_score(String score, Boolean player ){
				if (player == true){
					this.player_1_score.setText(score);
				} else {
					this.Player_2_score.setText(score);
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
