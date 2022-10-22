package priorityqueue;

 class PriorityQueue {
    
    public int MAX;
    public int []arr;
    public int nItems;
    public static int size=0;

    public PriorityQueue(){
        MAX=10;
        arr= new int [MAX];
        nItems =0;

    }
    public void enqueue(int val){
        int i;
        if(nItems == 0){
            arr[0] =val;
            nItems++;
            size+=1;
            return;
        }
        for(i=nItems-1;i>=0;i--){
            if(val>arr[i]){
                arr[i+1]=arr[i];
            }
            else{break;}
        }
        arr[i+1]=val;
        nItems++;
        size+=1;
    }
    public void printPriorityQueue(){
        for(int i=0;i<nItems;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public int dequeue(){
        size-=1;
        return arr[--nItems];
    }
    public boolean isFull(){
        return nItems == MAX;
    }
    public boolean isEmpty(){
        return nItems==0;
    }
    public int getpeek(){
        return arr[nItems-1];
    }
    public int getsize(){
        return size;
    }
    public void getmiddle(){
        int mid;
        int start=0;
        int end=size;
        if(size%2==0){mid=((start+end)/2)+1;}
        else{mid=(start+end)/2;}
        System.out.println("\nMidddle element of the priority queue is: "+arr[mid]);
    }
    public void reverse(){
        for(int i=nItems-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
    }
    public void contains(int x){
        int i;
        int pos=0;
        for(i=0;i<size;i++){
            if(arr[i]==x){
                System.out.println("\nElement present in priority queue at position: "+ pos+1);
                break;
            }
            
        }
        if(i==size){
        System.out.println("\nNot present in the priority queue");}
    }


    
}
