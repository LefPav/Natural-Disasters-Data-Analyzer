	package domain;

import java.util.List;

import org.apache.commons.math3.util.Pair;

import dom2app.IMeasurementVector;

public class MeasurementVector implements IMeasurementVector{
	
	private NaturalDisaster naturaldis;
	
	public MeasurementVector(NaturalDisaster naturaldis) {
		this.naturaldis = naturaldis;
	}
	
	public String getCountryName() {
		return this.naturaldis.getCountry();		
	}
	
	
	public String getIndicatorString() {
		return this.naturaldis.getIndicator();	
	}
	public List<Pair<Integer, Integer>> getMeasurements(){
		return this.naturaldis.getKf();	
	}
	
	
	
	public String getDescriptiveStatsAsString() {
		return this.naturaldis.getStats();
		
	}
	
	public void setDescriptiveStatsAsString(String newStatsString) {
		this.naturaldis.setStats(newStatsString);
	}
	
	
	
	public String getRegressionResultAsString() {
		return this.naturaldis.getRegression();	
	}
	
	public void setRegressionResultAsString(String newRegressionString) {
		this.naturaldis.setRegression(newRegressionString);
	}
	
	

}
