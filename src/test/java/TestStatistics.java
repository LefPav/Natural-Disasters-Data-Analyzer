import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.junit.Before;
import org.junit.Test;

import statistics.Statistics;

public class TestStatistics {

	private Statistics statistics;
	private List<Pair<Integer, Integer>> measurements = new ArrayList<Pair<Integer, Integer>>(); 
	
	@Before
	public void setUp() throws Exception{
		measurements.add(new Pair<Integer, Integer>(1980, 10));
		measurements.add(new Pair<Integer, Integer>(1981, 20));
		measurements.add(new Pair<Integer, Integer>(1982, 30));
		measurements.add(new Pair<Integer, Integer>(1983, 48));
		measurements.add(new Pair<Integer, Integer>(1984, 50));
		statistics = new Statistics(measurements);
	}
	
	
	@Test
	public void testcalculateStatsHappyDay() {
		String x = "";
		x += "\ncount: " + "5" + "\n";
		x += "minD: " + "10.0" + "\n";
		x += "gMean: " + "27.019200770412272" + "\n";
		x += "mean: " + "31.6" + "\n";
		x += "medianD: " + "30.0"+ "\n";
		x += "maxD: " + "50.0"+ "\n";
		x += "kurtosis: " + "-2.236510315871765" + "\n";
		x += "stdev: " + "17.401149387324963" + "\n";
		x += "sumD: " + "158.0" + "\n";
		assertEquals(x, statistics.calculateStats());
	}
	
	@Test
	public void testcalculateStatsRainyDay() {
		String x = "";
		x += "\ncount: " + "6" + "\n";
		x += "minD: " + "10.0" + "\n";
		x += "gMean: " + "27.019100770412272" + "\n";
		x += "mean: " + "36.6" + "\n";
		x += "medianD: " + "30.0"+ "\n";
		x += "maxD: " + "51.0"+ "\n";
		x += "kurtosis: " + "-2.236510315871765" + "\n";
		x += "stdev: " + "17.401149387324963" + "\n";
		x += "sumD: " + "158.0" + "\n";
		assertEquals(x, statistics.calculateStats());
	}
	
	@Test
	public void testcalculateRegressionHappyDay() {
		String x = "";
		x += "intercept: " + "-21374.0" + "\n";
		x += "slope: " + "10.8" + "\n";
		x += "slopeError: " + "1.2220201853215567" + "\n";
		x += "trend: " + " Increased Tendency" + "\n";
		assertEquals(x, statistics.calculateRegression());
	}
	
	@Test
	public void testcalculateRegressionRainyDay() {
		String x = "";
		x += "intercept: " + "-21375.0" + "\n";
		x += "slope: " + "10.4" + "\n";
		x += "slopeError: " + "1.2220201851215567" + "\n";
		x += "trend: " + " Increased Tendency" + "\n";
		assertEquals(x, statistics.calculateRegression());
	}

}
