package fr.univcotedazur.progfonc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class FlowImpl<I> implements Flow<I> {
    private final static Logger logger = Logger.getLogger("flow");
    private final List<I> items;

    public FlowImpl(List<I> items) {
        this.items = items;
    }

    public List<I> getItems() {
        return this.items;
    }

    @Override
    public Flow<I> filter(Predicate<I> pred) {
        logger.info("applying 'filter' operation");
        return new FlowImpl<>(items.parallelStream()
                .filter(pred)
                .toList());
    }

    @Override
    public <O> Flow<O> map(Function<I, O> mapper) {
        logger.info("applying 'map' operation");
        return new FlowImpl<>(items.parallelStream()
                .map(mapper)
                .toList());
    }

    @Override
    public List<I> compute() {
        logger.info("computing flow result");
        return new ArrayList<>(this.items);
    }
}
