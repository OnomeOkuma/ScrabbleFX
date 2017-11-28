package com.LetsPlay.gameplay.rules;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;
import com.LetsPlay.ui.GameLayout;

public class SingleTilePlayChecker {

		public static boolean checkWord(){
			if(SingleTilePlayChecker.isRowPlay() && !SingleTilePlayChecker.isColumnPlay()){
				return SingleTilePlayChecker.checkWordRow();
			} else if (!SingleTilePlayChecker.isRowPlay() && SingleTilePlayChecker.isColumnPlay()){
				return SingleTilePlayChecker.checkWordColumn();
			} else if (SingleTilePlayChecker.isRowPlay() && SingleTilePlayChecker.isColumnPlay()){
				return (SingleTilePlayChecker.checkWordRow() && SingleTilePlayChecker.checkWordColumn());
			} else return false;
		}
	
		public static boolean isSingleTilePlay(){
			return (Hand.tiles_played.sameRow() && Hand.tiles_played.sameColumn());
			}
		
		
		static boolean isRowPlay(){
			int row = Hand.tiles_played.row.get(0);
			int column = Hand.tiles_played.column.get(0);
			return (GameLayout.board.isPositionOccupied(row, (column + 1)) || GameLayout.board.isPositionOccupied(row, (column - 1)));
			}
		
		
		static boolean isColumnPlay(){
			int row = Hand.tiles_played.row.get(0);
			int column = Hand.tiles_played.column.get(0);
			return (GameLayout.board.isPositionOccupied((row + 1), column) || GameLayout.board.isPositionOccupied((row - 1), column));
			}
		
		
		private static boolean checkWordRow(){
			StringBuffer word = new StringBuffer();
			int row = Hand.tiles_played.row.get(0);
			int column = Hand.tiles_played.column.get(0);
			while(GameLayout.board.isPositionOccupied(row, column)){
				word.append(GameLayout.board.TileInPosition(row, column).letter);
				column--;
			}
			word = word.reverse();
			column = Hand.tiles_played.column.get(0);
			column++;
		
			while(GameLayout.board.isPositionOccupied(row, column)){
				word.append(GameLayout.board.TileInPosition(row, column).letter);
				column++;
			}
		
			return GameSession.wordlist.isWordContained(word.toString());
			}
	
		
		
		private static boolean checkWordColumn(){
		
			StringBuffer word = new StringBuffer();
			int row = Hand.tiles_played.row.get(0);
			int column = Hand.tiles_played.column.get(0);
			while(GameLayout.board.isPositionOccupied(row, column)){
				word.append(GameLayout.board.TileInPosition(row, column).letter);
				row--;
			}
		
			word = word.reverse();
			row = Hand.tiles_played.row.get(0);
			row++;
		
			while(GameLayout.board.isPositionOccupied(row, column)){
				word.append(GameLayout.board.TileInPosition(row, column).letter);
				row++;
			}
	
			return GameSession.wordlist.isWordContained(word.toString());
		}
	
}
