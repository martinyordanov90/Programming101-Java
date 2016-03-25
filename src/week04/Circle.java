package week04;

public class Circle extends Shape {
	private final Point _center;
	private final double _radius;
	
	public Circle(Point center, double radius) {
		_center = new Point(center);
		_radius = radius;
	}
	
	public Circle(Circle other) {
		this(other._center, other._radius);
	}
	
	public Point getUpperLeft() {
		double x = _center.getX() - _radius;
		double y = _center.getY() + _radius;
		return new Point(x, y);
	}
	
	public Point getUpperRight() {
		double x = _center.getX() + _radius;
		double y = _center.getY() + _radius;
		return new Point(x, y);
	}
	
	public Point getLowerLeft() {
		double x = _center.getX() - _radius;
		double y = _center.getY() - _radius;
		return new Point(x, y);
	}
	
	public Point getLowerRight() {
		double x = _center.getX() + _radius;
		double y = _center.getY() - _radius;
		return new Point(x, y);
	}
	
	public Point getCenter() {
		return _center;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * _radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(_radius, 2);
	}
	
	@Override
	public String toString() {
		return String.format("Circle[Center: %s, Radius: %d]", _center, _radius);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Circle other = (Circle) obj;
		return this._radius == other._radius && this._center == other._center;
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + _center.hashCode();
	    hash = hash * 23 + Double.valueOf(_radius).hashCode();
	    return hash;
	}
}
