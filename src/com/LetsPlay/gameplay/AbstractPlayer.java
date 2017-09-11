package com.LetsPlay.gameplay;

import com.LetsPlay.ui.ScoreBoard;

public abstract class AbstractPlayer {
		public ScoreBoard scoreboard;
		protected int player_score;
		
		public void setPlayerScore(int score){
			this.player_score += score;
			this.scoreboard.setScore(Integer.toString(this.player_score));
		}
		
}
