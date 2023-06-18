import org.example.problems.min_stack.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinStackTest {
    @Test
    public void test() {
        Solution minStack = new Solution();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertSame(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertSame(0, minStack.top());
        Assertions.assertSame(-2, minStack.getMin());
    }
}
