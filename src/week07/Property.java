package week07;

public class Property {
    public final String mKey;
    public final String mValue;

    public Property(String key, String value) {
        mKey = key;
        mValue = value;
    }

    public String getKey() {
        return mKey;
    }

    public String getValue() {
        return mValue;
    }
}