package us.martink.uniquex.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import us.martink.uniquex.api.dto.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class MergeSortTest {

    private MergeSort heapSort = new MergeSort();

    @Test
    public void test() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("st1", 8));
        students.add(new Student("st2", 5));
        students.add(new Student("st3", 7));
        students.add(new Student("st4", 2));
        students.add(new Student("st5", 84));
        students.add(new Student("st6", 5));
        students.add(new Student("st7", 88));
        students.add(new Student("st8", 1));

        List<Student> sortedStudents = heapSort.sortByMark(students);
        double prevMark = sortedStudents.get(0).getMark();
        for (Student sortedStudent : sortedStudents) {
            assertTrue(sortedStudent.getMark() <= prevMark);
            prevMark = sortedStudent.getMark();
        }
    }

}
