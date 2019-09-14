package us.martink.uniquex.sort;

import org.springframework.stereotype.Component;
import us.martink.uniquex.api.dto.Student;

import java.util.List;

@Component("heap")
public class HeapSort implements SortStrategy {

    @Override
    public List<Student> sortByMark(List<Student> students) {
        Student temp;
        int size = students.size();
        // Build heap (rearrange array)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(students, size, i);
        }

        // One by one extract an element from heap
        for (int i = size - 1; i >= 0; i--) {
            // Move current root to end
            temp = students.get(0);
            students.set(0, students.get(i));
            students.set(i, temp);

            // call max heapify on the reduced heap
            heapify(students, i, 0);
        }
        return students;
    }

    private void heapify(List<Student> students, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && students.get(l).getMark() < students.get(largest).getMark())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && students.get(r).getMark() < students.get(largest).getMark())
            largest = r;

        // If largest is not root
        Student temp;
        if (largest != i) {
            temp = students.get(i);
            students.set(i, students.get(largest));
            students.set(largest, temp);

            // Recursively heapify the affected sub-tree
            heapify(students, n, largest);
        }
    }
}
