package task15;

import java.util.List;
import java.util.Optional;

interface CourseRepository {
    void addAll(List<Course> courses) throws InfrastructureException;

    Optional<Course> findByCode(CourseCode code)
            throws InfrastructureException;

    int size();
}
