package ex46;

public class WordDetector {

    private String word;
    private int count;

    public WordDetector(String word, int count){
        this.word = word;
        this.count = count;
    }

    public String getWord(){
        return word;
    }

    public int getCount(){
        return count;
    }

    public void addToCount(){
        count++;
    }
}
