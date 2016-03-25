package week04;

public class Rectangle extends Shape {
	private final Point _upperLeft;
	private final Point _upperRight;
	private final Point _lowerLeft;
	private final Point _lowerRight;
	
	public Rectangle(Point upperLeft, Point lowerRight) {
		try {
		if (upperLeft.getX() == lowerRight.getX()
		 || upperLeft.getY() == lowerRight.getY()) {
			throw new RectangleException("Points are on the same axis.");
		}
		} catch (RectangleException e) {
			e.printStackTrace();
		}
		
		_upperLeft = new Point(upperLeft);
		_lowerRight = new Point(lowerRight);
		
		_upperRight = new Point(_lowerRight.getX(), _upperLeft.getY());
		_lowerLeft = new Point(_upperLeft.getX(), _lowerRight.getY());
	}
	
	public Rectangle(Rectangle other) {
		this(other._upperLeft, other._lowerRight);
	}

	public Point getUpperLeft() {
		return _upperLeft;
	}
	
	public Point getUpperRight() {
		return _upperRight;
	}
	
	public Point getLowerLeft() {
		return _lowerLeft;
	}
	
	public Point getLowerRight() {
		return _lowerRight;
	}
	
	public LineSegment getLeftEdge() {
		LineSegment leftEdge = null;
		leftEdge = new LineSegment(_lowerLeft, _upperLeft);
		return leftEdge;
		
	}
	
	public LineSegment getTopEdge() {
		LineSegment topEdge = null;
		topEdge = new LineSegment(_upperLeft, _upperRight);
		return topEdge;
	}
	
	public LineSegment getRightEdge() {
		LineSegment rightEdge = null;
		rightEdge = new LineSegment(_upperRight, _lowerRight);
		return rightEdge;
	}
	
	public LineSegment getBottomEdge() {
		LineSegment bottomEdge = null;
		bottomEdge = new LineSegment(_lowerRight, _lowerLeft);
		return bottomEdge;
	}
	
	public double getWidth() {
		return this.getTopEdge().getLength();
	}
	
	public double getHeight() {
		return this.getLeftEdge().getLength();
	}
	
	public double getPerimeter() {
		return getWidth()*2 + getHeight()*2;
	}
	
	public double getArea() {
		return getWidth() * getHeight();
	}
	
	public Point getCenter() {
		return new Point((_upperLeft.getX() + _lowerRight.getX()) / 2, 
				         (_upperLeft.getY() + _lowerRight.getY()) / 2);
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle[(%s,%s), (%f,%f)]",
				             _upperLeft, _lowerRight,
				             this.getHeight(), this.getWidth());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Rectangle other = (Rectangle) obj;
		if (!this._upperLeft.equals(other._upperLeft)) {
			return false;
		}
		if (!this._upperRight.equals(other._upperRight)) {
			return false;
		}
		if (!this._lowerLeft.equals(other._lowerLeft)) {
			return false;
		}
		if (!this._lowerRight.equals(other._lowerRight)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + _upperLeft.hashCode();
	    hash = hash * 23 + _upperRight.hashCode();
	    hash = hash * 23 + _lowerLeft.hashCode();
	    hash = hash * 23 + _lowerRight.hashCode();
	    return hash;
	}
}

@SuppressWarnings("serial")
class RectangleException extends Exception {
	public RectangleException() {}
	
	public RectangleException(String message) {
		super(message);
	}
}