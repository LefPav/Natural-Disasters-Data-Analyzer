package dom2engine;

import domain.NaturalDisaster;

public interface IDomainEngineConnector {
	
	 NaturalDisaster getDisasterCI(String country, String indicator);
	 NaturalDisaster getDisasterCIY(String country, String indicator, int Y1, int Y2);

}
