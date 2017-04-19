package Packets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by brandon on 10/29/2016.
 */
public class Parsing {

    private LinkedList<Node> data;

    Parsing(){
        data = new LinkedList<>();
    }

    public LinkedList<Node> getData() {
        return data;
    }

    public void setData(LinkedList<Node> data) {
        this.data = data;
    }

    private String removeLast(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    private String fromTo(String str){
        String ans = "";
        for(int i = 0, j = 8; i < 32; i = j, j += 8){
            ans += Integer.parseInt(str.substring(i,j), 2) + ".";
        }
        return removeLast(ans);
    }

    private int check(String str){
        return (int) Long.parseLong(str, 2);
    }

    private int lineSum(String str) {
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            ans += (int) str.charAt(i);
        }
        return ans;
    }

    private void checkMissing() {
        LinkedList<Node> temp = new LinkedList<>();

        int ctr = 0, i = 0, ctr1 = 0;
        for(Node n : data){
            if(checkIP(ctr1)){
                i = 0;
            }
            if(n.getSeq() != i){
                if(i > n.getSeq()){
                    i--;
                }else{
                    for(int j = 0, x = n.getSeq() - i; j < x; ctr++, j++, i++){
                        temp.add(ctr, new Node(-1, n.getFrom(), n.getTo(), i, "[MISSING]", -1, -1));
                    }
                    if(checkDup(temp.getLast(), n)) temp.add(n.getSeq(),n);
                }
            }
            else{
                if(checkCorrupted(n)){
                    n.setLine("[CORRUPTED]");
                }
                if(ctr1 == 0 || checkDup(temp.getLast(), n)) temp.add(n);
                ctr++;
            }
            i++; ctr1++;
        }
        setData(temp);
    }

    private boolean checkDup(Node last, Node n) {
        return !(last.getSeq() == n.getSeq());
    }

    private boolean checkIP(int i) {
        if(i != 0){
            return (!(data.get(i).getTo().equals(data.get(i - 1).getTo())) || !(data.get(i).getFrom().equals(data.get(i - 1).getFrom())));
        }
        return false;
    }

    private boolean checkCorrupted(Node n) {
        return !(n.getCheck() == n.getLineSum() && n.getLine().length() == n.getSize());
    }

    private void displaySort() {
        checkMissing();
        int ctr = 0;
        for(Node n : data){
            if(checkIP(ctr) || ctr == 0){
                System.out.println("=================");
                System.out.println("From: " + n.getFrom() + "\nTo: " + n.getTo());
            }
            System.out.println(n.getLine());
            ctr++;
        }
    }

    private void add(Node n){
        data.add(n);
    }

    public static void main(String[] args) {
        Parsing p = new Parsing();
        BufferedReader br = null;
        int size, seq, lineSum, check;
        String from, to, line;

        try {
            String input;
            br = new BufferedReader(new FileReader("D:\\School\\CMSC\\CMSC 123\\MP\\src\\Packets\\test3.in"));
            while ((input = br.readLine()) != null) {
                size = p.check(input.substring(0, 32));
                from = p.fromTo(input.substring(32, 64));
                to = p.fromTo(input.substring(64, 96));
                seq = p.check(input.substring(96, 128));
                line = input.substring(128, input.length() - 32);
                lineSum = p.lineSum(line);
                check = p.check(input.substring((input.length() - 32), input.length()));
                Node node = new Node(size, from, to, seq, line, lineSum, check);
                p.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        Collections.sort(p.getData());
        p.displaySort();
        //System.out.println(p.getData());
    }
}
