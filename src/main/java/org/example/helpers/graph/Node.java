package org.example.helpers.graph;

import java.util.*;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static Node createFromArray(int[][] values) {
        if (values.length == 0) {
            return null;
        }

        Node[] list = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            list[i] = new Node(i + 1);
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
        Queue<Node> leftToProcess = new LinkedList<>();

        leftToProcess.add(this);
        while (leftToProcess.peek() != null) {
            Node current = leftToProcess.poll();
            List<Integer> currentConnections = new ArrayList<>();
            for (Node neighbour: current.neighbors) {
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
        if (!(obj instanceof Node)) {
            return false;
        }

        return Arrays.deepEquals(this.export(), ((Node) obj).export());
    }
}

