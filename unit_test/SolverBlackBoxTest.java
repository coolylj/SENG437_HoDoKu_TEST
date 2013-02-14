import static org.junit.Assert.*;

import solver.*;
import sudoku.*;
//import generator.*;

import org.junit.Test;
import java.lang.String;

public class SolverBlackBoxTest {	
		// easy game
		String g1 = new String("..5......4....2.1...2.548...246....1...92....9.7...3.6............7..4...8..3.79.");
		String s1 = new String("195867234478392615362154879524673981836921547917548326749286153253719468681435792");
		// medium 
		String g2 = new String("1.25..4.6.8..49.155........7..46.2..4......38.....3...6.8....4....1.4..9........2");
		String s2 = new String("192537486386249715547681923735468291429715638861923574658392147273154869914876352");
		// hard
		String g3 = new String(".............1.487.4.7..53..13.........9......76.4..91.35..7.1....85...426...9...");
		String s3 = new String("387594126659213487142786539913625748428971653576348291835467912791852364264139875");
		// unfair
		String g4 = new String("...5.....14........2....63.....2.59...7.5...4.3.19....6..8...5.3.84...7.........9");
		String s4 = new String("769583412143267985825941637416728593987356124532194768694872351358419276271635849");
		// extreme
		String g5 = new String(".6....9....23..8..3...4.1..74.6.9..1.......6...9.325....6..5....589.....1........");
		String s5 = new String("867521934412397856395846172743659281521478369689132547936715428258964713174283695");
		
		Sudoku2 game;
		SudokuSolver solver;	
		
		private void setup()
		{
			game = new Sudoku2();
			solver = SudokuSolverFactory.getInstance();			
		}
		
		private void teardown()
		{
			SudokuSolverFactory.giveBack(solver);
			game = null;
			solver = null;
		}
		
		private boolean solveGame(String gameString, String expectedSolution)
		{
			setup();
			
			// create new game
			game.setSudoku(gameString);
			assertTrue(game.isSolved() == false);
			System.out.printf("unsolved: %s\n", game.getSudoku(ClipboardMode.VALUES_ONLY));
			
			// solve it using all method(no restriction)
			solver.setSudoku(game);
			solver.solve();
			
			// check result
			assertTrue(game.isSolved() == true);
			String solverSolution = game.getSudoku(ClipboardMode.VALUES_ONLY);
			System.out.printf("  solved: %s\n", solverSolution);
			
			teardown();
			
			if(expectedSolution.equals(solverSolution)) return true;
			else return false;
		}
		
		@Test
		public void testSolveEasy()
		{
			assertTrue(solveGame(g1, s1));
		}
		@Test
		public void testSolveMedium()
		{
			assertTrue(solveGame(g2, s2));
		}
		@Test
		public void testSolveHard()
		{
			assertTrue(solveGame(g3, s3));
		}
		@Test
		public void testSolveUnfair()
		{
			assertTrue(solveGame(g4, s4));
		}
		@Test
		public void testSolveExtreme()
		{
			assertTrue(solveGame(g5, s5));
		}	
}
