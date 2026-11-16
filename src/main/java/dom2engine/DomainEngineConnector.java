package dom2engine;

import java.util.ArrayList;

import org.apache.commons.math3.util.Pair;

import domCreator.DomainCreatorFactory;
import domCreator.IDomainCreator;
import domain.NaturalDisaster;

public class DomainEngineConnector implements IDomainEngineConnector{
	
	private String path;
	private String delimiter;
	private IDomainCreator creator;
	private DomainCreatorFactory creatorfac;
	
	public DomainEngineConnector(String delimiter, String path) {
		this.path = path;
		this.delimiter = delimiter;
		this.creatorfac = new DomainCreatorFactory();
		this.creator = creatorfac.createDomainCreator(delimiter, path);
	}
	
	public NaturalDisaster getDisasterCI(String country, String indicator) {
		ArrayList<NaturalDisaster> disasters =  creator.createDisasters();
		if (disasters == null) {
			return null;
		}
    	NaturalDisaster disaster = disasters.get(0);
    	for (int i = 0; i < disasters.size(); i++) {
    		if (disasters.get(i).getCountry().equals(country) && disasters.get(i).getIndicator().equals(indicator)) {
    			disaster = disasters.get(i);
    		}
    	}
        return disaster; 
    }	
	
	public NaturalDisaster getDisasterCIY(String country, String indicator, int Y1, int Y2) {
		ArrayList<NaturalDisaster> disasters =  creator.createDisasters();
		if (disasters == null) {
			return null;
		}
    	NaturalDisaster disaster = disasters.get(0);
    	for (int i = 0; i < disasters.size(); i++) {
    		if (disasters.get(i).getCountry().equals(country) && disasters.get(i).getIndicator().equals(indicator)) {
    			disaster = disasters.get(i);
    		}
    	}
    	int start = Y1 - 1980;
    	int end = start + Y2-Y1;
    	ArrayList<Pair<Integer, Integer>> newkf = new ArrayList<>();
    	for(int i= start; i<end+1; i++) {
    		newkf.add(disaster.getKf().get(i));
    	}
    	disaster.setKf(newkf);
    	return disaster;
	}
}