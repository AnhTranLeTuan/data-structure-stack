public class Stack<E> {
    private E[] collection = (E[]) new Object[10];
    private int arraySize = 10;
    private int counter;

    public Stack(){}

    public Stack(int arraySize){
        collection = (E[]) new Object[arraySize];
        this.arraySize = arraySize;
    }

    public void push(E item) {
        if (item == null)
            throw new IllegalArgumentException();

        if (counter == arraySize)
            doubleArraySize();

        collection[counter++] = item;
    }

    public E pop() {
        if (counter == 0)
            return null;

        E item = collection[--counter];
        collection[counter] = null;
        return item;
    }

    public E peek() {
        if (counter == 0)
            return null;

        return collection[counter - 1];
}


    public boolean isEmpty(){
        return counter == 0;
    }

    private void doubleArraySize(){
        arraySize = arraySize * 2;
        E[] tempArray = (E[]) new Object[arraySize];

        for (int i = 0; i < collection.length; i++)
            tempArray[i] = collection[i];

        collection = tempArray;
    }

}
