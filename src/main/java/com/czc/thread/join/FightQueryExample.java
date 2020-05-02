package com.czc.thread.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author changzhichen
 * @date 2020-05-02 10:17
 */
public class FightQueryExample {
    private static List<String> fightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> resultList = search("SH", "BJ");
        System.out.println("======result=======");
        resultList.forEach(System.out::println);
    }

    private static List<String> search(String origin, String dest) {
        final List<String> result = new ArrayList<>();
        List<FightQueryTask> taskList = fightCompany.stream().map(f -> createSearchTask(f, origin, dest))
                .collect(Collectors.toList());

        taskList.forEach(Thread::start);
        taskList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        taskList.stream().map(FightQuery::get).forEach(result::addAll);
        return result;
    }

    private static FightQueryTask createSearchTask(String fight, String origin, String dest) {
        return new FightQueryTask(fight, origin, dest);
    }
}
