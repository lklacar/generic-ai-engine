package com.lukaklacar.aiengine.chain;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Element> {

    private T item;
    private List<Node<T>> children;
    private Node parent;

    public Node(T item) {
        this.item = item;
        children = new ArrayList<>();
    }

    public void add(Node<T> child) {
        this.children.add(child);
    }

    public int id() {
        return item.id();
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
