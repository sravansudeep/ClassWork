package Lab2;

import java.util.ArrayList;

class Node{
    int data;
    Node next;
}
public class SinglyLinkedList {
    Node head;
    void insertFirst(int key) {
        Node temp = new Node();
        temp.data = key;
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }
    void insert(int pos, int key) {
        Node temp = new Node();
        temp.data = key;
        if (pos == 0) {
            temp.next = head;
            head = temp;
        } else {
            Node curr = head;
            for (int i = 0; i < pos - 1; i++) {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
    }
    void insertLast(int key) {
        Node temp = new Node();
        temp.data = key;
        if (head == null) {
            head = temp;
        } else {
            Node curr = head;
            while (curr.next != null) {  // so we create a temp node and assign it as head
                curr = curr.next;        //then we can traverse it to the next node using while loop, then once it reaches NULL.
            }
            curr.next = temp;  // We can assign the new node to the one last one.
        }
    }
    void isEmpty() {
        Node temp = head;
        if (temp == null) {
            System.out.println("\nThe list is empty!");
        } else {
            System.out.println("\nThe list is not empty!");
        }
    }
    void deleteFirst() {head = head.next;}
    void delete(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
        }
        int cnt = 0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        if(pos>=cnt){
            System.out.println("Given position exceed the size limit!");
            return;
        }
        if (pos == 0) {
            head = head.next;
        }
        temp = head;
        Node prev = null;
        for (int i = 0; i < pos - 1; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;//connection break for prev - temp and connection established between prev - (node after temp).
        temp.next = null; //connection break.
    }
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty!");
        }
        Node temp = head;
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }
    int size() {
        Node temp = head;
        int cnt = 0;
        while (temp.next != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
    void isLastElement(int key) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        if (temp.data == key) {
            System.out.println("\nThe last Element is " + key);
        } else {
            System.out.println("\nThe last Element is not " + key);
        }
    }
    void reverse() {
        Node temp = head;
        Node curr = temp;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp.next != null) {
            arr.add(temp.data);
            temp = temp.next;
        }
        arr.add(temp.data);
        for (int i = 0; i < arr.size(); i++) {
            curr.data = arr.get(arr.size() - i - 1);
            curr = curr.next;
        }
    }
    void print() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
/*void search(int key) {
        Node temp = head;
        int pos = 0;
        while (temp.next != null) {
            pos++;
            if (temp.data == key) {
                System.out.println("Data: " + temp.data + " Node Pos: " + (pos - 1));
                return;
            }
            temp = temp.next;
        }
        if (temp.data == key) {
            System.out.println("Data: " + temp.data + " Node Pos: " + pos);
            return;
        }
        System.out.println("Not found!");
    }*/


