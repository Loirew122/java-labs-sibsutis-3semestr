package task14;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.io.Reader;

class CourseImporter{
    private final CourseRepository repository;

    CourseImporter(CourseRepository repository) {
        this.repository = Objects.requireNonNull(repository) ;
    }
    ImportResult importCourses(Reader reader)
     throws CourseImportException {
        List<Course> temp = new ArrayList<>();
        int recordNumber = 0; // какую строку сейчас рассматриваем; 
        int processedCount = 0; // сколько правильны строк уже преобразовано 
        try (BufferedReader buffer = new BufferedReader(reader)) {
            String line;
            while((line = buffer.readLine()) != null){
                recordNumber++;
                Course course = parse(line, recordNumber, processedCount);
                temp.add(course);
                processedCount++;
            }
        } catch(IOException e){
            throw new CourseImportException("CourseImportFailing", recordNumber, 
            processedCount, e);
        } catch (CourseImportException e){
            throw e;
        }
        repository.addAll(temp);
        return new ImportResult(processedCount);
    }
    private Course parse(String line, int recordNumber, int processedCount)
    throws  CourseImportException{
        String[] parts = line.split(";", -1);
        if (parts.length !=2  || parts[0].isBlank() || parts[1].isBlank()){
            IllegalArgumentException cause = 
            new IllegalArgumentException("Expected non-empty code and title");
            throw new CourseImportException("Malformed record: " + recordNumber, recordNumber, 
            processedCount, cause);
        }
        return new Course(parts[0].strip(), parts[1].strip());
    }
     
}