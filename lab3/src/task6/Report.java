package src.task6;

public class Report {
    public String render(int level) {
        return "Report.render, level " + level;
    }

    public void print(String text) {
        System.out.println("Report: " + text);
    }

    protected Object info() {
        return "Report info";
    }
}