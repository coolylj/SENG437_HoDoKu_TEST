import static org.junit.Assert.*;
import generator.SudokuGeneratorFactory;
import solver.BruteForceSolver;
import solver.SudokuStepFinder;
import sudoku.SolutionStep;
import sudoku.SolutionType;
import sudoku.Sudoku2;

import org.junit.Test;


public class BruteForceTest extends BruteForceSolver{

	private SolutionStep sStep;
	private Sudoku2 testSudoku;
	public SolutionType sType;
	private SudokuStepFinder s;
	
	public BruteForceTest(){
		super(new SudokuStepFinder());
		String g1 = new String("..5......4....2.1...2.548...246....1...92....9.7...3.6............7..4...8..3.79.");
		testSudoku = new Sudoku2();
		testSudoku.setSudoku(g1);
		sType = SolutionType.HIDDEN_SINGLE;
		
		s = new SudokuStepFinder();
		s.setSudoku(testSudoku);
		finder = s;
	}
	
	@Test
	public void Test_GetStep_WrongType() {
		sStep = this.getStep(sType);
		assertNull("Code did not run properly.", sStep);
	}
	
	@Test
	public void Test_GetStep_CorrectType(){
		sType = SolutionType.BRUTE_FORCE;
		sStep = this.getStep(sType);
		assertNotNull("Code did not run properly.", sStep);
	}
	
	@Test
	public void TestGetStep_InvalidSudoku(){
		s.setSudoku(new Sudoku2());
		sType = SolutionType.BRUTE_FORCE;
		sStep = this.getStep(sType);
		assertNull("Code did not run properly.", sStep);
	}
	
	@Test
	public void TestGetStep_ValidSudoku_WithSolution(){
		SudokuGeneratorFactory.getDefaultGeneratorInstance().validSolution(testSudoku);
		sType = SolutionType.BRUTE_FORCE;
		sStep = this.getStep(sType);
		assertNotNull("Code did not run properly.", sStep);
	}
	
	@Test
	public void Test_DoStep_CorrectType(){
		sType = SolutionType.BRUTE_FORCE;
		sStep = this.getStep(sType);
		boolean success = this.doStep(sStep);
		assertEquals("Code did not run properly.", true, success);
	}
	
	@Test
	public void Test_DoStep_IncorrectType(){
		sType = SolutionType.BRUTE_FORCE;
		sStep = this.getStep(sType);
		sStep.setType(SolutionType.HIDDEN_SINGLE);
		boolean success = this.doStep(sStep);
		assertEquals("Code did not run properly.", false, success);
	}
}