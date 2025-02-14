package fr.univcotedazur.progfonc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flow<Integer> integer = Source.fromList(List.of(6, 2, 4, 2, 6));

        // Example 1: Filter numbers greater than or equal to 4 and map them to strings
        List<String> res1 = integer
                .filter(i -> i >= 4)
                .map(i -> String.format("that's %d", i))
                .compute();
        System.out.println("Example 1: " + res1);

        // Example 2: Map each number to its square
        List<Integer> res2 = integer
                .map(i -> i * i)
                .compute();
        System.out.println("Example 2: " + res2);

        // Example 3: Filter even numbers
        List<Integer> evenNumbers = integer
                .filter(i -> i % 2 == 0)
                .compute();
        System.out.println("Example 3: " + evenNumbers);

        // Example 4: Chain multiple filters and a map
        List<String> chainedRes = integer
                .filter(i -> i > 3)
                .filter(i -> i < 6)
                .map(i -> "Value: " + i)
                .compute();
        System.out.println("Example 4: " + chainedRes);

        // Example 5: Aggregate two flows
        Flow<Integer> moreInts = Source.fromList(List.of(8, 10, 3));
        Flow<Integer> aggregatedFlow = Flow.aggregate(integer, moreInts);
        List<Integer> aggregatedRes = aggregatedFlow.compute();
        System.out.println("Example 5 (Aggregated Flow): " + aggregatedRes);

        // Example 6: Aggregate and filter the result
        List<Integer> aggregatedFilteredRes = Flow.aggregate(integer, moreInts)
                .filter(i -> i > 5)
                .compute();
        System.out.println("Example 6 (Aggregated and Filtered): " + aggregatedFilteredRes);

        // Example 7: Aggregate, map, and compute
        List<String> aggregatedMappedRes = Flow.aggregate(integer, moreInts)
                .map(i -> "Mapped: " + i)
                .compute();
        System.out.println("Example 7 (Aggregated and Mapped): " + aggregatedMappedRes);

        // Example 8: Aggregate with an empty flow
        Flow<Integer> emptyFlow = Source.fromList(List.of());
        List<Integer> aggregatedWithEmpty = Flow.aggregate(integer, emptyFlow)
                .compute();
        System.out.println("Example 8 (Aggregated with Empty Flow): " + aggregatedWithEmpty);

        // Example 9: Aggregate three flows
        Flow<Integer> anotherFlow = Source.fromList(List.of(1, 9, 11));
        List<Integer> threeWayAggregate = Flow.aggregate(Flow.aggregate(integer, moreInts), anotherFlow)
                .compute();
        System.out.println("Example 9 (Three-Way Aggregate): " + threeWayAggregate);

        // Example 10: Aggregate, map, filter, and chain multiple operations
        List<String> complexChainRes = Flow.aggregate(integer, anotherFlow)
                .map(i -> i * 2)
                .filter(i -> i > 10)
                .map(i -> "Doubled and Filtered: " + i)
                .compute();
        System.out.println("Example 10 (Complex Chained Flow): " + complexChainRes);
    }
}