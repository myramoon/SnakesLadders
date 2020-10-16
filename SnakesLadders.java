/*Purpose: Check option for no play, ladder and snake */

public class SnakesLadders {
	//constants	
	static final int START_POSITION = 0;
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
				current_player_position += roll_result;
				break;
			case (SNAKE):
				current_player_position -= roll_result;
				break;
		}		
		return current_player_position;
	}

        public static void main(String[] args) {
        		
        	SnakesLadders game1=new SnakesLadders();
        		
        	int current_player_position = game1.createGame();
       		int roll_result=game1.rollDice();
       		current_player_position = game1.getOption(roll_result , current_player_position );
       		System.out.println(current_player_position);  //display result
        }

}



