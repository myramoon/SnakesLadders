/* Purpose: Refactor code to not let player exceed 100 */

public class SnakesLadders {
		
	static final int START_POSITION = 0;
	static final int WINNING_POSITION = 100;
	static final int NO_PLAY=0;
	static final int LADDER=1;
	static final int SNAKE=2;
	
	//create instance of game	
	private int createGame() {
		int current_player_position = START_POSITION;
		return current_player_position;
	}
	
	//get dice number 		
	private int rollDice() {
		int roll_result = (int) Math.floor(Math.random() * 10 % 6 + 1 ) ;
		return roll_result;
	}
	
	//determine no play, ladder or snake move
	private int getOption(int roll_result , int current_player_position) {
		int option = (int) Math.floor(Math.random() * 10) % 3 ;
		switch (option) {
			case (NO_PLAY):
				break;
			case (LADDER):
				if ((current_player_position + roll_result) <= 100)
					current_player_position += roll_result;
				break;
			case (SNAKE):
				if ((current_player_position - roll_result) < 0)
        				current_player_position = START_POSITION;
				else
					current_player_position -= roll_result;
				break;				
		}		

		return current_player_position;
	}
	//play game till player reaches 100
	private void playGame(int current_player_position,SnakesLadders game1) {
			while(current_player_position != WINNING_POSITION) {
    			
    			if (current_player_position < 0)
    				current_player_position = START_POSITION;
    			while(current_player_position != WINNING_POSITION && current_player_position >= 0 ) {
    				int roll_result=game1.rollDice();
    				current_player_position = game1.getOption(roll_result , current_player_position );
    				System.out.print("  "+current_player_position);
    			}
    		
    		}
	}


        public static void main(String[] args) {
        		
       		SnakesLadders game1=new SnakesLadders();
        	int current_player_position = game1.createGame();
        	game1.playGame(current_player_position,game1);	

	}

}


