package us.martink.uniquex.sort;

import org.springframework.stereotype.Component;
import us.martink.uniquex.api.dto.Student;

import java.util.ArrayList;
import java.util.List;

@Component("merge")
public class MergeSort implements SortStrategy {

    @Override
    public List<Student> sortByMark(List<Student> students) {
        sort(students, 0, students.size() - 1);
        return students;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private void sort(List<Student> students, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(students, l, m);
            sort(students, m + 1, r);

            // Merge the sorted halves
            merge(students, l, m, r);
        }
    }

    private void merge(List<Student> students, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        List<Student> left = new ArrayList<>();
        List<Student> right = new ArrayList<>();

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            left.add(i, students.get(l + i));
        }
        for (int j = 0; j < n2; ++j) {
            right.add(j, students.get(m + 1 + j));
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (left.get(i).getMark() >= right.get(j).getMark()) {
                students.set(k, left.get(i));
                i++;
            } else {
                students.set(k, right.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            students.set(k, left.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            students.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
