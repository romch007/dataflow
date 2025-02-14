package fr.univcotedazur.progfonc;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> res = Source.fromList(List.of(6, 8, 4))
                .filter(i -> i > 9)
                .map(i -> String.format("that's %d", i))
                .compute();
    }
}