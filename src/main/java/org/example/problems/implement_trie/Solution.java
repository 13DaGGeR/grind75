package org.example.problems.implement_trie;

import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Implement Trie";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/implement-trie-prefix-tree/";
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = getLastNode(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }

    private Node getLastNode(String word) {
        Node node = root;
        for (char c: word.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) {
                return null;
            }
        }

        return node;
    }

    private static class Node {
        public boolean isEnd = false;
        public Node[] children = new Node[26];
    }
}
