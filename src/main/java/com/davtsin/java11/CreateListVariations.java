package com.davtsin.java11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateListVariations {
    private static Logger logger = LoggerFactory.getLogger(CreateListVariations.class);

    public static void main(String[] args) {
        // asList list creation
        var list = new ArrayList<>(Arrays.asList(1, 2, 3));
        modifyTest(list);

        // anonymous class list creation
        var list1 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        modifyTest(list1);

        // stream list creation
        var list2 = Stream.of(1, 2, 3).collect(Collectors.toList());
        modifyTest(list2);

        // with List.of in constructor list creation
        var list3 = new ArrayList<>(List.of(1, 2, 3));
        modifyTest(list3);

        // with List.of list creation - runtime error when modify
        var list4 = List.of(1, 2, 3);
        // UnsupportedOperationException
        // modifyTest(list4);
    }

    private static void modifyTest(List<Integer> list) {
        list.add(4);
        list.remove(3);
        list.set(0, 7);
        logger.info("list: {} Test OK", list);
    }
}
