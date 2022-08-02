package org.example.infrastructure.stub_creator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableTransport {
    private final String filename;

    private static final String DELIMITER_BEFORE = "[//]: # (Problems list below)";
    private static final String DELIMITER_AFTER = "[//]: # (Problems list above)";
    private static final Pattern titlePattern = Pattern.compile("^\\s*\\|\\s*([^|]+?)\\s*\\|");
    private static final Pattern urlPattern = Pattern.compile("^\\s*\\|\\s*[^|]+?\\s*\\|[^|]+(https://[^\\s)]+)[\\s)]?");
    private static final Set<String> skipTitles = new HashSet<>(List.of("Name"));

    public TableTransport(String filename) {
        this.filename = filename;
    }

    public Problem[] getProblems() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        boolean isTable = false;
        List<Problem> result = new ArrayList<>();

        String row;
        while ((row = br.readLine()) != null) {
            if (!isTable && row.equals(DELIMITER_BEFORE)) {
                isTable = true;
                continue;
            }
            if (isTable && row.equals(DELIMITER_AFTER)) {
                break;
            }

            if (isTable && !row.isEmpty()) {
                String title = getTitle(row);
                if (!title.isEmpty() && title.charAt(0) != '-') {
                    result.add(new Problem(title, new URL(getUrl(row))));
                }
            }
        }
        fr.close();

        return result.toArray(new Problem[0]);
    }

    private static String getTitle(String row) {
        Matcher matcher = titlePattern.matcher(row);
        if (matcher.find() && !skipTitles.contains(matcher.group(1))) {
            return matcher.group(1);
        }
        return "";
    }

    private static String getUrl(String row) {
        Matcher matcher = urlPattern.matcher(row);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "http://test.test";
    }

    public void write(Problem problem) throws IOException {
        Path path = Path.of(filename);
        List<String> rows = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));

        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);
            if (getTitle(row).equals(problem.title())) {
                rows.set(i, String.format(
                    "| %s | [problem](%s) | [solution](%s) | [test](%s) |",
                    problem.title(),
                    problem.url(),
                    problem.getFullSolutionPath(),
                    problem.getFullTestClassPath()
                ));
                break;
            }
        }

        Files.write(path, rows, StandardCharsets.UTF_8);
    }
}
