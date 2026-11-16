package domain;

import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class SingleMeasureRequest implements ISingleMeasureRequest{
	
	private MeasurementVector measure;
	private String name;
	private String filter;
	
	public SingleMeasureRequest(MeasurementVector measure, String name) {
		this.measure = measure;
		this.name = name;
		this.filter = this.measure.getCountryName() + " " + this.measure.getIndicatorString(); 
	}
	

	public String getRequestName() {
		return this.name;
		
	}
	
	
	public String getRequestFilter() {
		return this.filter;
		
	}
	
	
	public boolean isAnsweredFlag() {
		return this.measure != null;
		
	}
	
	
	public IMeasurementVector getAnswer() {
		return measure;
		
	}
	
	
	public String getDescriptiveStatsString() {
		return this.measure.getDescriptiveStatsAsString();
		
	}
	
	public void setDescriptiveStatsString(String newStatsString ) {
		this.measure.setDescriptiveStatsAsString(newStatsString);
	}
	
	public String getRegressionResultString() {
		return this.measure.getRegressionResultAsString();
		
	}
	
	public void setRegressionResultString(String newRegressionString) {
		this.measure.setRegressionResultAsString(newRegressionString);
	}

	
	
}
