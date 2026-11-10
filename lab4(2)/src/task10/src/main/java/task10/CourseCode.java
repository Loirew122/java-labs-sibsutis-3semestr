package task10;
import java.util.Objects;
record CourseCode(String name){
    
    CourseCode{
        Objects.requireNonNull(name);
        String finalName = name.strip().toUpperCase();
        if (!finalName.matches("[A-Z]{2,8}[0-9]{3}")){
            throw new IllegalArgumentException("Invalid course code : " + name);
        }
        name = finalName;
    }
}
