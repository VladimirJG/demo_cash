package ru.danilov.demo_cash.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BackupService {
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String databaseName;

    @Value("${backup.path}")
    private String backupPath;

    public void performBackup() throws IOException {
        String command = "pg_dump -U " + username + " -d " + databaseName + " -f " + backupPath;
        Process process = Runtime.getRuntime().exec(command);
    }
}
