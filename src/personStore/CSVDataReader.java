package personStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CSVDataReader extends DataReader {

	private String csvFilePath;
	
	public CSVDataReader(String csvFilePath) {
		this.csvFilePath = csvFilePath;
	}

	@Override
	public Set<Person> getPersons(String searchCriteria, SearchType searchType) {
		String[] criteria = searchCriteria.split(";");
		String csvLine = "";
		String csvSeparator = ",";
		Set<Person> result = new HashSet<Person>();
		
		try {
			FileReader fileReader = new FileReader(csvFilePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((csvLine = bufferedReader.readLine()) != null){
				String[] personData = csvLine.split(csvSeparator);
				String skill = personData[2];
				if(Arrays.asList(criteria).contains(skill)){
					Person person = parseCSVLine(personData);
					if(!result.contains(person)){
						result.add(person);
					}else{
						
					}
				}
			}
			
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(searchType == SearchType.MANDATORY){
			
		}
		return result;
	}

	private Person parseCSVLine(String[] csvLine){
		Person result = new Person();
		Skill skill = new Skill(csvLine[2], csvLine[3]);
		skill.setRate(Double.parseDouble(csvLine[4]));
		result.name = csvLine[0];
		result.email = csvLine[1];
		result.addSkill(skill);
		
		return result;
	}
	
	@Override
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	@Override
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
}
