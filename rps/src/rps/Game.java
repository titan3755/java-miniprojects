package rps;

public class Game {
	public String[] rpsValues = {"rock", "paper", "scissors"};
	public String[] gameStateValues = {"won", "lost", "draw", "undefined"};
	int score;
	int rpsState; // rps map -> 1 == "rock" || 2 == "paper" || 3 == "scissors"
	int difficulty;
	int turns;
	int turnLimit;
	String previousState;
	
	public Game(int diff, int tl) {
		score = 0;
		difficulty = diff;
		turns = 0;
		turnLimit = tl;
		rpsState = (int) ((Math.random() * (3 - 1)) + 1);
		previousState = gameStateValues[3];
	}
	
	public void roll() {
		rpsState = (int) ((Math.random() * (3 - 1)) + 1);
		turns += 1;
	}
	
	public void unroll() {
		turns -= 1;
	}
	
	public String check(String userResp) {
		if (rpsState == 1 && userResp.toLowerCase().equals(rpsValues[1])) {
			score += 1;
			previousState = gameStateValues[0];
			return gameStateValues[0];
		} else if (rpsState == 1 && userResp.toLowerCase().equals(rpsValues[2])) {
			score -= 1;
			previousState = gameStateValues[1];
			return gameStateValues[1];
		} else if (rpsState == 1 && userResp.toLowerCase().equals(rpsValues[0])) {
			previousState = gameStateValues[2];
			return gameStateValues[2];
		} else if (rpsState == 2 && userResp.toLowerCase().equals(rpsValues[2])) {
			score += 1;
			previousState = gameStateValues[0];
			return gameStateValues[0];
		} else if (rpsState == 2 && userResp.toLowerCase().equals(rpsValues[0])) {
			score -= 1;
			previousState = gameStateValues[1];
			return gameStateValues[1];
		} else if (rpsState == 2 && userResp.toLowerCase().equals(rpsValues[1])) {
			previousState = gameStateValues[2];
			return gameStateValues[2];
		} else if (rpsState == 3 && userResp.toLowerCase().equals(rpsValues[0])) {
			score += 1;
			previousState = gameStateValues[0];
			return gameStateValues[0];
		} else if (rpsState == 3 && userResp.toLowerCase().equals(rpsValues[1])) {
			score -= 1;
			previousState = gameStateValues[1];
			return gameStateValues[1];
		} else if (rpsState == 3 && userResp.toLowerCase().equals(rpsValues[2])) {
			previousState = gameStateValues[2];
			return gameStateValues[2];
		} else {
			previousState = gameStateValues[3];
			return gameStateValues[3];
		}
	}
	
	public String checkGameOver() {
		if (score == difficulty && turns < turnLimit) {
			return gameStateValues[0];
		} else if ((score == -difficulty) || (turns >= turnLimit)) {
			return gameStateValues[1];
		} else if ((turns == turnLimit) && (score == difficulty)) {
			return gameStateValues[2];
		} else {
			return gameStateValues[3];
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public int getRpsState() {
		return rpsState;
	}
	
	public String getPrevState() {
		return previousState;
	}
	
	public int getTurns() {
		return turns;
	}
	
	public int getTurnLimit() {
		return turnLimit;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public String[] getGameStateValues() {
		return gameStateValues;
	}
	
	public String[] getRpsValues() {
		return rpsValues;
	}

}
