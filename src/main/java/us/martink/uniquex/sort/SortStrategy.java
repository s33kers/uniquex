package us.martink.uniquex.sort;

import us.martink.uniquex.api.dto.Student;

import java.util.List;

public interface SortStrategy {
    List<Student> sortByMark(List<Student> students);
}
