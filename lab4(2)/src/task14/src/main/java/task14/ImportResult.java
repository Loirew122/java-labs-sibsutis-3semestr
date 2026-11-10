package task14;

final class ImportResult {
    private final int processedCount;

    ImportResult(int processedCount) {
        this.processedCount = processedCount;
    }

    int processedCount() {
        return processedCount;
    }
}
