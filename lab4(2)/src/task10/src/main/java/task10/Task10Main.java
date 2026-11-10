package task10;
class Task10Main{
    
    public static void main(String[] args) {
        CourseCode course = new CourseCode("bob303");
        System.out.println("1 valid name : " + course.name());
        try {
            CourseCode course2 = new CourseCode("a909");
        } catch (IllegalArgumentException e) {
            System.out.println("2 invalid name : " + e.getMessage());
        } 
    }
}