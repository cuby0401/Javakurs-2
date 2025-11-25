package javakurs.jimmy.tag6;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FileDemo {
    public static void main(String[] args) {
        final File start = new File(".");
        System.out.println("Recursive DFS");
        recursiveDfsFileSearch(start, "java");
        System.out.println();
        System.out.println("BFS");
        bfsFileSearch(start, "java");
        System.out.println();
        System.out.println("Iterative DFS");
        iterativeDfsFileSearch(start, "java");
    }

    public static void recursiveDfsFileSearch(final File from, final String suffix) {
        if (from == null) {
            return;
        }
        if (from.isFile()) {
            checkFile(from, suffix);
        }

        final File[] ls = from.listFiles();
        if (ls == null) {
            return;
        }
        for (final File currentFile : ls) {
            recursiveDfsFileSearch(currentFile, suffix);
        }
    }

    public static void bfsFileSearch(final File from, final String suffix) {
        if (from == null) {
            return;
        }
        if (from.isFile()) {
            checkFile(from, suffix);
        }
        final Queue<File> buffer = new LinkedList<>();
        buffer.offer(from);

        while (!buffer.isEmpty()) {
            final File current = buffer.poll();
            if (current.isDirectory()) {
                final File[] files = current.listFiles();
                if (files == null) {
                    continue;
                }
                for (final File nextFile : files) {
                    buffer.offer(nextFile);
                }
            } else if (current.isFile()) {
                checkFile(current, suffix);
            }
        }
    }

    public static void iterativeDfsFileSearch(final File from, final String suffix) {
        if (from == null) {
            return;
        }
        if (from.isFile()) {
            checkFile(from, suffix);
        }
        final Stack<File> buffer = new Stack<>();
        buffer.push(from);

        while (!buffer.isEmpty()) {
            final File current = buffer.pop();
            if (current.isDirectory()) {
                final File[] files = current.listFiles();
                if (files == null) {
                    continue;
                }
                for (final File nextFile : files) {
                    if (nextFile.isFile()) {
                        checkFile(nextFile, suffix);
                    } else if (nextFile.isDirectory()) {
                        buffer.push(nextFile);
                    }
                }
            }
        }
    }

    private static void checkFile(final File from, final String suffix) {
        if (from.getName().toLowerCase().endsWith(suffix.toLowerCase())) {
            System.out.println(from.getAbsolutePath());
        }
    }
}
