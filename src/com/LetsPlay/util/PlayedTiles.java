/*
 * This class holds the state of the most recent play made temporarily. That is until the play is made
 * permanent. It has 3 public properties for holding the Tile and its location on the board
 * and 4 methods for adding a tile, clearing a tile and checking if they were played on the same row or
 * column.
 *   This class is still under active development, So there might be some drastic changes made to it.
 */
package com.LetsPlay.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import com.LetsPlay.ui.Tile;

public class PlayedTiles {
	// Holds information regarding the row of each played tile.
	public ArrayList<Integer> row = new ArrayList<Integer>();
	
	// Hold information regarding the column of each played tile. 
	public ArrayList<Integer> column = new ArrayList<Integer>();
	
	// The tiles currently being played.
	public Tile tiles[][] = new Tile[225][225];
	
	// Constructor Statement.
	public PlayedTiles(){
	}
	
	// Adds a tile and its coordinates.
	public void add(Tile tile, int row, int column){
		
		this.row.add(row);
		this.column.add(column);
		this.tiles[row][column] = tile;
		
		// Sorted in ascending order. This is to enable us determine the order of play.
		Collections.sort(this.row);
		Collections.sort(this.column);
		
	}
	
	// Clears the current information being held.
	public void clear(){
		this.row = new ArrayList<Integer>();
		this.column = new ArrayList<Integer>();
		this.tiles = new Tile[225][225];
	}
	
	// Returns true if they are both in the same row. 
	public boolean sameRow(){
		
		// Get an iterator over the row property.
		Iterator<Integer> iterator = this.row.iterator();
		
		// Get the first element.
		int temp = iterator.next();
		
		// While looping, if the next element is not equal to the first element return false.
		while (iterator.hasNext()){
			if (temp != iterator.next())
				return false;
		}
		
		//Otherwise, Return true.
		return true;
	}
	
	// Returns true if they are both in the same column.
	public boolean sameColumn(){
		
		// Get an iterator over the column property.
		Iterator<Integer> iterator = this.column.iterator();
		
		// Get the first element.
		int temp = iterator.next();
		
		// While looping, if the next element is not equal to the first element return false.
		while (iterator.hasNext()){
			
			if (temp != iterator.next())
				return false;
		}
		//Otherwise, Return true.
		return true;
	}
}
