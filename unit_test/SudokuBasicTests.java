import static org.junit.Assert.*;

import java.awt.Color;

import sudoku.*;
import generator.*;

import org.junit.Test;
//Basic test

public class SudokuBasicTests {

	SudokuGenerator generator;
	Sudoku2 s;
	
	String clear = ".................................................................................";
	String testString1 = ".1....4.64.76...956..17..2...4..168...8..63...568......7..25..154...82.72.9...54.";
	String testString2 = "010000406407600095600170020004001680008006300056800000070025001540008207209000540";
	String testString3 =  "*-----------*\n" +
						  "|.1.|...|4.6|\n" +
						  "|4.7|6..|.95|\n" +
						  "|6..|17.|.2.|\n" +
						  "|---+---+---|\n" +
						  "|..4|..1|68.|\n" +
						  "|..8|..6|3..|\n" +
						  "|.56|8..|...|\n" +
						  "|---+---+---|\n" +
						  "|.7.|.25|..1|\n" +
						  "|54.|..8|2.7|\n" +
						  "|2.9|...|54.|\n" +
						  "*-----------*\n";

	
	String expOutput =  ".---------.---------.---------.\n" +
						"| .  1  . | .  .  . | 4  .  6 |\n" +
						"| 4  .  7 | 6  .  . | .  9  5 |\n" +
						"| 6  .  . | 1  7  . | .  2  . |\n" +
						":---------+---------+---------:\n" +
						"| .  .  4 | .  .  1 | 6  8  . |\n" +
						"| .  .  8 | .  .  6 | 3  .  . |\n" +
						"| .  5  6 | 8  .  . | .  .  . |\n" +
						":---------+---------+---------:\n" +
						"| .  7  . | .  2  5 | .  .  1 |\n" +
						"| 5  4  . | .  .  8 | 2  .  7 |\n" +
						"| 2  .  9 | .  .  . | 5  4  . |\n" +
						"\'---------\'---------\'---------\'\n" ;
	
	public SudokuBasicTests()
	{
		generator = SudokuGeneratorFactory.getInstance();
		s = generator.generateSudoku(false);
	}
	
	@Test
	public void newInstanceTest()
	{
		s = new Sudoku2();
	}
	/*
	 * Test of setSudoku method, of class Sudoku2
	 * Input Format: ...1.32.4..1.
	 */
	@Test
	public void testSetSudokuType1()
	{
		System.out.println("setSudoku Test 1");
		s.setSudoku(testString1);
		assertEquals(testString1, s.getSudoku(ClipboardMode.VALUES_ONLY));
		assertEquals(expOutput, s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
	}

	/*
	 * Test of setSudoku method, of class Sudoku2
	 * Input Format: 0001032040010
	 */
	@Test
	public void testSetSudokuType2()
	{
		System.out.println("setSudoku Test 2");
		s.setSudoku(testString2);
		assertEquals(testString1, s.getSudoku(ClipboardMode.VALUES_ONLY));
		assertEquals(expOutput, s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
	}
	
	/*
	 * Test of setSudoku method, of class Sudoku2
	 * Input Format: 
	 * 	  "*-----------*\n" +
		  "|.1.|...|4.6|\n" +
		  "|4.7|6..|.95|\n" +
		  "|6..|17.|.2.|\n" +
		  "|---+---+---|\n" +
		  "|..4|..1|68.|\n" +
		  "|..8|..6|3..|\n" +
		  "|.56|8..|...|\n" +
		  "|---+---+---|\n" +
		  "|.7.|.25|..1|\n" +
		  "|54.|..8|2.7|\n" +
		  "|2.9|...|54.|\n" +
		  "*-----------*\n" +
	 */
	@Test
	public void testSetSudokuType3()
	{
		System.out.println("setSudoku Test 3");
		s.setSudoku(testString3);
		//System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
		assertEquals(testString1, s.getSudoku(ClipboardMode.VALUES_ONLY));
		assertEquals(expOutput, s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
	}
	
	/*
	 * Test of clearSudoku method, of class Sudoku2
	 */
	
	@Test
	public void testClearSudoku()
	{
		System.out.println("clearSudoku Test");
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
		System.out.println("getIndex Test");
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
		System.out.println("getValue Test");
		s.setSudoku(testString2);
		//System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
		assertEquals(1, s.getValue(1));
		assertEquals(7, s.getValue(1,2));
	}
}
