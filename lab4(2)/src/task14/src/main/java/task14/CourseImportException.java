package task14;
final class CourseImportException extends Exception{
    private final int recordNumber; // какую строку сейчас рассматриваем; 
    private final int processedCount; // сколько правильны строк уже преобразовано 

    CourseImportException(String message, int recordNumber,
    int processedCount, Throwable cause) {
        super(message, cause);
        this.recordNumber =  recordNumber;
        this.processedCount = processedCount;
    }
    int recordNumber(){ return recordNumber;}
    int processedCount(){ return processedCount;}
    
}