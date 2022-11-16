import org.junit.Assert;
import org.junit.Test;

import com.program.CensusAnalyser;
import com.program.CensusAnalyserException;

public class CensusAnalyserTest {
    @Test
    public void givenIndianStateCSV_ShouldReturnExactCount() {
        try {
        	 final String INDIAN_STATE_CSV_FILE = "C:\\Users\\ASHUTOSH NAWALE\\eclipse-workspace\\CensusIndia_Program_Class199\\IndiaStateCode.csv";
   		  CensusAnalyser censusAnalyser = new CensusAnalyser();
             int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_STATE_CSV_FILE);
             Assert.assertEquals(37,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }
}
