package agh.cs.lab8;

import java.util.LinkedList;

public class Chapter {
    final int number;
    final String title;
    private LinkedList<Article> articles = new LinkedList<>();
    Chapter(int number, String title){
        this.number = number;
        this.title = title;
    }
    public void addArticle(Article article){
        this.articles.add(article);
    }
    public String toString(){
        return "Rozdział " + RomanNumber.fromIntToRoman(this.number) + "\n" + this.title + "\n" + this.toString(new Option(OptionType.Article,this.getFirstArticleNumber(), this.getLastArticleNumber()));
    }
    public String toString(Option option){
        if(option.type != OptionType.Article || option.first < this.getFirstArticleNumber() || option.last > this.getLastArticleNumber()) throw new IllegalArgumentException("Nie poprawne zapytanie o artykuły rodziału");
        StringBuilder answer = new StringBuilder();
        for (Article article: this.articles) {
            if(article.number > option.last) break;
            if(article.number < option.first) continue;
            answer.append(article.toString());
            answer.append("\n");
        }
        return answer.toString();
    }
    public int getFirstArticleNumber(){
        return this.articles.getFirst().number;
    }

    public int getLastArticleNumber(){
        return this.articles.getLast().number;
    }
}
