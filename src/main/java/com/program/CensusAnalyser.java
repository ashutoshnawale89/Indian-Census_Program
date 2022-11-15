package com.program;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {
	public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int namOfEateries=0;
			while (censusCSVIterator.hasNext()) {
				namOfEateries++;           
				IndiaCensusCSV censusData = censusCSVIterator.next();
			}
			return namOfEateries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	public static void main(String[] args) throws CensusAnalyserException {
		// TODO Auto-generated method stub
		  final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\ASHUTOSH NAWALE\\eclipse-workspace\\AdvancedJavaPrograming\\src\\main\\java\\com\\CensusIndia\\Program\\IndiaStateCensusData.csv";
		  final String INDIAN_STATE_CSV_FILE = "C:\\Users\\ASHUTOSH NAWALE\\Desktop\\IndiaStateCode.csv";
		  CensusAnalyser censusAnalyser = new CensusAnalyser();
          int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
		    System.out.println(numOfRecords);
	}

}
