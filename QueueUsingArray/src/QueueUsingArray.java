import java.util.Arrays;

public class QueueUsingArray {

    private int data[];
    private int front;
    private int rear;
    private int size;

    QueueUsingArray() {
        data = new int[10];
        front = -1;
        rear = -1;
    }

    QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public void enqueue(int element) throws QueueFullException {
        if (size == 0) {
            front = 0;
        }
        if (size == data.length) {
            throw new QueueFullException();
        }
       /*below lines are can be replaced by line 45
        rear++;
        if(rear==data.length){
            rear=0;
        }*/
       rear=(rear+1)%data.length;
        data[rear] = element;
        size++;

    }

    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int tmp = data[front];
     /* below lines are can be replaced by line 59
     front++;
        if(front==data.length){
            front=0;
        }*/
      front=(front+1)%data.length;
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return tmp;

    }
    public void printElement(){
        Arrays.stream(data).forEach(t->System.out.print(t+" "));
        System.out.println();
    }


    public static void main(String[] args) throws QueueFullException {
        QueueUsingArray queue= new QueueUsingArray();
        System.out.println("Size::"+queue.size);
        System.out.println("front::"+queue.front);
        System.out.println("After------------");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.printElement();
        System.out.println("Size::"+queue.size);
        System.out.println("front::"+queue.front);
    }
}
