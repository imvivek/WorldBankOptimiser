package org.worldbank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CSVDataReader {

	Properties appData = new Properties();
	String fileName = "appConfig.properties";
	InputStream loadAppData = getClass().getClassLoader().getResourceAsStream(fileName);

	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println("Hello");

		CSVDataReader csvDataReader = new CSVDataReader();
		int yearNumber = 2000;
		String filePath = csvDataReader.appData.getProperty("CSVDataFilePath");

		csvDataReader.getDataForSpecificYear(filePath, yearNumber);
	}

	private void getDataForSpecificYear(String filePath, int yearNumber) throws IOException {
		BufferedReader br = null;
		if (loadAppData != null)
			appData.load(loadAppData);
		try {
			br = new BufferedReader(new FileReader(appData.getProperty("CSVDataFilePath")));
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		if (br != null) {
			final int length = 60;
			int startingYearValue = 1960;
			int startingYearColumn = 4;
			int currentLineLength = 0;
			String[] currentLine = new String[length];
			String[] csvLine = new String[length];
			String line = "";

			System.out.println("CountryName\t\tIndicatorName\t\t\t\t\t\t\t\t\tY" + yearNumber);

			try {
				while ((line = br.readLine()) != null) {

					currentLine = line.split("," + appData.getProperty("regex"));
					currentLineLength = currentLine.length;

					for (int i = 0; i < currentLineLength; i++)
						csvLine[i] = currentLine[i];

					for (int i = currentLineLength; i < length; i++)
						csvLine[i] = "NA";

					if (yearNumber > 1959 && yearNumber < 2016) {
						System.out.println(csvLine[0] + "\t\t" + csvLine[2] + "\t\t\t\t\t\t\t\t\t"
								+ csvLine[yearNumber - startingYearValue + startingYearColumn]);
					} else
						System.out.println("Enter year between 1960 to 2015");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
