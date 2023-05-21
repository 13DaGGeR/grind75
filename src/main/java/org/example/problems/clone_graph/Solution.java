package org.example.problems.clone_graph;

import org.example.helpers.graph.Node;
import org.example.problems.SolutionInterface;

import java.util.HashMap;
import java.util.Map;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Clone Graph";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/clone-graph/";
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return getClone(new HashMap<>(), node);
    }

    private Node getClone(Map<Node, Node> clonesMap, Node original) {
        if (clonesMap.containsKey(original)) {
            return clonesMap.get(original);
        }

        Node clone = new Node(original.val);
        clonesMap.put(original, clone);

        for (Node neighbour: original.neighbors) {
            clone.neighbors.add(getClone(clonesMap, neighbour));
        }

        return clone;
    }
}
