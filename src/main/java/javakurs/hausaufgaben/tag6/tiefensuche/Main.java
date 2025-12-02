package javakurs.hausaufgaben.tag6.tiefensuche;

import java.io.File;
import java.util.Objects;

public class Main {
    public static void main(String[] args)
    {
        final File fileOrDirectory = new File("~");

        try
        {
            searchForTextFiles(fileOrDirectory);
        }
        catch (Exception e)
        {
            System.out.println("Ungültiger Dateipfad.");
        }
    }

    public static void searchForTextFiles(final File fileOrDirectory)
    {
        if (fileOrDirectory.isFile() && fileOrDirectory.getName().equals(".java"))
        {
            System.out.println(fileOrDirectory.getAbsolutePath());
        }
        else if (fileOrDirectory.isDirectory())
        {
            for (File file : Objects.requireNonNull(fileOrDirectory.listFiles()))
            {
                searchForTextFiles(file);
            }
        }
    }
}