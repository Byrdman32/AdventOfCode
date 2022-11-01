package dev.Byrdman32.util.datastructure;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ArrayUtil {
    public static Number[][] rotateClockwise(Number[][] a) {
        Number[][] ret = new Number[a.length][a[0].length];

        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[0].length; c++) {
                ret[c][a.length - 1 - r] = a[r][c];
            }
        }

        return ret;
    }

    public static Long[][] initSquareArray(int size) {
        var array = new Long[size][size];
        for (Long[] longs : array) {
            Arrays.fill(longs, 0L);
        }

        return array;
    }

    public static long[] fromInput(List<String> input, int delta) {
        var counts = new long[delta];

        for (var line : input.get(0).split(",")) {
            counts[parseInt(line)]++;
        }

        return counts;
    }

    public static <T> int findInArray(T[] mapping, T curr) {
        for (var i = 0; i < mapping.length; i++) {
            if (mapping[i].equals(curr)) {
                return i;
            }
        }
        return -1;
    }

    public static void incrementArray(Long[][] toInc) {
        for (int i = 0; i < toInc.length; i++) {
            for (int j = 0; j < toInc[i].length; j++) {
                toInc[i][j]++;
            }
        }
    }

    public static void incrementDiagonally(int i, int j, Long[][] arr) {
        for (int diagonallyI = -1; diagonallyI <= 1; diagonallyI++) {
            for (int diagonallyJ = -1; diagonallyJ <= 1; diagonallyJ++) {
                if (diagonallyI != 0 || diagonallyJ != 0) {
                    if (i + diagonallyI >= 0 && i + diagonallyI < arr.length
                            && j + diagonallyJ >= 0 && j + diagonallyJ < arr[i].length) {

                        arr[i + diagonallyI][j + diagonallyJ]++;
                    }
                }
            }
        }
    }
}