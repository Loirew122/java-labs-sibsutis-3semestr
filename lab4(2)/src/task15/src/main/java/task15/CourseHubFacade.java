package task15;

import java.io.Reader;
import java.util.Objects;

final class CourseHubFacade {
    private final CourseRepository repository;
    private final EnrollmentService enrollmentService;
    private final CourseImporter courseImporter;

    CourseHubFacade(CourseRepository repository) {
        this.repository = Objects.requireNonNull(repository);
        enrollmentService = new EnrollmentService();
        courseImporter = new CourseImporter(repository);
    }

    OperationResult<Integer> importCourses(Reader reader) {
        try {
            return OperationResult.success(
                    courseImporter.importCourses(reader)
            );
        } catch (CourseImportException exception) {
            return OperationResult.failure(
                    exception.errorCode(),
                    exception.getMessage(),
                    exception
            );
        } catch (InfrastructureException exception) {
            return infrastructureFailure(exception);
        }
    }

    OperationResult<Course> enroll(
            String rawCourseCode, EnrollmentRequest request) {
        Objects.requireNonNull(request);

        try {
            CourseCode courseCode = new CourseCode(rawCourseCode);
            Course course = repository.findByCode(courseCode)
                    .orElseThrow(() -> new EnrollmentRejectedException(
                            ErrorCode.COURSE_NOT_OPEN,
                            "Course is unavailable"
                    ));

            enrollmentService.enroll(course, request);
            return OperationResult.success(course);
        } catch (DomainValidationException exception) {
            return OperationResult.failure(
                    ErrorCode.VALIDATION_ERROR,
                    exception.getMessage(),
                    exception
            );
        } catch (EnrollmentRejectedException exception) {
            return OperationResult.failure(
                    exception.errorCode(),
                    exception.getMessage(),
                    exception
            );
        } catch (InfrastructureException exception) {
            return infrastructureFailure(exception);
        }
    }

    private <T> OperationResult<T> infrastructureFailure(
            InfrastructureException exception) {
        return OperationResult.failure(
                ErrorCode.INFRASTRUCTURE_UNAVAILABLE,
                "Course repository is unavailable",
                exception
        );
    }
}
