package Lab7;

import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BSTNode {
    protected int data;
    protected BSTNode left;
    protected BSTNode right;

    public BSTNode() {
    }

    public BSTNode(int d) {
        data = d;
    }

    public void insert(int key) {
        if (key < data) {
            if (left == null)
                left = new BSTNode(key);
            else
                left.insert(key);
        } else {
            if (right == null)
                right = new BSTNode(key);
            else
                right.insert(key);
        }
    }

    public void inorder() {
        if (left != null){
            left.inorder();}
        System.out.print(data + " ");
        if (right != null){
            right.inorder();}
    }

    public void preorder() {
        System.out.print(data + " ");
        if (left != null){
            left.preorder();}
        if (right != null){
            right.preorder();}
    }

    public void postorder() {
        if (left != null){
            left.postorder();}
        if (right != null){
            right.postorder();}
        System.out.print(data + " ");
    }

    public boolean search(int key) {
        if (key == data){
            return true;}
        else if (key < data && left != null){
            return left.search(key);}
        else if (key > data && right != null){
            return right.search(key);}
        else{
            return false;}
    }
    public void delete(int key){
        if(left!=null && left.data == key){
            if(left.isleaf()){
                left = null;
            }else if(left.hasOnlyLeft()){
                left = left.left;
            } else if (left.hasOnlyRight()) {
                left = left.right;
            }else {
                if(left.left.hasOnlyLeft() || left.left.isleaf()) {
                    left.data = left.left.data;
                    left.left = left.left.left;
                }else{
                    BSTNode PredParent = left.left;
                    BSTNode Pred = PredParent.right;
                    while(Pred.right!= null){
                        PredParent = Pred;
                        Pred = Pred.right;
                    }
                    left.data = Pred.data;
                    PredParent.right = Pred.left;
                }
            }
        }else if(right!=null && right.data == key) {
            if (right.isleaf()) {
                right = null;
            } else if (right.hasOnlyLeft()) {
                right = right.left;
            } else if (right.hasOnlyRight()){
                right = right.right;
            }else{
                if(right.left.hasOnlyLeft() || right.left.isleaf()){
                    right.data = right.left.data;
                    right.left=right.left.left;
                }else{
                    BSTNode PredParent = right.left;
                    BSTNode Pred = PredParent.right;
                    while(Pred.right!=null){
                        PredParent = Pred;
                        Pred = Pred.right;
                    }
                    right.data = Pred.data;
                    PredParent.right = Pred.left;
                }
            }
        }else if(left!=null && key < data){
            left.delete(key);
        }else if(right != null && key > data){
            right.delete(key);
        }
    }
    public boolean isleaf(){return left==null && right == null;}
    public boolean hasOnlyLeft(){return left!=null && right == null;}
    public boolean hasOnlyRight(){return left==null && right!=null;}
    public int smallest(int n){
        if (left != null) {
            n = left.smallest(n);
        }
        if(data < n){
            n = data;
        }
        if (right != null) {
            n = right.smallest(n);
        }
        return n;
    }
    public int largest(int n){
        if (left != null) {
            n = left.largest(n);
        }
        if(data > n){
            n = data;
        }
        if (right != null) {
            n = right.largest(n);
        }
        return n;
    }
}
class BST{
    protected BSTNode root;
    public void insert(int key){
        if(root == null){
            root = new BSTNode(key);
        }else{
            root.insert(key);
        }
    }
    public void preorder(){
        if(root == null){
            return;
        }else{
            root.preorder();
        }
    }
    public void postorder(){
        if(root == null){
            return;
        }else{
            root.postorder();
        }
    }
    public void inorder(){
        if(root == null){
            return;
        }else{
            root.inorder();
        }
    }
    public boolean search(int key){
        return root!=null && root.search(key);
    }
    public void delete(int key){
        if(root==null){
            return;
        }else if(root.data!=key){
            root.delete(key);
        }else{
            BSTNode dummy = new BSTNode();
            dummy.left = root;
            root=dummy;
            root.delete(key);
            root=root.left;

        }
    }
    public void levelorder() {
        ArrayDeque<BSTNode> deq = new ArrayDeque<>();
        deq.addLast(root);
        while (!deq.isEmpty()) {
            BSTNode n = deq.removeFirst();
            System.out.print(n.data + " ");
            if (n.left != null) {
                deq.addLast(n.left);
            }
            if (n.right != null)
                deq.addLast(n.right);
        }
        System.out.println();
    }
    public void smallest(){
        if(root==null){
            System.out.println("There is no Binary Tree");
        }else {
            System.out.println("Smallest Value: "+root.smallest(root.data));
        }
    }
    public void largest(){
        if(root==null){
            System.out.println("There is no Binary Tree");
        }else {
            System.out.println("Smallest Value: "+root.largest(root.data));
        }
    }

    public static void main(String[] args) {
        BST BinaryOne = new BST();
        // Inserting numbers into the BinaryOne BST
        BinaryOne.insert(6);
        BinaryOne.insert(9);
        BinaryOne.insert(5);
        BinaryOne.insert(2);
        BinaryOne.insert(8);
        BinaryOne.insert(15);
        BinaryOne.insert(24);
        BinaryOne.insert(14);
        BinaryOne.insert(7);
        //Traversal
        System.out.println("Preorder: ");
        BinaryOne.inorder();
        System.out.println("\nInorder: ");
        BinaryOne.inorder();
        System.out.println("\nPostorder: ");
        BinaryOne.postorder();
        System.out.println("\nLevelOrder: ");
        BinaryOne.levelorder();
        //Searching
        Scanner sc = new Scanner(System.in);
        System.out.print("Type in element you want to search: ");
        int key = sc.nextInt();
        if(BinaryOne.search(key)){
            System.out.println(key+" does exist in the BST");
        }else{
            System.out.println(key+" does not exist in the BST");
        }
        //Finding Smallest & Largest in the Tree
        BinaryOne.smallest();
        BinaryOne.largest();
    }
}
