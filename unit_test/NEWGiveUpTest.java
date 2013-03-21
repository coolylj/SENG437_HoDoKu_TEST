import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import solver.*;
import sudoku.SolutionStep;
import sudoku.SolutionType;

/*
 * THIS TESTS THE GIVE UP SOLVER CLASS
 */

public class NEWGiveUpTest extends GiveUpSolver{
	
	private SolutionStep sStep;
	public SolutionType sType;
	
	public NEWGiveUpTest()
	{
		super(new SudokuStepFinder());
		sType = SolutionType.HIDDEN_SINGLE;
	}

	@Test
	public void getStepTest()
	{
		GiveUpSolver s = new GiveUpSolver(new SudokuStepFinder());
		
		sStep = this.getStep(sType);
		SolutionStep s1 = null;
	
		assertEquals(s1, sStep);
	}
	
	/*********************************
	 * ADDED
	 ********************************/
	@Test
	public void getStepGiveUpTypeTest() {
	    SolutionType sType1 = SolutionType.GIVE_UP;
		
		sStep = this.getStep(sType1);
		SolutionStep s1 = new SolutionStep(SolutionType.GIVE_UP);
		
		assertEquals(s1.getType(), sStep.getType());
	}
	
	//not done yet
	@Test
	public void giveUpStepTest()
	{
		sType = SolutionType.GIVE_UP;
		sStep = this.getStep(sType);
		SolutionStep s1 = new SolutionStep(SolutionType.GIVE_UP);
		
		assertNotSame(s1, sStep);
	}
	
	
	@Test
	public void doStepTest1()
	{
		sStep = new SolutionStep(SolutionType.GIVE_UP);
		boolean expected = true;
		boolean result = this.doStep(sStep);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void doStepTest2()
	{
		sStep = new SolutionStep(SolutionType.FULL_HOUSE);
		boolean expected = false;
		boolean result = this.doStep(sStep);
		
		assertEquals(expected, result);
	}
}
