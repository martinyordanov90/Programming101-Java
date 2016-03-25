package week05;

public class Product {
	private int _id;
	private String _name;
	private double _basePrice;
	private int _quantity;
	private int _countryId;
	
	public Product(int id, String name, double basePrice, int quantity, int countryId) {
		_id = id;
		_name = name;
		_basePrice = basePrice;
		_quantity = quantity;
		_countryId = countryId;
	}
}