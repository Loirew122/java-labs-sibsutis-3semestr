package task5;
import java.util.Arrays;
class Task5Main{

    public static void main(String[] args) {
        //1 
        try(TrackingResource resource = new TrackingResource(1, false, false)){
            resource.use();
        }
        //2 исключение не мешает закрытию ресурса
        try(TrackingResource resource2 = new TrackingResource(2, true, false)){
            resource2.use();
        } catch(IllegalStateException e) {System.out.println(e.getMessage());}
        //3 close тоже выбрасывает исключение
        try(TrackingResource resource3 = new TrackingResource(3, true, true)){
            resource3.use();
        } catch(IllegalStateException e) {System.out.println(e.getMessage());}
        //4 проверка результата третьего сценария 
        try(TrackingResource resource4 = new TrackingResource(4, true, true)){
            resource4.use();
        } catch(IllegalStateException e) {System.out.println(e.getMessage() + " " + Arrays.toString(e.getSuppressed()));}
        // 5 два ресурса 
        try (TrackingResource resource5 = new TrackingResource(5, false, false); 
        TrackingResource resource6 = new TrackingResource(6, false, false)){
            resource5.use();
            resource6.use();
        }


    }
}
