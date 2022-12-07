package dev.Byrdman32.calendar.year2022.day07;

import java.util.*;

import dev.Byrdman32.interfaces.GenericPuzzle;

public class Puzzle implements GenericPuzzle  {

    private static class File {
        String name;
        int size = 0;
        boolean file = true;
        List<File> subElements = new ArrayList<>();
        File parent = null;

        File(int size, String name, boolean file, File parent) {
            this.size = size;
            this.name = name;
            this.file = file;
            this.parent = parent;
        }

    }private static void updateDirectoryCount(File element) {
        for (File e : element.subElements) {
            updateDirectoryCount(e);
        }
        if (!element.file) {
            element.size = element.subElements.stream().mapToInt(e -> e.size).sum();
        }
    }

    private static List<File> collectDirs(File element) {
        List<File> result = new ArrayList<>();
        for (File e : element.subElements) {
            if (!e.file) {
                result.add(e);
                result.addAll(collectDirs(e));
            }
        }
        return result;
    }

    public Object solvePart1(List<String> input) {
        File root = new File(0, "/", false, null);
        int MAX_DIR = 100000;

        File current = root;
        for (int index = 1; index < input.size(); ++index) {
            if (input.get(index).startsWith("$ cd")) {
                String dirName = input.get(index).substring("$ cd ".length());
                if (dirName.equals("..")) {
                    current = current.parent;
                } else {
                    current = current.subElements.stream().filter(fse -> fse.name.equals(dirName)).findAny().orElseThrow();
                }
            } else if (input.get(index).startsWith("dir ")) {
                String dirName = input.get(index).substring("dir ".length());
                current.subElements.add(new File(0, dirName, false, current));
            } else if (!input.get(index).equals("$ ls")) {
                String[] parts = input.get(index).split(" ");
                int size = Integer.parseInt(parts[0]);
                String name = parts[1];
                current.subElements.add(new File(size, name, true, current));
            }
        }
        updateDirectoryCount(root);
        List<File> dirs = collectDirs(root);

        return dirs.stream().filter(d -> d.size < MAX_DIR).mapToInt(d -> d.size).sum();
    }

    public Object solvePart2(List<String> input) {
        File root = new File(0, "/", false, null);
        int HDD_SPACE = 70000000;
        int UPDATE_SPACE = 30000000;

        File current = root;
        for (int index = 1; index < input.size(); ++index) {
            if (input.get(index).startsWith("$ cd")) {
                String dirName = input.get(index).substring("$ cd ".length());
                if (dirName.equals("..")) {
                    current = current.parent;
                } else {
                    current = current.subElements.stream().filter(fse -> fse.name.equals(dirName)).findAny().orElseThrow();
                }
            } else if (input.get(index).startsWith("dir ")) {
                String dirName = input.get(index).substring("dir ".length());
                current.subElements.add(new File(0, dirName, false, current));
            } else if (!input.get(index).equals("$ ls")) {
                String[] parts = input.get(index).split(" ");
                int size = Integer.parseInt(parts[0]);
                String name = parts[1];
                current.subElements.add(new File(size, name, true, current));
            }
        }
        updateDirectoryCount(root);
        List<File> dirs = collectDirs(root);


        int availableSpace = HDD_SPACE - root.size;
        int needed = UPDATE_SPACE - availableSpace;
        return dirs.stream().filter(d -> d.size >= needed).min(Comparator.comparingInt(a -> a.size)).orElseThrow().size;
    }
}