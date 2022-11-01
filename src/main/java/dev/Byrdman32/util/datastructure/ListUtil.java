package dev.Byrdman32.util.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
    public static <T> List<T> enqueue(List<T> a, T c) {
        var list = new ArrayList<>(a);
        list.add(c);
        return list;
    }

    public static <T> List<T> list(Class<T> clazz) {
        return new ArrayList<>();
    }

//    public static boolean all(List<Number> a) {
//        return a.stream()
//                .map(Number::isDrawn)
//                .reduce(true, (total, current) -> total &= current);
//    }
}