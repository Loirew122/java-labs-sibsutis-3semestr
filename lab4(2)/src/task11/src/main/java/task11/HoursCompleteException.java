package task11;

class HoursCompleteException extends IllegalArgumentException{
    private final int requestedHours; 
    private final int remainingHours;

    HoursCompleteException(int requestedHours, int remainingHours) {
        super("Error hours requersted : " + requestedHours + " remaining hours : " + remainingHours);
        this.remainingHours = remainingHours;
        this.requestedHours = requestedHours;
    }
    int requestedHours(){ return requestedHours;}
    int remainingHours(){ return remainingHours;}
    
    
}