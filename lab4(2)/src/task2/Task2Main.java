package task2;

class Task2Main{
    private enum ErrorStrategy{
        CHECKED_EXCEPTION, UNCHECKED_EXCEPTION, 
        OTHER_RESULT, UNRECOVERABLE
    }
    private record ErrorCase(String situation, ErrorStrategy strategy, String explanation){}     
    private static final int countError = 6; 
    public static void main(String[] args){
        
        ErrorCase[] errorArray = {
            new ErrorCase("IllegalArgumentException", ErrorStrategy.UNCHECKED_EXCEPTION,
            "Проблема возникла из-за некорректного аргумента (нарушение контракта).\nРешение: передать в метод корректный аргумент"), 
            new ErrorCase("OutOfFile", ErrorStrategy.UNCHECKED_EXCEPTION, 
            "Проблема возникла из-за отсутсвия ресурса.\nРешение: найти и присвоить объекту корректный файл"),
            new ErrorCase("НарушениеСостояния", ErrorStrategy.OTHER_RESULT, 
            "Проблема возникла из-за недопустимого состояния.\nРешение: вернуть объект в состояние, при котором с ним можно взаимодействовать"), 
            new ErrorCase("NetworkError", ErrorStrategy.CHECKED_EXCEPTION, 
            "Проблема возникла из-за сетевого отказа.\nРешение: дождаться восстановления сети"), 
            new ErrorCase("ConfigurationError", ErrorStrategy.CHECKED_EXCEPTION, 
            "Проблема возникла из-за неверной конфигурации.\nРешение: привести конфигурацию к корректному состоянию"), 
            new ErrorCase("OutOfMemory", ErrorStrategy.UNRECOVERABLE, 
            "Проблема возникла из-за нехватки памяти в JVM.\nРешение: устранить утечку памяти или увеличить размер кучи")
        };
        for (int i =0; i<countError; i++){System.out.println(String.format("№%d - %s", i+1, errorArray[i].toString()));}
    }
}

