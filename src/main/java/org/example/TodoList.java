package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private static final class Task {
        private final String text;
        private boolean done;

        private Task(String text) {
            this.text = text;
        }
    }

    private final List<Task> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            String normalized = item.trim();
            if (!normalized.isEmpty()) {
                items.add(new Task(normalized));
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public boolean markDone(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).done = true;
            return true;
        }
        return false;
    }

    public boolean isDone(int index) {
        return index >= 0 && index < items.size() && items.get(index).done;
    }

    public List<String> search(String substring) {
        List<String> found = new ArrayList<>();
        if (substring == null) {
            return found;
        }
        String needle = substring.trim().toLowerCase();
        if (needle.isEmpty()) {
            return found;
        }
        for (Task task : items) {
            if (task.text.toLowerCase().contains(needle)) {
                found.add(task.text);
            }
        }
        return found;
    }

    public void clear() {
        items.clear();
    }

    public List<String> getAll() {
        List<String> texts = new ArrayList<>();
        for (Task task : items) {
            texts.add(task.text);
        }
        return texts;
    }

    public int size() {
        return items.size();
    }
}
