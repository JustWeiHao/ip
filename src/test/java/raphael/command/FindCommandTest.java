package raphael.command;

import org.junit.jupiter.api.Test;
import raphael.task.TaskList;
import raphael.ui.Ui;
import raphael.storage.Storage;

public class FindCommandTest {
    @Test
    public void executeTest() {
        new FindCommand("").execute(new TaskList(), new Ui(), new Storage("./data/tasks.txt"));
    }
}
