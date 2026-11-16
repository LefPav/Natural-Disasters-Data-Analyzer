import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import load.Loader;

public class TestLoader {
	
	private Loader loader1;
	private Loader loader2;
	
	@Before
	public void setUp() throws Exception{
		loader1 = new Loader("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.tsv");
		loader2 = new Loader("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.ts");
	}
	

	@Test
	public void testLoadTextHappyDay() {
		assertNotNull(loader1.loadText());		
	}
	
	@Test
	public void testLoadTextRainyDay() {
		assertNull(loader2.loadText());
	}

}
