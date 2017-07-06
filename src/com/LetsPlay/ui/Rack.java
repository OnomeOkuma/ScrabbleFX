package com.LetsPlay.ui;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.layout.HBox;

public class Rack extends HBox{
		private int number_of_tiles_added = 0;
		private Stack <Tile> tiles_on_rack = new Stack <Tile>();

		public Rack(){
			super(1.55);
		}
		
		public Tile removeTile(Tile tile){
			this.tiles_on_rack.remove(tile);
			this.number_of_tiles_added = 0;
			this.getChildren().remove(tile);
			return tile;
		}
		
		public void putTile(Tile tile){
			this.getChildren().add(tile);
			this.number_of_tiles_added++;
			this.tiles_on_rack.push(tile);
		}
		
		public ArrayList<Tile> returnTiles(){
			ArrayList<Tile> temp = new ArrayList<Tile>();
			for (int counter = 0; counter < this.number_of_tiles_added; counter++){
				temp.add(this.tiles_on_rack.pop());
			}
			this.number_of_tiles_added = 0;
			return temp;
		}
}
