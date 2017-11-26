package com.LetsPlay.gameplay.rules;

import com.LetsPlay.GameLayout;
import com.LetsPlay.gameplay.Hand;

public class SingleTileScoreCalculator {
	
	public static int calculateScore(){
		int score = 0;
		if(SingleTilePlayChecker.isRowPlay() && !SingleTilePlayChecker.isColumnPlay()){
			score += SingleTileScoreCalculator.calculateScoreRow();
		} else if (!SingleTilePlayChecker.isRowPlay() && SingleTilePlayChecker.isColumnPlay()){
			score += SingleTileScoreCalculator.calculateScoreColumn();
		} else if (SingleTilePlayChecker.isRowPlay() && SingleTilePlayChecker.isColumnPlay()){
			score += (SingleTileScoreCalculator.calculateScoreRow() + SingleTileScoreCalculator.calculateScoreColumn());
		} else score = 0;
		
		TileScoreCalculator.updateBoardValues();
		
		return score;
		
	}
	
	
	private static int calculateScoreRow(){
		int score = 0;
		int word_score_multiplier = 1;
		
		int row = Hand.tiles_played.row.firstElement();
		int column = Hand.tiles_played.column.firstElement();
		
		score += (GameLayout.board.TileInPosition(row, column).score * 
				TileScoreCalculator.letter_score[row][column]);
		word_score_multiplier *= TileScoreCalculator.word_score[row][column];
		
		column--;
		
		while(GameLayout.board.isPositionOccupied(row, column)){
			score += GameLayout.board.TileInPosition(row, column).score;
			column--;
		}
		
		column = Hand.tiles_played.column.firstElement();
		column++;
	
		while(GameLayout.board.isPositionOccupied(row, column)){
			score += GameLayout.board.TileInPosition(row, column).score;
			column++;
		}
		score = score * word_score_multiplier;
		
		return score;
		}
	
	
	private static int calculateScoreColumn(){
		int score = 0;
		int word_score_multiplier = 1;
		
		int row = Hand.tiles_played.row.firstElement();
		int column = Hand.tiles_played.column.firstElement();
		
		score += (GameLayout.board.TileInPosition(row, column).score * 
				TileScoreCalculator.letter_score[row][column]);
		word_score_multiplier *= TileScoreCalculator.word_score[row][column];
		
		row--;
		
		while(GameLayout.board.isPositionOccupied(row, column)){
			score += GameLayout.board.TileInPosition(row, column).score;
			row--;
		}
	
		row = Hand.tiles_played.row.firstElement();
		row++;
	
		while(GameLayout.board.isPositionOccupied(row, column)){
			score += GameLayout.board.TileInPosition(row, column).score;
			row++;
		}
		
		score = score * word_score_multiplier;
		
		return score;
	}
	
}
