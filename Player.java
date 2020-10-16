/* Purpose: Let 2 players play Snakes and Ladders */

import java.util.ArrayList;

public class Player {

	//constants
	static final int START=0;
	static final int WIN=100;
	static final int NO_PLAY=0;
	static final int LADDER=1;
	static final int SNAKE=2;	

	int current_position;
	int[] determiner = new int[2];
	ArrayList<Integer> position_list = new ArrayList<Integer>();
	
	//create position list for each player 
	public void playGame(int turn ,Player[] playerlist) {
		int roll_result;
		Player player = playerlist[turn];

		while (playerlist[0].current_position != WIN && playerlist[1].current_position != WIN) {
			roll_result = player.rollDice();
			player.determiner = player.calculatePosition(roll_result,player.current_position,player); //got option and current_position
			player.position_list.add(determiner[1]);
			if ( determiner[0] != LADDER ) {						       	  //code to set another chance for ladder
				if ( turn == 0 )
					turn = 1;
				else
					turn = 0;
			}	
			player = playerlist[turn];	

		}
		if (playerlist[0].current_position == WIN)
			System.out.println("WINNER is Player1");
		else
			System.out.println("WINNER is Player2");
	
		displayPosition(playerlist);
	}
	
	//get dice number
	private int rollDice() {
        	int roll_result = (int) Math.floor(Math.random() * 10 % 6 + 1 ) ;
        	return roll_result;
	}
	
	//calculate position for every roll of each player
	public int[] calculatePosition(int roll_result , int current_position, Player player) {
		int option = (int) Math.floor(Math.random() * 10) % 3 ; 
		switch (option) {
			case (NO_PLAY):
				break;
			case (LADDER):
				if ((this.current_position + roll_result) <= 100)
					this.current_position += roll_result;
				break;
			case (SNAKE):
				if ((this.current_position - roll_result) < 0)
    					this.current_position = START;
				else
					this.current_position -= roll_result;
				break;
		}	
		
		determiner[0] = option;
		determiner[1] = this.current_position;
		return determiner;
	}
	
	//print list of position for each player
	void displayPosition(Player[] playerlist) {
		for (int i=0; i<=1; i++) {
			System.out.println("Position on board for each roll : ");
			for( int count = 0; count < playerlist[i].position_list.size(); count++) {
				System.out.print(" " + playerlist[i].position_list.get(count)+" | ");
			}
			System.out.println();
			System.out.println("Total number of dice rolls for player" + ( i + 1 ) + " : " + playerlist[i].position_list.size());
			System.out.println();
		}
		
	}
	
	//set first turn when game starts
	static int setTurn() {
		int turn = (int) Math.floor(Math.random() * 10) % 2;
		return turn;
	}
	
	public static void main(String[] args) {
		Player player1 = new Player();  //create players
		Player player2 = new Player();
		player1.current_position = START; 
		player2.current_position = START;
		Player[] playerlist = new Player[2];
		playerlist[0] = player1;
		playerlist[1] = player2;	
		int turn = setTurn();		//first turn set
		playerlist[turn].playGame(turn,playerlist);
		
	}

}




