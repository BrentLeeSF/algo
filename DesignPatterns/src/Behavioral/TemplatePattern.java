package Behavioral;

abstract class TemplateGame {
	
	abstract void initialize();

	abstract void startPlay();

	abstract void endPlay();

	/** Template method to initialize, start and end game */
	public final void play() {

		initialize();

		startPlay();

		endPlay();
	}
}

class Cricket extends TemplateGame {

	@Override
	void endPlay() {
		System.out.println("Cricket Game Finished!");
	}

	@Override
	void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}
}

class Football extends TemplateGame {

	@Override
	void endPlay() {
		System.out.println("Football Game Finished!");
	}

	@Override
	void initialize() {
		System.out.println("Football Game Initialized! Start playing.");
	}

	@Override
	void startPlay() {
		System.out.println("Football Game Started. Enjoy the game!");
	}
}

public class TemplatePattern {
	
	public static void main(String[] args) {

		TemplateGame game = new Cricket();
		game.play();
		
		System.out.println();
		
		game = new Football();
		game.play();
	}
}
