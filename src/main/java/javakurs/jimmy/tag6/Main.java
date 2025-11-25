package javakurs.jimmy.tag6;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        final File a = new File(".");
        searchForTextFiles(a);
    }

    public static <element> void searchForTextFiles(final File fileOrDirectory) {
        if (fileOrDirectory.isFile() && fileOrDirectory.getName().endsWith(".java")) {
            System.out.println(fileOrDirectory.getAbsoluteFile());
        } else if (fileOrDirectory.isDirectory()) {
            for (File a : fileOrDirectory.listFiles()) {
                searchForTextFiles(a);
            }
        } else {
            return;
        }
    }

}
