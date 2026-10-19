package src.task6;

// здесь нет @Override, поэтому ошибка в типе параметра компилятору не видна
public class LooseReport extends Report {
    // Integer вместо int: это перегрузка, а не переопределение
    public String render(Integer level) {
        return "LooseReport.render, level " + level;
    }
}
