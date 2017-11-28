package com.LetsPlay;
	

import java.net.URI;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.ui.GameLayout;
import com.LetsPlay.ui.PlayersView;
import com.LetsPlay.util.WebSocketConnection;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			 String destUri = "ws://localhost:4567/";
			
			 WebSocketClient client = new WebSocketClient();
			 WebSocketConnection websocket = new WebSocketConnection();
			 
			 try
		        {
		            client.start();

		            URI echoUri = new URI(destUri);
		            ClientUpgradeRequest request = new ClientUpgradeRequest();
		            client.connect(websocket,echoUri,request);
		            System.out.printf("Connecting to : " + echoUri.getPath());
		            
		        }
		        catch (Throwable t)
		        {
		            t.printStackTrace();
		        }
			 
			// Initialize the GameSession object
			GameSession.init();
			PlayersView.playerview.relocate(1000, 50);
			
			Scene scene = new Scene(GameLayout.sceneLayout, 1366, 768);
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
