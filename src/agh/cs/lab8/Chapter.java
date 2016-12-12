package agh.cs.lab8;

import java.util.LinkedList;

class Chapter {
    int number;
    String title;
    LinkedList<Article> articles = new LinkedList<>();
    Chapter(int number, String title){
        this.number = number;
        this.title = title;
    }
    void addArticle(Article article){
        this.articles.add(article);
    }
    public String toString(){
        return "Rozdział " + RomanDigit.fromIntToRoman(this.number) + "\n" + this.title + "\n" + this.toString(new Option(OptionType.Article,this.getFirstArticleNumber(), this.getLastArticleNumber()));
    }
    String toString(Option option){
        if(option.type != OptionType.Article || option.first < this.getFirstArticleNumber() || option.last > this.getLastArticleNumber()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        StringBuilder answer = new StringBuilder();
        for (Article article: this.articles) {
            if(article.number > option.last) break;
            if(article.number < option.first) continue;
            answer.append(article.toString());
            answer.append("\n");
        }
        return answer.toString();
    }
    int getFirstArticleNumber(){
        if(this.articles.isEmpty()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        return this.articles.getFirst().number;
    }

    int getLastArticleNumber(){
        if(this.articles.isEmpty()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        return this.articles.getLast().number;
    }
}
