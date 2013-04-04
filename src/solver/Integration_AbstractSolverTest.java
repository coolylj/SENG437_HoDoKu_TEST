package solver;
import static org.junit.Assert.*;
import org.junit.*;
import solver.*;
import sudoku.*;

public class Integration_AbstractSolverTest {
	private Sudoku2 sudoku;
	private SudokuStepFinder finder;
	
    private AbstractSolver[] solvers;
    private BruteForceSolver bruteForceSolver;
    private GiveUpSolver giveUpSolver;
    
    private SolutionStep ss;
    
	@Before
	public void setUp() throws Exception {
    	finder = new SudokuStepFinder();
    	sudoku = new Sudoku2();
    	
		String g1 = new String("..5......4....2.1...2.548...246....1...92....9.7...3.6............7..4...8..3.79.");
		sudoku.setSudoku(g1);
		finder.setSudoku(sudoku);
		
		bruteForceSolver = new BruteForceSolver(finder);
		giveUpSolver = new GiveUpSolver(finder);
		solvers = new AbstractSolver[]{bruteForceSolver, giveUpSolver};
		
		ss = null;
	}

    @Test
    public void test1_withType1(){
    	ss = solvers[0].getStep(SolutionType.GIVE_UP);
    	assertNull(ss);
    }
    
    @Test
    public void test2_withType1(){	
    	ss = solvers[1].getStep(SolutionType.GIVE_UP);
    	assertNotNull(ss);
    	assertTrue(solvers[1].doStep(ss));
    }
    
    @Test
    public void test3_withType2(){
    	ss = solvers[0].getStep(SolutionType.BRUTE_FORCE);
    	assertNotNull(ss);
    	assertTrue(solvers[0].doStep(ss));
    }
    
    @Test
    public void test4_withType2(){
    	ss = solvers[1].getStep(SolutionType.BRUTE_FORCE);
    	assertNull(ss);
    }  
}
