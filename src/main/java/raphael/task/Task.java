package raphael.task;
import raphael.exception.RaphaelException;
import raphael.format.FileFormattable;

import java.util.Comparator;

/**
 * The task class.
 */
public class Task implements FileFormattable, Comparable<Task> {
    private final String description;
    private boolean isDone;

    /**
     * The overloaded constructor of the task.
     *
     * @param description the description of the task.
     * @param isDone the status of the task.
     */
    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * The constructor of the task.
     *
     * @param description the description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks the current task as done.
     *
     * @return 0 if the current task is not done yet, and hence a successful operation can be carried out; -1 otherwise.
     */
    public int check() {
        if (this.isDone) {
            return -1;
        } else {
            this.isDone = true;
            return 0;
        }
    }

    /**
     * Marks the current task as undone.
     *
     * @return 0 if the current task is done, and hence a successful operation can be carried out; -1 otherwise.
     */
    public int uncheck() {
        if (!this.isDone) {
            return -1;
        } else {
            this.isDone = false;
            return 0;
        }
    }
    public boolean isContaining(String keyword) {
        return this.description.contains(keyword);
    }
    public String toFileFormat() {
        return String.format("%d |&| %s", this.isDone ? 1 : 0, this.description);
    }

    /**
     * Return the relevant task based on its string format.
     *
     * @param task the string format of the task.
     * @return the task generated by interpreting the task.
     * @throws RaphaelException an exception exclusive to Raphael.
     */
    public static Task of(String task) throws RaphaelException {
        final String[] taskArr = task.split(" \\|&\\| ");
        switch (taskArr[0]) {
        case "T":
            return new Todo(taskArr[2], taskArr[1].equals("1"));
        case "D":
            return new Deadline(taskArr[2], taskArr[3], taskArr[1].equals("1"));
        case "E":
            return new Event(taskArr[2], taskArr[3],
                    taskArr[4], taskArr[1].equals("1"));
        default:
            throw new RaphaelException("Error in loading the tasks!");
        }
    }
    @Override
    public String toString() {
        return String.format("[%c] %s", isDone ? 'X' : ' ', this.description);
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Task o) {
        return this.description.compareTo(o.description);
    }
}
