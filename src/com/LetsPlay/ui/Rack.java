package com.LetsPlay.ui;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.layout.HBox;

public class Rack extends HBox{
		private int tiles_added = 0;
		private Stack <Tile> recent_tiles_added = new Stack <Tile>();

		public Rack(){
			this.setSpacing(5.55);
		}
		
		public void putTile(Tile tile){
			this.getChildren().add(tile);
			this.tiles_added++;
			this.recent_tiles_added.push(tile);
		}
		
		public ArrayList<Tile> returnTiles(){
			ArrayList<Tile> temp = new ArrayList<Tile>();
			for (int counter = 0; counter < this.tiles_added; counter++){
				temp.add(this.recent_tiles_added.pop());
			}
			this.tiles_added = 0;
			return temp;
		}
}
