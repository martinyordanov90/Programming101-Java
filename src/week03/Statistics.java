package week03;

import java.util.List;

public interface Statistics {
	public double getMean(List<Integer> numbers);
	public double getMedian(List<Integer> numbers);
	public int getMode(List<Integer> numbers);
	public int getRange(List<Integer> numbers);
}