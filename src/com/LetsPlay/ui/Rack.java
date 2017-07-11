package com.LetsPlay.ui;

import javafx.scene.layout.HBox;

public class Rack extends HBox{
	
		public Rack(){
			super(1.55);
			this.setPrefSize(276.85, 36.6);
			this.setStyle("-fx-background-color: #f0fff0;");
		}
		
		public void putTile(Tile tile){
			this.getChildren().add(tile);
		}
}
