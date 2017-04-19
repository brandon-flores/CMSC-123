package Packets;

/**
 * Created by brandon on 10/29/2016.
 */
public class Node implements Comparable<Node>{
    private int size;
    private String from;
    private String to;
    private int seq;
    private String line;
    private int lineSum;
    private int check;

    public Node(int size, String from, String to, int seq, String line, int lineSum, int check) {
        this.size = size;
        this.from = from;
        this.to = to;
        this.seq = seq;
        this.line = line;
        this.lineSum = lineSum;
        this.check = check;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getSize() {
        return size;
    }

    public String getTo() {
        return to;
    }

    public int getSeq() {
        return seq;
    }

    public String getLine() {
        return line;
    }

    public int getLineSum() {
        return lineSum;
    }

    public int getCheck() {
        return check;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString(){
        return String.format("Size: %d\nFrom: %s\nTo: %s\nSeq: %d\nLine: %s\nLine Sum: %d\nCheck: %d",size, from, to, seq, line, lineSum, check);
    }

    @Override
    public int compareTo(Node o) {
        int i = this.getFrom().compareTo(o.getFrom());
        if (i != 0) return i;

        i = this.getTo().compareTo(o.getTo());
        if (i != 0) return i;

        return Integer.compare(this.getSeq(), o.getSeq());
    }
}