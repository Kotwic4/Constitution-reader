package agh.cs.lab8;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class ConstitutionParser{

    private static LinkedList<String> removeGarbage (List<String> input){
        LinkedList<String> answer = new LinkedList<>();
        int i = 0;
        for(; i < input.size(); i++){
            if(input.get(i).matches("Rozdział .+")) break;
        }
        for(;i < input.size(); i++){
            String line = input.get(i);
            if(line.matches("©.+")){
                i++;
                if(i == input.size());
            }
            else{
                answer.add(line);
            }
        }
        return answer;
    }

    private static Chapter parseNextChapter(LinkedList<String> input){
        int number = RomanNumber.fromRomanToInt(input.getFirst().substring(9));
        input.removeFirst();
        StringBuilder title = new StringBuilder();
        while(!input.isEmpty() && !input.getFirst().matches("Rozdział .+") && !input.getFirst().matches("Art\\..+")){
            title.append(input.getFirst());
            input.removeFirst();
        }
        Chapter chapter = new Chapter(number,title.toString());
        while(!input.isEmpty() && !input.getFirst().matches("Rozdział .+")){
            chapter.addArticle(parseNextArticle(input));
        }
        return chapter;
    }

    private static Article parseNextArticle(LinkedList<String> input){
        int number = Integer.parseInt(input.getFirst().substring(5).split("\\.",2)[0]);
        input.removeFirst();
        StringBuilder builder = new StringBuilder();
        while(!input.isEmpty() && !input.getFirst().matches("Rozdział .+") && !input.getFirst().matches("Art\\..+")){
            if(!builder.toString().equals("")) builder.append(" ");
            String line = input.getFirst();
            input.removeFirst();
            if((line.matches("\\d+\\).+") || line.matches("\\d+\\..+"))&& !builder.toString().equals("")) builder.append("\n");
            while(line.endsWith("-")){
                line = line.substring(0,line.length()-1) + input.getFirst();
                input.removeFirst();
            }
            builder.append(line);
        }
        return new Article(number,builder.toString());
    }

    public static Constitution parseConstitution(String path) throws IOException {
        Constitution constitution = new Constitution();
        LinkedList<String> input = readConstitution(path);
        while(!input.isEmpty()){
            constitution.addChapter(parseNextChapter(input));
        }
        return constitution;
    }

    private static LinkedList<String> readConstitution(String path) throws IOException {
        return removeGarbage(Files.readAllLines(Paths.get(path)));
    }


}
