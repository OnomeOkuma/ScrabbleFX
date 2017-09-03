package com.LetsPlay.gameplay.ai;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.ui.Tile;

class CrossSet {
	
	static boolean rowCrossSet(int row, int column, Tile tile){
		StringBuffer prefix = new StringBuffer();
		StringBuffer suffix = new StringBuffer();
		suffix.append(tile.letter);
		int temp = column;
		temp--;
		
		while(GameSession.board.isPositionOccupied(row, temp)){
			prefix.append(GameSession.board.TileInPosition(row, temp).letter);
			temp--;
		}
		
		prefix = prefix.reverse();
		column++;
		
		while(GameSession.board.isPositionOccupied(row, column)){
			suffix.append(GameSession.board.TileInPosition(row, column).letter);
			column++;
		}
		
		prefix.append(suffix);
		return GameSession.wordlist.isWordContained(prefix.toString());

	}
	
	static boolean columnCrossSet(int row, int column, Tile tile){
		StringBuffer prefix = new StringBuffer();
		StringBuffer suffix = new StringBuffer();
		suffix.append(tile.letter);
		int temp = row;
		temp--;
		
		while(GameSession.board.isPositionOccupied(temp, column)){
			prefix.append(GameSession.board.TileInPosition(temp, column).letter);
			temp--;
		}
		
		prefix = prefix.reverse();
		row++;
		
		while(GameSession.board.isPositionOccupied(row, column)){
			suffix.append(GameSession.board.TileInPosition(row, column).letter);
			row++;
		}
		
		prefix.append(suffix);
		return GameSession.wordlist.isWordContained(prefix.toString());
	}
}