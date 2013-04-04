import static org.junit.Assert.*;
import generator.SudokuGenerator;
import generator.SudokuGeneratorFactory;

import org.junit.Test;


public class GeneratorIntegrationTest {

	@Test
	public void test() {
		SudokuGenerator bs = SudokuGeneratorFactory.getDefaultGeneratorInstance();
		bs.solve("..15............32...............2.9.5...3......7..8..27.....4.3...9.......6..5..");
        System.out.println(bs.getSolutionAsString() + " (" + bs.getSolutionCount() + ")");
        bs.solve(".1.....2....8..6.......3........43....2.1....8......9.4...7.5.3...2...........4..");
      System.out.println(bs.getSolutionAsString() + " (" + bs.getSolutionCount() + ")");
	}

}
