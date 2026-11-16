import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domCreator.DomainCreator;

public class TestDomainCreator {

	private DomainCreator domainCreator1;
	private DomainCreator domainCreator2;
	@Before
	public void setUp() throws Exception{
		domainCreator1 = new DomainCreator("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.tsv");
		domainCreator2 = new DomainCreator("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.ts");
	}

	
	@Test
	public void testCreateDisastersHappyDay() {
		assertNotNull(domainCreator1.createDisasters());
	}
	
	@Test
	public void testCreateDisastersRainyDay() {
		assertNull(domainCreator2.createDisasters());
	}

}
