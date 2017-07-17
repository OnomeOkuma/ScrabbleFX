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
	 *then iterating through the played tiles and getting their respective column or row
	 *and saving it in an arraylist.
	 */ 
	
	// 	This arraylist is converted to an array and sorted, after which the difference
	// between each successive pair is tested. if it is greater than 1, a false value is returned.
	public static boolean isPlayConsercutive(){
		
		Tile first_tile_played = Hand.tiles_played.firstElement();
		Tile last_tile_played = Hand.tiles_played.lastElement();
		
		if (GridPane.getRowIndex(first_tile_played) == GridPane.getRowIndex(last_tile_played)){
			
			ArrayList<Integer> columnindices = new ArrayList<Integer>() ;
			Iterator<Tile> iterator = Hand.tiles_played.iterator();
			
			while(iterator.hasNext()){
				
				columnindices.add(GridPane.getColumnIndex(iterator.next()));
			
			}
			
			Object temp[] = new Object[columnindices.size()];
			temp = columnindices.toArray();
			
			Arrays.sort(temp);
			
			int element1 = 0;
			int element2 = 1;
			
			while(element2 < temp.length){
				if (((int)temp[element2] - (int)temp[element1]) != 1)
					return false;
				else {
					element1++;
					element2++;
				}
			}
			
			
			
		}else if(GridPane.getColumnIndex(first_tile_played) == GridPane.getColumnIndex(last_tile_played)){
			
			ArrayList<Integer> rowindices = new ArrayList<Integer>() ;
			Iterator<Tile> iterator = Hand.tiles_played.iterator();
			
			while(iterator.hasNext()){
				
				rowindices.add(GridPane.getRowIndex(iterator.next()));
				
			}
			
			Object temp[] = new Object[rowindices.size()];
			temp = rowindices.toArray();
			
			Arrays.sort(temp);
			
			int element1 = 0;
			int element2 = 1;
			
			while(element2 < temp.length){
				
				if (((int)temp[element2] - (int)temp[element1]) != 1)
					return false;
				
				else {
					element1++;
					element2++;
				}
			}
			
		} else return false;
		
		
		return true;
	}
	
	
}
