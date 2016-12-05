import java.util.List;

/**
 * Created by Kotwic4 on 05.12.2016.
 */
public class Chapter {
    int number;
    String title;
    List<Article> articles;
    Chapter(int number, String title){}
    void addArticle(Article article){}
    public String toString(){
        //Return whole chapter
    }
    public String toString(int firstArticleNumber){
        //Return from firstArticleNumber to the end of chapter
    }
    public String toString(int firstArticleNumber, int lastArticleNumber){
        //Return from firstArticleNumber to lastArticleNumber
    }
}
