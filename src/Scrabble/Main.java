package Scrabble;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ui_Components.Board_tilesFactory;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Layout to arrange all the UI component
			Pane scene_layout = new Pane();
			
			//Layout for the Scrabble board and setting the Scrabble board properties
			GridPane board = new GridPane();
			board.relocate(80, 90);
			board.setPrefSize(593.50, 549);
			board.setGridLinesVisible(true);

			
			//Layout for the player racks
			HBox rack1 = new HBox(3);
			rack1.relocate(225, 30);
			rack1.setPrefSize(276.85, 36.6);
			
			HBox rack2 = new HBox(3);
			rack2.relocate(225, 669);
			rack2.setPrefSize(276.85, 36.6);
			
			//Creating the buttons for gameplay control
			VBox button_list = new VBox(10);
			button_list.relocate(700.5, 300);
			
			Button play_button = new Button("Play");
			play_button.setVisible(true);
			play_button.setPrefSize(90, 20);
			Button challenge_button = new Button("Challenge");
			challenge_button.setVisible(true);
			challenge_button.setPrefSize(90, 20);
			button_list.getChildren().add(play_button);
			button_list.getChildren().add(challenge_button);
			
			//Creating the board and each player racks
			Board_tilesFactory boardtiles = new Board_tilesFactory();
			for(int rowindex = 0; rowindex < 15; rowindex++){
				for(int columnindex = 0; columnindex < 15; columnindex++){
					board.add(boardtiles.create_board_grid(), columnindex, rowindex);
				}
			}
			for (int columnindex = 0; columnindex < 7; columnindex++){
				rack1.getChildren().add(boardtiles.create_board_grid());
				rack2.getChildren().add(boardtiles.create_board_grid());
			}
			
			//Putting the pieces together
			scene_layout.getChildren().add(board);
			scene_layout.getChildren().addAll(rack1, rack2);
			scene_layout.getChildren().add(button_list);
			Scene scene = new Scene(scene_layout, 1366, 768);
			primaryStage.setTitle("Let's Play");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
