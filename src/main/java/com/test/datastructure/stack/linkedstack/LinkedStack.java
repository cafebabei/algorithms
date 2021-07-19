import com.test.datastructure.stack.IStack;

public class LinkedStack<T> implements IStack<T>
{
    private T data;
    private LinkedStack<T> next;
    private int size = 0;

    public LinkedStack(T data){
        this.data = data;
    }

    @Override
    public void push(T item) {
        LinkedStack<T> nextItem = next;
        next = new LinkedStack(item);
        next.next = nextItem;
        size++;
    }

    @Override
    public T pop() {
        LinkedStack<T> pop = next;
        next = next.next;
        size --;
        return pop.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }



}