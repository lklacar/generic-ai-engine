package com.lukaklacar.aiengine.chain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private List<Object> items;
    private Set<Node> rootNodes;

    public Graph(List<Object> items) {
        this.items = items;
        rootNodes = new HashSet<Node>();
    }


    private Node findNode(Node node) {
        return rootNodes
                .stream()
                .filter(rootNode -> rootNode.id() == node.id())
                .findFirst()
                .orElse(null);
    }

    private void connect(Node node1, Node node2) {
        node1.add(node2);
        node2.setParent(node1);
    }

    public void build() {
        for (int i = 0; i < items.size() - 1; i++) {
            Object item1 = items.get(i);
            Object item2 = items.get(i + 1);
            Node node1 = new Node(item1);
            Node node2 = new Node(item2);

            Node rootNode1 = findNode(node1);
            Node rootNode2 = findNode(node2);

            if (rootNode1 == null) {
                rootNodes.add(node1);
                rootNode1 = node1;
            }

            if (rootNode2 == null) {
                rootNodes.add(node2);
                rootNode2 = node2;
            }

            connect(rootNode1, rootNode2);
        }
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public Set<Node> getRootNodes() {
        return rootNodes;
    }

    public void setRootNodes(Set<Node> rootNodes) {
        this.rootNodes = rootNodes;
    }
}
