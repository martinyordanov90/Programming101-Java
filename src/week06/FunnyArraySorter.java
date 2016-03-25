package week06;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunnyArraySorter {
    private int m_pivot;

    public FunnyArraySorter(int pivot) {
        m_pivot = pivot;
    }

    public void reverseSort(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer t1, Integer t2) {
                return t2.compareTo(t1);
            }
        });
    }

    public void pivotSubtractionSort(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer t1, Integer t2) {
                if (t1 - m_pivot > t2) {
                    return 1;
                }
                if (t1 - m_pivot == t2) {
                    return 0;
                }
                return -1;
            }
        });
    }

    public void pivotDivisionSort(List list) {
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer t1, Integer t2) {
                if (t1 / m_pivot > t2) {
                    return 1;
                }
                if (t1 / m_pivot == t2) {
                    return 0;
                }
                return -1;
            }
        });
    }
}
