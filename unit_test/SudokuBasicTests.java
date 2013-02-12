import static org.junit.Assert.*;

import java.awt.Color;

import sudoku.*;
import generator.*;

import org.junit.Test;


public class SudokuBasicTests {

	SudokuGenerator generator;
	Sudoku2 s;
	
	String clear = ".................................................................................";
	String sudokuTest = "010000406407600095600170020004001680008006300056800000070025001540008207209000540";
	
	public SudokuBasicTests()
	{
		generator = SudokuGeneratorFactory.getInstance();
		s = generator.generateSudoku(false);
		//System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
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
	
	/*
	 * Test of getIndex method, of class Sudoku2
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testGetIndex()
	{
		System.out.println("getIndex");
		assertEquals(38, s.getIndex(4, 2));
		assertNotSame(48, s.getIndex(4, 2));
		assertEquals(80, s.getIndex(8, 8));
	}
	
	/*
	 * Test of getValue method, of class Sudoku2
	 */
	@Test
	public void testGetValue()
	{
		System.out.println("getValue");
		s.setSudoku(sudokuTest);
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
		assertEquals(1, s.getValue(1));
		assertEquals(7, s.getValue(1,2));
	}
	
	/*@Test
	public void testResetSudoku()
	{
		System.out.println("resetSudoku");
		s.setSudoku(sudokuTest);
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
		s.resetSudoku();
		System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
	}*/
	
	

}
