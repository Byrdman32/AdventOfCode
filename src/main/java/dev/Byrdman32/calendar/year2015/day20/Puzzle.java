package dev.Byrdman32.calendar.year2015.day20;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static Integer sumFactors(Integer i){
        int total = 0;

        for(int x = 1; x <= Math.sqrt(i); x++){
            if(i % x == 0){
                total += x;
                if(Math.pow(x, 2) != i)
                    total += i/x;
            }
        }

        return total;
    }

    public Object solvePart1(List<String> input) {

        int i = 1;
        while(sumFactors(i) < Integer.parseInt(input.get(0))/10){
            i++;
        }

        return i;
    }

    public Object solvePart2(List<String> input) {

        return null;
    }
}