/* Purpose: code to store position after every roll and number of times die was rolled */

import java.util.ArrayList;

public class SnakesLadders {
		
	static final int START_POSITION = 0;
	static final int WINNING_POSITION = 100;
	static final int NO_PLAY = 0;
	static final int LADDER = 1;
	static final int SNAKE = 2;

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
	//print position after every roll and total number of rolls		
	private void printPosition(ArrayList<Integer> position_list) {
		for (int count=0 ; count<position_list.size() ; count++ ) {
    			System.out.println("  " + position_list.get(count));
    		}
		System.out.println("Total number of dice rolls : " + position_list.size());
	}
		
        public static void main(String[] args) {
        		
        	SnakesLadders game1=new SnakesLadders();		
        	int current_player_position = game1.createGame();
        		
        	ArrayList<Integer> position_list = new ArrayList<Integer>();
       	
		//loop to create list of poSitions
	 	while(current_player_position != WINNING_POSITION) {
       			int roll_result=game1.rollDice();
        		current_player_position = game1.getOption(roll_result , current_player_position );
     			position_list.add(current_player_position);
        	}
        	game1.printPosition(position_list);
        		
        }

}



