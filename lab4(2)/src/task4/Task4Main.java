package task4;
class Task4Main{
    //1
    static boolean returnFromTry(){
        try {
            return true;
        }
        finally{ System.out.println("Finally was executed. (returnFromTry)"); }
    } 
    //2
    static void throwAndCatch(){
        try {
            System.out.println("Try was executed. (throwAndCatch)");
            throw new Exception("throwAndCatch");

        } catch (Exception e) {
            System.out.println("Catch was executed. (throwAndCatch)");
        } finally{
            System.out.println("Finally was executed. (throwAndCatch)");
        }
    }
    //3
    static void throwFromCatch(){
        try {
            System.out.println("Try was executed. (throwFromCatch)");
            throw new Exception("throwFromCatch");

        } catch (Exception e) {
            System.out.println("Catch was executed. (throwFromCatch)");
            throw new IllegalStateException("NewExceptionThrow (throwFromCatch)");
        } finally{
            System.out.println("Finally was executed. (throwFromCatch)");
        }
    }
    //4
    static void throwFromFinally(){
        try {
            System.out.println("Try was executed. (throwFromFinally)");
            throw new IllegalArgumentException("OldArgumentException");
        } finally{
            System.out.println("Finally was executed. (throwFromFinally)");
            throw new IllegalStateException("NewExceptionThrow (throwFromFinally)");
        }
    }
    //5
    static boolean badReturnFromFinally(){
        try{ return true;} finally{ return false;}
    }
    public static void main(String[] args) {
        System.out.println("returnFromTry : " + Task4Main.returnFromTry());
        System.out.print("\nthrowAndCatch : "); Task4Main.throwAndCatch();
        System.out.print("\nthrowFromCatch : "); try{Task4Main.throwFromCatch();} catch (Exception e) {System.out.println(e.getMessage() + e.getClass());}
        System.out.print("\nthrowFromFinally : "); try{Task4Main.throwFromFinally();} catch (Exception e){ System.out.println(e.getMessage() + e.getClass());}
        System.out.println("\nbadReturnFromFinally : " + Task4Main.badReturnFromFinally());
        

    }
}

/*
returnFromTry()	Выполнится ли finally, если в try уже встретился return
throwAndCatch()	Порядок try → catch → finally
throwFromCatch()	Что произойдёт, если catch выбросит новое исключение
throwFromFinally()	Как исключение из finally влияет на предыдущий результат
badReturnFromFinally()	Почему return внутри finally опасен
*/