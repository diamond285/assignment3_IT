package com.company;

public class Letter {
    private int letter;
    private int count;

    public Letter(int letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return (char) letter + " - " + count;
    }
}
