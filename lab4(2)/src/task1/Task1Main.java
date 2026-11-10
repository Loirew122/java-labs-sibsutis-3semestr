package task1;
class Task1Main{
    private static int expMain(String text){
        return next1(text);
    } 
    private static int next1(String text){
        return next2(text);
    }
    private static int next2(String text){
        return last(text);
    }
    private static int last(String text){
        return Integer.parseInt(text);
    }
    public static void main(String[] args) {
        //Task1Main.expMain("Abc");
        Task1Main.expMain("42");

    }
}
/*
[stepa@loirew122 lab4(2)]$ java -cp out task1/Task1Main
Exception in thread "main" java.lang.NumberFormatException: For input string: "Abc"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:662)
        at java.base/java.lang.Integer.parseInt(Integer.java:778)
        at task1.Task1Main.last(Task1Main.java:13)
        at task1.Task1Main.next2(Task1Main.java:10)
        at task1.Task1Main.next1(Task1Main.java:7)
        at task1.Task1Main.expMain(Task1Main.java:4)
        at task1.Task1Main.main(Task1Main.java:16)
увидели всю цепочку методов stacktrace 
причина в некорекнто заданных данных
*/