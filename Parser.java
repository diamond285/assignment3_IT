package com.company;

import java.util.Vector;

public class Parser {
    public static Node[] toNodes(Letter[] l) {
        Node[] nodes = new Node[l.length];
        for (int i = 0; i < l.length; i++) {
            nodes[i] = new Node(l[i].getCount(), Character.toString((char) l[i].getLetter()), null, null);
        }
        return nodes;
    }

    private static Node[] sorter(Node[] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < i; j++) {
                if (n[i].getCount() > n[j].getCount()) {
                    Node temp = n[i];
                    n[i] = n[j];
                    n[j] = temp;
                }
            }
        }
        return n;
    }

    public static Node treeBuilder(Node[] n) {
        int counter = 1;
        while (n.length != 1) {
            int n1 = n.length - 2, n2 = n1 + 1;
            System.out.println("Node " + counter + ": " + n[n1].getName() + " + " + n[n2].getName() + " = " + (n[n1].getCount() + n[n2].getCount()));
            Node temp = new Node(n[n1].getCount() + n[n2].getCount(), "Node " + counter, n[n2], n[n1]);
            Node[] tempNodes = new Node[n.length - 1];
            int i;
            for (i = 0; i < n.length - 2; i++) {
                tempNodes[i] = n[i];
            }
            tempNodes[i] = temp;
            n = tempNodes;
            n = sorter(n);
            counter++;
        }
        return n[0];
    }

    public static Vector<Node> toCode(Node root, String s, Vector<Node> nodes) {
        if(root == null) {
            return nodes;
        }
        toCode(root.getLeft(), s + "0", nodes);
        root.setCode(s);
        nodes.add(root);
        toCode(root.getRight(), s + "1", nodes);
        return nodes;
    }

    public static String parse(String s, Vector<Node> nodes) {
        StringBuilder temp = new StringBuilder();
        for(char x : s.toCharArray()) {
            for(Node y : nodes) {
                if(x == y.getName().toCharArray()[0]) {
                    temp.append(y.getCode());
                }
            }
        }
        return temp.toString();
    }
}
