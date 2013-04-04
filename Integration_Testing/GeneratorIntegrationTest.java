import static org.junit.Assert.*;
import generator.SudokuGenerator;
import generator.SudokuGeneratorFactory;

import org.junit.Test;

import sudoku.ClipboardMode;
import sudoku.Sudoku2;


public class GeneratorIntegrationTest extends SudokuGenerator {
	
	SudokuGenerator g;
	
	public GeneratorIntegrationTest()
	{
		g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
	}

	@Test
	public void defaultGeneratorTest() {
		SudokuGenerator bs = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		
		bs.solve("..15............32...............2.9.5...3......7..8..27.....4.3...9.......6..5..");
		
		assertEquals("731526984546918732892374615683145279957283461124769853279851346365497128418632597", bs.getSolutionAsString());
		assertEquals(1, bs.getSolutionCount());
       
	}
	
	@Test
	public void getInstanceTest() {
		SudokuGenerator bs = SudokuGeneratorFactory.getInstance();
		
		bs.solve("1..2..3...2.1.........3...1....1.2.3..1...4....2.4...........1.2.........1.......");
		
		assertEquals("169254378328167549457839621845716293631925487972348156596483712283571964714692835", bs.getSolutionAsString());
		assertEquals(2, bs.getSolutionCount());
       
	}
	
	@Test
	public void giveBackTest() {
		
		//SudokuGenerator bs = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		SudokuGenerator bs = SudokuGeneratorFactory.getInstance();
		SudokuGeneratorFactory.giveBack(bs);
		
		SudokuGenerator a = SudokuGeneratorFactory.getInstance();
		
		a.solve("1..2..3...2.1.........3...1....1.2.3..1...4....2.4...........1.2.........1.......");
		
		assertEquals("169254378328167549457839621845716293631925487972348156596483712283571964714692835", a.getSolutionAsString());
		assertEquals(2, a.getSolutionCount());
       
	}
	
	@Test
	public void NullGiveBackTest() {
		
		//SudokuGenerator bs = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		SudokuGeneratorFactory.giveBack(null);
		
		SudokuGenerator a = SudokuGeneratorFactory.getInstance();
		
		a.solve("1..2..3...2.1.........3...1....1.2.3..1...4....2.4...........1.2.........1.......");
		
		assertEquals("169254378328167549457839621845716293631925487972348156596483712283571964714692835", a.getSolutionAsString());
		assertEquals(2, a.getSolutionCount());
       
	}
	
	
	@Test
	public void Generate_WithPatternNotSymmetric(){
		//SudokuGenerator g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		boolean[] pattern = {true, false, false, true, true, true, false, true, false, false};
		Sudoku2 s = g.generateSudoku(false, pattern);
		assertEquals("Invalid sudoku generated", true, g.validSolution(s));
	}

	@Test
	public void Generate_WithPatternSymmetric(){
		//SudokuGenerator g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		boolean[] pattern = {true, false, true, true, true, false, false, false, true, false, true, false, false};
		Sudoku2 s = g.generateSudoku(true, pattern);
		assertEquals("Invalid sudoku generated", true, g.validSolution(s));
	}
	
	@Test
	public void Generate_RunOtherMethods(){
		//SudokuGenerator g = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		boolean[] pattern = {true, false, false, true, true, false, false};
		Sudoku2 s = g.generateSudoku(true, pattern);
		
		g.getNumberOfSolutions(s);
		g.solve(s.getSudoku(ClipboardMode.VALUES_ONLY));
	}
}

