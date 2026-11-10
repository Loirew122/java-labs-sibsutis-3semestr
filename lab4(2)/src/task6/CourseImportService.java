package task6;
class CourseImportService{
    static int parse(String text, int id) throws CourseImportException {
        try{
        return CourseRecordParser.parse(text);
        } catch (NumberFormatException e) { throw new CourseImportException(id, e);}
    }
}
    