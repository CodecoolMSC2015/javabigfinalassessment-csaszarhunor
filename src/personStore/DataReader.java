package personStore;

import java.util.Set;

public abstract class DataReader {

	protected String searchCriteria;
	protected SearchType searchType;
	
	public abstract Set<Person> getPersons(String searchCriteria, SearchType searchType);

	public abstract void setSearchCriteria(String searchCriteria);

	public abstract void setSearchType(SearchType searchType);
}
