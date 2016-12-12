package agh.cs.lab8;

public class Article {

    final int number;
    final String content;

    public Article(int number, String content){
        this.number = number;
        this.content = content;
    }
    public String toString(){
        return  "Art. " + this.number + ".\n"  + this.content;
    }

}
