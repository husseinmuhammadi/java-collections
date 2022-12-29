package com.javastudio.adyen;

import java.util.Comparator;
import java.util.List;

public class Application {

    static class BinRange{
        private final String start;
        private final String end;
        private final String cardType;

        public BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }

    static abstract class CardTypeCache{
        public abstract String getCardType(String cardNumber);

        public static CardTypeCache buildCache(List<BinRange> binRanges){
            binRanges.sort(Comparator.comparing(range -> range.start));
            return new CardTypeCache() {
                @Override
                public String getCardType(String cardNumber) {
                    String bin = cardNumber.substring(0,6);
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
}

