package infrastructure;

import org.example.helpers.GraphNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphNodeTest {
    @Test
    public void testExport() {
        GraphNode node = GraphNode.createFromArray(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        GraphNode node2 = GraphNode.createFromArray(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        Assertions.assertEquals(node, node2);
    }
}
