package raphael.command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ListCommandTest {
    @Test
    public void listCommand_emptyList() {
        new ListCommand().execute(new raphael.task.TaskList(),
                new raphael.ui.Ui(), new raphael.storage.Storage("./data/tasks.txt"));

    }
}
