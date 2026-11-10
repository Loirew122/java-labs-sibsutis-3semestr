package task6;
class Task6Main{

    public static void main(String[] args) {
        try{
        System.out.println("1 : " + CourseImportService.parse("213", 1));
        } catch (CourseImportException e) { System.out.println(e.getMessage() + " Cause :  " + e.getCause());} 
        try{
        System.out.println("\n2 : " + CourseImportService.parse("abc", 2));
        } catch (CourseImportException e) { System.out.println(e.getMessage()+ " Cause :  " + e.getCause());} 

    }
}

/*
Иерархия уровней:

Task6Main — верхний уровень. Запускает импорт и решает, как обработать отказ.
CourseImportService — уровень операции. Добавляет номер записи и переводит техническую ошибку в CourseImportException.
CourseRecordParser — низкоуровневый parser. Преобразует текст в число и не знает контекст импорта.
Integer.parseInt — библиотечный метод. Выбрасывает NumberFormatException для некорректной строки.

Цепочка перевода:
NumberFormatException → CourseImportException с номером записи и сохранённым cause.

Низкий уровень сообщает техническую причину,
средний уровень добавляет смысл операции,
а верхний уровень решает, как обработать отказ

*/
