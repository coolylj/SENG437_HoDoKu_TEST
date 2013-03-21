import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.SolutionType;


/*
 * THIS TESTS THE SOLUTION TYPE CLASS
 */
public class NEWSolutionTypeTest {
	
	SolutionType sType;
	
	@SuppressWarnings("null")
	@Test
	public void solutionTypeCall1()
	{
		SolutionType s = SolutionType.FULL_HOUSE;
		s.setStepName("Full_House");

		assertEquals("Full_House", s.getStepName());
	}
	
	@Test
	public void solutionTypeCall2()
	{
		SolutionType s = SolutionType.FULL_HOUSE;
		s.setLibraryType("0000");

		assertEquals("0000", s.getLibraryType());
	}
	
	@Test
	public void solutionTypeCall3()
	{
		SolutionType s = SolutionType.FULL_HOUSE;
		s.setArgName("fh");

		assertEquals("fh", s.getArgName());
	}


	/*************************************************************************
	 * PREVIOUS
	 ************************************************************/
	
	/*
	 * This tests the toString method
	 */
	@Test
	public void toStringTest() {
		
		//ssType.SolutionType();
		sType = SolutionType.HIDDEN_SINGLE;
		
		String expected = "enum SolutionType: Hidden Single (0002|h1)";
		
		String actual = sType.toString();
		
		assertEquals(expected, actual);
	}
	
	
	/*
	 * This tests the compareTo method
	 */
	@Test
	public void compareToTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		SolutionType s1 = SolutionType.GIVE_UP;
		
		System.out.println(sType.compareTo(s1));
	}
	
	
	/*
	 * This tests the getFishSize method
	 * with X_WING case
	 */
	@Test
	public void getFishSizeTest1()
	{
		sType = SolutionType.X_WING;
		
		int expected = 2;
		int actual = sType.getFishSize();
		
		assertEquals(expected, actual);
	}
	
	/*
	 * This tests the getFishSize method
	 * with SWORDFISH case
	 */
	@Test
	public void getFishSizeTest2()
	{
		sType = SolutionType.SWORDFISH;
		
		int expected = 3;
		int actual = sType.getFishSize();
		
		assertEquals(expected, actual);
	}
	
	/*
	 * This tests the getFishSize method
	 * with JELLYFISH case
	 */
	@Test
	public void getFishSizeTest3()
	{
		sType = SolutionType.JELLYFISH;
		
		int expected = 4;
		int actual = sType.getFishSize();
		
		assertEquals(expected, actual);
	}
	
	/*
	 * This tests the getFishSize method
	 * with SQUIRMBAG case
	 */
	@Test
	public void getFishSizeTest4()
	{
		sType = SolutionType.SQUIRMBAG;
		
		int expected = 5;
		int actual = sType.getFishSize();
		
		assertEquals(expected, actual);
	}
	
	/*
	 * This tests the getFishSize method
	 * with WHALE case
	 */
	@Test
	public void getFishSizeTest5()
	{
		sType = SolutionType.WHALE;
		
		int expected = 6;
		int actual = sType.getFishSize();
		
		assertEquals(expected, actual);
	}
	
	/*
	 * This tests the getFishSize method
	 * with a random case (ex. GIVE_UP)
	 */
	@Test
	public void getFishSizeTest6()
	{
		sType = SolutionType.GIVE_UP;
		
		int expected = 7;
		int actual = sType.getFishSize();
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSingleTestValidInputs()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		SolutionType sType2 = SolutionType.NAKED_SINGLE;
		SolutionType sType3 = SolutionType.FULL_HOUSE;
		
		boolean expected = true;
		boolean actual1 = sType.isSingle();
		boolean actual2 = sType.isSingle(sType);
		boolean actual3 = sType.isSingle(sType2);
		boolean actual4 = sType.isSingle(sType3);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSingleTestInvalidInputs()
	{
		sType = SolutionType.GIVE_UP;
		SolutionType sType2 = SolutionType.NAKED_PAIR;
		
		boolean expected = false;
		boolean actual1 = sType.isSingle();
		boolean actual2 = sType.isSingle(sType);
		boolean actual3 = sType.isSingle(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSSSTStestValid()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		boolean expected = true;
		boolean actual1 = sType.isSSTS();
		boolean actual2 = sType.isSSTS(SolutionType.HIDDEN_PAIR);
		boolean actual3 = sType.isSSTS(SolutionType.HIDDEN_TRIPLE);
		boolean actual4 = sType.isSSTS(SolutionType.HIDDEN_QUADRUPLE);
		boolean actual5 = sType.isSSTS(SolutionType.NAKED_PAIR);
		boolean actual6 = sType.isSSTS(SolutionType.NAKED_TRIPLE);
		boolean actual7 = sType.isSSTS(SolutionType.NAKED_QUADRUPLE);
		boolean actual8 = sType.isSSTS(SolutionType.LOCKED_PAIR);
		boolean actual9 = sType.isSSTS(SolutionType.LOCKED_TRIPLE);
		boolean actual10 = sType.isSSTS(SolutionType.LOCKED_CANDIDATES);
		boolean actual11 = sType.isSSTS(SolutionType.LOCKED_CANDIDATES_1);
		boolean actual12 = sType.isSSTS(SolutionType.LOCKED_CANDIDATES_2);
		boolean actual13 = sType.isSSTS(SolutionType.X_WING);
		boolean actual14 = sType.isSSTS(SolutionType.XY_WING);
		boolean actual15 = sType.isSSTS(SolutionType.SWORDFISH);
		boolean actual16 = sType.isSSTS(SolutionType.JELLYFISH);
		boolean actual17 = sType.isSSTS(SolutionType.SIMPLE_COLORS);
		boolean actual18 = sType.isSSTS(SolutionType.MULTI_COLORS);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
		assertEquals(expected, actual6);
		assertEquals(expected, actual7);
		assertEquals(expected, actual8);
		assertEquals(expected, actual9);
		assertEquals(expected, actual10);
		assertEquals(expected, actual11);
		assertEquals(expected, actual12);
		assertEquals(expected, actual13);
		assertEquals(expected, actual14);
		assertEquals(expected, actual15);
		assertEquals(expected, actual16);
		assertEquals(expected, actual17);
		assertEquals(expected, actual18);
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSSTSInvalidInputs()
	{
		sType = SolutionType.UNIQUENESS_1;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isSSTS();
		boolean actual2 = sType.isSSTS(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isHiddenTestValid()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		SolutionType sType2 = SolutionType.HIDDEN_PAIR;
		SolutionType sType3 = SolutionType.HIDDEN_TRIPLE;
		SolutionType sType4 = SolutionType.HIDDEN_QUADRUPLE;
		
		boolean expected = true;
		boolean actual1 = sType.isHiddenSubset();
		boolean actual2 = sType.isHiddenSubset(sType2);
		boolean actual3 = sType.isHiddenSubset(sType3);
		boolean actual4 = sType.isHiddenSubset(sType4);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isHiddenTestInvalidInputs()
	{
		sType = SolutionType.UNIQUENESS_1;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isHiddenSubset();
		boolean actual2 = sType.isHiddenSubset(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isFishValidInputs()
	{
		sType = SolutionType.X_WING;
		SolutionType sType2 = SolutionType.SASHIMI_X_WING;
		SolutionType sType3 = SolutionType.FRANKEN_X_WING;
		SolutionType sType4 = SolutionType.FINNED_FRANKEN_X_WING;
		SolutionType sType5 = SolutionType.MUTANT_X_WING;
		SolutionType sType6 = SolutionType.FINNED_MUTANT_X_WING;
		
		
		boolean expected = true;
		boolean actual1 = sType.isFish();
		boolean actual2 = sType.isFish(sType2);
		boolean actual3 = sType.isFish(sType3);
		boolean actual4 = sType.isFish(sType4);
		boolean actual5 = sType.isFish(sType5);
		boolean actual6 = sType.isFish(sType6);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
		assertEquals(expected, actual6);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isFishInvalidInputTest1()
	{
		
		boolean expected = false;
		boolean actual1 = sType.isFish(null);
		
		assertEquals(expected, actual1);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isFishInvalidInputTest2()
	{
		sType = SolutionType.SKYSCRAPER;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isFish();
		boolean actual2 = sType.isFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}

	@SuppressWarnings("static-access")
	@Test
	public void isBasicFishValidTest()
	{
		sType = SolutionType.X_WING;
		SolutionType sType2 = SolutionType.FINNED_X_WING;
		
		boolean expected = true;
		boolean actual1 = sType.isBasicFish();
		boolean actual2 = sType.isBasicFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isBasicFishNullTest()
	{
		
		boolean expected = false;
		boolean actual1 = sType.isBasicFish(null);
		
		assertEquals(expected, actual1);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isBasicFishInvalidTest()
	{
		sType = SolutionType.SKYSCRAPER;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isBasicFish();
		boolean actual2 = sType.isBasicFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isFrankenFishValidTest()
	{
		sType = SolutionType.FRANKEN_SWORDFISH;
		SolutionType sType2 = SolutionType.FINNED_FRANKEN_X_WING;
		
		boolean expected = true;
		boolean actual1 = sType.isFrankenFish();
		boolean actual2 = sType.isFrankenFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isFrankenFishNullTest()
	{
		
		boolean expected = false;
		boolean actual1 = sType.isFrankenFish(null);
		
		assertEquals(expected, actual1);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isFrankenFishInvalidTest()
	{
		sType = SolutionType.SKYSCRAPER;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isFrankenFish();
		boolean actual2 = sType.isFrankenFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isMutantFishValidTest()
	{
		sType = SolutionType.MUTANT_X_WING;
		SolutionType sType2 = SolutionType.FINNED_MUTANT_JELLYFISH;
		
		boolean expected = true;
		boolean actual1 = sType.isMutantFish();
		boolean actual2 = sType.isMutantFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isMutantFishNullTest()
	{
		
		boolean expected = false;
		boolean actual1 = sType.isMutantFish(null);
		
		assertEquals(expected, actual1);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isMutantFishInvalidTest()
	{
		sType = SolutionType.SKYSCRAPER;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isMutantFish();
		boolean actual2 = sType.isMutantFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isKrakenFishValidTest()
	{
		sType = SolutionType.KRAKEN_FISH;
		SolutionType sType2 = SolutionType.KRAKEN_FISH_TYPE_1;
		SolutionType sType3 = SolutionType.KRAKEN_FISH_TYPE_2;
		
		boolean expected = true;
		boolean actual1 = sType.isKrakenFish();
		boolean actual2 = sType.isKrakenFish(sType2);
		boolean actual3 = sType.isKrakenFish(sType3);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isKrakenFishInvalidTest()
	{
		sType = SolutionType.SKYSCRAPER;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isKrakenFish();
		boolean actual2 = sType.isKrakenFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSashimiFishValidTest()
	{
		sType = SolutionType.SASHIMI_X_WING;
		SolutionType sType2 = SolutionType.SASHIMI_SWORDFISH;
		SolutionType sType3 = SolutionType.SASHIMI_JELLYFISH;
		SolutionType sType4 = SolutionType.SASHIMI_SQUIRMBAG;
		SolutionType sType5 = SolutionType.SASHIMI_LEVIATHAN;
		SolutionType sType6 = SolutionType.SASHIMI_WHALE;
		
		boolean expected = true;
		boolean actual1 = sType.isSashimiFish();
		boolean actual2 = sType.isSashimiFish(sType2);
		boolean actual3 = sType.isSashimiFish(sType3);
		boolean actual4 = sType.isSashimiFish(sType4);
		boolean actual5 = sType.isSashimiFish(sType5);
		boolean actual6 = sType.isSashimiFish(sType6);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
		assertEquals(expected, actual6);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSashimiFishInvalidTest()
	{
		sType = SolutionType.SKYSCRAPER;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isSashimiFish();
		boolean actual2 = sType.isSashimiFish(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSimpleChainOrLoopValidTest()
	{
		sType = SolutionType.NICE_LOOP;
		SolutionType sType2 = SolutionType.DISCONTINUOUS_NICE_LOOP;
		SolutionType sType3 = SolutionType.CONTINUOUS_NICE_LOOP;
		SolutionType sType4 = SolutionType.GROUPED_NICE_LOOP;
		SolutionType sType5 = SolutionType.GROUPED_DISCONTINUOUS_NICE_LOOP;
		SolutionType sType6 = SolutionType.GROUPED_CONTINUOUS_NICE_LOOP;
		SolutionType sType7 = SolutionType.X_CHAIN;
		SolutionType sType8 = SolutionType.XY_CHAIN;
		SolutionType sType9 = SolutionType.REMOTE_PAIR;
		SolutionType sType10 = SolutionType.AIC;
		SolutionType sType11 = SolutionType.GROUPED_AIC;
		
		
		boolean expected = true;
		boolean actual1 = sType.isSimpleChainOrLoop();
		boolean actual2 = sType.isSimpleChainOrLoop(sType2);
		boolean actual3 = sType.isSimpleChainOrLoop(sType3);
		boolean actual4 = sType.isSimpleChainOrLoop(sType4);
		boolean actual5 = sType.isSimpleChainOrLoop(sType5);
		boolean actual6 = sType.isSimpleChainOrLoop(sType6);
		boolean actual7 = sType.isSimpleChainOrLoop(sType7);
		boolean actual8 = sType.isSimpleChainOrLoop(sType8);
		boolean actual9 = sType.isSimpleChainOrLoop(sType9);
		boolean actual10 = sType.isSimpleChainOrLoop(sType10);
		boolean actual11 = sType.isSimpleChainOrLoop(sType11);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
		assertEquals(expected, actual6);
		assertEquals(expected, actual7);
		assertEquals(expected, actual8);
		assertEquals(expected, actual9);
		assertEquals(expected, actual10);
		assertEquals(expected, actual11);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void isSimpleChainOrLoopInvalidTest()
	{
		sType = SolutionType.UNIQUENESS_1;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.isSimpleChainOrLoop();
		boolean actual2 = sType.isSimpleChainOrLoop(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}

	@SuppressWarnings("static-access")
	@Test
	public void useCandToDelInLibraryFormatValidTest()
	{
		sType = SolutionType.NICE_LOOP;
		SolutionType sType2 = SolutionType.DISCONTINUOUS_NICE_LOOP;
		SolutionType sType3 = SolutionType.CONTINUOUS_NICE_LOOP;
		SolutionType sType4 = SolutionType.GROUPED_NICE_LOOP;
		SolutionType sType5 = SolutionType.GROUPED_DISCONTINUOUS_NICE_LOOP;
		SolutionType sType6 = SolutionType.GROUPED_CONTINUOUS_NICE_LOOP;
		SolutionType sType7 = SolutionType.FORCING_CHAIN_CONTRADICTION;
		SolutionType sType8 = SolutionType.FORCING_NET_CONTRADICTION;
		//SolutionType sType9 = SolutionType.REMOTE_PAIR;
		SolutionType sType10 = SolutionType.AIC;
		SolutionType sType11 = SolutionType.GROUPED_AIC;
		SolutionType sType12 = SolutionType.ALS_XZ;
		SolutionType sType13 = SolutionType.ALS_XY_WING;
		SolutionType sType14 = SolutionType.ALS_XY_CHAIN;
		SolutionType sType15 = SolutionType.DEATH_BLOSSOM;
		SolutionType sType16 = SolutionType.SUE_DE_COQ;
		
		
		boolean expected = true;
		boolean actual1 = sType.useCandToDelInLibraryFormat();
		boolean actual2 = sType.useCandToDelInLibraryFormat(sType2);
		boolean actual3 = sType.useCandToDelInLibraryFormat(sType3);
		boolean actual4 = sType.useCandToDelInLibraryFormat(sType4);
		boolean actual5 = sType.useCandToDelInLibraryFormat(sType5);
		boolean actual6 = sType.useCandToDelInLibraryFormat(sType6);
		boolean actual7 = sType.useCandToDelInLibraryFormat(sType7);
		boolean actual8 = sType.useCandToDelInLibraryFormat(sType8);
		//boolean actual9 = sType.useCandToDelInLibraryFormat(sType9);
		boolean actual10 = sType.useCandToDelInLibraryFormat(sType10);
		boolean actual11 = sType.useCandToDelInLibraryFormat(sType11);
		boolean actual12 = sType.useCandToDelInLibraryFormat(sType12);
		boolean actual13 = sType.useCandToDelInLibraryFormat(sType13);
		boolean actual14 = sType.useCandToDelInLibraryFormat(sType14);
		boolean actual15 = sType.useCandToDelInLibraryFormat(sType15);
		boolean actual16 = sType.useCandToDelInLibraryFormat(sType16);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
		assertEquals(expected, actual3);
		assertEquals(expected, actual4);
		assertEquals(expected, actual5);
		assertEquals(expected, actual6);
		assertEquals(expected, actual7);
		assertEquals(expected, actual8);
		//assertEquals(expected, actual9);
		assertEquals(expected, actual10);
		assertEquals(expected, actual11);
		assertEquals(expected, actual12);
		assertEquals(expected, actual13);
		assertEquals(expected, actual14);
		assertEquals(expected, actual15);
		assertEquals(expected, actual16);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void useCandToDelInLibraryFormatInvalidTest()
	{
		sType = SolutionType.UNIQUENESS_1;
		SolutionType sType2 = SolutionType.BUG_PLUS_1;
		
		boolean expected = false;
		boolean actual1 = sType.useCandToDelInLibraryFormat();
		boolean actual2 = sType.useCandToDelInLibraryFormat(sType2);
		
		assertEquals(expected, actual1);
		assertEquals(expected, actual2);
	}
	
	@Test
	public void getLibraryTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		String expected = "0002";
		String actual = sType.getLibraryType();
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getStepNameTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		String expected = "Hidden Single";
		String actual = sType.getStepName();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void getArgNameTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		String expected = "h1";
		String actual = sType.getArgName();
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getFromArgNameValidTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		SolutionType expected = SolutionType.HIDDEN_PAIR;
		SolutionType actual = sType.getTypeFromArgName("h2");
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getFromArgNameInvalidTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		String str = "";
		
		SolutionType expected = null;
		SolutionType actual = sType.getTypeFromArgName(str);
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getTypeFromLibraryTypeValidTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		
		SolutionType expected = SolutionType.HIDDEN_PAIR;
		SolutionType actual = sType.getTypeFromLibraryType("0210");
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getTypeFromLibraryTypeValidNull()
	{
		sType = SolutionType.SASHIMI_X_WING;
		
		SolutionType expected = SolutionType.SASHIMI_X_WING;
		SolutionType actual = sType.getTypeFromLibraryType("03201");
		
		assertEquals(expected, actual);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void getTypeFromLibraryTypeTestInvalidTest()
	{
		sType = SolutionType.HIDDEN_SINGLE;
		String str = " ";
		
		SolutionType expected = null;
		SolutionType actual = sType.getTypeFromLibraryType(str);
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getTypeFromLibraryTypeTestSiameseTest()
	{
		sType = SolutionType.SIMPLE_COLORS_WRAP;
		
		SolutionType expected = null;
		SolutionType actual = sType.getTypeFromLibraryType("1111");
		
		assertEquals(expected, actual);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getStepConfigTest()
	{
		sType = SolutionType.CONTINUOUS_NICE_LOOP;
		SolutionType sType2 = SolutionType.DISCONTINUOUS_NICE_LOOP;
		SolutionType sType3 = SolutionType.AIC;
		SolutionType sType4 = SolutionType.GROUPED_CONTINUOUS_NICE_LOOP;
		SolutionType sType5 = SolutionType.GROUPED_DISCONTINUOUS_NICE_LOOP;
		SolutionType sType6 = SolutionType.GROUPED_AIC;
		SolutionType sType7 = SolutionType.FORCING_CHAIN_CONTRADICTION;
		SolutionType sType8 = SolutionType.FORCING_CHAIN_VERITY;
		SolutionType sType9 = SolutionType.FORCING_NET_CONTRADICTION;
		SolutionType sType10 = SolutionType.KRAKEN_FISH_TYPE_1;
		SolutionType sType11 = SolutionType.KRAKEN_FISH_TYPE_2;
		SolutionType sType12 = SolutionType.DUAL_TWO_STRING_KITE;
		SolutionType sType13 = SolutionType.DUAL_EMPTY_RECTANGLE;
		SolutionType sType14 = SolutionType.SIMPLE_COLORS_TRAP;
		SolutionType sType15 = SolutionType.SIMPLE_COLORS_WRAP;
		SolutionType sType16 = SolutionType.MULTI_COLORS_1;
		SolutionType sType17 = SolutionType.MULTI_COLORS_2;
		SolutionType sType18 = SolutionType.FORCING_NET_VERITY;
	
		
		String expected1 = "Nice Loop/AIC";
		String actual1 = (sType.getStepConfig()).toString();
		String expected2 = "Nice Loop/AIC";
		String actual2 = (sType.getStepConfig(sType2)).toString();
		String expected3 = "Nice Loop/AIC";
		String actual3 = (sType.getStepConfig(sType3)).toString();
		String expected4 = "Grouped Nice Loop/AIC";
		String actual4 = (sType.getStepConfig(sType4)).toString();
		String expected5 = "Grouped Nice Loop/AIC";
		String actual5 = (sType.getStepConfig(sType5)).toString();
		String expected6 = "Grouped Nice Loop/AIC";
		String actual6 = (sType.getStepConfig(sType6)).toString();
		String expected7 = "Forcing Chain";
		String actual7 = (sType.getStepConfig(sType7)).toString();
		String expected8 = "Forcing Chain";
		String actual8 = (sType.getStepConfig(sType8)).toString();
		String expected9 = "Forcing Net";
		String actual9 = (sType.getStepConfig(sType9)).toString();
		String expected18 = "Forcing Net";
		String actual18 = (sType.getStepConfig(sType18)).toString();
		String expected10 = "Kraken Fish";
		String actual10 = (sType.getStepConfig(sType10)).toString();
		String expected11 = "Kraken Fish";
		String actual11 = (sType.getStepConfig(sType11)).toString();
		String expected12 = "2-String Kite";
		String actual12 = (sType.getStepConfig(sType12)).toString();
		String expected13 = "Empty Rectangle";
		String actual13 = (sType.getStepConfig(sType13)).toString();
		String expected14 = "Simple Colors";
		String actual14 = (sType.getStepConfig(sType14)).toString();
		String expected15 = "Simple Colors";
		String actual15 = (sType.getStepConfig(sType15)).toString();
		String expected16 = "Multi Colors";
		String actual16 = (sType.getStepConfig(sType16)).toString();
		String expected17 = "Multi Colors";
		String actual17 = (sType.getStepConfig(sType17)).toString();
		
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
		assertEquals(expected5, actual5);
		assertEquals(expected6, actual6);
		assertEquals(expected7, actual7);
		assertEquals(expected8, actual8);
		assertEquals(expected9, actual9);
		assertEquals(expected10, actual10);
		assertEquals(expected11, actual11);
		assertEquals(expected12, actual12);
		assertEquals(expected13, actual13);
		assertEquals(expected14, actual14);
		assertEquals(expected15, actual15);
		assertEquals(expected16, actual16);
		assertEquals(expected17, actual17);
		assertEquals(expected18, actual18);
	}
	
	@Test
	public void compareTestNonFish()
	{
		SolutionType s1 = SolutionType.FULL_HOUSE;
		SolutionType s2 = SolutionType.HIDDEN_SINGLE;
		
		assertTrue(s2.compare(s1) > 0);
	}
	
	@Test
	public void compareTestNonFish2()
	{
		SolutionType s1 = SolutionType.FULL_HOUSE;
		SolutionType s2 = SolutionType.HIDDEN_SINGLE;
		
		System.out.println("hello " +s2.compare(s1));
		
		assertTrue(s2.compare(s1) == 200);
	}
	
	@Test
	public void compareTestSecondNonFish()
	{
		SolutionType s1 = SolutionType.X_WING;
		SolutionType s2 = SolutionType.HIDDEN_SINGLE;
		
		assertTrue(s1.compare(s2) > 0);
	}
	
	@Test
	public void compareTestSecondNonFish3()
	{
		SolutionType s1 = SolutionType.X_WING;
		SolutionType s2 = SolutionType.X_WING;
		
		assertTrue(s1.compare(s2) == 0);
	}
	
	@Test
	public void compareTestSecondNonFish2()
	{
		SolutionType s2 = SolutionType.X_WING;
		SolutionType s1 = SolutionType.HIDDEN_SINGLE;
		
		assertTrue(s1.compare(s2) < 0);
	}
	
	@Test
	public void compareTestSecondNonFish4()
	{
		SolutionType s2 = SolutionType.X_WING;
		SolutionType s1 = SolutionType.HIDDEN_SINGLE;
		
		assertTrue(s1.compare(s2) == -1900);
	}
	
	@Test
	public void compareTestFishDifferCategory()
	{
		SolutionType s1 = SolutionType.X_WING;
		SolutionType s2 = SolutionType.FINNED_X_WING;
		
		assertTrue(s2.compare(s1) > 0);
	}
	
	@Test
	public void compareTestFishDifferCategory2()
	{
		SolutionType s2 = SolutionType.X_WING;
		SolutionType s1 = SolutionType.FINNED_X_WING;
		
		assertTrue(s2.compare(s1) < 0);
	}
	
	@Test
	public void compareTestFishDifferCategory3()
	{
		SolutionType s1 = SolutionType.X_WING;
		SolutionType s2 = SolutionType.FINNED_X_WING;
		System.out.println("hello 12" +s2.compare(s1));
		
		assertTrue(s2.compare(s1) == 1);
	}
	
	@Test
	public void compareTestFishSameCategory()
	{
		SolutionType s1 = SolutionType.SQUIRMBAG;
		SolutionType s2 = SolutionType.SQUIRMBAG;
		
		assertTrue(s2.compare(s1) == 0);
	}

	@Test
	public void compareTestSizeNotSame()
	{
		SolutionType s1 = SolutionType.SQUIRMBAG;
		SolutionType s2 = SolutionType.X_WING;
		
		assertTrue(s2.compare(s1) < 0);
	}
	
	@Test
	public void compareTestBothSashimi()
	{
		SolutionType s1 = SolutionType.SASHIMI_SWORDFISH;
		SolutionType s2 = SolutionType.SASHIMI_SWORDFISH;
		
		assertTrue(s2.compare(s1) == 0);
	}
	
	@Test
	public void compareTestOneNotSashimi1()
	{
		SolutionType s1 = SolutionType.SASHIMI_SQUIRMBAG;
		SolutionType s2 = SolutionType.FINNED_SQUIRMBAG;
		
		assertTrue(s2.compare(s1) < 0);
	}
	
	@Test
	public void compareTestOneNotSashimi2()
	{
		SolutionType s2 = SolutionType.SASHIMI_SQUIRMBAG;
		SolutionType s1 = SolutionType.FINNED_SQUIRMBAG;
		
		assertTrue(s2.compare(s1) > 0);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getNonSinglesAnzTest()
	{
		sType = SolutionType.HIDDEN_PAIR;
		
		assertTrue(sType.getNonSinglesAnz() > 0);
	}
	
	//ADDEEEEEEEEEED
	@SuppressWarnings("static-access")
	@Test
	public void getNonSinglesAnzTest2()
	{
		sType = SolutionType.NAKED_PAIR;
		
		assertTrue(sType.getNonSinglesAnz() == 108);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getNonSSTSAnzTest()
	{
		sType = SolutionType.SKYSCRAPER;
		
		assertTrue(sType.getNonSSTSAnz() > 0);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void getNonSSTSAnzTest2()
	{
		sType = SolutionType.SKYSCRAPER;
		
		assertTrue(sType.getNonSSTSAnz() ==  91);
	}
	
	
}
