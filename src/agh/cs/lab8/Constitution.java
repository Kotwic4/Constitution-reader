package agh.cs.lab8;

import java.util.LinkedList;

class Constitution {

    private LinkedList<Chapter> chapters = new LinkedList<>();
    public void addChapter(Chapter chapter){
        this.chapters.add(chapter);
    }
    public String toString() {
        return this.toString(new Option(OptionType.Chapter,this.getFirstChapterNumber(),this.getLastChapterNumber()));
    }
    public String toString(Option option){
        StringBuilder answer = new StringBuilder();
        if(option.type == OptionType.Article){
            if(option.first < this.getFirstArticleNumber() || option.last > this.getLastArticleNumber()) throw new IllegalArgumentException("Nie poprawne zapytanie o artykuly konstytucji");
            for (Chapter chapter: this.chapters) {
                if(chapter.getFirstArticleNumber() > option.last) break;
                if(chapter.getLastArticleNumber() < option.first) continue;
                answer.append(chapter.toString(new Option(OptionType.Article,Math.max(chapter.getFirstArticleNumber(),option.first),Math.min(chapter.getLastArticleNumber(),option.last))));
            }
        }
        else if(option.type == OptionType.Chapter){
            if(option.first < this.getFirstChapterNumber() || option.last > this.getLastChapterNumber()) throw new IllegalArgumentException("Nie poprawne zapytanie o rozdziały konstytucji");
            for (Chapter chapter: this.chapters) {
                if(chapter.number > option.last) break;
                if(chapter.number < option.first) continue;
                answer.append(chapter.toString());
                answer.append("\n");
            }
        }
        else{
            return this.toString();
        }
        return answer.toString();
    }

    private int getFirstChapterNumber(){
        return chapters.getFirst().number;
    }

    private int getLastChapterNumber(){
        return chapters.getLast().number;
    }
    private int getFirstArticleNumber(){
        return chapters.getFirst().getFirstArticleNumber();
    }

    private int getLastArticleNumber(){
        return chapters.getLast().getLastArticleNumber();
    }
    
    
}
