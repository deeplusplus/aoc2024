package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try{
            Integer runningSum = 0;
            String regex = "mul\\(\\d+,\\d+\\)";
            String wholeFile = Files.readAllLines(Paths.get("C:\\Users\\r2dan\\IdeaProjects\\aoc2024\\src\\main\\java\\org\\example\\day3_input.txt")).get(0);

            //Parse out matches with regex
            List<String> matches = new ArrayList<String>();
            Matcher m = Pattern.compile("(?=(" + regex + "))").matcher(wholeFile);
            while(m.find()) {
                matches.add(m.group(1));
            }

            for(int i = 0; i < matches.size(); i++){
                String[] subStrings = matches.get(i).split(",");
                Integer firstNum = Integer.parseInt(subStrings[0].substring(4));
                Integer secondNum = Integer.parseInt(subStrings[1].substring(0, subStrings[1].length() - 1));
                runningSum += firstNum * secondNum;
            }

            System.out.print(runningSum);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }
}