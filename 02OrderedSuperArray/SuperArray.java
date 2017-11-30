public class SuperArray {
    private String[] data;
    private int size;
    private int start;

    public SuperArray() {
	data = new String[10];
	size = 0;
    }
    public SuperArray(int capacity) {
	start = capacity;
    }
    public void clear() {
	data = new String[size];
	size = 0;
    }
    public int size() {
	return size;
    }
    public String[] getData(){
	return data;
    }
    public boolean isEmpty() {
	return size() == 0;
    }
    public boolean add(String element) {
	if (size() >= data.length) {
	    resize();
	}
	data[size] = element;
	size++;
	return true;
    }
    public String toString() {
	String news = "[";
	for (int i = 0; i < size(); i++) {
	    if (i != size()-1) {
		news += data[i];
		news += ", ";
	    }
	    else {
		news += data[i];
	    }
	}	
	return news + "]";
    }
    public String get(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("Not a valid index!");
	}
	return data[index];
    }
    public String set(int index, String element) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("Not a valid index!");
	}
	else {
	    String original = data[index];
	    data[index] = element;
	    return original;
	}
    }
    //private
    private void resize() {
	String[] biggerData = new String[size*2+1];
	for (int i = 0; i < data.length; i++) {
	    biggerData[i] = data[i];
	}
	data = biggerData;
    }
    public boolean contains(String target) {
	String tof = "";
	for (int i = 0; i < size() && !tof.equals("true"); i++) {
	    if (data[i].equals(target)) {
		tof = "true";
	    }
	}
	return tof.equals("true");
    }
    public int indexOf(String target) {
	int index = -1;
	for (int i = 0; i < size() && index == -1; i++) {
	    if (data[i].equals(target)) {
		index = i;
	    }
	}
	return index;
    }
    public int lastIndexOf(String target) {
	int index = -1;
	for (int i = size()-1; i >= 0 && index == -1; i--) {
	    if (data[i].equals(target)) {
		index = i;
	    }
	}
	return index;
    }
    public void add(int index, String element) {
	if (index > 0 && index < size()) {
	    String[] newArray = new String[data.length];
	    for (int i = 0; i <= size(); i++) {
		if (i < index) {
		    newArray[i] = data[i];
		}
		else if (i == index) {
		    newArray[i] = element;
		}
		else {
		    newArray[i] = data[i-1];
		}
	    }
	    data = newArray;
	}
	else {
	    throw new IndexOutOfBoundsException("Not a valid index!");
	}
    }
    public String remove(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException("Not a valid index!");
	}
	else {
	    String[] newArray = new String[data.length];
	    String original = data[index];
	    for (int i = 0; i < size(); i++) {
		if (i < index) {
		    newArray[i] = data[i];
		}
		else {
		    newArray[i] = data[i+1];
		}
	    }
	    data = newArray;
	    return original;
	}
    } 
    public boolean remove(String element) {
	remove(indexOf(element));
	return true;
    }
}
	
