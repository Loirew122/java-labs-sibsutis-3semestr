package src.task15;

import java.util.Set;

public record Offer(String title, Set<String> prerequisites, int capacity, int enrolled) {
}
