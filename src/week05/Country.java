package week05;

public class Country {
	private final String mCountryCode;
	private final String mName;
	private final double mVatTax;
	private final boolean mIsDefault;
	
	public Country(String countryCode, String name, double vatTax, boolean isDefault) {
		mCountryCode = countryCode;
		mName = name;
		mVatTax = vatTax;
		mIsDefault = isDefault;
	}

	public String getCode() {
		return mCountryCode;
	}
	
	public String getName() {
		return mName;
	}
	
	public double getVatTax() {
		return mVatTax;
	}
	
	public boolean isDefault() {
		return mIsDefault;
	}
}
