package fr.univcotedazur.progfonc;

import java.util.List;
import java.util.logging.Logger;

public class Source {
    private final static Logger logger = Logger.getLogger("flow");

    public static <T> Flow<T> fromList(List<T> l) {
        logger.info(String.format("created flow from list of size %d", l.size()));
        return new FlowImpl<>(l);
    }
}
