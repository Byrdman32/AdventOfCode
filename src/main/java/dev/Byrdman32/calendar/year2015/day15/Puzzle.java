package dev.Byrdman32.calendar.year2015.day15;

import java.util.List;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    public static class Ingredient {
        private final String name;
        private final Integer capacity;
        private final Integer durability;
        private final Integer flavor;
        private final Integer texture;
        private final Integer calories;

        public Ingredient(String name, Integer capacity, Integer durability, Integer flavor, Integer texture, Integer calories) {
            this.name = name;
            this.capacity = capacity;
            this.durability = durability;
            this.flavor = flavor;
            this.texture = texture;
            this.calories = calories;
        }

        public String getName() {
            return name;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public Integer getDurability() {
            return durability;
        }

        public Integer getFlavor() {
            return flavor;
        }

        public Integer getTexture() {
            return texture;
        }

        public Integer getCalories() {
            return calories;
        }
    }

    public Object solvePart1(List<String> input) {

        Ingredient sprinkles = null;
        Ingredient candy = null;
        Ingredient chocolate = null;
        Ingredient sugar = null;

        for (String s : input) {
            String[] split = s.split(" ");
            String name = split[0].substring(0, split[0].length() - 1);
            Integer capacity = Integer.parseInt(split[2].substring(0, split[2].length() - 1));
            Integer durability = Integer.parseInt(split[4].substring(0, split[4].length() - 1));
            Integer flavor = Integer.parseInt(split[6].substring(0, split[6].length() - 1));
            Integer texture = Integer.parseInt(split[8].substring(0, split[8].length() - 1));
            Integer calories = Integer.parseInt(split[10]);

            switch (name) {
                case "Sprinkles" -> sprinkles = new Ingredient(name, capacity, durability, flavor, texture, calories);
                case "Candy" -> candy = new Ingredient(name, capacity, durability, flavor, texture, calories);
                case "Chocolate" -> chocolate = new Ingredient(name, capacity, durability, flavor, texture, calories);
                case "Sugar" -> sugar = new Ingredient(name, capacity, durability, flavor, texture, calories);
            }
        }

        int maxScore = 0;
        for(Integer a = 0; a <= 100; a++){
            for(Integer b = 0; b <= 100; b++){
                if(a + b > 100){
                    break;
                }
                for(Integer c = 0; c <= 100; c++){
                    if(a + b + c > 100){
                        break;
                    }
                    for(Integer d = 0; d <= 100; d++){
                        if(a + b + c + d > 100){
                            break;
                        }
                        if(a + b + c + d != 100){
                            continue;
                        }

                        assert sprinkles != null;
                        assert candy != null;
                        assert chocolate != null;
                        assert sugar != null;

                        Integer capacity = Math.max(0,
                                a*sprinkles.getCapacity() +
                                b*candy.getCapacity() +
                                c*chocolate.getCapacity() +
                                d*sugar.getCapacity()
                        );
                        Integer durability = Math.max(0,
                                a*sprinkles.getDurability() +
                                b*candy.getDurability() +
                                c*chocolate.getDurability() +
                                d*sugar.getDurability()
                        );
                        Integer flavor = Math.max(0,
                                a*sprinkles.getFlavor() +
                                b*candy.getFlavor() +
                                c*chocolate.getFlavor() +
                                d*sugar.getFlavor()
                        );
                        Integer texture = Math.max(0,
                                a*sprinkles.getTexture() +
                                b*candy.getTexture() +
                                c*chocolate.getTexture() +
                                d*sugar.getTexture()
                        );

                        maxScore = Math.max(capacity*durability*flavor*texture, maxScore);
                    }
                }
            }
        }

        return maxScore;
    }

    public Object solvePart2(List<String> input) {

        Ingredient sprinkles = null;
        Ingredient candy = null;
        Ingredient chocolate = null;
        Ingredient sugar = null;

        for (String s : input) {
            String[] split = s.split(" ");
            String name = split[0].substring(0, split[0].length() - 1);
            Integer capacity = Integer.parseInt(split[2].substring(0, split[2].length() - 1));
            Integer durability = Integer.parseInt(split[4].substring(0, split[4].length() - 1));
            Integer flavor = Integer.parseInt(split[6].substring(0, split[6].length() - 1));
            Integer texture = Integer.parseInt(split[8].substring(0, split[8].length() - 1));
            Integer calories = Integer.parseInt(split[10]);

            switch (name) {
                case "Sprinkles" -> sprinkles = new Ingredient(name, capacity, durability, flavor, texture, calories);
                case "Candy" -> candy = new Ingredient(name, capacity, durability, flavor, texture, calories);
                case "Chocolate" -> chocolate = new Ingredient(name, capacity, durability, flavor, texture, calories);
                case "Sugar" -> sugar = new Ingredient(name, capacity, durability, flavor, texture, calories);
            }
        }

        assert sprinkles != null;
        assert candy != null;
        assert chocolate != null;
        assert sugar != null;

        int maxScore = 0;
        for(Integer a = 0; a <= 100; a++){
            for(Integer b = 0; b <= 100; b++){
                if(a + b > 100){
                    break;
                }
                for(Integer c = 0; c <= 100; c++){
                    if(a + b + c > 100){
                        break;
                    }
                    for(Integer d = 0; d <= 100; d++){
                        if(a + b + c + d > 100){
                            break;
                        }
                        if(a + b + c + d != 100){
                            continue;
                        }
                        if( a*sprinkles.getCalories() +
                            b*candy.getCalories() +
                            c*chocolate.getCalories() +
                            d*sugar.getCalories() != 500
                        ){
                            continue;
                        }

                        Integer capacity = Math.max(0,
                                a*sprinkles.getCapacity() +
                                        b*candy.getCapacity() +
                                        c*chocolate.getCapacity() +
                                        d*sugar.getCapacity()
                        );
                        Integer durability = Math.max(0,
                                a*sprinkles.getDurability() +
                                        b*candy.getDurability() +
                                        c*chocolate.getDurability() +
                                        d*sugar.getDurability()
                        );
                        Integer flavor = Math.max(0,
                                a*sprinkles.getFlavor() +
                                        b*candy.getFlavor() +
                                        c*chocolate.getFlavor() +
                                        d*sugar.getFlavor()
                        );
                        Integer texture = Math.max(0,
                                a*sprinkles.getTexture() +
                                        b*candy.getTexture() +
                                        c*chocolate.getTexture() +
                                        d*sugar.getTexture()
                        );

                        maxScore = Math.max(capacity*durability*flavor*texture, maxScore);
                    }
                }
            }
        }

        return maxScore;
    }
}