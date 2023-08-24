package Test4;

import java.util.Arrays;
import java.util.List;

public class MyArrayList<E>{
    private Object[] elements = {};
    private int size = 0;
    private int expend_size = 16;

    public MyArrayList() {
    }

    public MyArrayList(int size){
        elements = new Object[size];
    }

    private void grow(){
        if(elements.length == 0){
            elements = new Object[this.expend_size];
        }
        else{
            elements = Arrays.copyOf(elements, elements.length >> 1);
        }
    }
    public boolean add(E e){
        if(size == elements.length){
            grow();
        }
        elements[size] = e;
        size++;
        return true;
    }

    private void checkIndex(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("索引越界");
        }
    }
    public E get(int index){
        checkIndex(index);
        return (E) elements[index];
    }

    public boolean remove(int index){
        checkIndex(index);

        for(int i = index; i < size; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        return true;
    }

    public boolean insert(E e, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        if(size + 1 > elements.length) grow();
        for(int i = size; i >= index + 1; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        return true;
    }

    public void foreach(MyForeachFunction<E> my_interface){
        for(int i = 0; i < size; i++){
            my_interface.action((E) elements[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i = 0; i < size - 1; i++){
            res.append(String.format("%s, ", elements[i]));
        }
        res.append(String.format("%s]%n", elements[size - 1]));
        return res.toString();
    }
}