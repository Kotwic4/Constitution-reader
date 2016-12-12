package agh.cs.lab8;

import java.util.LinkedList;
import java.util.List;

class OptionParser {

    public static List<Option> parseOptions(String[] args){
        LinkedList<Option> options = new LinkedList<Option>();
        for(int i = 0; i < args.length; i++){
            switch(args[i]){
                case "r":
                case "R":
                    if(i >= args.length -1 || !args[i+1].matches("\\d+")) throw new IllegalArgumentException("Nie poprawny argument : " + args[i]);
                    i++;
                    int firstC = Integer.parseInt(args[i]);
                    if(i >= args.length -1 || !args[i+1].matches("\\d+")){
                        options.add(new Option(OptionType.Chapter,firstC,firstC));
                    }else
                    {
                        i++;
                        int secondC = Integer.parseInt(args[i]);
                        options.add(new Option(OptionType.Chapter,firstC,secondC));
                    }
                    break;
                case "a":
                case "A":
                    if(i >= args.length -1 || !args[i+1].matches("\\d+")) throw new IllegalArgumentException("Nie poprawny argument : " + args[i]);
                    i++;
                    int firstA = Integer.parseInt(args[i]);
                    if(i >= args.length -1 || !args[i+1].matches("\\d+")){
                        options.add(new Option(OptionType.Article,firstA,firstA));
                    }else
                    {
                        i++;
                        int secondA = Integer.parseInt(args[i]);
                        options.add(new Option(OptionType.Article,firstA,secondA));
                    }
                    break;
                case "c":
                case "C":
                    options.add(new Option(OptionType.Constitution));
                    break;
                default:
                    throw new IllegalArgumentException("Nie poprawny argument : " + args[i]);
            }
        }
        return options;
    }
}
