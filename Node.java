package com.company;

public class Node {
    private int count;
    private String name;
    private Node left;
    private Node right;
    private String code;

    public Node(int count, String name, Node left, Node right) {
        this.count = count;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public Node(int count, String name, Node left, Node right, String code) {
        this.count = count;
        this.name = name;
        this.left = left;
        this.right = right;
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
