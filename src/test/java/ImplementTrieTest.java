import org.example.problems.implement_trie.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ImplementTrieTest {
    @Test
    public void test() {
        Solution trie = new Solution();
        trie.insert("apple");
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assertions.assertTrue(trie.search("app"));
    }
}
