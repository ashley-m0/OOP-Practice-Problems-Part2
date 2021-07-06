package ex45;

public class WordFinder {
    private String searchWord;
    private String changeWord;

    public WordFinder(String searchWord, String changeWord){
        this.searchWord = searchWord;
        this.changeWord = changeWord;
    }

    public String getChangeWord(){
        return changeWord;
    }

    public String getSearchWord(){
        return searchWord;
    }
}
