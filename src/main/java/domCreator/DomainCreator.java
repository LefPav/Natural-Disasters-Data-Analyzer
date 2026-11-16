package domCreator;

import java.util.ArrayList;

import domain.NaturalDisaster;
import load.ILoader;
import load.LoaderFactory;


public class DomainCreator implements IDomainCreator {

	private String path;
	private String delimiter;
	private ILoader loader;
	private LoaderFactory loaderfac;
	
	
	public DomainCreator(String delimiter, String path) {
		this.path = path;
		this.delimiter = delimiter;
		this.loaderfac = new LoaderFactory();
		this.loader = loaderfac.createLoader(delimiter, path);
	}
	
	public ArrayList<NaturalDisaster> createDisasters(){
		ArrayList<String[]> data =  loader.loadText();
		if(data == null) {
			return null;
		}
		ArrayList<NaturalDisaster> disasters = new ArrayList<>();
		for( int i=1; i<data.size(); i++) {
			String objectId = data.get(i)[0];
			String country = data.get(i)[1];
			String iso2 = data.get(i)[2];
			String iso3 = data.get(i)[3];
			String indicator = data.get(i)[4];
			NaturalDisaster naturalDis = new NaturalDisaster(objectId ,country , indicator , iso2 , iso3);
			for(int j=5; j<data.get(i).length; j++) {
				int year = Integer.parseInt(data.get(0)[j]);
				int times = Integer.parseInt(data.get(i)[j]);
				naturalDis.addpair(year, times);
			}
			disasters.add(naturalDis);
		}
		return disasters;
	}
}
