package com.LetsPlay.gameplay.rules;

import com.LetsPlay.gameplay.GameSession;
import com.LetsPlay.gameplay.Hand;

public class SingleTileScoreCalculator {
	
	public static int calculateScore(){
		if(SingleTilePlayChecker.isRowPlay() && !SingleTilePlayChecker.isColumnPlay()){
			return SingleTileScoreCalculator.calculateScoreRow();
		} else if (!SingleTilePlayChecker.isRowPlay() && SingleTilePlayChecker.isColumnPlay()){
			return SingleTileScoreCalculator.calculateScoreColumn();
		} else if (SingleTilePlayChecker.isRowPlay() && SingleTilePlayChecker.isColumnPlay()){
			return SingleTileScoreCalculator.calculateScoreRow() + SingleTileScoreCalculator.calculateScoreColumn();
		} else return 0;
	}
	
	
	private static int calculateScoreRow(){
		int score = 0;
		int word_score_multiplier = 0;
		
		int row = Hand.tiles_played.row.get(0);
		int column = Hand.tiles_played.column.get(0);
		
		score += (GameSession.board.TileInPosition(row, column).score * 
				TileScoreCalculator.letter_score[row][column]);
		word_score_multiplier = TileScoreCalculator.word_score[row][column];
		TileScoreCalculator.word_score[row][column] = 1;
		
		column--;
		
		while(GameSession.board.isPositionOccupied(row, column)){
			score += GameSession.board.TileInPosition(row, column).score;
			column--;
		}
		
		column = Hand.tiles_played.column.get(0);
		column++;
	
		while(GameSession.board.isPositionOccupied(row, column)){
			score += GameSession.board.TileInPosition(row, column).score;
			column++;
		}
		score = score * word_score_multiplier;
		
		return score;
		}
	
	
	private static int calculateScoreColumn(){
		int score = 0;
		int word_score_multiplier = 0;
		
		int row = Hand.tiles_played.row.get(0);
		int column = Hand.tiles_played.column.get(0);
		
		score += (GameSession.board.TileInPosition(row, column).score * 
				TileScoreCalculator.letter_score[row][column]);
		word_score_multiplier = TileScoreCalculator.word_score[row][column];
		TileScoreCalculator.word_score[row][column] = 1;
		
		row--;
		
		while(GameSession.board.isPositionOccupied(row, column)){
			score += GameSession.board.TileInPosition(row, column).score;
			row--;
		}
	
		row = Hand.tiles_played.row.get(0);
		row++;
	
		while(GameSession.board.isPositionOccupied(row, column)){
			score += GameSession.board.TileInPosition(row, column).score;
			row++;
		}
		
		score = score * word_score_multiplier;
		
		return score;
	}
}
