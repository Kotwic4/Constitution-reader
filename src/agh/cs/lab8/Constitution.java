package agh.cs.lab8;

import java.util.LinkedList;

public class Constitution {

    LinkedList<Chapter> chapters = new LinkedList<>();
    void addChapter(Chapter chapter){
        this.chapters.add(chapter);
    }
    public String toString() {
        return this.toString(new Option(OptionType.Chapter,this.getFirstChapterNumber(),this.getLastChapterNumber()));
    }
    public String toString(Option option){
        StringBuilder answer = new StringBuilder();
        if(option.type == OptionType.Article){
            if(option.first < this.getFirstArticleNumber() || option.last > this.getLastArticleNumber()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
            for (Chapter chapter: this.chapters) {
                if(chapter.getFirstArticleNumber() > option.last) break;
                if(chapter.getLastArticleNumber() < option.first) continue;
                answer.append(chapter.toString(new Option(OptionType.Article,Math.max(chapter.getFirstArticleNumber(),option.first),Math.min(chapter.getLastArticleNumber(),option.last))));
                answer.append("\n");
            }
        }
        else if(option.type == OptionType.Chapter){
            if(option.first < this.getFirstChapterNumber() || option.last > this.getLastChapterNumber()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
            for (Chapter chapter: this.chapters) {
                if(chapter.number > option.last) break;
                if(chapter.number < option.first) continue;
                answer.append(chapter.toString());
                answer.append("\n");
            }
        }
        else{
            throw new IllegalArgumentException(); //// TODO: 12.12.2016
        }
        return answer.toString();
    }

    public int getFirstChapterNumber(){
        if(chapters.isEmpty()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        return chapters.getFirst().number;
    }

    public int getLastChapterNumber(){
        if(chapters.isEmpty()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        return chapters.getLast().number;
    }
    public int getFirstArticleNumber(){
        if(chapters.isEmpty()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        return chapters.getFirst().getFirstArticleNumber();
    }

    public int getLastArticleNumber(){
        if(chapters.isEmpty()) throw new IllegalArgumentException(); //// TODO: 12.12.2016
        return chapters.getLast().getLastArticleNumber();
    }
    
    
}
