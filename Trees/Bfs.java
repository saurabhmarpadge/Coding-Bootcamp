package bfs;
import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node left;
    Node right;
    boolean visited = false;
    Node(int input,Node l, Node r){
        data = input;
        left = l;
        right = r;
    }
    public Node[] children(){
        Node[] children = new Node[2];
        children[0] = left;
        children[1] = right;
        return children;
    }
    
}

class Bfstrav{
    private Node root;
    
    Bfstrav(Node input){
        root = input;
        trav();
    }
    
    public void trav(){
        if(root == null){
            return;
        }
        
        LinkedList<Node> ll = new LinkedList<Node>();
        root.visited = true;
        System.out.println(root.data+" ");
        ll.add(root);
        Node curr = root;
        
        while(!ll.isEmpty()){
            for(Node n: curr.children()){
                if(n!=null && !n.visited){
                    System.out.println(n.data+" ");
                    n.visited = true;
                    ll.add(n);
                }
            }
            ll.removeFirst();
            curr = ll.peekFirst();
        }
        
    }
}

class  Bfs{
    
    public static void main(String args[]){
        Node three = new Node(3,null,null);
        Node two = new Node(2,null,null);
        Node one = new Node(1,null,null);
        Node four = new Node(4,null,null);
        Node five = new Node(5,null,null);
        Node six = new Node(6,null,null);
        Node seven = new Node(7,null,null);
        
        four.left = one;
        one.left = two;
        one.right = three;
        four.right = five;
        five.left = six;
        five.right = seven;
        Bfstrav hey = new Bfstrav(four);
    }
    
}
//  Coding bootcamp
/*package bfs;
import java.util.*;
import java.io.*;

class Node{
    int value;
    Node left;
    Node right;
    boolean visited = false;
    
    Node(int v, Node l,Node r){
        value = v;
        left = l;
        right = r;
    }
    
    public Node[] children(){
        Node[] children = new Node[2];
        children[0] = left;
        children[1] = right;
        return children;
    }
}

public class Bfs {
    private Node root;
    
    Bfs(Node first){
        root = first;
        traverseIterative();
    }
    void traverseIterative(){
        if(root == null){
            return;
        }
        
        LinkedList<Node> ll = new LinkedList<Node>();;
        root.visited = true;
        System.out.print(root.value+" ");
        ll.add(root);
        Node curr = root;
        
        while(!ll.isEmpty()){
            for(Node n: curr.children()){
                if(n != null && !n.visited){
                   System.out.print(n.value+" ");
                   ll.add(n);
                   n.visited = true;
                }
            }
            ll.removeFirst();
            curr = ll.peekFirst();
        }
    }
    public static void main(String[] args) {
        Node three_first = new Node(3, null,null);
        Node two = new Node(2, null,null);
        Node four = new Node(4, null,null);
        Node six = new Node(6, null,null);
        Node eight = new Node(8, null,null);
        Node nine = new Node(9, null,null);
        Node ten = new Node(10, null,null);
        
        three_first.left = two;
        three_first.right = four;
        two.left = six;
        two.right = eight;
        four.left = nine;
        four.right = ten;
        
        Bfs perm = new Bfs(three_first);
    }
    
    
}
*/
