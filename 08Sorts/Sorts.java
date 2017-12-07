import java.util.Arrays;

public class Sorts{
    /**EDIT THIS METHOD TO MATCH YOUR NAME 
     */
    public static String name(){
	return "01.Nath.Anusua"; 
    }

    public static boolean isSorted(int[] ary) {
	for(int i = 0; i < ary.length - 1 ; i++) {
	    if(ary[i] > ary[i+1]) {
		return false;
	    }
	}
	return true;
    }

    public static void bogoSort(int[] ary) {
	while (!isSorted(ary)) {
	    for (int i = 0; i < ary.length; i++) {
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i] = ary[newSpot];
		ary[newSpot] = temp;
	    }
	}
    }
    private static void swap(int[] ary, int a, int b) {
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }
    
    /**Selection sort of an int array. 
     *Upon completion, the elements of the array will be in increasing order.
     *@param data  the elements to be sorted.
     */
    public static void selectionSort(int[] data){
	int[] sorted = new int[data.length];
	while (data.length > 0) {
	    int lower = data[0];
	    for (int i = 0; i < data.length; i++) {
		if (data[i] <= lower) {
		    lower = data[i];
		}
	    }
	    sorted.add(lower);
	    data.remove(lower);
	}
    }

    public static void insertionSort(int[] data) {
	int lower = data[0];
	int higher = data[1];
	for (int i = 0; i < data.length-1; i++) {
	    if (data[i] > data[i+1]) {
		lower = data[i+1];
		higher = data[i];
		swap(data,lower,higher);
	    }
	}		
    }
    
    public static void main(String[] artie) {                           
        for(int i = 0 ; i < randish.length; i++) {
            randish[i] =(int)(Math.random()*100);  
        }                                            
        int a = 10, b = 20;  
        swap(a,b);   
        System.out.println(a + " " + b );                                 
        System.out.println(Arrays.toString(randish));
	//      bogoSort(randish);
	System.out.println(Arrays.toString(randish));
     }
}


