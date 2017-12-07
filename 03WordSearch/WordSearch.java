import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenorefoundexception

public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public WordSearch(int rows,int cols){
	data = new char[rows][cols];
	clear();
    }
    private void clear(){
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j++) {
		data[i][j] = '_';
	    }
	}						      
    }

    public WordSearch(int rows,int cols,String filename) {
	data = new char[rows][cols];
	clear();
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	randgen = new Random();
        try{
	    Scanner in = new Scanner(new File(filename));
	    while (in.hasNext()) {
		wordsToAdd.add(in.next().toUpperCase());
	    }
	}
	catch(FileNotFoundException e) {
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
    }
    public WordSearch(int rows,int cols,String filename,int randomSeed) {
	data = new char[rows][cols];
	clear();
	wordsToAdd = new ArrayList<String>();
	wordsAdded = new ArrayList<String>();
	randgen = new Random(randomSeed);
        try{
	    Scanner in = new Scanner(new File(filename));
	    while (in.hasNext()) {
		wordsToAdd.add(in.next().toUpperCase());
	    }
	}
	catch(FileNotFoundException e) {
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
    }
    
    
    
    private boolean addWord(int r, int c, String word,int rowIncrement, int colIncrement) {
	if (rowIncrement != 0 || colIncrement != 0) {
	    if (addWordHorizontal(word,r,c) || addWordVertical(word,r,c) || addWordDiagonal(word,r,c)) {
		for (int i = 0; i < word.length(); i++) {
		    data[r][c] = word.charAt(i);
		    r += rowIncrement;        //negatives don't work??
		    c += colIncrement;
		}
		wordsAdded.add(word);
		wordsToAdd.remove(word);
		return true;
	    }
	    return false;
	}
	return false;
    }
    private boolean addAllWords() {
	int triesLeft = 1000;
	while (wordsToAdd.size() > 0 || triesLeft > 0) {
	    int word = randgen.nextInt(wordsToAdd.size());
	    int r = randgen.nextInt(data.length);
	    int c = randgen.nextInt(data[0].length);
	    int rInc = randgen.nextInt(3) - 1;
	    int cInc = randgen.nextInt(3) - 1;
	    addWord(r,c,wordsToAdd.get(word),rInc,cInc);    //apparently ArrayIndexOutOfBounds
	    triesLeft -= 1;
	}
	return wordsToAdd.size() == 0;
    }

    public String toString(){
	String wordGrid = "";
	for (int i = 0; i < data.length; i++) {
	    for (int j = 0; j < data[i].length; j++) {
		wordGrid += data[i][j] + " ";
	    }
	    wordGrid += "\n";
	}
	return wordGrid;
    }

    public boolean addWordHorizontal(String word,int row,int col){
	if (col + word.length() <= data[row].length) {
	    for (int i = col; i < col+word.length(); i++) {
		return data[row][i] == '_' || data[row][i] == word.charAt(i-col) ;
	    }
	}
	return false;
    }
    public boolean addWordVertical(String word,int row, int col){
	if (row + word.length() <= data.length) {
	    for (int i = row; i < row+word.length(); i++) {
		return data[i][col] == '_' || data[i][col] == word.charAt(i-row);
	    }
	}
	return false;
    }
    public boolean addWordDiagonal(String word,int row, int col){
	if (row+word.length() <= data.length && col+word.length() <= data[row].length) {
	    int i = row;
	    int j = col;
	    for (;i < row+word.length() && j < col+word.length();i++,j++) {
		return data[i][j] == '_' || data[i][j] == word.charAt(i-row);
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	WordSearch a = new WordSearch(10,10,"words.txt");
	WordSearch b = new WordSearch(5,6);
	//System.out.println(a.toString());
        System.out.println(a.toString(args));
	//System.out.println(c.toString());

	//System.out.println(a.addWord(1,1,"beef",1,0));
	//System.out.println(a.addWord(5,6,"cat",0,0));
	//System.out.println(a.addWord(9,9,"cat",-1,0));
	System.out.println(a.addAllWords());
	System.out.println(a.toString());
    }
}


