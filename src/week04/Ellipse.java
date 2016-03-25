package week04;

public class Ellipse extends Shape {
	private final Point _center;
	private final double _a;
	private final double _b;
	
	public Ellipse(Point center, double a, double b) {
		_center = new Point(center);
		_a = a;
		_b = b;
	}
	
	public Ellipse(Ellipse other) {
		this(other._center, other._a, other._b);
	}
	
	@Override
	public String toString() {
		return String.format("Ellipse[%d, %d]", _a, _b);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Ellipse other = (Ellipse) obj;
		return this._a == other._a && this._b == other._b;
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + Double.valueOf(_a).hashCode();
	    hash = hash * 23 + Double.valueOf(_b).hashCode();
	    return hash;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * Math.sqrt((_a*_a + _b*_b) / 2);
	}

	@Override
	public double getArea() {
		return Math.PI * (_a / 2) * (_b / 2);
	}

	@Override
	public Point getCenter() {
		return _center;
	}
}
