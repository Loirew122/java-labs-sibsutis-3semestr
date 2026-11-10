package task8;

class Course{
    private final int durationHours;
    private int completedHours;

    Course(int durationHours, int completedHours){
        if (durationHours <= 0) throw new IllegalArgumentException("Duration must be positive");
        if (completedHours < 0 || completedHours > durationHours) {
            throw new IllegalArgumentException("Completed hours must fit duration");
        }
        this.durationHours = durationHours;
        this.completedHours = completedHours;
    }

    void completeHours(int hours){
        if (hours <= 0) throw new IllegalArgumentException("Hours must be positive");
        if (completedHours + hours > durationHours) {
            throw new IllegalArgumentException("Completed hours exceed duration");
        }
        completedHours += hours;
    }

    int completedHours(){ return completedHours; }
    int durationHours(){ return durationHours; }

}
