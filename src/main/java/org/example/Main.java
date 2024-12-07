package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.print("Hello and welcome!");

            List<String> fileLinesAsList = Files.readAllLines(Paths.get("C:\\Users\\r2dan\\IdeaProjects\\aoc2024\\src\\main\\java\\org\\example\\day1_input.txt"));
            List<Integer> leftNumbers = new ArrayList<Integer>();
            List<Integer> rightNumbers = new ArrayList<Integer>();

            for(int i = 0; i < fileLinesAsList.size(); i ++){
                String line = fileLinesAsList.get(i);

                leftNumbers.add(Integer.parseInt(fileLinesAsList.get(i).substring(0, 5)));
                rightNumbers.add(Integer.parseInt(fileLinesAsList.get(i).substring(8, 13)));

                Collections.sort(leftNumbers);
                Collections.sort(rightNumbers);
            }

            Integer sumOfDiffs = 0;
            for(int i = 0; i < fileLinesAsList.size(); i ++){
                sumOfDiffs += Math.abs(leftNumbers.get(i) - rightNumbers.get(i));
            }
            System.out.print(sumOfDiffs);
        }
        catch (Exception e){
            System.out.print(e);
        }

    }
}