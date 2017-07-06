package com.LetsPlay.gameplay;

import com.LetsPlay.ui.Tile;

public class Hand {
		private static Tile tile;

		public static Tile getTile() {
			return tile;
		}

		public static void setTile(Tile tile) {
			Hand.tile = tile;
		}
		
		
}
