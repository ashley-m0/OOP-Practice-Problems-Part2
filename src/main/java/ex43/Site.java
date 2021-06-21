package ex43;

public class Site {
    private String sitename;
    private String author;
    private boolean javascript;
    private boolean css;

    public Site(String sitename, String author, boolean javascript, boolean css){
        this.sitename = sitename;
        this.author = author;
        this.javascript = javascript;
        this.css= css;
    }

    public void setSiteName(String sitename){
        this.sitename = sitename;
    }

    public String getSiteName(){
        return sitename;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setJavascript(boolean javascript){
        this.javascript = javascript;
    }

    public boolean getJavascript(){
        return javascript;
    }

    public void setCss(boolean css){
        this.css = css;
    }

    public boolean getCss(){
        return css;
    }
}
