package BST;

public class SplayTree {

  private MyTreeNode root;

  public SplayTree() {
    this.root = null;
  }

  // convenience function for testing
  public Integer root() {
    return root.getData();
  }

  // - copied from BinarySearchTree for convenience
  // - !not correct splay add
  public void add(Integer data) throws Exception {
    this.root = add(root, data);
    //this.root = new MyTreeNode(69);
  }

  private MyTreeNode add(MyTreeNode node, Integer data) throws Exception {
    if (node == null) {
      return new MyTreeNode(data);
    } else if (node.getData().equals(data)) {
      throw new Exception("Item is already in the tree");
    }

    if (data < node.getData()) {
      node.setLeft(add(node.getLeft(), data));
    } else if (data > node.getData()) {
      node.setRight(add(node.getRight(), data));
    }
    return node;
  }

  public boolean splay(Integer data) {
    if(root.getData().equals(data)) return true;
    if(root == null) return false;
    root = splay(root, data);
    //this.root = new MyTreeNode(69);
    //return splay(root, data);
    return this.root.getData().equals(data);
  }

  public MyTreeNode splay(MyTreeNode node, int data){
    if(data > node.getData()){
      if(node.getRight() != null && node.getRight().getData() == data){
        return rotateLeft(node);
      }else if(node.getRight().getRight() != null && data == node.getRight().getRight().getData()){
        node = rotateLeft(node);
        return rotateLeft(node);
      }else if(node.getRight().getLeft() != null && data == node.getRight().getLeft().getData()){
        node.setRight(rotateRight(node.getRight()));
        return rotateLeft(node);
      }else{
        if(data > node.getRight().getData()){
          node.getRight().setRight(splay(node.getRight().getRight(), data));
          node = rotateLeft(node);
          return rotateLeft(node);
        }else{
          node.getRight().setLeft(splay(node.getRight().getLeft(), data));
          node.setRight(rotateRight(node.getRight()));
          return rotateLeft(node);
        }
      }
    }
    if(data < node.getData()){
      if(node.getRight() != null && node.getRight().getData() == data){
        return rotateRight(node);
      }if(node.getLeft().getLeft() != null && data == node.getLeft().getLeft().getData()){
        node = rotateRight(node);
        return rotateRight(node);
      }if(node.getLeft().getRight() != null && data == node.getLeft().getRight().getData()){
        node.setLeft(rotateLeft(node.getLeft()));
        return rotateRight(node);
      }else{
        if(data < node.getRight().getData()){
          node.getLeft().setLeft(splay(node.getLeft().getLeft(), data));
          node = rotateRight(node);
          return rotateRight(node);
        }else{
          node.getLeft().setRight(splay(node.getLeft().getRight(), data));
          node.setLeft(rotateLeft(node.getLeft()));
          return rotateRight(node);
        }
      }
    }
    return node;
  }

  private MyTreeNode rotateLeft(MyTreeNode n) {
    MyTreeNode temp = n.getRight();
    n.setRight(temp.getLeft());
    temp.setLeft(n);
    return temp;
  }

  private MyTreeNode rotateRight(MyTreeNode n){
    MyTreeNode temp = n.getLeft();
    n.setLeft(temp.getRight());
    temp.setRight(n);
    return temp;
  }

  public String toString() {
    return toString(root);
  }

  private String toString(MyTreeNode root) {
    if (root == null) {
      return "";
    } else {
      return toString(root.getLeft()) + root.getData() + " " + toString(root.getRight());
    }
  }


  private class MyTreeNode {
    private Integer data;
    private MyTreeNode left;
    private MyTreeNode right;

    public MyTreeNode(Integer data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public MyTreeNode(Integer data, MyTreeNode left, MyTreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public Integer getData() {
      return data;
    }

    public void setData(Integer data) {
      this.data = data;
    }

    public MyTreeNode getLeft() {
      return left;
    }

    public void setLeft(MyTreeNode left) {
      this.left = left;
    }

    public MyTreeNode getRight() {
      return right;
    }

    public void setRight(MyTreeNode right) {
      this.right = right;
    }

  }
}
