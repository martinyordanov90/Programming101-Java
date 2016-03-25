package week04;

public class Triangle extends Shape {
	private final Point _a;
	private final Point _b;
	private final Point _c;
	
	public Triangle(Point a, Point b, Point c) {
		try {
			if ((a.getX() == b.getX() && b.getX() == c.getX())
			 || (a.getY() == b.getY() && b.getY() == c.getY())) {
				throw new TriangleException("Points are on the same axis");
			}
		} catch (TriangleException e) {
			e.printStackTrace();
		}
		_a = new Point(a);
		_b = new Point(b);
		_c = new Point(c);
	}
	
	public Triangle(Triangle other) {
		this(other._a, other._b, other._c);
	}
	
	public Point getA() {
		return _a;
	}
	
	public Point getB() {
		return _b;
	}
	
	public Point getC() {
		return _c;
	}
	
	public LineSegment getAB() {
		return new LineSegment(_a, _b);
	}

	public LineSegment getBC() {
		return new LineSegment(_b, _c);
	}
	
	public LineSegment getCA() {
		return new LineSegment(_c, _a);
	}
	
	public double getBase() {
		return getAB().getLength();
	}
	
	public double getPerimeter() {
		return getAB().getLength() + getBC().getLength() + getCA().getLength();
	}
	
	@Override
	public String toString() {
		return String.format("Triangle[A(%s), B(%s), C(%s)]", _a, _b, _c);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Triangle other = (Triangle) obj;
		if (!this._a.equals(other._a)) {
			return false;
		}
		if (!this._b.equals(other._b)) {
			return false;
		}
		if (!this._c.equals(other._c)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + _a.hashCode();
	    hash = hash * 23 + _b.hashCode();
	    hash = hash * 23 + _c.hashCode();
	    return hash;
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public Point getCenter() {
		return null;
	}
}

@SuppressWarnings("serial")
class TriangleException extends Exception {
	public TriangleException() {}
	
	public TriangleException(String message) {
		super(message);
	}
}