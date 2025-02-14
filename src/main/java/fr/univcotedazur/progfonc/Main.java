package fr.univcotedazur.progfonc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flow<Integer> ints = Source.fromList(List.of(6, 2, 4, 2, 6));

        List<String> res1 = ints
                .filter(i -> i >= 4)
                .map(i -> String.format("that's %d", i))
                .compute();

        List<Integer> res2 = ints
                .map(i -> i * i)
                .compute();

        System.out.println(res1);
        System.out.println(res2);
    }
}