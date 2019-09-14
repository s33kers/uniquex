package us.martink.uniquex.api;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import us.martink.uniquex.api.dto.SortType;
import us.martink.uniquex.api.dto.Student;
import us.martink.uniquex.sort.SortStrategy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/sort", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SortController {

    private static final CsvMapper CSV_MAPPER = new CsvMapper();
    private Map<String, SortStrategy> sortStrategy;

    @GetMapping("/types")
    public List<SortType> getSortTypes() {
        return Arrays.asList(SortType.values());
    }

    @PostMapping
    public List<Student> sortStudents(@RequestParam SortType type,
                                      @RequestParam MultipartFile studentsFile) throws IOException {
        MappingIterator<Student> studentsIter = CSV_MAPPER.readerWithSchemaFor(Student.class).readValues(studentsFile.getInputStream());
        return sortStrategy.get(type.getKey()).sortByMark(studentsIter.readAll());
    }

}
