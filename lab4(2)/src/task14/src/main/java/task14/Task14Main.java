package task14;

import java.io.StringReader;

class Task14Main{
    public static void main(String[] args){
        //1  success import
        CourseRepository repo = new CourseRepository();
        CourseImporter importer = new CourseImporter(repo);
        StringReader reader = new StringReader("JAVA101;Java Basics\nDB201;Databases");
        try{
        ImportResult result1 = importer.importCourses(reader);
        System.out.println("1 Success - Processed : " + result1.processedCount() + " Repository size : " + repo.size());

        } catch (CourseImportException e ) { System.out.println("1 - Error " + e.getMessage());}
        //2 
        CourseRepository repo2 = new CourseRepository();
        CourseImporter importer2 = new CourseImporter(repo2);
        int repoSize  = repo2.size();
        String text = "JAVA101;Java Basics\nBROKEN";
        CloseFailingReader reader2 = new CloseFailingReader(text);
        try {
            importer2.importCourses(reader2);
        } catch (CourseImportException e) {
            System.out.println();
            System.out.println("2 - Malformed record and close failure");
            System.out.println("Input:");
            System.out.println(text);
            System.out.println("Record number     : " + e.recordNumber());
            System.out.println("Processed records : " + e.processedCount());
            System.out.println("Cause             : " + e.getCause());
            System.out.println("Suppressed count  : " + e.getSuppressed().length);

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed        : " + suppressed);
            }

            System.out.println("Repository before : " + repoSize);
            System.out.println("Repository after  : " + repo2.size());
            System.out.println("Reader closed     : " + reader2.closed());
        }
    }
}
