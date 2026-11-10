package task13;
import java.util.Objects;
class Course{
    private final String name;
    private final int capacity;
    private int enrolledCount = 0;
    private final CourseStatus status;
    Course(String name, int capacity, CourseStatus status){
        this.name = Objects.requireNonNull(name);
        this.capacity = capacity;
        this.status = status;
    }
    void enroll(){
        enrolledCount++;
    }
    boolean hasAvailableSeat(){
        return enrolledCount<capacity;
    }
    String name(){ return name; }
    int capacity(){ return capacity;}
    int enrolledCount(){ return enrolledCount;}
    CourseStatus status(){ return status;}
    @Override
    public String toString() {
        return "Course{name='" + name + "', capacity=" + capacity  + ", status = " + status + " }";
    }
}