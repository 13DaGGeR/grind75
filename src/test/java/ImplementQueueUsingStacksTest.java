import org.example.problems.implement_queue_using_stacks.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImplementQueueUsingStacksTest {
    @Test
    public void test() {
        Solution q = new Solution();
        q.push(1);
        q.push(2);
        Assertions.assertSame(1, q.peek());
        Assertions.assertSame(1, q.pop());
        Assertions.assertFalse(q.empty());
        Assertions.assertSame(2, q.pop());
        Assertions.assertTrue(q.empty());
    }
}
