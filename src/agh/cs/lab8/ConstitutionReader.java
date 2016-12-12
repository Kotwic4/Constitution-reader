package agh.cs.lab8;

import java.util.Arrays;
import java.util.LinkedList;

public class ConstitutionReader {

    public static void main(String[] args) {
        Constitution constitution = ConstitutionParser.parseConstitution(args[0]);
        LinkedList<Option> options=OptionParser.parseOptions(Arrays.copyOfRange(args,1,args.length-1));
        StringBuilder builder = new StringBuilder();
        for (Option option: options)
        {
            builder.append(constitution.toString(option));
        }
    }
}
