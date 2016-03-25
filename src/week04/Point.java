package week04;

public class Point {
	private static final Point origin = new Point(0, 0);
	private final double _x;
	private final double _y;
	
	public static LineSegment add(Point start, Point end) throws LineSegmentException {
		return new LineSegment(start, end);
	}
	
	public Point(double x, double y) {
		_x = x;
		_y = y;
	}
	
	public Point(Point other) {
		_x = other._x;
		_y = other._y;
	}
	
	public Point() {
		_x = origin._x;
		_y = origin._y;
	}
	
	public double getX() {
		return _x;
	}
	
	public double getY() {
		return _y;
	}
	
	@Override
	public String toString() {
		return String.format("Point(%f,%f)", _x, _y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Point other = (Point) obj;
		return (_x == other._x) && (_y == other._y);
	}
	
	@Override
	public int hashCode() {
        int hash = 17;
        hash = hash * 23 + Double.valueOf(_x).hashCode();
        hash = hash * 23 + Double.valueOf(_y).hashCode();
        return hash;
	}
 	
}
