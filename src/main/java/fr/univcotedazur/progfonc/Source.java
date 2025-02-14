package fr.univcotedazur.progfonc;

import java.util.List;

public class Source {
    public static <T> Flow<T> fromList(List<T> l) {
        return new FlowImpl<>(l);
    }
}
