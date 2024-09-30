import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {


        JFileChooser chooser = new JFileChooser();
        StringBuilder content = new StringBuilder();
        File selectedFile;
        String rec = "";
        ArrayList words = new ArrayList();
        ArrayList<Filter> filter = new ArrayList<>();
        ArrayList filtered = new ArrayList();
        Object x = null;

        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineWords = line.split("\\s+");
                    for (String word : lineWords) {
                        if (!word.isEmpty()) {
                            words.add(word);
                            filter.add(new ShortWordFilter(word));
                        }
                    }
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

            for (Filter f : filter) {
                if (f.accept(x) == true) {
                    filtered.add(words.get(filter.indexOf(f)));
                }
        }
            for (int i = 0; i < filtered.size(); i++) {
                System.out.println(filtered.get(i));
            }

    }


    }
