package engine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;
import dom2engine.IDomainEngineConnector;
import domCreator.DomainCreatorFactory;
import domCreator.IDomainCreator;
import domain.MeasurementVector;
import domain.NaturalDisaster;
import domain.SingleMeasureRequest;
import report.IReport;
import report.ReportFactory;
import statistics.IStatistics;
import statistics.Statistics;
import statistics.StatisticsFactory;
import dom2engine.DomainEngineConnectorFactrory;


public class MainController implements IMainController {
	
	private String path;
	private String delimiter;
	private HashSet<String> requestNames;
	private ArrayList<SingleMeasureRequest> allRequests;
	private IDomainCreator domainCreator;
	private DomainCreatorFactory domainCreatorFactory;
	private IDomainEngineConnector domainEngine;
	private DomainEngineConnectorFactrory domainEngineFactory;
	private IStatistics stats;
	private StatisticsFactory statsFactory;
	private IReport report;
	private ReportFactory reportFactory;
	
	
	public MainController() {
		this.requestNames = new HashSet<>();
		this.allRequests = new ArrayList<>();
		
	}
	
	

	@Override
	public List<IMeasurementVector> load(String fileName, String delimiter) throws FileNotFoundException, IOException {
		this.path = fileName;
		this.delimiter = delimiter;
		this.domainCreatorFactory = new DomainCreatorFactory();
		this.domainCreator = domainCreatorFactory.createDomainCreator(delimiter, path);
		ArrayList<IMeasurementVector> measures = new ArrayList<>();
		ArrayList<NaturalDisaster> disasters = domainCreator.createDisasters();
		for(int i=0; i<disasters.size(); i++) {
			measures.add(new MeasurementVector(disasters.get(i)));
		}
		return measures;
	}

	@Override
	public ISingleMeasureRequest findSingleCountryIndicator(String requestName, String countryName,
			String indicatorString) throws IllegalArgumentException {
		this.domainEngineFactory = new DomainEngineConnectorFactrory();
		this.domainEngine = domainEngineFactory.createDomainEngineConnector(delimiter, path);
		NaturalDisaster disaster = domainEngine.getDisasterCI(countryName, indicatorString);
		MeasurementVector measure = new MeasurementVector(disaster);
		SingleMeasureRequest request = new SingleMeasureRequest(measure, requestName);
		requestNames.add(requestName);
		allRequests.add(request);
		return request;
	}
	@Override
	public ISingleMeasureRequest findSingleCountryIndicatorYearRange(String requestName, String countryName,
			String indicatorString, int startYear, int endYear) throws IllegalArgumentException {
		this.domainEngineFactory = new DomainEngineConnectorFactrory();
		this.domainEngine = domainEngineFactory.createDomainEngineConnector(delimiter, path);
		NaturalDisaster disaster = domainEngine.getDisasterCIY(countryName, indicatorString, startYear, endYear);
		MeasurementVector measure = new MeasurementVector(disaster);
		SingleMeasureRequest request = new SingleMeasureRequest(measure, requestName);
		requestNames.add(requestName);
		allRequests.add(request);
		return request;

	}

	@Override
	public Set<String> getAllRequestNames() {
		return this.requestNames;
	}

	@Override
	public ISingleMeasureRequest getRequestByName(String requestName) {
		for(int i=0; i<allRequests.size(); i++) {
			if(allRequests.get(i).getRequestName().equals(requestName)) {
				return allRequests.get(i);
			}
		}
		return null;
	}

	@Override
	public ISingleMeasureRequest getRegression(String requestName) {
		SingleMeasureRequest request = allRequests.get(0);
		for(int i=0; i<allRequests.size(); i++) {
			if(allRequests.get(i).getRequestName().equals(requestName)) {
				request = allRequests.get(i);
			}
		}
		statsFactory = new StatisticsFactory();
		stats = statsFactory.createStatistics(request.getAnswer().getMeasurements());
		request.setRegressionResultString(stats.calculateRegression());
		return request;
	}

	@Override
	public ISingleMeasureRequest getDescriptiveStats(String requestName) {
		SingleMeasureRequest request = allRequests.get(0);
		for(int i=0; i<allRequests.size(); i++) {
			if(allRequests.get(i).getRequestName().equals(requestName)) {
				request = allRequests.get(i);
			}
		}
		statsFactory = new StatisticsFactory();
		stats = statsFactory.createStatistics(request.getAnswer().getMeasurements());
		request.setDescriptiveStatsString(stats.calculateStats());
		return request;
	}

	@Override
	public int reportToFile(String outputFilePath, String requestName, String reportType) throws IOException {
		SingleMeasureRequest request = (SingleMeasureRequest) this.getRequestByName(requestName);
		reportFactory = new ReportFactory();
		report = reportFactory.createReport(outputFilePath, request);
		if(reportType.equals("text")) {
			report.reportTxt();
		}
		else if(reportType.equals("md")) {
			report.reportMd();
		}
		else if(reportType.equals("html")) {
			report.reportHtml();
		}
		return 1;
	}
		

}
