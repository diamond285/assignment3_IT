package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {
        DecimalFormat _numberFormat= new DecimalFormat("#0.000");
        String s = Counter.read_file("text.txt");
        int[] arr = Counter.count("text.txt");
        Letter[] letters = Counter.parse(arr);
        Letter[] sortedLetters = Counter.sorter(letters);
        Letter[] finalLetters = Counter.deleter(sortedLetters);
        for (Letter x : finalLetters) {
            System.out.println(x.getLetter() + " - " + _numberFormat.format(x.getCount() / (float)s.length()));
        }

        Node[] rawNodes = Parser.toNodes(finalLetters);
        Node head = Parser.treeBuilder(rawNodes);

        Vector<Node> nodes = Parser.toCode(head, "", new Vector<>());
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).getName().contains("Node")) {
                nodes.remove(i);
                i--;
            }
        }
        for(Node x : nodes) {
            System.out.println(x.getName() + " - " + _numberFormat.format(x.getCount() / (float)s.length()) + " - " + x.getCode());
        }

        String finalText = Parser.parse(s, nodes);
        System.out.println(finalText);

        Counter.save(finalText, "new.txt");

        System.out.println("Number of bits in the original text: " + (s.length() * 8) + " bits");
        System.out.println("Number of bits in the compressed text: " + finalText.length() + " bits");
        System.out.println("Compression ratio = " + _numberFormat.format(s.length() * 8 / (float)finalText.length()));
        System.out.println("Average code length = " + _numberFormat.format(finalText.length() / (float)s.length()));
    }
}
