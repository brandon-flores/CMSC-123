package Directory;

import java.util.*;

/**
 * Created by brandon on 12/9/2016.
 */
public class Tree {
    Node root;
    Node current;

    Tree(){
        root = new Node(1, null, "root");
        current = root;
    }

    void insert(String s, int i){
        current.addSubnodes(new Node(i, current, s));
    }

    boolean delete(){
        return false;
    }

    boolean search(String s){
        for(Node n : current.getSubnodes()){
            if(n.getDescriptor().getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    void edit(String s){
        Node temp = null;
        if(!search(s)){
            insert(s, -1);
        }
        for(Node n : current.getSubnodes()){
            if(n.getDescriptor().getName().equals(s)) {
                temp = n;
                break;
            }
        }
        temp.printData();
        Scanner scanner = new Scanner(System.in);
        String readString = scanner.nextLine();
        while(readString != null) {
            temp.addString(readString);
            if (readString.isEmpty()) {
                readString = null;
            }
            else{
                if (scanner.hasNextLine()) {
                    readString = scanner.nextLine();
                    //if (!readString.isEmpty()) ctr = 0;
                } else {
                    readString = null;
                }
            }

        }
        temp.getDescriptor().setMod(new Date());
    }

    boolean changeCurrent(String s){
        if(s.equals("..")){
            if(current.getFrom() != null) current = current.getFrom();
        }else{
            if(!search(s)) {
                System.out.println("The system cannot find the path specified. ");
                return false;
            }
            else{
                for(Node n : current.getSubnodes()){
                    if(n.getDescriptor().getName().equals(s)) {
                        if(n.getDescriptor().getType() == 1){
                            current = n;
                            return true;
                        }
                        else {
                            System.out.println("The directory name is invalid");
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    void remove(String s, boolean flag){
        Iterator<Node> iter = current.getSubnodes().iterator();
        while(iter.hasNext()){
            Node n = iter.next();
            if(n.getDescriptor().getName().equals(s)){
                if(flag){
                    if(n.getDescriptor().getType() != 1) iter.remove();
                    else System.out.println("Not a file");
                }else{
                    if(n.getDescriptor().getType() == 1) iter.remove();
                    else System.out.println("Not a directory");
                }
                break;
            }
        }
    }

    void remove(String s){
        Iterator<Node> iter = current.getSubnodes().iterator();
        while(iter.hasNext()){
            if(iter.next().getDescriptor().getName().endsWith(s)){
                iter.remove();
            }
        }
    }

    void list(){
        for(Node n : current.getSubnodes()){
            System.out.println(n.getDescriptor().getName() + " \t\tCreated: " + n.getDescriptor().getOrig() +
            " \t\tLast Modified: " + n.getDescriptor().getMod());
        }
    }

    void list(String s){
        for(Node n : current.getSubnodes()){
            if(n.getDescriptor().getName().endsWith(s)){
                System.out.println(n.getDescriptor().getName() + " \t\tCreated: " + n.getDescriptor().getOrig() +
                        " \t\tLast Modified: " + n.getDescriptor().getMod());
            }
        }
    }

    void show(String s){
        if(!search(s)) System.out.println("The system cannot find the path specified. ");
        else{

            for(Node n : current.getSubnodes()){
                if(n.getDescriptor().getName().equals(s)) {
                    if(n.getDescriptor().getType() == -1) {
                        n.printData();
                    }
                    else System.out.println("Not a file!");
                    break;
                }
            }
        }
    }

    void printLoc(){
        System.out.print(current.getDescriptor().getPath() + "\t\t");
    }

    public void whereis(String s) {
        Node temp = root;
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            Node node = q.remove();
            String ss = node.getDescriptor().getName();
            if(ss.equals(s)) System.out.println(node.getDescriptor().getPath());
            for (Node n : node.getSubnodes()) {
                q.add(n);
            }
        }
    }

    public void rename(String s, String s1) {
        if(!search(s)) System.out.println("The system cannot find the path specified. ");
        else{
            for(Node n : current.getSubnodes()){
                if(n.getDescriptor().getName().equals(s)) {
                    if(n.getDescriptor().getType() == -1) {
                        n.getDescriptor().setName(s1);
                    }
                    else System.out.println("Not a file!");
                    break;
                }
            }
        }
    }

    public void move(String s, String s1) {
        if(!search(s)) System.out.println("The system cannot find the path specified. ");
        else{
            boolean flag = false;
            Node move = null;
            for(Node n : current.getSubnodes()){
                if(n.getDescriptor().getName().equals(s)) {
                    if(n.getDescriptor().getType() != 1){
                        move = new Node(n);
                        remove(n.getDescriptor().getName());
                    }
                    else{
                        System.out.println("Not a file!");
                        flag = true;
                    }
                }
            }
            //System.out.println(search(move.getDescriptor().getName()));
            //System.out.println(move.getDescriptor().getName());
            if(!flag){
                Node temp = root;
                Node ans = null;
                Queue<Node> q = new LinkedList<>();
                q.add(temp);
                while(!q.isEmpty()){
                    Node node = q.remove();
                    String ss = node.getDescriptor().getPath();
                    if(ss.equals(s1)){
                        if(node.getDescriptor().getType() != 1){
                            System.out.println("Not a Directory!");
                            flag = true;
                        }
                        else{
                            ans = node;
                        }
                        break;
                    }
                    for (Node n : node.getSubnodes()) {
                        q.add(n);
                    }
                }
                if(!flag){
                    if(ans != null){
                        //ans.getSubnodes().add(move);
                        ans.addSubnodes(move);
                    }else{
                        current = root;
                        String[] str = s1.split("/");
                        int i = 1;
                        while(i < str.length - 1){
                            if(!changeCurrent(str[i])){
                                System.out.println("Created directory instead");
                                insert(str[i], 1);
                                changeCurrent(str[i]);
                            }
                            i++;
                        }
                        move.setFrom(current);
                        current.addSubnodes(move);
                    }
                }
            }
        }
    }

    public void copy(String s, String s1) {
        if(!search(s)) System.out.println("The system cannot find the path specified. ");
        else{
            Node copy = null;
            for(Node n : current.getSubnodes()){
                if(n.getDescriptor().getName().equals(s)) {
                    copy = n;
                }
            }
            if(copy != null){
                Node n = new Node(copy);
                n.getDescriptor().setName(s1);
                current.addSubnodes(n);
            }
        }
    }
}
