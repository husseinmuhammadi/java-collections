package com.javastudio.tutorial.collections.card;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class CardTypeCache {

    public abstract String getCardType(String cardNumber);

    static CardTypeCache buildCache(List<BinRange> binRanges) {
        binRanges.sort((range1, range2) -> range1.start.compareTo(range2.start));

        List<Integer> bins = binRanges.stream().map(b -> b.start).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        TreeSet<Integer> treeSet = new TreeSet<>(bins);

        TreeMap<Integer, BinRange> treeMap = new TreeMap<>(
                binRanges.stream().collect(Collectors.toMap(binRange -> Integer.valueOf(binRange.start), binRange -> binRange)));


        return new CardTypeCache() {
            @Override
            public String getCardType(String cardNumber) {
                String bin = cardNumber.substring(0, 6);

                // TreeMap
                Integer start = treeMap.floorKey(Integer.valueOf(bin));

//                if (start==null)
//                    return null;
//
//                return Optional.of(treeMap.get(start))
//                        .filter(range->bin.compareTo(range.start)>=0 && bin.compareTo(range.end)<=0)
//                        .map(b->b.cardType)
//                        .orElse(null);

                // TreeSet
//                Integer start = treeSet.floor(Integer.valueOf(bin));
//                return String.valueOf(start);



                //Binary search
                int left = 0, right = binRanges.size() - 1;
                while (left <= right)
                {
                    int mid = left + (right - left) / 2;
                    BinRange range = binRanges.get(mid);
                    // Check if the bin is in the range
                    if (bin.compareTo(range.start) >= 0 && bin.compareTo(range.end) <= 0)
                        return range.cardType;
                    if (bin.compareTo(range.start) > 0)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
                // if range not found
                return null;
            }
        };
    }
}



