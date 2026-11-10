package task11;

class Course{
    private final int durationHours;
    private int completedHours;

    Course(int durationHours, int completedHours){
        if (durationHours < 1 || durationHours > 500) {
            throw new IllegalArgumentException("Duration must be between 1 and 500 hours");
        }
        if (completedHours < 0 || completedHours > durationHours) {
            throw new IllegalArgumentException("Completed hours must fit duration");
        }
        this.durationHours = durationHours;
        this.completedHours = completedHours;
    }

    void completeHours(int hours){
        if (hours <= 0) throw new IllegalArgumentException("Hours must be positive");
        int remainingHours = durationHours - completedHours;
        if (hours >remainingHours) throw new HoursCompleteException(hours, remainingHours);
        completedHours += hours;
    }

    int completedHours(){ return completedHours; }
    int durationHours(){ return durationHours; }

}
