package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            Integer countOfPassingReports = 0;
            List<String> fileLinesAsList = Files.readAllLines(Paths.get("C:\\Users\\r2dan\\IdeaProjects\\aoc2024\\src\\main\\java\\org\\example\\day2_input.txt"));
            List<List<Integer>> inputAs2DList = new ArrayList<List<Integer>>();
            List<List<Integer>> inputAs2DListOfDifferences = new ArrayList<>();
            //Get 2D list of input as integers
            for(int i = 0; i < fileLinesAsList.size(); i ++){
                List<Integer> lineInts = new ArrayList<>();
                String line = fileLinesAsList.get(i);
                String[] lineAsStringList = line.split(" ");
                for(int j = 0; j < lineAsStringList.length; j++) {
                    lineInts.add(Integer.parseInt(lineAsStringList[j]));
                }
                inputAs2DList.add(lineInts);
            }

            //Convert list of integers to list of differences.  Should be easier to work with?
            for(int i = 0; i < inputAs2DList.size(); i++) {
                List<Integer> lineDifferences = new ArrayList<>();
                for(int j = 0; j < inputAs2DList.get(i).size() - 1; j++){
                    lineDifferences.add(inputAs2DList.get(i).get(j) - inputAs2DList.get(i).get(j + 1));
                }
                inputAs2DListOfDifferences.add(lineDifferences);
            }

            //Check each list of differences against rules
            for(int i = 0; i < inputAs2DListOfDifferences.size(); i++){
                Integer naturalSum = 0;
                Integer absoluteSum = 0;
                Boolean succeed = true;
                for(int j = 0; j < inputAs2DListOfDifferences.get(i).size(); j++){
                    Integer difference = inputAs2DListOfDifferences.get(i).get(j);
                    if(difference < -3 || difference > 3 || difference == 0) {
                        succeed = false;
                        break;
                    }
                    naturalSum += difference;
                    absoluteSum += Math.abs(difference);
                }

                if(Math.abs(naturalSum) == absoluteSum && succeed) {
                    countOfPassingReports++;
                }
            }

            System.out.print(countOfPassingReports);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }
}