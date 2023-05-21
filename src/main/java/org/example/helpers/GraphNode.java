package org.example.helpers;

import java.util.*;

public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static GraphNode createFromArray(int[][] values) {
        if (values.length == 0) {
            return null;
        }

        GraphNode[] list = new GraphNode[values.length];
        for (int i = 0; i < values.length; i++) {
            list[i] = new GraphNode(i + 1);
        }

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                list[i].neighbors.add(list[values[i][j] - 1]);
            }
        }

        return list[0];
    }

    public int[][] export() {
        List<List<Integer>> connections = new ArrayList<>();
        Set<Integer> processed = new HashSet<>();
        Queue<GraphNode> leftToProcess = new LinkedList<>();

        leftToProcess.add(this);
        while (leftToProcess.peek() != null) {
            GraphNode current = leftToProcess.poll();
            List<Integer> currentConnections = new ArrayList<>();
            for (GraphNode neighbour: current.neighbors) {
                currentConnections.add(neighbour.val);
                if (processed.contains(neighbour.val)) {
                    continue;
                }

                leftToProcess.add(neighbour);
            }
            while (current.val > connections.size()) {
                connections.add(new ArrayList<>());
            }
            connections.set(current.val - 1, currentConnections);
            processed.add(current.val);
        }

        int[][] result = new int[connections.size()][];
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> nodeConnections = connections.get(i);
            int[] resultConnections = new int[nodeConnections.size()];
            for (int j = 0; j < nodeConnections.size(); j++) {
                resultConnections[j] = nodeConnections.get(j);
            }
            result[i] = resultConnections;
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof GraphNode)) {
            return false;
        }

        return Arrays.deepEquals(this.export(), ((GraphNode) obj).export());
    }
}
