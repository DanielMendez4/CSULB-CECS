package project1;

public class GameTester {

	public static void main(String[] args) {
		
		Game myGame = new Game();
				
		while (myGame.getPlayerSize() != 0 || myGame.getComSize() != 0) {
			
			if (myGame.getPlayerSize() == 0 || myGame.getComSize() == 0) {
				break;
			}
			myGame.battle();
		}
		
		if (myGame.getPlayerSize() == 0) {
			System.out.println("PLAYER has lost the game of war! COM wins!");
		}
		if (myGame.getComSize() == 0) {
			System.out.println("COM has lost the game of war! PLAYER wins!");
		}
	}
}