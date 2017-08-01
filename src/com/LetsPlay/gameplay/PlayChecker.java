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
	
}

	