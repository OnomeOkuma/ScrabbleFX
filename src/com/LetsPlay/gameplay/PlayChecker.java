/*
 * This class checks the validity of play made by the player.  
 */
package com.LetsPlay.gameplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import com.LetsPlay.ui.Tile;

import javafx.scene.layout.GridPane;


public class PlayChecker {
		
// Checks if the play was made on the same column or row.
	public static boolean onSameLine(){

		// Get the first and last tiles of the recent play.
		Tile first_tile_played = Hand.tiles_played.firstElement();
		Tile last_tile_played = Hand.tiles_played.lastElement();
		
		// Checks if they are on the same row.
		if (GridPane.getRowIndex(first_tile_played) == GridPane.getRowIndex(last_tile_played)){
			
			Iterator<Tile> iterator = Hand.tiles_played.iterator();
			
			while(iterator.hasNext()){
				
				// Iterate through played tiles and checks they are on the same row.
				// Returns false if they are not.
				if(GridPane.getRowIndex(iterator.next()) != GridPane.getRowIndex(first_tile_played))
					return false;
				}
			
			// Checks if they are on the same column.
			} else if(GridPane.getColumnIndex(first_tile_played) == GridPane.getColumnIndex(last_tile_played)){
				
				Iterator<Tile> iterator = Hand.tiles_played.iterator();
					
				while(iterator.hasNext()){
					
					// Iterate through played tiles and checks they are on the same column.
					// Returns false if they are not.
					if(GridPane.getColumnIndex(iterator.next()) != GridPane.getColumnIndex(first_tile_played))
						return false;
					
							} 
						// Return false if both tests fail.
						}else return false;
		
		// Returns true if a false value is not returned up to this point.
		return true;
	}
	
	
	
	
	// 	Checks if play was made without skipping a grid.
	
	/* It solves this by first checking if they were made on the same row or column;
	 * then iterating through the played tiles and getting their respective column or row
	 * and saving it in an arraylist.
	 *
	 * This arraylist is converted to an array and sorted, after which the difference
	 * between each successive pair is tested. if it is greater than 1, a false value is returned.
	 * 
	 */ 
	 	
	public static boolean isPlayConsercutive(){
		
		// Gets the first and last tiles player.
		Tile first_tile_played = Hand.tiles_played.firstElement();
		Tile last_tile_played = Hand.tiles_played.lastElement();
		
		// Tests if they are on the same row
		if (GridPane.getRowIndex(first_tile_played) == GridPane.getRowIndex(last_tile_played)){
			
			// columnindices is used to hold the column value of each tile.
			ArrayList<Integer> columnindices = new ArrayList<Integer>() ;
			Iterator<Tile> iterator = Hand.tiles_played.iterator();
			
			// Iterate through the played tiles and get their column values.
			while(iterator.hasNext()){
				
				columnindices.add(GridPane.getColumnIndex(iterator.next()));
			
			}
			
			// Create a temporary object array using the size of columnindices. This is because the tiles played
			// varies.
			Object temp[] = new Object[columnindices.size()];
			
			// Convert columnindices to an array and store in temp.
			temp = columnindices.toArray();
			
			// Sort the array.
			Arrays.sort(temp);
			
			int element1 = 0;
			int element2 = 1;
			
			while(element2 < temp.length){
				
				// if the difference between a pair of array elements is greater than 1, it means
				// that a column grid was skipped during play. False value is returned.
				if (((int)temp[element2] - (int)temp[element1]) != 1)
					return false;
				
				// Otherwise we increment and continue the test.
				else {
					element1++;
					element2++;
				}
			}
			
			
			// Test to show if they are on the same column. 
		}else if(GridPane.getColumnIndex(first_tile_played) == GridPane.getColumnIndex(last_tile_played)){
			
			// rowindices is used to hold the column value of each tile.
			ArrayList<Integer> rowindices = new ArrayList<Integer>() ;
			Iterator<Tile> iterator = Hand.tiles_played.iterator();
			
			// Iterate through the played tiles and get their column values.
			while(iterator.hasNext()){
				
				rowindices.add(GridPane.getRowIndex(iterator.next()));
				
			}
			
			// Create a temporary object array using the size of columnindices. This is because the tiles played
			// varies.
			Object temp[] = new Object[rowindices.size()];
			temp = rowindices.toArray();
			
			// Sort the array.
			Arrays.sort(temp);
			
			int element1 = 0;
			int element2 = 1;
			
			while(element2 < temp.length){
				
				// if the difference between a pair of array elements is greater than 1, it means
				// that a row grid was skipped during play. False value is returned.
				if (((int)temp[element2] - (int)temp[element1]) != 1)
					return false;
				
				// Otherwise we increment and continue the test.
				else {
					element1++;
					element2++;
				}
			}
			
			// Return false if they are not on the same row or column.
		} else return false;
		
		// Return true if no false value has been returned up to this point.
		return true;
	}
	
	
}
