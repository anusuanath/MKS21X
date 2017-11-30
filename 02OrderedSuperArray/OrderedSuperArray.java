public class OrderedSuperArray extends SuperArray{
    
    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int capacity) {
	super(capacity);
    }

    public OrderedSuperArray(String[] ary) {
	for (int i = 0; i < size(); i++) {
	    ary[i] = super.getData()[i];
	}
    }

    public String set(int index, String element) {
	throw new UnsupportedOperationException();
    }

    public int indexOfBinary(String element) {
	int index = -1;
	int lower = 0;
	int upper = size()-1;
	for (int i = upper/2; i < size() && index == -1; ) {
	    if (element.compareTo(getData()[i]) < 0) {
		upper = i;
		i = (lower+upper)/2;
	    }
	    else if (element.compareTo(getData()[i]) > 0) {
		lower = i;
		i = (lower+upper)/2;
	    }
	    else {
		index = i;
		while (getData()[i-1].equals(element)) {
		    i--;
		    index = i;
		}
	    }
	}
	return index;
    }
    public int lastIndexOf(String element) {
	int index = -1;
	int lower = 0;
	int upper = size()-1;
	for (int i = upper/2; i < size() && index == -1; ) {
	    if (element.compareTo(getData()[i]) < 0) {
		upper = i;
		i = (lower+upper)/2;
	    }
	    else if (element.compareTo(getData()[i]) > 0) {
		lower = i;
		i = (lower+upper)/2;
	    }
	    else {
		index = i;
		while (getData()[i+1].equals(element)) {
		    i++;
		    index = i;
		}
	    }
	}
	return index;
    }
    
    /*call the proper add.*/
    public void add(int index, String value){
	add(value);
    }
    
    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String value){
	//add to the correct spot.
	//you may still use super.add(index,value)
	if (size() == getData().length) {
	    resize();
	}
	//index = findIndex(value);
	int index = findIndexBinary(value);
	super.add(index,value);
	return true;
    }

    //to find the index
    private int findIndex(String value) {
	int index = 0;
	for (int i = 0; i < getData().length && index == 0;) {
	    if (value.compareTo(getData()[i]) <= 0) {
		index = i;
	    }
	    else {
		i++;
	    }
	}
	return index;
    }
    private int findIndexBinary(String value) {
	int index = -1;
	int lower = 0;
	int upper = size()-1;
	for (int i = upper/2; i < size() && index == -1; ) {
	    if (value.compareTo(getData()[i]) < 0) {
		upper = i;
		i = (lower+upper)/2;
	    }
	    else if (value.compareTo(getData()[i]) > 0) {
		lower = i;
		i = (lower+upper)/2;
	    }
	    else {
		index = i;
		while (getData()[i+1].equals(value)) {
		    i++;
		    index = i;
		}
	    }
	}
	return index;
    }

}
