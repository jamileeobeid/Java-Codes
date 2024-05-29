//this class will implement the Heap interface
 
import java.util.Arrays;

public class ArrayHeap implements Heap{
    
    //creating an array
    int [] array;
    int size;

    //creating the heap array method
    public ArrayHeap(){
        size = 0;
        array = new int[3]; //setting a size for our array
    }

    @Override
    public boolean add(int value) {

        if(size==array.length){

            //copyOf copies all array content into another array
            int[] copy = Arrays.copyOf(array, (array.length*2));
            array = copy;

        }
        array[size] = value;

        int child = size;

        //2k+1 is for going from parents to left child. I need to go revert
        int parent = (size-1)/2;

        while(array[parent]>array[child]){
            swap(child,parent);

            //my new parent is now child of another parent
            child = parent;

            //reach to new parent
            parent = (child-1)/2;
        }
        size ++;

        return true;
    }

    private void swap(int a, int b){

        int temp;
        
        if(a!=b){
            temp = array[b];
            array[b] = array[a];
            array[a] = temp;
        }
    }

    @Override
    public int remove() {
        int temp = array[0]; //storing the root into a temprorary variable

        //assigning the last element to the root
        array[0] = array[--size]; //(--)size will decrement first then use later)
        array[size] = 0;

        //creating a variable to hold the new root
        int root = 0;

        //root should have the smallest index
        while(root<size-1){
            if(array[root*2+1] != 0 && array[root*2+2] != 0 && array[root*2+1]<array[root*2+2]){

                //now I am focusing on left child and compare
                if(array[root*2+1] != 0 && array[root]>array[root*2+1]){

                    //swap root and left
                    swap(root, root*2+1);

                    //update the root index
                    root = root * 2+1;
                }

                //if right child is smaller, i don't need to check left because I can only add right if left is full.
                else if(array[root*2+2] !=0 && array[root]>array[root*2+2]){
                    swap(root,root*2+2);
                }
            }
        }
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {

        //Arrays is a Java Collection framework that will print the array values 
        return Arrays.toString(array) + " " + size;
    }

    //creating main method
    public static void main(String[] args) {
        
        ArrayHeap ah = new ArrayHeap(); //creating a heap array
        System.out.println(ah);

        //adding elements to the heap array
        ah.add(7);
        ah.add(10);
        ah.add(21);
        ah.add(60);
        ah.add(50);
        ah.add(43);
        ah.add(24);
        ah.add(68);
        ah.add(66);
        System.out.println(ah);
        ah.remove();
        System.out.println(ah);
        ah.remove();
        System.out.println(ah);
    }

}
