package week04;

public class LineSegment implements Comparable<LineSegment> {
	private final Point _start;
	private final Point _end;
	
	public LineSegment(Point start, Point end) {
		try {
			if (start.equals(end)) {
				String errorMsg = "Cannot create a line segment with zero length.";
				throw new LineSegmentException(errorMsg);
			}
		} catch (LineSegmentException e) {
			e.printStackTrace();
		}
		
		_start = new Point(start);
		_end = new Point(end);
	}
	
	public LineSegment(LineSegment other) {
		this(other._start, other._end);
	}
	
	public Point getStart() {
		return _start;
	}
	
	public Point getEnd() {
		return _end;
	}
	
	public double getLength() {
		double distX = Math.abs(_start.getX() - _end.getX());
		double distY = Math.abs(_start.getY() - _end.getY());
		
		double distance = Math.sqrt(distX*distX + distY*distY);
		return distance;
	}
	
	@Override
	public String toString() {
		return String.format("Line[(%f,%f),(%f,%f)]",
				             _start.getX(), _start.getY(),
				             _end.getX(), _end.getY());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final LineSegment other = (LineSegment) obj;
		return (_start.equals(other._start)) && (_end.equals(other._end));
	}
	
	@Override
	public int compareTo(LineSegment other) {
		if (this.getLength() < other.getLength()) {
			return -1;
		} else if (this.getLength() == other.getLength()) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public int hashCode() {
	    int hash = 17;
	    hash = hash * 23 + _start.hashCode();
	    hash = hash * 23 + _end.hashCode();
	    return hash;
	}
}

@SuppressWarnings("serial")
class LineSegmentException extends Exception {
	public LineSegmentException() {}

	public LineSegmentException(String message) {
		super(message);
	}
}
