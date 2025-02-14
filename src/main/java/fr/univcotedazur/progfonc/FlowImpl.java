package fr.univcotedazur.progfonc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FlowImpl<I> implements Flow<I> {
    private final List<I> items;

    public FlowImpl(List<I> items) {
        this.items = items;
    }

    @Override
    public Flow<I> filter(Predicate<I> pred) {
        return new FlowImpl<>(items.parallelStream()
                .filter(pred)
                .toList());
    }

    @Override
    public <O> Flow<O> map(Function<I, O> mapper) {
        return new FlowImpl<>(items.parallelStream()
                .map(mapper)
                .toList());
    }

    @Override
    public List<I> compute() {
        return new ArrayList<>(this.items);
    }
}
