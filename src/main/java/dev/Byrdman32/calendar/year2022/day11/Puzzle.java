package dev.Byrdman32.calendar.year2022.day11;

import java.util.ArrayList;
import java.util.List;
import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    String in = "Monkey 0:\n  Starting items: 79, 98\n  Operation: new = old * 19\n  Test: divisible by 23\n    If true: throw to monkey 2\n    If false: throw to monkey 3\n\nMonkey 1:\n  Starting items: 54, 65, 75, 74\n  Operation: new = old + 6\n  Test: divisible by 19\n    If true: throw to monkey 2\n    If false: throw to monkey 0\n\nMonkey 2:\n  Starting items: 79, 60, 97\n  Operation: new = old * old\n  Test: divisible by 13\n    If true: throw to monkey 1\n    If false: throw to monkey 3\n\nMonkey 3:\n  Starting items: 74\n  Operation: new = old + 3\n  Test: divisible by 17\n    If true: throw to monkey 0\n    If false: throw to monkey 1";
    String in2 = "Monkey 0:\n  Starting items: 65, 58, 93, 57, 66\n  Operation: new = old * 7\n  Test: divisible by 19\n    If true: throw to monkey 6\n    If false: throw to monkey 4\n\nMonkey 1:\n  Starting items: 76, 97, 58, 72, 57, 92, 82\n  Operation: new = old + 4\n  Test: divisible by 3\n    If true: throw to monkey 7\n    If false: throw to monkey 5\n\nMonkey 2:\n  Starting items: 90, 89, 96\n  Operation: new = old * 5\n  Test: divisible by 13\n    If true: throw to monkey 5\n    If false: throw to monkey 1\n\nMonkey 3:\n  Starting items: 72, 63, 72, 99\n  Operation: new = old * old\n  Test: divisible by 17\n    If true: throw to monkey 0\n    If false: throw to monkey 4\n\nMonkey 4:\n  Starting items: 65\n  Operation: new = old + 1\n  Test: divisible by 2\n    If true: throw to monkey 6\n    If false: throw to monkey 2\n\nMonkey 5:\n  Starting items: 97, 71\n  Operation: new = old + 8\n  Test: divisible by 11\n    If true: throw to monkey 7\n    If false: throw to monkey 3\n\nMonkey 6:\n  Starting items: 83, 68, 88, 55, 87, 67\n  Operation: new = old + 2\n  Test: divisible by 5\n    If true: throw to monkey 2\n    If false: throw to monkey 1\n\nMonkey 7:\n  Starting items: 64, 81, 50, 96, 82, 53, 62, 92\n  Operation: new = old + 5\n  Test: divisible by 7\n    If true: throw to monkey 3\n    If false: throw to monkey 0\n";
    public Object solvePart1(List<String> input) {

        var monkeys = initializeMonkeys(in2);

        executeRounds(monkeys, 20);

        return getLevelOfMonkeyBusiness(monkeys);
    }

    public Object solvePart2(List<String> input) {

        return null;
    }

    private Monkey[] initializeMonkeys(String input) {
        var monkeyInputs = input.trim().split("\n\n");
        var monkeys = new Monkey[monkeyInputs.length];

        for (var i = 0; i < monkeyInputs.length; i++) {
            var monkeyInputLines = monkeyInputs[i].split("\n");
            var items = toLongList(monkeyInputLines[1].trim().split(": ")[1].split(", "));
            var operation = monkeyInputLines[2].trim().split("new = old ")[1];
            var divisible = Integer.parseInt(monkeyInputLines[3].replaceAll("\\D", ""));
            var trueMonkey = Integer.parseInt(monkeyInputLines[4].replaceAll("\\D", ""));
            var falseMonkey = Integer.parseInt(monkeyInputLines[5].replaceAll("\\D", ""));

            monkeys[i] = new Monkey(items, operation, divisible, trueMonkey, falseMonkey);
        }

        return monkeys;
    }

    private void executeRounds(Monkey[] monkeys, int rounds) {
        var prod = 1;

        for (var monkey: monkeys) {
            prod *= monkey.divisible;
        }

        for (var round = 1; round <= rounds; round++) {
            for (var monkey: monkeys) {
                for (var item: monkey.items) {
                    monkey.inspectedItems++;

                    var operationParameter = monkey.operationParameter.equals("old")
                            ? item
                            : Integer.parseInt(monkey.operationParameter);

                    switch (monkey.operation) {
                        case '+' -> item = item + operationParameter;
                        case '*' -> item = item * operationParameter;
                    }

                    item /= 3;

                    var target = item % monkey.divisible == 0 ? monkey.trueTarget : monkey.falseTarget;
                    monkeys[target].items.add(item % prod);
                }

                monkey.items = new ArrayList<>();
            }
        }
    }

    private String getLevelOfMonkeyBusiness(Monkey[] monkeys) {
        var maxInspections = new ArrayList<Long>();

        for (var monkey: monkeys) {
            maxInspections.add(monkey.inspectedItems);
        }

        maxInspections.sort((a, b) -> Long.compare(b, a));

        return String.valueOf(maxInspections.get(0) * maxInspections.get(1));
    }

    static class Monkey {
        public List<Long> items;
        public char operation;
        public String operationParameter;
        public int divisible;
        public int trueTarget;
        public int falseTarget;
        public Long inspectedItems = 0L;

        public Monkey(List<Long> items, String operation, int divisible, int trueTarget, int falseTarget) {
            this.items = items;
            this.operation = operation.charAt(0);
            this.operationParameter = operation.substring(2);
            this.divisible = divisible;
            this.trueTarget = trueTarget;
            this.falseTarget = falseTarget;
        }
    }

    private static List<Long> toLongList(String[] strings) {
        var list = new ArrayList<Long>();

        for (var str: strings) {
            list.add(Long.parseLong(str));
        }

        return list;
    }
}