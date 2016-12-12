package agh.cs.lab8;

class Article {

    int number;
    String content;

    Article(int number, String content){
        this.number = number;
        this.content = content;
    }
    public String toString(){
        return  "Art. " + this.number + ".\n"  + this.content;
    }

}
