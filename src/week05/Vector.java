package week05;

public class Vector {
	private final double[] _coordinates;
	
	public Vector(double... coordinates) {
		_coordinates = new double[coordinates.length];
		for (int i = 0; i < coordinates.length; i++) {
			_coordinates[i] = coordinates[i];
		}
	}
	
	public Vector(Vector other) {
		this(other._coordinates);
	}
	
	public double getCoordinate(int index) {
		return _coordinates[index];
	}
	
	public void setCoordinate(int index, double value) {
		_coordinates[index] = value;
	}
	
	public int getDimensions() {
		return _coordinates.length;
	}
	
	public double getLength() {
		double res = 0;
		for (double coord : _coordinates) {
			res += coord * coord;
		}
		
		return Math.sqrt(res);
	}
	
	public void add(Vector other) {
		try {
			if (this._coordinates.length != other._coordinates.length) {
				throw new VectorException("Error while adding: length not matching.");
			}
		} catch (VectorException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < this._coordinates.length; i++) {
			this._coordinates[i] += other._coordinates[i];
		}
	}
	
	public void subtract(Vector other) {
		try {
			if (this._coordinates.length != other._coordinates.length) {
				throw new VectorException("Error while adding: length not matching.");
			}
		} catch (VectorException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < this._coordinates.length; i++) {
			this._coordinates[i] -= other._coordinates[i];
		}
	}
	
	public void add(double n) {
		for (int i = 0; i < this._coordinates.length; i++) {
			_coordinates[i] += n;
		}
	}
	
	public void subtract(double n) {
		for (int i = 0; i < this._coordinates.length; i++) {
			_coordinates[i] -= n;
		}
	}
	
	public void multiply(double n) {
		for (int i = 0; i < this._coordinates.length; i++) {
			_coordinates[i] *= n;
		}
	}
	
	public void divide(double n) {
		for (int i = 0; i < this._coordinates.length; i++) {
			_coordinates[i] /= n;
		}
	}
	
	public double dotProduct(Vector other) {
		try {
			if (this._coordinates.length != other._coordinates.length) {
				throw new VectorException("Error while adding: length not matching.");
			}
		} catch (VectorException e) {
			e.printStackTrace();
		}
		
		double result = 0;
		
		for (int i = 0; i < this._coordinates.length; i++) {
			result += this._coordinates[i] * other._coordinates[i];
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		String[] strCoords = new String[_coordinates.length];
		
		for (int i = 0; i < _coordinates.length; i++) {
			strCoords[i] = String.valueOf(_coordinates[i]);
		}
		
		return String.format("Vector[%s]", String.join(", ", strCoords));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Vector other = (Vector) obj;
		for (double first : this._coordinates) {
			for (double second : other._coordinates) {
				if (first != second) {
					return false;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = (int)_coordinates[0];
		for (int i = 1; i < _coordinates.length; i++) {
			hash += Math.pow(31, i) * (int)_coordinates[i];
		}
		return hash;
	}
}

@SuppressWarnings("serial")
class VectorException extends Exception {
	public VectorException() {}
	
	public VectorException(String message) {
		super(message);
	}
}