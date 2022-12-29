package com.javastudio.adyen;

import java.util.List;

public class HRTestApp {
    static class BinRange {
        private final String start;
        private final String end;
        private final String cardType;

        public BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }

    static abstract class CardTypeCache {
        public abstract String getCardType(String cardNumber);

        public static CardTypeCache buildCache(List<BinRange> binRanges) {
            return null;
        }
    }
}
