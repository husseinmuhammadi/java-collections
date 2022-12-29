package com.javastudio.tutorial.collections;

import com.sun.javadoc.SeeTag;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MollieTest {
    @Test
    void x() {

        List<List<String>> items = List.of(
                List.of("Item1", "10", "15"),
                List.of("Item2", "3", "4"),
                List.of("Item3", "17", "8"));

        System.out.println(Arrays.toString(
                Result.fetchItemsToDisplay(new ArrayList<>(items),
                                1,
                                0,
                                2,
                                0)
                        .toArray()));
    }

    @Test
    void t2() throws IOException {
        String filename = "sdasdas - - ababab xyxyxyxy sadasdasdasd.gif sds.gif";

        String regex;
        regex = "(\\w+\\.)+\\w+\\s+";
        regex = "^\\w+\\s+\\-";

        Set<String> filenames = new HashSet<>();

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(filename);
        while(matcher.find()) {
            System.out.printf("[%s]", matcher.group());
        }

        for (String s : filenames) {

        }
    }
}

class Result {

    /*
     * Complete the 'fetchItemsToDisplay' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY items
     *  2. INTEGER sortParameter
     *  3. INTEGER sortOrder
     *  4. INTEGER itemsPerPage
     *  5. INTEGER pageNumber
     */

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {
        // Write your code here

        if (sortParameter > 0)
            items.sort((o1, o2) -> {
                if (sortOrder == 1)
                    return Long.valueOf(o2.get(sortParameter)).compareTo(Long.valueOf(o1.get(sortParameter)));
                return Long.valueOf(o1.get(sortParameter)).compareTo(Long.valueOf(o2.get(sortParameter)));
            });
        else
            items.sort((o1, o2) -> {
                if (sortOrder == 1)
                    return o2.get(sortParameter).compareTo(o1.get(sortParameter));
                return o1.get(sortParameter).compareTo(o2.get(sortParameter));
            });

        int from = pageNumber * itemsPerPage;
        int to = (pageNumber + 1) * itemsPerPage;
        if (to > items.size())
            to = items.size() - 1;
        return items.subList(from, to).stream().map(item -> item.get(0)).collect(Collectors.toList());

    }

}
