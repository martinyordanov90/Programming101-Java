package week05;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class CountryManager {
	
	private static CountryManager sCountryManager;
	
	private Map<String, Country> mCountries = new HashMap<>();
	
	private CountryManager() {
		
	}
	
	private void initDefaultCountry() {
		
	}
	
	public static CountryManager getInstance() {
		if (sCountryManager == null) {
			sCountryManager = new CountryManager();
		}
		
		return sCountryManager;
	}
	
	public void changeDefault(Country newDefault) {
		String newKey = newDefault.getCode();
		
		Iterator<Map.Entry<String, Country>> iterator = mCountries.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Country> entry = iterator.next();
			
			String key = entry.getKey();
			Country value = entry.getValue();
			
			if (value.isDefault()) {
				Country oldDefault = new Country(key, 
						                         value.getName(), 
						                         value.getVatTax(), 
						                         false);
				mCountries.put(key, oldDefault);
				
				newDefault = new Country(newKey, 
						                 newDefault.getName(), 
						                 newDefault.getVatTax(), 
						                 true);
				mCountries.put(newKey, newDefault);
			}
		}
	}
}