package gui.automation;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchDataProviders {

	@DataProvider(name = "searchQueries")
	public static Iterator<Object[]> getSearchQueries() throws IOException {
		List<Object[]> testData = new ArrayList<>();
		CSVReader reader = new CSVReader(new FileReader("src/test/resources/data_source/searchQueries.csv"));
			String[] line;
			while ((line = reader.readNext()) != null) {
				String searchQuery = line[0];
				testData.add(new Object[]{searchQuery});
			}

		return testData.iterator();
	}
}
