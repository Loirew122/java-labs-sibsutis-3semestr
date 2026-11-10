package task9;

class Task9Main{

    public static void main(String[] args) {
        int[] durations = {0, 1, 500, 501};

        for (int duration : durations) {
            try {
                new Course(duration, 0);
                System.out.println(duration + " -> accepted");
            } catch (IllegalArgumentException e) {
                System.out.println(duration + " -> rejected: " + e.getMessage());
            }
        }
    }
}
