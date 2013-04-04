package solver;
import static org.junit.Assert.*;
import org.junit.*;
import solver.*;
import sudoku.*;

public class Integration_AbstractSolverTest {
	private Sudoku2 sudoku;
	private SudokuStepFinder finder;

    private BruteForceSolver bruteForceSolver;
    private GiveUpSolver giveUpSolver;
    
    private SolutionStep ss_finder;
    private SolutionStep ss_solver;
    
	@Before
	public void setUp() throws Exception {
    	finder = new SudokuStepFinder();
    	sudoku = new Sudoku2();	
  	
		String g1 = new String("..5......4....2.1...2.548...246....1...92....9.7...3.6............7..4...8..3.79.");
		sudoku.setSudoku(g1);
		finder.setSudoku(sudoku);
		
		bruteForceSolver = new BruteForceSolver(finder);
		giveUpSolver = new GiveUpSolver(finder);
		
		ss_finder = null;
		ss_solver = null;
	}

	@Test
	public void test1(){
		ss_finder = finder.getStep(SolutionType.GIVE_UP);
		ss_solver = giveUpSolver.getStep(SolutionType.GIVE_UP);
		assertTrue(ss_solver.isEqual(ss_finder));
	} 
	
	@Test
	public void test2(){
		ss_finder = finder.getStep(SolutionType.BRUTE_FORCE);
		ss_solver = bruteForceSolver.getStep(SolutionType.BRUTE_FORCE);
		assertTrue(ss_solver.isEqual(ss_finder));
	} 
	
	@Test
	public void test3(){
		int before = finder.getSudoku().getUnsolvedCellsAnz();
		ss_finder = finder.getStep(SolutionType.GIVE_UP);
		finder.doStep(ss_finder);
		int after = finder.getSudoku().getUnsolvedCellsAnz();
		assertEquals(after, before); // it does not actually solve any steps, since it "gives up"
	}
	
	@Test
	public void test4(){
		int before = finder.getSudoku().getUnsolvedCellsAnz();
		ss_finder = finder.getStep(SolutionType.BRUTE_FORCE);
		finder.doStep(ss_finder);
		int after = finder.getSudoku().getUnsolvedCellsAnz();
		assertEquals(after, before-1);
	}
}
