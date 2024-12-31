package com.project.app;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.factory.Bags;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.multimap.list.ImmutableListMultimap;
import org.eclipse.collections.impl.block.procedure.AppendStringProcedure;
import org.eclipse.collections.impl.block.procedure.CaseProcedure;
import org.eclipse.collections.impl.block.procedure.CollectProcedure;
import org.eclipse.collections.impl.block.procedure.IfProcedure;
import org.eclipse.collections.impl.block.procedure.primitive.IntCaseProcedure;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.primitive.IntInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestCode {
    public static void main(String[] args) {
        MutableList<Integer> list = Lists.mutable.of(1, 2, 3).toList();
        list.select(it -> it % 2 == 0)
                .forEach(System.out::println);

        MutableMap<Integer, Integer> map = list.toMap(it -> it, it -> it);
        map.forEach(System.out::println);
        Maps.mutable.of("name", "bob")
                .forEach((key, value) -> System.out.println(key + "=" + value));

        Lists.mutable.of(1, 2, 3).forEachWithIndex((k, v) -> {
            System.out.println(k + ":" + v);
        });


        List<String> list2 = new ArrayList<>();
        IntInterval.zeroTo(10).forEach(
                new IntCaseProcedure(i -> list2.add(i + ""))
                        .addCase(i -> i % 3 == 0, i -> list2.add("Fizz"))
                        .addCase(i -> i % 5 == 0, i -> list2.add("Buzz"))
        );


        StringBuilder stringBuilder = new StringBuilder();
        ImmutableList<String> strings = Lists.immutable.of("a", "b", "c", "d", "e", "de")
                .rejectWith(String::equals, "e");
        System.out.println(strings);

        System.out.println(stringBuilder.toString());


        ImmutableBag<String> bags = Bags.immutable.of("a", "b", "c", "d", "e", "de");
    }
}