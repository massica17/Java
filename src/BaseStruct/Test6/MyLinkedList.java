package BaseStruct.Test6;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyLinkedList<E> {
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    private Node<E> Head;
    private Node<E> Last;
    private int length = 0;



    public MyLinkedList(){

    }

    public Node<E> getHead() {
        return Head;
    }

    public void setHead(Node<E> head) {
        Head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void add(){
        Scanner cin = new Scanner(System.in);
        System.out.print("请输入节点");
        String data;
        do {
            data = cin.next();
            if(this.Head == null){
                Head = new Node<E>((E) data, null);
                Last = Head;
                this.length++;
            }
            else{
                Last.setNext(new Node<E>((E) data, null));
                Last = Last.getNext();
                this.length++;
            }
        } while (!"exit".equals(data));
    }

    public Node<E> reverse(int start, int end){
        if(start < 0 || end > length) return null;
        int count = 0;
        if(this.Head == null){
            System.out.println("此链表为空");
        }
        Node<E> temp = this.Head;
        Node<E> r_start = null;
        Node<E> r_end = null;
        List<E> datas = new ArrayList<>();
        while(temp != null){
            count++;
            datas.add(temp.getData());
            if(count == start) r_start = temp;
            if(count == end){
                r_end = temp;
                break;
            }
            temp = temp.getNext();
        }
        int nums = datas.size();
        if(r_start == null) return null;
        for(int i = 0; i < nums; i++){
            r_start.setData(datas.get(nums - 1 - i));
            r_start = r_start.getNext();
        }
        return this.getHead();
    }

    public void foreach(Node<E> Head){
        if(Head == null){
            System.out.println("此链表为空");
        }
        else{
            Node<E> temp = Head;
            while(temp != null){
                System.out.print(temp.getData());
                System.out.print(" ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }
}
