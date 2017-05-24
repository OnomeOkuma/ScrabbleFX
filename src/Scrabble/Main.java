package Scrabble;
	
import javafx.application.Application;
import javafx.stage.Stage;
import scene_Components.Board_tilesFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Layout to arrange all the UI component
			Pane scene_layout = new Pane();
			
			//Layout for the Scrabble board 
			TilePane Board = new TilePane();
			
			//Setting the Scrabble board properties
			Board.relocate(60, 70);
			Board.setMaxSize(641.08, 591.22);
			//Board.setPrefTileHeight(42.74);
			Board.setPrefTileWidth(39.41);
			Board.setPrefColumns(15);
			
			
			for (int i = 0 ; i < 225 ; i++){
				int q = 1;
				if (q < 100){
					Board_tilesFactory boardtiles = new Board_tilesFactory();
					Board.getChildren().add(boardtiles.Create_tiles(Color.AQUA));
					++q;
					System.out.println("Smoke this yo");
				}
				
					else {
						Board_tilesFactory boardtiles = new Board_tilesFactory();
						Board.getChildren().add(boardtiles.Create_tiles(Color.RED));
						++q;
						System.out.print("This is how i role");
					}
			}
			
			scene_layout.getChildren().add(Board);
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
