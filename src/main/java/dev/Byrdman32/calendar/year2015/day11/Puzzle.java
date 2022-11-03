package dev.Byrdman32.calendar.year2015.day11;

import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;
import org.apache.commons.lang3.ArrayUtils;

public class Puzzle implements GenericPuzzle  {
    private boolean isPasswordCorrect(char[] password) {
        boolean increasing = false;
        for (int i = 0; i < password.length - 2; i++) {
            if (password[i] + 1 == password[i + 1]
                    && password[i + 1] + 1 == password[i + 2]) {
                increasing = true;
            }
        }

        boolean contain = !ArrayUtils.contains(password, 'i')
                && !ArrayUtils.contains(password, 'o')
                && !ArrayUtils.contains(password, 'l');

        int consecutive = 0;
        int i = 0;
        while (i < password.length - 1) {
            if (password[i] == password[i + 1]) {
                consecutive++;
                i++;
            }
            i++;
        }

        return increasing && contain && (consecutive >= 2);
    }

    private void increasePassword(char[] password, int pos) {
        if (password[pos] == 'z') {
            password[pos] = 'a';
            if (pos != 0) {
                increasePassword(password, pos - 1);
            }
        } else {
            password[pos] = (char) (password[pos] + 1);
            if (password[pos] == 'i' || password[pos] == 'o' || password[pos] == 'l') {
                password[pos] = (char) (password[pos] + 1);
            }
        }
    }

    public Object solvePart1(List<String> input) {

        char[] password = input.get(0).toCharArray();
        do {
            increasePassword(password, password.length - 1);
        } while (!isPasswordCorrect(password));

        return String.valueOf(password);
    }

    public Object solvePart2(List<String> input) {

        char[] password = String.valueOf(solvePart1(input)).toCharArray();

        do {
            increasePassword(password, password.length - 1);
        } while (!isPasswordCorrect(password));

        return String.valueOf(password);
    }
}