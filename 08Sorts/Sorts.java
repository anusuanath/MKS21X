import java.util.Arrays;

public class Sorts{
    
    public static String name(){
	return "10.Nath.Anusua"; 
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
    
    public static void selectionSort(int[] data){
	for (int i = 0; i < data.length; i++) {
	    int lower = data[i];
	    int index = i;
	    for (int j = i; j < data.length; j++) {
		if (data[j] < lower) {
		    lower = data[j];
		    index = j;
		}
	    }
	    data[index] = data[i];
	    data[i] = lower;	
	}
    }

    public static void insertionSort(int[] data) {
 	for (int i = 1; i < data.length; i++) {
	    for (int j = i; j < data.length; j++) {
		if (data[j] < data[j-1]) {
		    int lower = data[j];
		    data[j] = data[j-1];
		    data[j-1] = lower;
		}
	    }		
	}
    }

    public static void bubbleSort(int[] data) {
	int countPasses = 0;
	for (int i = 0; i < data.length && countPasses < data.length; i++) {
	    for (int j = 1; j < data.length; j++) {
		if (data[j-1] > data[j]) {
		    int higher = data[j-1];
		    data[j-1] = data[j];
		    data[j] = higher;
		}
	    }
	    countPasses++;
	}
    }
    
    public static void main(String[] args) {
	int[] randish = new int[5];
        for(int i = 0 ; i < randish.length; i++) {
            randish[i] =(int)(Math.random()*100);  
        }                                            
                                     
	// System.out.println(Arrays.toString(randish));
	//bogoSort(randish);
	//System.out.println(Arrays.toString(randish));
       
	//System.out.println(Arrays.toString(randish));
	//selectionSort(randish);
	//System.out.println(Arrays.toString(randish));

	//System.out.println(Arrays.toString(randish));
	//insertionSort(randish);
	//System.out.println(Arrays.toString(randish));

	//System.out.println(Arrays.toString(randish));
	//bubbleSort(randish);
	//System.out.println(Arrays.toString(randish));
     }
}


