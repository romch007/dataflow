package fr.univcotedazur.progfonc;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Flow<I> {
    Flow<I> filter(Predicate<I> pred);

    <O> Flow<O> map(Function<I, O> mapper);

    List<I> compute();
}