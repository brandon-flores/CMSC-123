import java.util.LinkedList;
import java.util.List;


public class GenNode {
	Descriptor item;
	List<GenNode> children;
	GenNode parent;
	GenNode(int type,GenNode parent,String name){
		children = new LinkedList<>();
		item = new Descriptor(type,name);
		this.parent = parent;
	}
	GenNode(GenNode src){
		item = new Descriptor(src.item);
		parent = src.parent;
		children = src.children;
	}
	public Descriptor getItem() {
		return item;
	}
	public void setItem(Descriptor item) {
		this.item = item;
	}
	public List<GenNode> getChildren() {
		return children;
	}
	public void setChildren(List<GenNode> children) {
		this.children = children;
	}
	public GenNode getParent() {
		return parent;
	}
	public void setParent(GenNode parent) {
		this.parent = parent;
	}
	public void addChildren(GenNode n){
        children.add(n);
    }
	public void removeChildren(GenNode n){
		children.remove(n);
	}
}
