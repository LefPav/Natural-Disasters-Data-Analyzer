package report;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.math3.util.Pair;

import domain.SingleMeasureRequest;

public class Report implements IReport {

	
	private File file;
	private SingleMeasureRequest request;
	
	public Report(String filename,SingleMeasureRequest theRequest) {
		this.file = new File(filename);
		this.request = theRequest;
	}
	
	public void reportTxt() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("Request Name: " + this.request.getRequestName());
			writer.println("Request Filter: " + this.request.getRequestFilter());
			writer.println("Year\tValue");
			ArrayList<Pair<Integer,Integer>> yearsAndValue = (ArrayList<Pair<Integer, Integer>>) request.getAnswer().getMeasurements();
			for(Pair<Integer, Integer> xyPair: yearsAndValue) {
				int year = xyPair.getFirst();
				int value = xyPair.getSecond();
				writer.println(year + "\t" + value);
			}
			writer.println("\n" + this.request.getDescriptiveStatsString());
			writer.println("\n" + this.request.getRegressionResultString());
			writer.close();
		}
		catch (IOException e) {
			System.out.print("IO Error");
		}
	}
	
	public void reportMd() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("Request Name: **" + this.request.getRequestName() + "**");
			writer.println("_Request Filter: " + this.request.getRequestFilter() + "_");
			writer.println("|*Year*|*Value*|");
			writer.println("|----|----|");
			ArrayList<Pair<Integer,Integer>> yearsAndValue = (ArrayList<Pair<Integer, Integer>>) request.getAnswer().getMeasurements();
			for(Pair<Integer, Integer> xyPair: yearsAndValue) {
				int year = xyPair.getFirst();
				int value = xyPair.getSecond();
				writer.println("|"+ year + "|" + value + "|");
			}
			writer.println("\n" + this.request.getDescriptiveStatsString());
			writer.println("\n" + this.request.getRegressionResultString());
			writer.close();
		}
		catch (IOException e) {
			System.out.print("IO Error");
		}
	}
	
	public void reportHtml() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(file);
			writer.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title></title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<p><b>Request Name: " + this.request.getRequestName() + "</b></p>\r\n"
					+ "<p><i>Request Filter:" + this.request.getRequestFilter() +"</i></p>\r\n"
					+ "<table>");
			writer.println("<tr><td>Year</td><td>Value</td></tr>");
			ArrayList<Pair<Integer,Integer>> yearsAndValue = (ArrayList<Pair<Integer, Integer>>) request.getAnswer().getMeasurements();
			for(Pair<Integer, Integer> xyPair: yearsAndValue) {
				int year = xyPair.getFirst();
				int value = xyPair.getSecond();
				writer.println("<tr><td>" + year + "</td><td>" + value + "</td></tr>");
			}
			writer.println("</table>");
			writer.println("\n<p>" + this.request.getDescriptiveStatsString() + "</p>");
			writer.println("\n<p>" + this.request.getRegressionResultString() + "</p>");
			writer.println("</body></html>");
			writer.close();
		}
		catch (IOException e) {
			System.out.print("IO Error");
		}
	}
}