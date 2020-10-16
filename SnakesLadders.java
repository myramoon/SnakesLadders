/* Purpose: Refactor code to get dice roll result */

public class SnakesLadders {

	//CONSTANT
	static final int START_POSITION = 0;		

	//create instance of game
	private int createGame(int START_POSITION) {
		int current_player_position = START_POSITION;
		return current_player_position;
	}
	//roll dice and get result
	private int rollDice() {
		int roll_result = (int) Math.floor(Math.random() * 10 % 6 + 1 ) ;
		return roll_result;
	}
	
        public static void main(String[] args) {
        		
        	SnakesLadders game1=new SnakesLadders();
       		int current_player_position = game1.createGame(START_POSITION);
       		int roll_result=game1.rollDice();
        }

}



