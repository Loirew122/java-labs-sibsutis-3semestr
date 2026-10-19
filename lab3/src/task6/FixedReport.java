package src.task6;

public class FixedReport extends Report {
    // параметр приведён к int, теперь сигнатура совпадает с Report.render и это настоящий override
    @Override
    public String render(int level) {
        return "FixedReport.render, level " + level;
    }

    // доступ расширен до public: override не может ослаблять доступ
    @Override
    public void print(String text) {
        System.out.println("FixedReport: " + text);
    }

    // ковариантный возврат: String это подтип Object, поэтому тип сужать можно
    @Override
    protected String info() {
        return "FixedReport info";
    }
}
