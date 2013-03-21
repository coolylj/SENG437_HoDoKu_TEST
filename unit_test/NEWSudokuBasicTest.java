import static org.junit.Assert.*;

import java.awt.Color;

import solver.*;
import sudoku.*;
import generator.*;

import org.junit.Test;
//Basic test

public class NEWSudokuBasicTest {

	SudokuGenerator generator;
	Sudoku2 s;
	SudokuSolver solver;
	
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
	
	// easy game
	String g1 = new String("..5......4....2.1...2.548...246....1...92....9.7...3.6............7..4...8..3.79.");
	String s1 = new String("195867234478392615362154879524673981836921547917548326749286153253719468681435792");
	
	public NEWSudokuBasicTest()
	{
		generator = SudokuGeneratorFactory.getInstance();
		s = generator.generateSudoku(false);
	}
	
	/*
	 * Test of setSudoku method, of class Sudoku2
	 * Input Format: ...1.32.4..1.
	 */
	@Test
	public void testSetSudokuType1()
	{
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
		s.setSudoku(testString3);
		//System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY));
		assertEquals(testString1, s.getSudoku(ClipboardMode.VALUES_ONLY));
		assertEquals(expOutput, s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
	}
	
	/*
	 * Test of getIndex method, of class Sudoku2
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testGetIndex()
	{
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
		s.setSudoku(testString2);
		//System.out.println(s.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
		assertEquals(1, s.getValue(1));
		assertEquals(7, s.getValue(1,2));
	}
	
	/*
	 * Test of clearSudoku method, of class Sudoku2
	 */
	
	@Test
	public void testClearSudoku()
	{
		s.clearSudoku();
		assertEquals(clear, s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
	
	/*************************NEW TESTS****************************/
	/*************************************************************/
	/*************************************************************/
	/*************************************************************/
	/*
	 * Test of clearSudoku method with a cleared board, of class Sudoku2
	 */
	
	@Test
	public void testClearedSudokuClear()
	{
		Sudoku2 b = new Sudoku2();
		//clear is a clear board.
		b.setSudoku(clear);
		
		//to double check it is not solved
		assertFalse(b.isSolved());
		
		s.clearSudoku();
		assertEquals(clear, s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
	
	/*
	 * Test of clearSudoku method with a completed board, of class Sudoku2
	 */
	
	@Test
	public void testCompletedSudokuClear()
	{
		Sudoku2 b = new Sudoku2();
		//s1 is a solved board.
		b.setSudoku(s1);
		//to double check it is solved
		assertTrue(b.isSolved());
		
		s.clearSudoku();
		assertEquals(clear, s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
	
	/*
	 * Test of resetSudokuTest, of class Sudoku2, with initial
	 * state != null
	 */
	@Test
	public void resetSudokuTest1()
	{
		s = new Sudoku2();
		s.setSudoku(g1);
		
		String expected = s.getSudoku(ClipboardMode.VALUES_ONLY);

		s.resetSudoku();
		String actual = s.getSudoku(ClipboardMode.VALUES_ONLY);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Test of resetSudokuTest, of class Sudoku2, with initial
	 * state == null
	 */
	@Test
	public void resetSudokuTest2()
	{
		s = new Sudoku2();
		
		String expected = s.getSudoku(ClipboardMode.VALUES_ONLY);

		//test the result now
		s.resetSudoku();
		String actual = s.getSudoku(ClipboardMode.VALUES_ONLY);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Test of set method, of class Sudoku2
	 */
	@Test
	public void setMethodTestWithInitStateNotNull()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString1);
		
		Sudoku2 s2 = new Sudoku2();
		s2.set(s);
		
		String expected = testString1;
		String actual = s2.getSudoku(ClipboardMode.VALUES_ONLY);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Test of set method, of class Sudoku2
	 */
	@Test
	public void setMethodTestWithNullInitState()
	{
		Sudoku2 s = new Sudoku2();
		Sudoku2 s2 = new Sudoku2();
		s2.set(s);
		
		String expected =  s.getSudoku(ClipboardMode.VALUES_ONLY);
		String actual = s2.getSudoku(ClipboardMode.VALUES_ONLY);
		
		assertEquals(expected, actual);
	}
	
	/*
	 * Test of isValidMethod method, of class Sudoku2, with a
	 * valid value
	 */
	@Test
	public void isValidValueTestValid()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString3);
		assertTrue(s.isValidValue(3, 3, 2));
	}
	
	/*
	 * Test of set method, of class Sudoku2, with a
	 * invalid value
	 */
	@Test
	public void isValidValueTestInvalid()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString3);
		assertFalse(s.isValidValue(3, 3, 1));
	}
	
	@Test
	public void setStatusTest1()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString3);
		
		s.setStatus(SudokuStatus.VALID);
		SudokuStatus expected = SudokuStatus.VALID;
		
		assertEquals(expected, s.getStatus());
	}
	
	@Test
	public void setStatusTest2()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString3);
		
		s.setStatus(0);
		SudokuStatus expected = SudokuStatus.INVALID;
		
		assertEquals(expected, s.getStatus());
	}
	
	@Test
	public void setStatusTest3()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString3);
		
		s.setStatus(1);
		SudokuStatus expected = SudokuStatus.VALID;
		
		assertEquals(expected, s.getStatus());
	}
	
	@Test
	public void setStatusTest4()
	{
		Sudoku2 s = new Sudoku2();
		s.setSudoku(testString3);
		
		s.setStatus(2);
		SudokuStatus expected = SudokuStatus.MULTIPLE_SOLUTIONS;
		
		assertEquals(expected, s.getStatus());
	}
	
	/*****************************************
	 * added
	 */
	
	@Test
	public void toStringTest() {
		StepConfig s1 = new StepConfig();
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		String expected = "Hidden Single";
		
		assertEquals(expected, s.toString());
	}
	
	@Test
	public void getTypeTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		SolutionType t = SolutionType.HIDDEN_SINGLE;
		
		assertEquals(t.getStepName(), s.getType().getStepName());
	}
	
	@Test
	public void setTypeTest() {
		
		StepConfig s = new StepConfig(1, null, 2, null, 3, 4, true, false, 5, true, false);
		SolutionType t = SolutionType.HIDDEN_SINGLE;
		
		s.setType(SolutionType.HIDDEN_SINGLE);
		
		assertEquals(t.getStepName(), s.getType().getStepName());
	}
	
	@Test
	public void getLevelTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		String t = "Medium";
		
		assertEquals(t, s.getLevelName(2));
	}
	
	@Test
	public void setLevelTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		String t = "Hard";
		
		s.setLevel(3);
		
		assertEquals(t, s.getLevelName(3));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getLevelDifficultyTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		String t = "Incomplete";
		DifficultyLevel level = new DifficultyLevel(DifficultyType.INCOMPLETE, 40, "COLOR", null, null);

		
		assertEquals(t, s.getLevelName(level));
	}
	
	@Test
	public void getLevelTest2() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 2;
		
		assertEquals(t, s.getLevel());
	}
	
	@Test
	public void getBaseTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 3;
		
		assertEquals(t, s.getBaseScore());
	}
	
	@Test
	public void setBaseTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 3;
		
		s.setBaseScore(3);
		
		assertEquals(t, s.getBaseScore());
	}
	
	@Test
	public void getAdminTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 4;
		
		assertEquals(t, s.getAdminScore());
	}
	
	@Test
	public void setAdminTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 4;
		
		s.setAdminScore(4);
		
		assertEquals(t, s.getAdminScore());
	}
	
	
	@Test
	public void isEnabledTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		boolean t = true;
		
		assertEquals(t, s.isEnabled());
	}
	
	@Test
	public void setEnabledTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		boolean t = true;
		
		s.setEnabled(true);
		
		assertEquals(t, s.isEnabled());
	}
	
	@Test
	public void isEnabledTrainingTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		boolean t = false;
		
		assertEquals(t, s.isEnabledTraining());
	}
	
	@Test
	public void isEnabledProgressTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		boolean t = true;
		
		assertEquals(t, s.isEnabledProgress());
	}
	
	@Test
	public void getIndexprogressTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 5;
		
		assertEquals(t, s.getIndexProgress());
	}
	
	@Test
	public void allStepsTest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		boolean t = false;
		
		assertEquals(t, s.isAllStepsEnabled());
	}
	
	@Test
	public void getIndextest() {
		
		StepConfig s = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		int t = 1;
		
		assertEquals(t, s.getIndex());
	}
	
	@Test
	public void compareTo() {
		
		StepConfig s1 = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		StepConfig s2 = new StepConfig(2, SolutionType.HIDDEN_SINGLE, 2, null, 3, 4, true, false, 5, true, false);
		
		assertTrue(s2.compareTo(s1) == 1);
	}
	
	@Test
	public void getCategoryNameTest() {
		
		StepConfig s1 = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, SolutionCategory.SINGLES, 3, 4, true, false, 5, true, false);
		String expected = "Singles";
		assertEquals(expected, s1.getCategoryName());
	}
	
	@Test
	public void getSolutionCategoryNameTest() {
		
		StepConfig s1 = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, SolutionCategory.SINGLES, 3, 4, true, false, 5, true, false);
		SolutionCategory expected = SolutionCategory.SINGLES;
		
		assertEquals(expected, s1.getCategory());
	}
	
	@Test
	public void setEnabledTrainingTest() {
		
		StepConfig s1 = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, SolutionCategory.SINGLES, 3, 4, true, false, 5, true, false);
		boolean expected = false;
		
		System.out.println(s1.isEnabledTraining());
		//s1.setEnabledTraining(true);
		
		assertEquals(expected, s1.isEnabledTraining());
	}
	
	@Test
	public void setEnabledStepsTest() {
		
		StepConfig s1 = new StepConfig(1, SolutionType.HIDDEN_SINGLE, 2, SolutionCategory.SINGLES, 3, 4, false, true, 5, false, true);
		boolean expected = true;

		
		assertEquals(expected, s1.isAllStepsEnabled());
		assertEquals(expected, s1.isEnabledTraining());
	}
	
}

