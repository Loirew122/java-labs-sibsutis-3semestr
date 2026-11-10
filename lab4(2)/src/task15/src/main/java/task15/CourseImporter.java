package task15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

final class CourseImporter {
    private final CourseRepository repository;

    CourseImporter(CourseRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    int importCourses(Reader reader)
            throws CourseImportException, InfrastructureException {
        Objects.requireNonNull(reader);
        List<Course> importedCourses = new ArrayList<>();
        int recordNumber = 0;
        int processedCount = 0;

        try (BufferedReader buffer = new BufferedReader(reader)) {
            String line;
            while ((line = buffer.readLine()) != null) {
                recordNumber++;
                importedCourses.add(
                        parse(line, recordNumber, processedCount)
                );
                processedCount++;
            }
        } catch (CourseImportException exception) {
            throw exception;
        } catch (IOException exception) {
            throw new CourseImportException(
                    ErrorCode.IMPORT_IO_ERROR,
                    "Cannot read course data",
                    recordNumber,
                    processedCount,
                    exception
            );
        }

        repository.addAll(importedCourses);
        return processedCount;
    }

    private Course parse(String line, int recordNumber, int processedCount)
            throws CourseImportException {
        try {
            String[] parts = line.split(";", -1);
            if (parts.length != 5) {
                throw new IllegalArgumentException("Expected five fields");
            }
            for (String part : parts) {
                if (part.isBlank()) {
                    throw new IllegalArgumentException("Fields cannot be blank");
                }
            }

            return new Course(
                    new CourseCode(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2].strip()),
                    CourseStatus.valueOf(
                            parts[3].strip().toUpperCase(Locale.ROOT)
                    ),
                    Integer.parseInt(parts[4].strip())
            );
        } catch (IllegalArgumentException exception) {
            throw new CourseImportException(
                    ErrorCode.IMPORT_MALFORMED_RECORD,
                    "Malformed record " + recordNumber,
                    recordNumber,
                    processedCount,
                    exception
            );
        }
    }
}
