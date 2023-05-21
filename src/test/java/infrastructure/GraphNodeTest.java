package infrastructure;

import org.example.helpers.graph.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphNodeTest {
    @Test
    public void testExport() {
        Node node = Node.createFromArray(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        Node node2 = Node.createFromArray(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        Assertions.assertEquals(node, node2);
    }
}
