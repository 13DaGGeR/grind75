package org.example;

import org.example.infrastructure.stub_creator.StubCreator;
import org.example.infrastructure.stub_creator.TableTransport;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        for (String arg: args) {
            if (arg.equals("stub")) {
                try {
                    new StubCreator(new TableTransport("./README.md")).run();
                } catch (IOException e) {
                    System.out.println("Failed to generate stubs: " + e);
                }
                return;
            }
        }

        System.out.println("Hello world!");
    }
}
