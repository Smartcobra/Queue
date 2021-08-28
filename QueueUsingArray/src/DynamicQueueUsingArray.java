public class DynamicQueueUsingArray {

    private int data[];
    private int front;
    private  int rear;
    private int size;

    DynamicQueueUsingArray(){
       data= new int[10];
       front=-1;
       rear=-1;
    }

    DynamicQueueUsingArray(int capacity){
        data= new int[capacity];
        front=-1;
        rear=-1;
    }

    public  int size(){
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int front() throws QueueEmptyException {
        if(size==0){
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public void enQueue(int element) throws QueueFullException {
        if(size==0){
            front++;
        }
        if(size==data.length){
           // throw  new QueueFullException();
            doubleQueueCapacity();
        }
           rear=(rear+1)%data.length;
        data[rear]=element;
        size++;
    }

    private void doubleQueueCapacity() {
        int tmp[]=data;
        data= new int[tmp.length*2];
        int index=0;
        for(int i=front;i<tmp.length;i++){
            data[index++]=tmp[i];
        }

        for(int i=0;i<front-1;i++){
            data[index++]=tmp[i];
        }
        front=0;
        rear=tmp.length-1;
    }

    public int deQueue() throws QueueEmptyException {
        if(size==0){
            throw new QueueEmptyException();
        }
        int temp=data[front];
        front=(front+1)%data.length;
       size--;
        if(size==0){
            rear=-1;
            front=-1;
        }
        return temp;
    }

    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        //int [] arr={12,3,1,5,6,8,9,13,45,6,7,9,5,32};
        int [] arr={12,3,1,5,6,8,9,23,43,11,8,7,3,1,2};
        DynamicQueueUsingArray dq= new DynamicQueueUsingArray();
        for(int i=0;i<arr.length;i++){
            dq.enQueue(arr[i]);
        }

        while(!dq.isEmpty()){
            System.out.print(dq.deQueue()+" ");
        }
    }

}
