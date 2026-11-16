package domain;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.math3.util.Pair;

public class NaturalDisaster {

	private String objectId;
	private String country;
	private String indicator;
	private String iso2;
	private String iso3;
	private List<Pair<Integer, Integer>> kf;
	private String stats;
	private String regression;
	
	public NaturalDisaster(String objectId, String country, String indicator, String iso2, String iso3) {
		this.objectId = objectId;
		this.country = country;
		this.indicator = indicator;
		this.iso2 = iso2;
		this.iso3 = iso3;
		
		this.kf = new ArrayList<>();
		this.stats = "";
		this.regression = "";
	}
	
	public void addpair(int year, int times) {
		kf.add(new Pair<Integer, Integer>(year,times));
	}
	
	public String getObject() {
		return objectId;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getIndicator() {
		return indicator;
	}
	
	public String getIso2() {
		return iso2;
	}
	
	public String getIso3() {
		return iso3;
	}
	
	public List<Pair<Integer, Integer>> getKf(){
		return kf;
	}
	
	public String getStats() {
		return stats;
	}
	
	public String getRegression() {
		return regression;
	}
	
	public void setKf(List<Pair<Integer, Integer>> newkf) {
		this.kf = newkf;
	}
	
	public void setStats(String newStats) {
		this.stats = newStats;
	}
	
	public void setRegression(String newRegression) {
		this.regression = newRegression;
	}
}
