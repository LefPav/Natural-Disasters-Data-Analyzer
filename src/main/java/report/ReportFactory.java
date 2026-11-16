package report;

import domain.SingleMeasureRequest;

public class ReportFactory {

	public IReport createReport(String theFilename,SingleMeasureRequest theRequest) {
		return new Report(theFilename,theRequest);
	}
	
}