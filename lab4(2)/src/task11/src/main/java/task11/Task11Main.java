package task11;
class Task11Main{
    
    public static void main(String[] args) {
        Course course = new Course(100, 50);
        course.completeHours(30);
        System.out.println("Completed hours: " + course.completedHours());

        try {
            course.completeHours(30);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}