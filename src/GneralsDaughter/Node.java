package GneralsDaughter;

/**
 * Created by brandon on 12/14/2016.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by brandon on 12/9/2016.
 */
public class Node {
    private Descriptor descriptor;
    private List<Node> subnodes;
    private Node from;
    private List<String> data;

    Node(Node n) {
        subnodes = new LinkedList<>(n.getSubnodes());
        descriptor = new Descriptor(n.getDescriptor().getType(), n.getDescriptor().getName());
        from = n.getFrom();
        if (from == null) descriptor.setPath("/root");
        else descriptor.setPath(from.getDescriptor().getPath() + "/" + n.getDescriptor().getName());
        if (n.getDescriptor().getType() == -1) data = new ArrayList<>(n.getData());
    }

    Node(int type, Node from, String name) {
        subnodes = new LinkedList<>();
        descriptor = new Descriptor(type, name);
        this.from = from;
        if (from == null) this.descriptor.setPath("/root");
        else this.descriptor.setPath(from.getDescriptor().getPath() + "/" + name);
        if (type == -1) data = new ArrayList<>();
    }

    public Descriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Descriptor descriptor) {
        this.descriptor = descriptor;
    }

    public List<Node> getSubnodes() {
        return subnodes;
    }

    public void setSubnodes(List<Node> subnodes) {
        this.subnodes = subnodes;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public void addSubnodes(Node n) {
        subnodes.add(n);
    }

    public void addString(String s) {
        data.add(s);
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void printData() {
        for (String s : data) {
            System.out.println(s);
        }
    }
}
