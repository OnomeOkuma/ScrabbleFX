package com.LetsPlay.gameplay;

import java.util.Arrays;
import java.util.Hashtable;

public class Board {
		private Hashtable<Integer , String[]> board = new Hashtable<Integer , String[]> (15, 1);
		@SuppressWarnings("unused")
		private int column;
		@SuppressWarnings("unused")
		private int row;
		
		public void setColumn(int column) {
			this.column = column;
		}
		
		public void setRow(int row) {
			this.row = row;
		}
		
		public Board (){
			for (int temp = 0; temp < 15; temp++){
				String temp2[] = new String[15];
				Arrays.fill(temp2, null);
				this.board.put(temp, temp2);
			}
		}


		


		
		
}
