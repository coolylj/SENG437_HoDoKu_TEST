import static org.junit.Assert.*;

import java.awt.Color;

import sudoku.*;
import generator.*;

import org.junit.Test;


public class OtherTests {

	SudokuGenerator generator;
	Sudoku2 s;
	
	String clear = ".................................................................................";
	
	public OtherTests()
	{
		generator = SudokuGeneratorFactory.getInstance();
		s = generator.generateSudoku(false);
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
	
	//@Test
	//public void ValidGenerationTest() {
		
		//generator.getNumberOfSolutions(s);
		//System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
		//assertEquals("Sudoku failed to generate.",true, s.checkSudoku());
	//}
	
	/*
	 * Test of clearSudoku method, of class Sudoku2
	 */
	
	@Test
	public void testClearSudoku()
	{
		System.out.println("clearSudoku");
		s.clearSudoku();
		assertEquals(clear, s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
	
	@Test
	public void testResetSudoku()
	{
		System.out.println("resetSudoku");
		s.resetSudoku();
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
	
	

}
