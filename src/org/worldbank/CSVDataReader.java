package org.worldbank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVDataReader {

	public static void main(String[] args) {
		System.out.println("Hello");
		CSVDataReader csvDataReader = new CSVDataReader();
		csvDataReader.echoCSVFile();
	}

	void echoCSVFile() {
		String csvPath = "C:/Users/VVERMA/Downloads/WDI_csv/sample.csv";
		BufferedReader br = null;
		String line = "";

		String[] data = new String[60];

		try {
			br = new BufferedReader(new FileReader(csvPath));

			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
