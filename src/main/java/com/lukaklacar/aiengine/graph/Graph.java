package com.lukaklacar.aiengine.graph;

import com.lukaklacar.aiengine.Element;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph<T extends Element> {

    private List<T> items;
    private Set<Node<T>> rootNodes;

    public Graph(List<T> items) {
        this.items = items;
        rootNodes = new HashSet<>();
    }

    private Node<T> findNode(Node<T> node) {
        return rootNodes
                .stream()
                .filter(rootNode -> rootNode.id() == node.id())
                .findFirst()
                .orElse(null);
    }

    private void connect(Node<T> node1, Node<T> node2) {
        node1.add(node2);
        node2.setParent(node1);
    }

    public void build() {
        for (int i = 0; i < items.size() - 1; i++) {

            if(i % 2000 == 0){
                System.out.println(((float)i / (float)items.size()) * 100 + "%");
            }

            if(((float)i / (float)items.size()) * 100 > 50){
                break;
            }

            T item1 = items.get(i);
            T item2 = items.get(i + 1);
            Node<T> node1 = new Node<>(item1);
            Node<T> node2 = new Node<>(item2);

            Node<T> rootNode1 = findNode(node1);
            Node<T> rootNode2 = findNode(node2);

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

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Set<Node<T>> getRootNodes() {
        return rootNodes;
    }

    public void setRootNodes(Set<Node<T>> rootNodes) {
        this.rootNodes = rootNodes;
    }
}
