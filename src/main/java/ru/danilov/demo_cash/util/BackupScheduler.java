package ru.danilov.demo_cash.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.danilov.demo_cash.service.BackupService;

import java.io.IOException;

@Component
public class BackupScheduler {

    private final BackupService backupService;

    @Autowired
    public BackupScheduler(BackupService backupService) {
        this.backupService = backupService;
    }

    @Scheduled(cron = "0 0 0 * * *") // Каждый день в полночь
    public void scheduleBackup() {
        try {
            backupService.performBackup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //планировщик задач Windows для запуска : java -jar demo_cash.jar.

}
