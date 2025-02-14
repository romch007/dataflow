package fr.univcotedazur.progfonc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;

public interface Flow<I> {
    Flow<I> filter(Predicate<I> pred);

    <O> Flow<O> map(Function<I, O> mapper);

    List<I> compute();

    static <I> Flow<I> aggregate(Flow<I> a, Flow<I> b) {
        Logger.getLogger("flow").info("applying 'aggregate' on two flows");

        if (a instanceof FlowImpl<I> aImpl && b instanceof FlowImpl<I> bImpl) {
            List<I> newItems = new ArrayList<>(aImpl.getItems());
            newItems.addAll(bImpl.getItems());

            return new FlowImpl<>(newItems);
        }

        throw new IllegalArgumentException("Invalid streams");
    }


    static <T> Flow<T> fromList(List<T> l) {
        Logger.getLogger("flow").info(String.format("created flow from list of size %d", l.size()));
        return new FlowImpl<>(l);
    }

    static <T> Flow<T> empty() {
        return fromList(List.of());
    }
}