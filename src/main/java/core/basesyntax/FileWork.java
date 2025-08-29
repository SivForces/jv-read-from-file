package core.basesyntax;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public Object[] readFromFile(String fileName) {
        File myFile = new File(fileName);
        List<String> lines;
        try {
            lines = Files.readAllLines(myFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        String strings = String.join(" ", lines);
        strings = strings.toLowerCase();
        String[] split = strings.split("\\W+");
        if (split.length == 0) {
            return (new String[0]);
        }
        ArrayList<String> result = new ArrayList<>();
        for (String s : split) {
            if (s.startsWith("w")) {
                    result.add(s);
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
