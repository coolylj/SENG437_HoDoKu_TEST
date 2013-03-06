import static org.junit.Assert.*;
import java.lang.String;
import java.awt.Color;

import sudoku.*;
import generator.*;

import org.junit.Test;


public class SudokuGeneratorTests {

	
	@Test
	// This test simply checks that the sudoku can load a puzzle from a given string
	// and then know that it is invalid (we are giving it an invalid sudoku to load)
	public void CreateFromInput_Test() {
		String input = "11.......22.......33......." +
					   "44.......55.......66......." +
					   "77.......88.......99.......";
		Sudoku2 s = new Sudoku2();
		s.setSudoku(input);
		for(int i = 0; i < 81; i++)
			assertEquals("Sudoku was not created properly.", input.charAt(i), s.getSudoku(ClipboardMode.VALUES_ONLY).charAt(i));
		assertEquals("Sudoku was not created properly.", false, s.checkSudoku());
	}
	
	/* The format for all of the tests that follow is the same. The point of these tests
	 * is to see how much "score" is needed by each difficulty in order to successfully 
	 * create a puzzle. Each test creates a difficulty level with its appropriate score,
	 * creates a progress dialog (needed for generation by difficulty) and creates a
	 * BackgroundGenerator to create a puzzle. The test will then check that the puzzle
	 * was actually created, and that it created properly.  */
	
	//EASY DIFFICULTY
	@Test
	public void GenerateEasy10000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EASY, 10000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateEasy5000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EASY, 5000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateEasy1000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EASY, 1000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	
	//MEDIUM DIFFICULTY
	@Test
	public void GenerateMedium10000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.MEDIUM, 10000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}

	@Test
	public void GenerateMedium5000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.MEDIUM, 5000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateMedium1000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.MEDIUM, 1000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	
	//HARD DIFFICULTY
	@Test
	public void GenerateHard10000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.HARD, 10000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateHard5000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.HARD, 5000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateHard1000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.HARD, 1000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	
	//UNFAIR DIFFICULTY
	@Test
	public void GenerateUnfair10000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.UNFAIR, 10000, "Test", Color.BLACK, Color.WHITE);
		GenerateSudokuProgressDialog g = new GenerateSudokuProgressDialog(new java.awt.Frame(), false, d, GameMode.PLAYING);
		BackgroundGenerator b = new BackgroundGenerator();
		g.run();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateUnfair5000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.UNFAIR, 5000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateUnfair1000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.UNFAIR, 1000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	//EXTREME DIFFICULTY
	@Test
	public void GenerateExtreme10000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EXTREME, 10000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateExtreme5000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EXTREME, 5000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}
	
	@Test
	public void GenerateExtreme1000_Test(){
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EXTREME, 1000, "Test", Color.BLACK, Color.WHITE);
		BackgroundGenerator b = new BackgroundGenerator();
		Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		assertNotNull("Sudoku failed to generate.", s);
		assertEquals("Sudoku generated was invalid.",true, s.checkSudoku());
	}

	
	/*
	 * The following are white box tests that were added in order to increase code coverage.
	 */
	
	@Test
	public void Generate_WithoutGUI_Test(){
		BackgroundGenerator b = new BackgroundGenerator();
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EXTREME, 10000, "Test", Color.BLACK, Color.WHITE);
		String puzzle = b.generate(d, GameMode.PLAYING);
		assertNotNull("Sudoku failed to generate.", puzzle);
	}
	
	@Test
	public void Generate_GameModeLearning(){
		BackgroundGenerator b = new BackgroundGenerator();
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EXTREME, 10000, "Test", Color.BLACK, Color.WHITE);
		String puzzle = b.generate(d, GameMode.LEARNING);
		assertNotNull("Sudoku failed to generate.", puzzle);
	}
	
	@Test
	public void Generate_GameModePractice(){
		BackgroundGenerator b = new BackgroundGenerator();
		DifficultyLevel d = new DifficultyLevel(DifficultyType.EXTREME, 10000, "Test", Color.BLACK, Color.WHITE);
		String puzzle = b.generate(d, GameMode.PRACTISING);
		assertNotNull("Sudoku failed to generate.", puzzle);
	}
	
	@Test
	public void Generate_WithPatternNotSymmetric(){
		SudokuGenerator g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		boolean[] pattern = {true, false, false, true, true, true, false, true, false, false};
		Sudoku2 s = g.generateSudoku(false, pattern);
		assertEquals("Invalid sudoku generated", true, g.validSolution(s));
	}

	@Test
	public void Generate_WithPatternSymmetric(){
		SudokuGenerator g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		boolean[] pattern = {true, false, true, true, true, false, false, false, true, false, true, false, false};
		Sudoku2 s = g.generateSudoku(true, pattern);
		assertEquals("Invalid sudoku generated", true, g.validSolution(s));
	}
	
	@Test
	public void Generate_RunOtherMethods(){
		SudokuGenerator g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		boolean[] pattern = {true, false, false, true, true, false, false};
		Sudoku2 s = g.generateSudoku(true, pattern);
		
		g.getNumberOfSolutions(s);
		g.solve(s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
}

