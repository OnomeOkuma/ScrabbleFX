package com.LetsPlay.gameplay.rules;

import java.util.ArrayList;
import java.util.Iterator;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;

public class TileScoreCalculator {

	private static int letter_score[][] = new int[15][15];
	private static int word_score[][] = new int[15][15];
	
	public static void letterScoreInit(){
		letter_score[0][0] = 1;
		letter_score[0][1] = 1;
		letter_score[0][2] = 1;
		letter_score[0][3] = 2;
		letter_score[0][4] = 1;
		letter_score[0][5] = 1;
		letter_score[0][6] = 1;
		letter_score[0][7] = 1;
		letter_score[0][8] = 1;
		letter_score[0][9] = 1;
		letter_score[0][10] = 1;
		letter_score[0][11] = 2;
		letter_score[0][12] = 1;
		letter_score[0][13] = 1;
		letter_score[0][14] = 1;
		letter_score[1][0] = 1;
		letter_score[1][1] = 1;
		letter_score[1][2] = 1;
		letter_score[1][3] = 1;
		letter_score[1][4] = 1;
		letter_score[1][5] = 3;
		letter_score[1][6] = 1;
		letter_score[1][7] = 1;
		letter_score[1][8] = 1;
		letter_score[1][9] = 3;
		letter_score[1][10] = 1;
		letter_score[1][11] = 1;
		letter_score[1][12] = 1;
		letter_score[1][13] = 1;
		letter_score[1][14] = 1;
		letter_score[2][0] = 1;
		letter_score[2][1] = 1;
		letter_score[2][2] = 1;
		letter_score[2][3] = 1;
		letter_score[2][4] = 1;
		letter_score[2][5] = 1;
		letter_score[2][6] = 2;
		letter_score[2][7] = 1;
		letter_score[2][8] = 2;
		letter_score[2][9] = 1;
		letter_score[2][10] = 1;
		letter_score[2][11] = 1;
		letter_score[2][12] = 1;
		letter_score[2][13] = 1;
		letter_score[2][14] = 1;
		letter_score[3][0] = 2;
		letter_score[3][1] = 1;
		letter_score[3][2] = 1;
		letter_score[3][3] = 1;
		letter_score[3][4] = 1;
		letter_score[3][5] = 1;
		letter_score[3][6] = 1;
		letter_score[3][7] = 2;
		letter_score[3][8] = 1;
		letter_score[3][9] = 1;
		letter_score[3][10] = 1;
		letter_score[3][11] = 1;
		letter_score[3][12] = 1;
		letter_score[3][13] = 1;
		letter_score[3][14] = 2;
		letter_score[4][0] = 1;
		letter_score[4][1] = 1;
		letter_score[4][2] = 1;
		letter_score[4][3] = 1;
		letter_score[4][4] = 1;
		letter_score[4][5] = 1;
		letter_score[4][6] = 1;
		letter_score[4][7] = 1;
		letter_score[4][8] = 1;
		letter_score[4][9] = 1;
		letter_score[4][10] = 1;
		letter_score[4][11] = 1;
		letter_score[4][12] = 1;
		letter_score[4][13] = 1;
		letter_score[4][14] = 1;
		letter_score[5][0] = 1;
		letter_score[5][1] = 3;
		letter_score[5][2] = 1;
		letter_score[5][3] = 1;
		letter_score[5][4] = 1;
		letter_score[5][5] = 3;
		letter_score[5][6] = 1;
		letter_score[5][7] = 1;
		letter_score[5][8] = 1;
		letter_score[5][9] = 3;
		letter_score[5][10] = 1;
		letter_score[5][11] = 1;
		letter_score[5][12] = 1;
		letter_score[5][13] = 3;
		letter_score[5][14] = 1;
		letter_score[6][0] = 1;
		letter_score[6][1] = 1;
		letter_score[6][2] = 2;
		letter_score[6][3] = 1;
		letter_score[6][4] = 1;
		letter_score[6][5] = 1;
		letter_score[6][6] = 2;
		letter_score[6][7] = 1;
		letter_score[6][8] = 2;
		letter_score[6][9] = 1;
		letter_score[6][10] = 1;
		letter_score[6][11] = 1;
		letter_score[6][12] = 2;
		letter_score[6][13] = 1;
		letter_score[6][14] = 1;
		letter_score[7][0] = 1;
		letter_score[7][1] = 1;
		letter_score[7][2] = 1;
		letter_score[7][3] = 2;
		letter_score[7][4] = 1;
		letter_score[7][5] = 1;
		letter_score[7][6] = 1;
		letter_score[7][7] = 1;
		letter_score[7][8] = 1;
		letter_score[7][9] = 1;
		letter_score[7][10] = 1;
		letter_score[7][11] = 2;
		letter_score[7][12] = 1;
		letter_score[7][13] = 1;
		letter_score[7][14] = 1;
		letter_score[8][0] = 1;
		letter_score[8][1] = 1;
		letter_score[8][2] = 2;
		letter_score[8][3] = 1;
		letter_score[8][4] = 1;
		letter_score[8][5] = 1;
		letter_score[8][6] = 2;
		letter_score[8][7] = 1;
		letter_score[8][8] = 2;
		letter_score[8][9] = 1;
		letter_score[8][10] = 1;
		letter_score[8][11] = 1;
		letter_score[8][12] = 2;
		letter_score[8][13] = 1;
		letter_score[8][14] = 1;
		letter_score[9][0] = 1;
		letter_score[9][1] = 3;
		letter_score[9][2] = 1;
		letter_score[9][3] = 1;
		letter_score[9][4] = 1;
		letter_score[9][5] = 3;
		letter_score[9][6] = 1;
		letter_score[9][7] = 1;
		letter_score[9][8] = 1;
		letter_score[9][9] = 3;
		letter_score[9][10] = 1;
		letter_score[9][11] = 1;
		letter_score[9][12] = 1;
		letter_score[9][13] = 3;
		letter_score[9][14] = 1;
		letter_score[10][0] = 1;
		letter_score[10][1] = 1;
		letter_score[10][2] = 1;
		letter_score[10][3] = 1;
		letter_score[10][4] = 1;
		letter_score[10][5] = 1;
		letter_score[10][6] = 1;
		letter_score[10][7] = 1;
		letter_score[10][8] = 1;
		letter_score[10][9] = 1;
		letter_score[10][10] = 1;
		letter_score[10][11] = 1;
		letter_score[10][12] = 1;
		letter_score[10][13] = 1;
		letter_score[10][14] = 1;
		letter_score[11][0] = 2;
		letter_score[11][1] = 1;
		letter_score[11][2] = 1;
		letter_score[11][3] = 1;
		letter_score[11][4] = 1;
		letter_score[11][5] = 1;
		letter_score[11][6] = 1;
		letter_score[11][7] = 2;
		letter_score[11][8] = 1;
		letter_score[11][9] = 1;
		letter_score[11][10] = 1;
		letter_score[11][11] = 1;
		letter_score[11][12] = 1;
		letter_score[11][13] = 1;
		letter_score[11][14] = 2;
		letter_score[12][0] = 1;
		letter_score[12][1] = 1;
		letter_score[12][2] = 1;
		letter_score[12][3] = 1;
		letter_score[12][4] = 1;
		letter_score[12][5] = 1;
		letter_score[12][6] = 2;
		letter_score[12][7] = 1;
		letter_score[12][8] = 2;
		letter_score[12][9] = 1;
		letter_score[12][10] = 1;
		letter_score[12][11] = 1;
		letter_score[12][12] = 1;
		letter_score[12][13] = 1;
		letter_score[12][14] = 1;
		letter_score[13][0] = 1;
		letter_score[13][1] = 1;
		letter_score[13][2] = 1;
		letter_score[13][3] = 1;
		letter_score[13][4] = 1;
		letter_score[13][5] = 3;
		letter_score[13][6] = 1;
		letter_score[13][7] = 1;
		letter_score[13][8] = 1;
		letter_score[13][9] = 3;
		letter_score[13][10] = 1;
		letter_score[13][11] = 1;
		letter_score[13][12] = 1;
		letter_score[13][13] = 1;
		letter_score[13][14] = 1;
		letter_score[14][0] = 1;
		letter_score[14][1] = 1;
		letter_score[14][2] = 1;
		letter_score[14][3] = 2;
		letter_score[14][4] = 1;
		letter_score[14][5] = 1;
		letter_score[14][6] = 1;
		letter_score[14][7] = 1;
		letter_score[14][8] = 1;
		letter_score[14][9] = 1;
		letter_score[14][10] = 1;
		letter_score[14][11] = 2;
		letter_score[14][12] = 1;
		letter_score[14][13] = 1;
		letter_score[14][14] = 1;
	}
	
	public static void wordScoreInit(){
		word_score[0][0] = 3;
		word_score[0][1] = 1;
		word_score[0][2] = 1;
		word_score[0][3] = 1;
		word_score[0][4] = 1;
		word_score[0][5] = 1;
		word_score[0][6] = 1;
		word_score[0][7] = 3;
		word_score[0][8] = 1;
		word_score[0][9] = 1;
		word_score[0][10] = 1;
		word_score[0][11] = 1;
		word_score[0][12] = 1;
		word_score[0][13] = 1;
		word_score[0][14] = 3;
		word_score[1][0] = 1;
		word_score[1][1] = 2;
		word_score[1][2] = 1;
		word_score[1][3] = 1;
		word_score[1][4] = 1;
		word_score[1][5] = 1;
		word_score[1][6] = 1;
		word_score[1][7] = 1;
		word_score[1][8] = 1;
		word_score[1][9] = 1;
		word_score[1][10] = 1;
		word_score[1][11] = 1;
		word_score[1][12] = 1;
		word_score[1][13] = 2;
		word_score[1][14] = 1;
		word_score[2][0] = 1;
		word_score[2][1] = 1;
		word_score[2][2] = 2;
		word_score[2][3] = 1;
		word_score[2][4] = 1;
		word_score[2][5] = 1;
		word_score[2][6] = 2;
		word_score[2][7] = 1;
		word_score[2][8] = 1;
		word_score[2][9] = 1;
		word_score[2][10] = 1;
		word_score[2][11] = 1;
		word_score[2][12] = 2;
		word_score[2][13] = 1;
		word_score[2][14] = 1;
		word_score[3][0] = 1;
		word_score[3][1] = 1;
		word_score[3][2] = 1;
		word_score[3][3] = 2;
		word_score[3][4] = 1;
		word_score[3][5] = 1;
		word_score[3][6] = 1;
		word_score[3][7] = 1;
		word_score[3][8] = 1;
		word_score[3][9] = 1;
		word_score[3][10] = 1;
		word_score[3][11] = 2;
		word_score[3][12] = 1;
		word_score[3][13] = 1;
		word_score[3][14] = 1;
		word_score[4][0] = 1;
		word_score[4][1] = 1;
		word_score[4][2] = 1;
		word_score[4][3] = 1;
		word_score[4][4] = 2;
		word_score[4][5] = 1;
		word_score[4][6] = 1;
		word_score[4][7] = 1;
		word_score[4][8] = 1;
		word_score[4][9] = 1;
		word_score[4][10] = 2;
		word_score[4][11] = 1;
		word_score[4][12] = 1;
		word_score[4][13] = 1;
		word_score[4][14] = 1;
		word_score[5][0] = 1;
		word_score[5][1] = 1;
		word_score[5][2] = 1;
		word_score[5][3] = 1;
		word_score[5][4] = 1;
		word_score[5][5] = 1;
		word_score[5][6] = 1;
		word_score[5][7] = 1;
		word_score[5][8] = 1;
		word_score[5][9] = 1;
		word_score[5][10] = 1;
		word_score[5][11] = 1;
		word_score[5][12] = 1;
		word_score[5][13] = 1;
		word_score[5][14] = 1;
		word_score[6][0] = 1;
		word_score[6][1] = 1;
		word_score[6][2] = 1;
		word_score[6][3] = 1;
		word_score[6][4] = 1;
		word_score[6][5] = 1;
		word_score[6][6] = 1;
		word_score[6][7] = 1;
		word_score[6][8] = 1;
		word_score[6][9] = 1;
		word_score[6][10] = 1;
		word_score[6][11] = 1;
		word_score[6][12] = 1;
		word_score[6][13] = 1;
		word_score[6][14] = 1;
		word_score[7][0] = 3;
		word_score[7][1] = 1;
		word_score[7][2] = 1;
		word_score[7][3] = 1;
		word_score[7][4] = 1;
		word_score[7][5] = 1;
		word_score[7][6] = 1;
		word_score[7][7] = 2;
		word_score[7][8] = 1;
		word_score[7][9] = 1;
		word_score[7][10] = 1;
		word_score[7][11] = 1;
		word_score[7][12] = 1;
		word_score[7][13] = 1;
		word_score[7][14] = 3;
		word_score[8][0] = 1;
		word_score[8][1] = 1;
		word_score[8][2] = 1;
		word_score[8][3] = 1;
		word_score[8][4] = 1;
		word_score[8][5] = 1;
		word_score[8][6] = 1;
		word_score[8][7] = 1;
		word_score[8][8] = 1;
		word_score[8][9] = 1;
		word_score[8][10] = 1;
		word_score[8][11] = 1;
		word_score[8][12] = 1;
		word_score[8][13] = 1;
		word_score[8][14] = 1;
		word_score[9][0] = 1;
		word_score[9][1] = 1;
		word_score[9][2] = 1;
		word_score[9][3] = 1;
		word_score[9][4] = 1;
		word_score[9][5] = 1;
		word_score[9][6] = 1;
		word_score[9][7] = 1;
		word_score[9][8] = 1;
		word_score[9][9] = 1;
		word_score[9][10] = 1;
		word_score[9][11] = 1;
		word_score[9][12] = 1;
		word_score[9][13] = 1;
		word_score[9][14] = 1;
		word_score[10][0] = 1;
		word_score[10][1] = 1;
		word_score[10][2] = 1;
		word_score[10][3] = 1;
		word_score[10][4] = 2;
		word_score[10][5] = 1;
		word_score[10][6] = 1;
		word_score[10][7] = 1;
		word_score[10][8] = 1;
		word_score[10][9] = 1;
		word_score[10][10] = 2;
		word_score[10][11] = 1;
		word_score[10][12] = 1;
		word_score[10][13] = 1;
		word_score[10][14] = 1;
		word_score[11][0] = 1;
		word_score[11][1] = 1;
		word_score[11][2] = 1;
		word_score[11][3] = 2;
		word_score[11][4] = 1;
		word_score[11][5] = 1;
		word_score[11][6] = 1;
		word_score[11][7] = 1;
		word_score[11][8] = 1;
		word_score[11][9] = 1;
		word_score[11][10] = 1;
		word_score[11][11] = 2;
		word_score[11][12] = 1;
		word_score[11][13] = 1;
		word_score[11][14] = 1;
		word_score[12][0] = 1;
		word_score[12][1] = 1;
		word_score[12][2] = 2;
		word_score[12][3] = 1;
		word_score[12][4] = 1;
		word_score[12][5] = 1;
		word_score[12][6] = 1;
		word_score[12][7] = 1;
		word_score[12][8] = 1;
		word_score[12][9] = 1;
		word_score[12][10] = 1;
		word_score[12][11] = 1;
		word_score[12][12] = 2;
		word_score[12][13] = 1;
		word_score[12][14] = 1;
		word_score[13][0] = 1;
		word_score[13][1] = 2;
		word_score[13][2] = 1;
		word_score[13][3] = 1;
		word_score[13][4] = 1;
		word_score[13][5] = 1;
		word_score[13][6] = 1;
		word_score[13][7] = 1;
		word_score[13][8] = 1;
		word_score[13][9] = 1;
		word_score[13][10] = 1;
		word_score[13][11] = 1;
		word_score[13][12] = 1;
		word_score[13][13] = 2;
		word_score[13][14] = 1;
		word_score[14][0] = 3;
		word_score[14][1] = 1;
		word_score[14][2] = 1;
		word_score[14][3] = 1;
		word_score[14][4] = 1;
		word_score[14][5] = 1;
		word_score[14][6] = 1;
		word_score[14][7] = 3;
		word_score[14][8] = 1;
		word_score[14][9] = 1;
		word_score[14][10] = 1;
		word_score[14][11] = 1;
		word_score[14][12] = 1;
		word_score[14][13] = 1;
		word_score[14][14] = 3;
	}
	
	public static int getLetterScore(int row, int column){
		return TileScoreCalculator.letter_score[row][column];
	}
	
	public static int getWordScore(int row, int column){
		return TileScoreCalculator.word_score[row][column];
	}
	
	public static int calculateScore(){
		if(PlayChecker.isPlayCrossPlay())
			return (TileScoreCalculator.calculateWordScore() + TileScoreCalculator.calculateCrossWordScore());
		else return TileScoreCalculator.calculateWordScore();
	}
	
	private static int calculateWordScore(){
		int score = 0;
		ArrayList<Integer> word_score_multiplier = new ArrayList<Integer>();
		
		// if the number of tiles played is 7, add 50 to the score.
		if(Hand.number_of_plays == 7)
			score += 50;
		
		if(Hand.tiles_played.sameRow()){
			int row = Hand.tiles_played.row.get(0);
			int column = Hand.tiles_played.column.get(0);
			
			
			while (column <= Hand.tiles_played.column.get(Hand.tiles_played.column.size() - 1)){
				score += (GameSession.board.TileInPosition(row, column).score * 
						letter_score[row][column]);
				letter_score[row][column] = 1;
				word_score_multiplier.add(word_score[row][column]);
				word_score[row][column] = 1;
				column++;
	
			}
			

			if (PlayChecker.isPlaySuffix()){
				column = Hand.tiles_played.column.get(0);
				column--;
				while(GameSession.board.isPositionOccupied(row, column)){
					score += GameSession.board.TileInPosition(row, column).score; 
					column--;
				}
				
			}
			
			

			if (PlayChecker.isPlayPrefix()){
				column = Hand.tiles_played.column.get(Hand.tiles_played.column.size() - 1);
				column++;
				while(GameSession.board.isPositionOccupied(row, column)){
					score += GameSession.board.TileInPosition(row, column).score; 
					column++;
				}
				
			}
			Iterator<Integer> iterator = word_score_multiplier.iterator();
			while(iterator.hasNext()){
				score *= iterator.next();
			}
			
			return score;
			
			// This is the second part.
		} else {
			int row = Hand.tiles_played.row.get(0);
			int column = Hand.tiles_played.column.get(0);
			
			// Get the word formed by the tiles played.
			while (row <= Hand.tiles_played.row.get(Hand.tiles_played.row.size() - 1)){
				score += (GameSession.board.TileInPosition(row, column).score * 
						letter_score[row][column]);
				letter_score[row][column] = 1;
				word_score_multiplier.add(word_score[row][column]);
				word_score[row][column] = 1;
				row++;
				
			}
			
			if (PlayChecker.isPlaySuffix()){
				row = Hand.tiles_played.row.get(0);
				row--;
				while(GameSession.board.isPositionOccupied(row, column)){
					score += GameSession.board.TileInPosition(row, column).score;
					row--;
				}
				
			}
			
			if (PlayChecker.isPlayPrefix()){
				row = Hand.tiles_played.row.get(Hand.tiles_played.row.size() - 1);
				row++;
				while(GameSession.board.isPositionOccupied(row, column)){
					score += GameSession.board.TileInPosition(row, column).score;
					row++;
				}
				
			}
			
			Iterator<Integer> iterator = word_score_multiplier.iterator();
			while(iterator.hasNext()){
				score *= iterator.next();
			}
			return score;
	}
}
	
	private static int calculateCrossWordScore(){
		int cross_score = 0;
		int cross_word_score_multiplier = 0;
		
		if(Hand.tiles_played.sameRow()){

			Iterator<Integer> column_values = Hand.tiles_played.column.iterator();
			
			while (column_values.hasNext()){
				int column = column_values.next();
				int row = Hand.tiles_played.row.get(0);
				cross_score += (GameSession.board.TileInPosition(row, column).score * 
						letter_score[row][column]);
				letter_score[row][column] = 1;
				cross_word_score_multiplier = word_score[row][column];
				word_score[row][column] = 1;
				
				row++; 
				
				// Append the letters found in the successive rows where tiles are found.
				while(GameSession.board.isPositionOccupied(row, column)){
					cross_score += GameSession.board.TileInPosition(row, column).score;
					row++;
				}

				row = Hand.tiles_played.row.get(0);
				row--;
				
				while(GameSession.board.isPositionOccupied(row, column)){
					cross_score += GameSession.board.TileInPosition(row, column).score;
					row--;
				}
				
				cross_score = cross_score * cross_word_score_multiplier;
			}
			return cross_score;
		}else{
				Iterator<Integer> row_values = Hand.tiles_played.row.iterator();
				
				while (row_values.hasNext()){
					
					int row = row_values.next();
					int column = Hand.tiles_played.column.get(0);
					cross_score += (GameSession.board.TileInPosition(row, column).score * 
							letter_score[row][column]);
					letter_score[row][column] = 1;
					cross_word_score_multiplier = word_score[row][column];
					word_score[row][column] = 1;
					column++;
					
					
					while(GameSession.board.isPositionOccupied(row, column)){
						cross_score += GameSession.board.TileInPosition(row, column).score;
						column++;
						}
					
					column = Hand.tiles_played.column.get(0);
					column--;
					

					while(GameSession.board.isPositionOccupied(row, column)){
						cross_score += GameSession.board.TileInPosition(row, column).score;
						column--;
						}
					
					cross_score = cross_score * cross_word_score_multiplier;
					}
				return cross_score;	
			}
		}
	}

