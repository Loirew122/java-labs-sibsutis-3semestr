package task7;

import java.util.Optional;

class Course{
    private final String name;
    private final int id;
    private final boolean open;

    Course(String name, int id, boolean open) {
        this.name = name ;
        this.id = id ;
        this.open = open;
    }
    Optional<Course> findCourse(int id){
        if (this.id == id) return Optional.of(this);
        return Optional.empty();
    }    
    void enroll() throws EnrollmentRejectedException{
        if (open) System.out.println("Successfully enrolled");
        else throw new EnrollmentRejectedException();
    }
    @Override
    public String toString(){
        return String.format("[String name : %s. Id : %d. Status : %b]", name, id, open);
    }

}
