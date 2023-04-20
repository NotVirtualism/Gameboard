import java.util.ArrayList;
import java.util.Comparator;


public class TagListComparator implements Comparator<ArrayList<String>> {

    /**
     * compares the number of times a tag appears and returns a list with the top 3
     *
     * @param l1 the first object to be compared.
     * @param l2 the second object to be compared.
     * @return
     */
    public int compare(ArrayList<String> l1, ArrayList<String> l2) {
        if (l1.size() < l2.size()) {
            return 1;
        }
        if (l1.size() > l2.size()) {
            return -1;
        }
        return 0;
    }
}


