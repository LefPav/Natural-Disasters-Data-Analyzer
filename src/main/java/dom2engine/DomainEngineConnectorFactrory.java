package dom2engine;

public class DomainEngineConnectorFactrory {

	public IDomainEngineConnector createDomainEngineConnector(String delimiter, String path) {
		return new DomainEngineConnector(delimiter, path);
	}
	
}
