package org.example.infrastructure.stub_creator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StubCreator {
    final TableTransport table;

    public StubCreator(TableTransport table) {
        this.table = table;
    }

    public void run() throws IOException {
        for (Problem problem : table.getProblems()) {
            boolean hasUpdates = false;
            if (!hasSolution(problem)) {
                try {
                    generateSolutionStub(problem);
                    System.out.printf("Created solution stub for '%s'\n", problem.title());
                    hasUpdates = true;
                } catch (IOException e) {
                    System.out.printf("Failed to create solution stub for '%s': %s\n", problem.title(), e);
                    continue;
                }
            }
            if (!hasTest(problem)) {
                try {
                    generateTestStub(problem);
                    System.out.printf("Created test stub for '%s'\n", problem.title());
                    hasUpdates = true;
                } catch (IOException e) {
                    System.out.printf("Failed to create test stub for '%s': %s\n", problem.title(), e);
                    continue;
                }
            }

            if (hasUpdates) {
                table.write(problem);
                System.out.println("Table updated");
            }
        }
        System.out.println("Stub creation finished");
    }

    private boolean hasSolution(Problem problem) {
        return new File(problem.getFullSolutionPath()).exists();
    }

    private boolean hasTest(Problem problem) {
        return new File(problem.getFullTestClassPath()).exists();
    }

    private void generateSolutionStub(Problem problem) throws IOException {
        String template = Files.readString(Path.of("./src/main/resources/templates/solution.template"));
        String stub = template.formatted(problem.getPackageName(), problem.title(), problem.url());
        if (!new File(problem.getFullSolutionPackagePath()).mkdirs()) {
            throw new IOException("Can't create package directory at " + problem.getFullSolutionPackagePath());
        }
        Files.writeString(Path.of(problem.getFullSolutionPath()), stub);
    }

    private void generateTestStub(Problem problem) throws IOException {
        String template = Files.readString(Path.of("./src/main/resources/templates/test.template"));
        String stub = template.formatted(problem.getTestClassName());
        Files.writeString(Path.of(problem.getFullTestClassPath()), stub);
    }
}

