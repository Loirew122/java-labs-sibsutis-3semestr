package task8;

class Task8Main{

    public static void main(String[] args) {
        Course course = new Course(100, 0);
        course.completeHours(30);
        System.out.println("Completed hours: " + course.completedHours());

        try {
            course.completeHours(-123);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
