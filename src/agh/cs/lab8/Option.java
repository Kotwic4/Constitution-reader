package agh.cs.lab8;

public class Option {

    public final OptionType type;
    public final int first;
    public final int last;
    public Option (OptionType type){
        this.type = type;
        this.first = 0;
        this.last = 0;
    }
    public Option(OptionType type, int first, int last){
        this.type = type;
        this.first = first;
        this.last = last;
    }
}
