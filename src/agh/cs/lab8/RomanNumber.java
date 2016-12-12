package agh.cs.lab8;

public class RomanNumber {

    public static String fromIntToRoman(int param){
        StringBuilder answer = new StringBuilder();
        while(param > 0){
            if(param >= 1000){
                answer.append("M");
                param -= 1000;
                continue;
            }
            if(param >= 900){
                answer.append("CM");
                param -= 900;
                continue;
            }
            if(param >= 500){
                answer.append("D");
                param -= 500;
                continue;
            }
            if(param >= 400){
                answer.append("CD");
                param -= 400;
                continue;
            }
            if(param >= 100){
                answer.append("C");
                param -= 100;
                continue;
            }
            if(param >= 90){
                answer.append("XC");
                param -= 90;
                continue;
            }
            if(param >= 50){
                answer.append("L");
                param -= 50;
                continue;
            }
            if(param >= 40){
                answer.append("XL");
                param -= 40;
                continue;
            }
            if(param >= 10){
                answer.append("X");
                param -= 10;
                continue;
            }
            if(param >=  9){
                answer.append("IX");
                param -= 9;
                continue;
            }
            if(param >= 5){
                answer.append("V");
                param -= 5;
                continue;
            }
            if(param >= 4){
                answer.append("IV");
                param -= 4;
                continue;
            }
            if(param >= 1){
                param -= 1;
                answer.append("I");
            }
        }
        return answer.toString();
    }
    public static int fromRomanToInt(String param){
        int answer = 0;
        for(int i = 0; i < param.length(); i++){
            switch (param.charAt(i)){
                case 'I':
                    if(i < param.length() - 1 && param.charAt(i+1) == 'V'){
                        answer += 4;
                        i++;
                    }
                    else if(i < param.length() - 1 && param.charAt(i+1) == 'X'){
                        answer += 9;
                        i++;
                    }
                    else{
                        answer++;
                    }
                    break;
                case 'V':
                    answer += 5;
                    break;
                case 'X':
                    if(i < param.length() - 1 && param.charAt(i+1) == 'L'){
                        answer += 40;
                        i++;
                    }
                    else if(i < param.length() - 1 && param.charAt(i+1) == 'C'){
                        answer += 90;
                        i++;
                    }
                    else{
                        answer += 10;
                    }
                    break;
                case 'L':
                    answer += 50;
                    break;
                case 'C':
                    if(i < param.length() - 1 && param.charAt(i+1) == 'D'){
                        answer += 400;
                        i++;
                    }
                    else if(i < param.length() - 1 && param.charAt(i+1) == 'M'){
                        answer += 900;
                        i++;
                    }
                    else{
                        answer += 100;
                    }
                    break;
                case 'D':
                    answer += 500;
                    break;
                case 'M':
                    answer += 1000;
                    break;
            }
        }
        return answer;
    }
}
