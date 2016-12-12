package agh.cs.lab8;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConstitutionReader {

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Bład: Minimalna ilosc argumentów to 2");
        }
        else
        {
            Constitution constitution;
            try {
                constitution = ConstitutionParser.parseConstitution(args[0]);
                List<Option> options=OptionParser.parseOptions(Arrays.copyOfRange(args,1,args.length));
                for (Option option: options)
                {
                    System.out.println(constitution.toString(option));
                }
            }
            catch(IOException ex){
                System.out.println("Bład odczytu pliku : " + ex.getMessage());
            }
            catch(IllegalArgumentException ex){
                System.out.println("Bład argumentu : " + ex.getMessage());
            }
        }
    }
}
