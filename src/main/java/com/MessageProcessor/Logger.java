package com.MessageProcessor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private String logFilePath;

    public Logger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    // Grava o log de inatividade
    public void logInactivity(LocalDateTime inactivityTime) {
        try (FileWriter writer = new FileWriter(logFilePath, true)) {
            String log = "Inatividade detectada às: " + inactivityTime + "\n";
            writer.write(log);
            System.out.println(log);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o log: " + e.getMessage());
        }
    }
}