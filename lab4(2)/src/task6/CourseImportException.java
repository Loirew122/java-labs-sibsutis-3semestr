package task6;
class CourseImportException extends Exception{
    private final int id;
    CourseImportException(int id, Throwable cause){
        super("Error with id : " + id, cause);
        this.id = id;
    }
    int id(){return id;}
}
