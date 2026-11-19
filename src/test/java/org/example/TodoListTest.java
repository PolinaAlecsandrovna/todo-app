package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add("  ");
        assertEquals(0, t.size());
    }

    @Test
    void markDone() {
        TodoList t = new TodoList();
        t.add("task");
        assertFalse(t.isDone(0));
        assertTrue(t.markDone(0));
        assertTrue(t.isDone(0));
        assertFalse(t.markDone(5));
    }

    @Test
    void searchBySubstring() {
        TodoList t = new TodoList();
        t.add("buy milk");
        t.add("buy bread");
        t.add("call mom");
        List<String> found = t.search("buy");
        assertEquals(2, found.size());
        assertTrue(t.search("milk").contains("buy milk"));
        assertTrue(t.search("xyz").isEmpty());
    }

    @Test
    void clearRemovesAll() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        t.clear();
        assertEquals(0, t.size());
    }
}
