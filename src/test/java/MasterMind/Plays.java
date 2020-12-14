package MasterMind;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class Plays {
	int LENGTH = 4;
	int turn = 9;
	@Test
	public void testPlays() {
		View view = new View(LENGTH);
		Model model = new Model(LENGTH, turn);
		Controller controller = new Controller(view, model);
		
		
		//Play 1: the user wins at first
		ArrayList<Integer> randomPattern = new ArrayList<Integer>();
		randomPattern.add(1);
		randomPattern.add(2);
		randomPattern.add(3);
		randomPattern.add(4);
		model.setRandomPattern(randomPattern);
		
		ArrayList<Integer> guessedPattern = new ArrayList<Integer>();
		guessedPattern.add(1);
		guessedPattern.add(2);
		guessedPattern.add(3);
		guessedPattern.add(4);
		model.setGuessedPattern(guessedPattern);
		assertTrue(model.isFilled());

		model.checkResult();
		assertFalse(controller.isPlaying());
		
		//Play 2: the user introduces illegal combination and later wins
		
		View view2 = new View(LENGTH);
		Model model2 = new Model(LENGTH, turn);
		Controller controller2 = new Controller(view2, model2);
		
		
		ArrayList<Integer> randomPattern2 = new ArrayList<Integer>();
		randomPattern2.add(1);
		randomPattern2.add(2);
		randomPattern2.add(3);
		randomPattern2.add(4);
		model2.setRandomPattern(randomPattern2);
		
		ArrayList<Integer> guessedPattern2 = new ArrayList<Integer>();
		guessedPattern2.add(1);
		guessedPattern2.add(2);
		guessedPattern2.add(2);
		guessedPattern2.add(4);
		guessedPattern2.add(4);
		model2.setGuessedPattern(guessedPattern2);
		
		assertFalse(model2.isFilled());
		model2.checkResult();
		assertTrue(controller2.isPlaying());
		
		model2.resetCountWhite();
		ArrayList<Integer> guessedPattern21 = new ArrayList<Integer>();
		guessedPattern21.add(1);
		guessedPattern21.add(2);
		guessedPattern21.add(3);
		guessedPattern21.add(4);
		model2.setGuessedPattern(guessedPattern21);
		assertTrue(model2.isFilled());
		model2.checkResult();
		assertFalse(controller2.isPlaying());
		
		
		//Play 3: the user introduces a wrong number and later wins
		
		View view3 = new View(LENGTH);
		Model model3 = new Model(LENGTH, turn);
		Controller controller3 = new Controller(view3, model3);
		
		
		ArrayList<Integer> randomPattern3 = new ArrayList<Integer>();
		randomPattern3.add(1);
		randomPattern3.add(2);
		randomPattern3.add(3);
		randomPattern3.add(4);
		model3.setRandomPattern(randomPattern3);
		
		ArrayList<Integer> guessedPattern3 = new ArrayList<Integer>();
		guessedPattern3.add(1);
		guessedPattern3.add(2);
		guessedPattern3.add(-2);
		guessedPattern3.add(4);
		model3.setGuessedPattern(guessedPattern3);
		
		assertTrue(model3.isFilled());
		model3.checkResult();
		assertTrue(controller3.isPlaying());
		
		model3.resetCountWhite();
		ArrayList<Integer> guessedPattern31 = new ArrayList<Integer>();
		guessedPattern31.add(1);
		guessedPattern31.add(2);
		guessedPattern31.add(3);
		guessedPattern31.add(4);
		model3.setGuessedPattern(guessedPattern31);
		assertTrue(model3.isFilled());
		model3.checkResult();
		assertFalse(controller3.isPlaying());
		
		//Play 4: the user writes "quit"
		View view4 = new View(LENGTH);
		Model model4 = new Model(LENGTH, turn);
		MockController controller4 = new MockController(view4, model4);
		
		Scanner input = new Scanner("quit");
		assertFalse(controller4.loop(input));
		
		//Play 5: the user writes "reset"
		View view5 = new View(LENGTH);
		Model model5 = new Model(LENGTH, turn);
		MockController controller5 = new MockController(view5, model5);
		
		ArrayList<Integer> randomPattern5 = new ArrayList<Integer>();
		randomPattern5.add(1);
		randomPattern5.add(2);
		randomPattern5.add(3);
		randomPattern5.add(4);
		model5.setRandomPattern(randomPattern5);
		
		Scanner input_reset = new Scanner("reset");
		assertTrue(controller5.loop(input_reset));
		
		
		//Play 6: player looses
		View view6 = new View(LENGTH);
		Model model6 = new Model(LENGTH, turn);
		Controller controller6 = new Controller(view6, model6);
		
		
		ArrayList<Integer> randomPattern6 = new ArrayList<Integer>();
		randomPattern6.add(1);
		randomPattern6.add(2);
		randomPattern6.add(3);
		randomPattern6.add(4);
		model6.setRandomPattern(randomPattern6);
		
		//first play
		ArrayList<Integer> guessedPattern6 = new ArrayList<Integer>();
		guessedPattern6.add(1);
		guessedPattern6.add(2);
		guessedPattern6.add(2);
		guessedPattern6.add(4);
		model6.setGuessedPattern(guessedPattern6);
		
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//second play
		ArrayList<Integer> guessedPattern61 = new ArrayList<Integer>();
		guessedPattern61.add(1);
		guessedPattern61.add(2);
		guessedPattern61.add(3);
		guessedPattern61.add(2);
		model6.setGuessedPattern(guessedPattern61);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//third play
		ArrayList<Integer> guessedPattern62 = new ArrayList<Integer>();
		guessedPattern62.add(1);
		guessedPattern62.add(3);
		guessedPattern62.add(3);
		guessedPattern62.add(2);
		model6.setGuessedPattern(guessedPattern62);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//fourth play
		ArrayList<Integer> guessedPattern63 = new ArrayList<Integer>();
		guessedPattern63.add(1);
		guessedPattern63.add(3);
		guessedPattern63.add(7);
		guessedPattern63.add(2);
		model6.setGuessedPattern(guessedPattern63);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//fifth play
		ArrayList<Integer> guessedPattern64 = new ArrayList<Integer>();
		guessedPattern64.add(1);
		guessedPattern64.add(3);
		guessedPattern64.add(7);
		guessedPattern64.add(3);
		model6.setGuessedPattern(guessedPattern64);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//sixth play
		ArrayList<Integer> guessedPattern65 = new ArrayList<Integer>();
		guessedPattern65.add(2);
		guessedPattern65.add(3);
		guessedPattern65.add(7);
		guessedPattern65.add(3);
		model6.setGuessedPattern(guessedPattern65);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//seventh play
		ArrayList<Integer> guessedPattern66 = new ArrayList<Integer>();
		guessedPattern66.add(2);
		guessedPattern66.add(4);
		guessedPattern66.add(7);
		guessedPattern66.add(3);
		model6.setGuessedPattern(guessedPattern66);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//eighth play
		ArrayList<Integer> guessedPattern67 = new ArrayList<Integer>();
		guessedPattern67.add(2);
		guessedPattern67.add(4);
		guessedPattern67.add(7);
		guessedPattern67.add(3);
		model6.setGuessedPattern(guessedPattern67);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertTrue(controller6.isPlaying());
		
		model6.resetCountWhite();
		//ninth play
		ArrayList<Integer> guessedPattern68 = new ArrayList<Integer>();
		guessedPattern68.add(2);
		guessedPattern68.add(4);
		guessedPattern68.add(7);
		guessedPattern68.add(3);
		model6.setGuessedPattern(guessedPattern68);
		assertTrue(model6.isFilled());
		model6.checkResult();
		assertFalse(controller6.isPlaying());
		
	}
}
