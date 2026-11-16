package statistics;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.Pair;

public class Statistics implements IStatistics {
	
	List<Pair<Integer, Integer>> measurements;
	
	public Statistics(List<Pair<Integer, Integer>> measurements) {
		this.measurements = measurements;
	}
	
	public String calculateStats(){
		String x = "Descriptive Stats\n------------------------";
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for(Pair<Integer, Integer> xyPair: measurements) {
			int value = xyPair.getSecond();
			stats.addValue(value);
		}

		long count = stats.getN();
		double minD = stats.getMin();
		double gMean = stats.getGeometricMean();
		double mean = stats.getMean();
		double medianD = stats.getPercentile(50);
		double maxD = stats.getMax();
		double kurtosis = stats.getKurtosis();
		double stdev = stats.getStandardDeviation();
		double sumD = stats.getSum();
		
		x += "\ncount: " + count + "\n";
		x += "minD: " + minD + "\n";
		x += "gMean: " + gMean + "\n";
		x += "mean: " + mean + "\n";
		x += "medianD: " + medianD + "\n";
		x += "maxD: " + maxD + "\n";
		x += "kurtosis: " + kurtosis + "\n";
		x += "stdev: " + stdev + "\n";
		x += "sumD: " + sumD + "\n";
		
		return x;
	}
	
	public String calculateRegression() {
		String x = "Regression Stats\n------------------------";
		SimpleRegression regression = new SimpleRegression();
		for(Pair<Integer, Integer> xyPair: measurements) {
			int year = xyPair.getFirst();
			int value = xyPair.getSecond();
			regression.addData(year, value);
		}
		
		double intercept = regression.getIntercept();
		double slope = regression.getSlope();
		double slopeError = regression.getSlopeStdErr();
		
		x += "\nintercept: " + intercept + "\n";
		x += "slope: " + slope + "\n";
		x += "slopeError: " + slopeError + "\n";
		x += "trend: " + getLabel(slope) + "\n";
		
		return x;	
	}
	
	public String getLabel(double slope) {
		if (Double.isNaN(slope))
			return "Tendency Undefined";
		else if(slope > 0.1)
			return "Increased Tendency";
		else if(slope < -0.1)
			return "Decreased Tendency";
		return "Tendency stable";
	}
	
	public static void main(String args[]) {
		List<Pair<Integer, Integer>> measurements = new ArrayList<Pair<Integer, Integer>>(); 
		measurements.add(new Pair<Integer, Integer>(1980, 10));
		measurements.add(new Pair<Integer, Integer>(1981, 20));
		measurements.add(new Pair<Integer, Integer>(1982, 30));
		measurements.add(new Pair<Integer, Integer>(1983, 48));
		measurements.add(new Pair<Integer, Integer>(1984, 50));
		Statistics stats = new Statistics(measurements);
		System.out.println(stats.calculateStats());
		System.out.println(stats.calculateRegression());
	}

}
