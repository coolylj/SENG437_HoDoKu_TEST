import static org.junit.Assert.*;

import java.awt.Color;

import solver.*;
import sudoku.*;
import generator.*;

import org.junit.Test;


public class SudokuGeneratorTests {

	@Test
	public void ValidGenerationTest() {
		
		/*This works, but I don't know how we can use this. Also, Only the generation
		 * part works for sure, I'm not sure if its getting the solutions properly */
		
		SudokuGenerator generator = SudokuGeneratorFactory.getInstance();
		Sudoku2 s = generator.generateSudoku(false);
		generator.getNumberOfSolutions(s);
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
		
		
		/*This DOESN'T work*/
		//DifficultyLevel d = new DifficultyLevel(DifficultyType.EASY, 1000, "Test", Color.BLACK, Color.WHITE);
		//GenerateSudokuProgressDialog g = new GenerateSudokuProgressDialog(new java.awt.Frame(), false, d, GameMode.PLAYING);
		//BackgroundGenerator b = new BackgroundGenerator();
		//g.run();
		//Sudoku2 s = b.generate(d, GameMode.PLAYING, null);
		//System.out.println(s);
		assertEquals("Sudoku failed to generate.",true, s.checkSudoku());
		
	}

}
