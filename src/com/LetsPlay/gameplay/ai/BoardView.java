package com.LetsPlay.gameplay.ai;

import com.LetsPlay.gameplay.GameSession;

class BoardView {
	
	static boolean rowCrossSet(int row, int column, String tile){
		StringBuffer prefix = new StringBuffer();
		StringBuffer suffix = new StringBuffer();
		suffix.append(tile);
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
		if(prefix.length() == 1)
			return true;
		return GameSession.wordlist.isWordContained(prefix.toString());

	}
	
	
	static boolean columnCrossSet(int row, int column, String tile){
		StringBuffer prefix = new StringBuffer();
		StringBuffer suffix = new StringBuffer();
		suffix.append(tile);
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
		
		if(prefix.length() == 1)
			return true;
		
		return GameSession.wordlist.isWordContained(prefix.toString());
	}
	
	
	static boolean isColumnAnchorSquare(int row, int column){
		
		if(GameSession.board.isPositionOccupied(row, column)){
			
			return false;
			
		}else{
			
			int topsquare = row - 1;
			int downsquare = row + 2;
	
		return (GameSession.board.isPositionOccupied(topsquare, column) || GameSession.board.isPositionOccupied(downsquare, column));
		}
	}
	
	
	static boolean isRowAnchorSquare(int row, int column){
		
		if(GameSession.board.isPositionOccupied(row, column)){
			
			return false;
			
		}else{
			
			int topsquare = column - 1;
			int downsquare = column + 2;
		
			return (GameSession.board.isPositionOccupied(row, topsquare) || GameSession.board.isPositionOccupied(row, downsquare));
		}
	}
	
	static String columnPrefix(int row, int column){
		
		StringBuffer word = new StringBuffer();
		row--;
		
		while(GameSession.board.isPositionOccupied(row, column)){
			word.append(GameSession.board.TileInPosition(row, column).letter);
			row--;
		}
		
		word = word.reverse();
		
		return word.toString();
		
	}
	
	static String rowPrefix(int row, int column){
		StringBuffer word = new StringBuffer();
		column--;
		
		while(GameSession.board.isPositionOccupied(row, column)){
			word.append(GameSession.board.TileInPosition(row, column).letter);
			column--;
		}
		
		word = word.reverse();
		
		return word.toString();
		
	}
	
}
