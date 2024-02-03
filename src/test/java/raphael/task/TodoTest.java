package raphael.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void toString_doneTodo() {
        assertEquals("[T][X] stub", new Todo("stub", true).toString());
    }
    @Test
    public void toString_undoneTodo() {
        assertEquals("[T][ ] stub", new Todo("stub", false).toString());
    }
    @Test
    public void toFileFormat_doneTodo() {
        assertEquals("T |&| 1 |&| stub", new Todo("stub", true).toFileFormat());
    }
    @Test
    public void toFileFormat_undoneTodo() {
        assertEquals("T |&| 0 |&| stub", new Todo("stub", false).toFileFormat());
    }
}
