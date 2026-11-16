package statistics;

import java.util.List;
import org.apache.commons.math3.util.Pair;


public class StatisticsFactory {
	
	public IStatistics createStatistics(List<Pair<Integer, Integer>> measurements){
		return new Statistics(measurements);
	}
	

}
