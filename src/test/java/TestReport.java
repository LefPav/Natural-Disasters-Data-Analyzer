import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.MeasurementVector;
import domain.NaturalDisaster;
import domain.SingleMeasureRequest;
import report.Report;

public class TestReport {

	private Report report1;
	private Report report2;
	private Report report3;
	private SingleMeasureRequest request;
	private MeasurementVector measure;
	private String name;
	private NaturalDisaster naturaldis;
	private String objectId;
	private String country;
	private String indicator;
	private String iso2;
	private String iso3;
	
	@Before
	public void setUp() throws Exception {
		name = "total";
		objectId = "348";
		country = "GREECE";
		indicator = "TOTAL";
		iso2 = "GR";
		iso3 = "GRC";
		naturaldis = new NaturalDisaster(objectId, country, indicator, iso2, iso3);
		measure = new MeasurementVector(naturaldis);
		request = new SingleMeasureRequest(measure, name);
		report1 = new Report("file.txt", request);
		report2 = new Report("file.md", request);
		report3 = new Report("file.html", request);
	}
	
	
	@Test
	public void testReportTxtHappyDay() {

		report1.reportTxt();
	}
	
	@Test
	public void testReportMd(){
		report2.reportMd();
	}
	
	@Test
	public void testReportHtml() {
		report3.reportHtml();
	}

}
