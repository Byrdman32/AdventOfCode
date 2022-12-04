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

    private static Integer sumFactors2(Integer houseNumber){
        Integer total = 0;

        for(int elf = 1; elf <= houseNumber; elf++){
            if(houseNumber % elf == 0){
                if(50*elf < houseNumber)
                    continue;

                total += elf;
                if(Math.pow(elf, 2) != houseNumber)
                    total += houseNumber/elf;
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

        int i = (int) solvePart1(input);
        while(sumFactors2(i) < Integer.parseInt(input.get(0))/11){
            i++;
        }

        return i;
    }
}