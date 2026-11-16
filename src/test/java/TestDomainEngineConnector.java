import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dom2engine.DomainEngineConnector;
import domCreator.DomainCreator;
import domain.NaturalDisaster;

public class TestDomainEngineConnector {
	
	private DomainEngineConnector dom1;
	private DomainEngineConnector dom2;
	
	
	@Before
	public void setUp() throws Exception{
		dom1 = new DomainEngineConnector("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.tsv");
		dom2 = new DomainEngineConnector("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.ts");
	}

	@Test
	public void testGetDisasterCIHappyDay() {
		NaturalDisaster naturalDis = dom1.getDisasterCI("Greece","TOTAL");
		assertEquals(naturalDis.getCountry(), "Greece");
	}
	
	@Test
	public void testGetDisasterCIRainyDay() {
		NaturalDisaster naturalDis = dom2.getDisasterCI("Greece","TOTAL");
		assertNull(naturalDis);
	}
	
	@Test
	public void testGetDisasterCIYHappyDAY() {
		NaturalDisaster naturaldis = dom1.getDisasterCIY("Greece", "TOTAL", 1995, 2000);
		assertEquals(naturaldis.getCountry(), "Greece");
	}
	
	@Test
	public void testGetDisasterCIYRainyDay() {
		NaturalDisaster naturalDis = dom2.getDisasterCIY("Greece","TOTAL", 1995, 2000);
		assertNull(naturalDis);
	}

}
