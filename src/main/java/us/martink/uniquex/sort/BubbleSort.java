package us.martink.uniquex.sort;

import org.springframework.stereotype.Component;
import us.martink.uniquex.api.dto.Student;

import java.util.List;

@Component("bubble")
public class BubbleSort implements SortStrategy {

    @Override
    public List<Student> sortByMark(List<Student> students) {
        Student temp;
        int size = students.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (students.get(j).getMark() < students.get(j + 1).getMark()) {
                    temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        return students;
    }
}
