/*
 * This class checks the validity of play made by the player.  
 */
package com.LetsPlay.gameplay;

import java.util.Iterator;

public class PlayChecker {
		
// Checks if the play was made on the same column or row.
	public static boolean onSameLine(){
		
		// Checks if tiles are on the same row.
		if (Hand.tiles_played.sameRow())
			return true;
		
			// Checks if tiles are on the same column.
			else if (Hand.tiles_played.sameColumn())
				return true;
		
				else return false;
	}
	
	 
// Checks if the tiles are placed Consercutively on the board. 	
	public static boolean isPlayConsercutive(){
		if (Hand.tiles_played.sameRow()){
			Iterator<Integer> iterator = Hand.tiles_played.column.iterator();
			int temp = iterator.next();
			while (iterator.hasNext()){
				int temp2 = iterator.next();
				
				// If the difference is more than 1, it means that a column was skipped. 
				if ((temp2 - temp) != 1)
					return false;
				
				else temp = temp2;
			}
			
			return true;
			
		}else if (Hand.tiles_played.sameColumn()){
			Iterator<Integer> iterator = Hand.tiles_played.row.iterator();
			int temp = iterator.next();
			while (iterator.hasNext()){
				int temp2 = iterator.next();
				
				if ((temp2 - temp) != 1)
					return false;
				
				// If the difference is more than 1, it means that a row was skipped.
				else temp = temp2;
			}
			
			return true;
		}
		
		return false;
	}

// Checks if the play made was suffixed to a previous play on the board.
	public static boolean isPlaySuffixed(){
		int column = Hand.tiles_played.column.get(0);
		int row = Hand.tiles_played.row.get(0);
		
		
		if (Hand.tiles_played.sameRow() && GameSession.board.isPositionOccupied(row, (column-1)))
			return true;
		else if (Hand.tiles_played.sameRow() && GameSession.board.isPositionOccupied((row - 1), column))
			return true;
		else if (Hand.tiles_played.sameRow() && GameSession.board.isPositionOccupied((row + 1), column))
			return true;
		else if (Hand.tiles_played.sameColumn() && GameSession.board.isPositionOccupied((row - 1), column))
			return true;
		else if (Hand.tiles_played.sameColumn() && GameSession.board.isPositionOccupied(row, (column - 1)))
			return true;
		else if (Hand.tiles_played.sameColumn() && GameSession.board.isPositionOccupied(row, (column + 1)))
			return true;
		return false;
	}
	
// Checks if the play made was prefixed to a previous play made on the board.
	public static boolean isPlayPrefixed(){
		int column = Hand.tiles_played.column.get((Hand.tiles_played.column.size() - 1));
		int row = Hand.tiles_played.row.get((Hand.tiles_played.row.size() - 1));
			
		if (Hand.tiles_played.sameRow() && GameSession.board.isPositionOccupied(row, (column + 1)))
			return true;
		else if (Hand.tiles_played.sameRow() && GameSession.board.isPositionOccupied((row - 1), column))
			return true;
		else if (Hand.tiles_played.sameRow() && GameSession.board.isPositionOccupied((row + 1), column))
			return true;
		else if (Hand.tiles_played.sameColumn() && GameSession.board.isPositionOccupied((row + 1), column))
			return true;
		else if (Hand.tiles_played.sameColumn() && GameSession.board.isPositionOccupied(row, (column - 1)))
			return true;
		else if (Hand.tiles_played.sameColumn() && GameSession.board.isPositionOccupied(row, (column + 1)))
			return true;
		
		return false;
	}
	
// Checks if the non-consercutive play made is valid
	public static boolean isNonConsercutivePlayValid(){
	
		// If all plays were made on the same row, execute this block.
		if(Hand.tiles_played.sameRow()){
			
			// Since all row values are the same, pick one.
			int row = Hand.tiles_played.row.get(0);
			
			// Getting and incrementing the column value until we get to the last value played. 
			for (int column = Hand.tiles_played.column.get(0); column <= Hand.tiles_played.column.get((Hand.tiles_played.column.size() - 1)); column++){
				if(!GameSession.board.isPositionOccupied(row, column))
					return false;
			}
			return true;
		
			// If all plays were made on the same column, execute this block.
		}else if (Hand.tiles_played.sameColumn()){
			
			// Since all column values are the same, pick one.
			int column = Hand.tiles_played.column.get(0);
			
			// Getting and incrementing the row value until we get to the last value played. 
			for (int row = Hand.tiles_played.row.get(0); row <= Hand.tiles_played.row.get((Hand.tiles_played.row.size() - 1)); row++){
				if(!GameSession.board.isPositionOccupied(row, column))
					return false;
			}
			return true;
			
		}else return false;
		
	}
	
	
// Check if the first play made was made according to the rules of the game.
	public static boolean isFirstPlayValid(){
		return GameSession.board.isPositionOccupied(7, 7);
	}
}

	