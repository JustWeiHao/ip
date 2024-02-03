package raphael.command;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ExitCommandTest {

    @Test
    public void executeTest() {
        new ExitCommand().execute(null, null, null);
    }
    @Test
    public void isExitTest() {
        assertTrue(new ExitCommand().isExit());
    }
}
