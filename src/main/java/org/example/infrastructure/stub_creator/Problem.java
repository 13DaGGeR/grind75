package org.example.infrastructure.stub_creator;

import java.net.URL;

public record Problem(String title, URL url) {
    public Problem(String title, URL url) {
        this.title = title;
        this.url = url;
        if (getWordsLc().length == 0) {
            throw new IllegalArgumentException("Bad title: '%s'".formatted(title));
        }
    }

    public String getPackageName() {
        String result = String.join("_", getWordsLc());
        if (result.matches("^\\d.*")) {
            result = "_" + result;
        }

        return result;
    }

    public String getTestClassName() {
        StringBuilder sb = new StringBuilder();
        for (String word : getWordsLc()) {
            String wordUCFirst = word.substring(0, 1).toUpperCase();
            if (word.length() > 1) {
                wordUCFirst += word.substring(1);
            }
            sb.append(wordUCFirst);
        }
        String result = sb.toString();
        if (result.matches("^\\d.*")) {
            result = "Problem" + result;
        }

        return result + "Test";
    }

    public String getFullSolutionPath() {
        return getFullSolutionPackagePath() + "/Solution.java";
    }

    public String getFullSolutionPackagePath() {
        return "./src/main/java/org/example/problems/" + getPackageName();
    }

    public String getFullTestClassPath() {
        return "./src/test/java/" + getTestClassName() + ".java";
    }

    private String[] getWordsLc() {
        return title.toLowerCase().split("[^a-z\\d]+");
    }
}
