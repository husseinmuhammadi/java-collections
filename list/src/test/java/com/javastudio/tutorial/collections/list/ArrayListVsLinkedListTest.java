package com.javastudio.tutorial.collections.list;

import com.javastudio.tutorial.collections.handler.Library;
import com.javastudio.tutorial.collections.handler.LibraryImpl;
import com.javastudio.tutorial.collections.handler.Position;
import com.javastudio.tutorial.collections.model.Book;
import com.javastudio.tutorial.collections.proxy.Delegator;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ArrayListVsLinkedListTest {
    private static final int N = 10_000_000; //100_000_000;
    private static final int ONE_HUNDRED_THOUSAND = 100_000; //100_000_000;
    private static final int ONE_MILLION = 1_000_000; //100_000_000;

    @Test
    void add() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Library library = new LibraryImpl(new LinkedList<>());

        ClassLoader classLoader = library.getClass().getClassLoader();
        Class<?>[] interfaces = library.getClass().getInterfaces();

        InvocationHandler invocationHandler = (proxy, method, args) -> {
            return method.invoke(library, args);
        };

        Library proxy = (Library) Proxy.newProxyInstance(
                classLoader,
                interfaces,
                new Delegator(interfaces, new Object[]{library}));

        proxy.add(Book.builder().build(), Position.TAIL);

        System.out.println(library.getSize());

        // proxy.add(Book.builder().build());

//        Library handlerProxy = Proxy.newProxyInstance(Library.class.getClassLoader(),
//                new Class[]{Library.class},
//                );


//        for (int i = 0; i < n; i++) {
//            arrayList.add(Book.builder()
//                    .id(1L).name("Introduction To Algorithms")
//                    .publishDate(LocalDate.now()).build());
//        }
    }

    @Test
    void whenAddItemsToTheEndOfList_thenArrayListWithInitialCapacityWillBeFaster() {
        Library library;

        library = new LibraryImpl(new ArrayList<>(N));
        System.out.println(String.format("ArrayList with initial capacity : %f",addItemsToEndOfList(library) / 1E9));

        library = new LibraryImpl(new ArrayList<>());
        System.out.println(String.format("ArrayList without initial capacity : %f",addItemsToEndOfList(library) / 1E9));

        library = new LibraryImpl(new LinkedList<>());
        System.out.println(String.format("LinkedList : %f",addItemsToEndOfList(library) / 1E9));
    }

    @Test
    void whenAddItemsToTheHeadOfList_thenLinkedListWillBeFaster() {
        Library library;

        library = new LibraryImpl(new LinkedList<>());
        System.out.printf("LinkedList : %f%n",addItemsToHeadOfList(library) / 1E9);

        library = new LibraryImpl(new ArrayList<>(ONE_MILLION));
        System.out.printf("ArrayList with initial capacity : %f%n",addItemsToHeadOfList(library) / 1E9);

        library = new LibraryImpl(new ArrayList<>());
        System.out.printf("ArrayList without initial capacity : %f%n",addItemsToHeadOfList(library) / 1E9);
    }

    private long addItemsToEndOfList(Library library) {
        long start = System.nanoTime();

        for (int i = 0; i < N; i++) {
            library.add(Book.builder().build(), Position.TAIL);
        }

        long end = System.nanoTime();

        return end - start;
    }

    private long addItemsToHeadOfList(Library library) {
        long start = System.nanoTime();

        for (int i = 0; i < ONE_MILLION; i++) {
            library.add(Book.builder().build(), Position.HEAD);
        }

        long end = System.nanoTime();

        return end - start;
    }

    void t1() {
        BiConsumer<String, String> x = new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {

            }
        };
    }

    void t2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
    }
}
