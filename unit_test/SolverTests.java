import static org.junit.Assert.*;
import generator.SudokuGenerator;
import generator.SudokuGeneratorFactory;
import solver.*;
import sudoku.ClipboardMode;
import sudoku.Sudoku2;

import org.junit.Test;


public class SolverTests {

	SudokuGenerator generator;
	Sudoku2 s;
	SudokuSolver solver;
	
	public SolverTests() {
		generator = SudokuGeneratorFactory.getInstance();
		s = generator.generateSudoku(false);
		//solver = SudokuSolverFactory.getDefaultSolverInstance();
        //solver.setSudoku(s.clone());
        //solver.solve();
		//System.out.println(solver.getSudoku(ClipboardMode.VALUES_ONLY_FORMATTED));
	}
	
	/*
	 * Test of isSolved method, of class Sudoku2
	 */
	@Test
	public void testIsSolved() {
		System.out.println("isSolved Test");
		assertEquals(false, s.isSolved());
	}

}
