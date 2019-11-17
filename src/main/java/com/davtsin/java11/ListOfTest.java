package com.davtsin.java11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListOfTest {
    private static Logger logger = LoggerFactory.getLogger(ListOfTest.class);

    public static void main(String[] args) {
        var list = List.of(1L, "Hello", 3);
        logger.info("list: {}", list);
        logger.info("list class: {}", list.getClass());
//        unsupported operation exception
//        list.add(4);
//        list.set(0, 1);
        list.forEach(e -> logger.info("class of list element: {}", e.getClass()));

        var arrayList = List.<Integer>of(1, 2, 3);

    }
}
