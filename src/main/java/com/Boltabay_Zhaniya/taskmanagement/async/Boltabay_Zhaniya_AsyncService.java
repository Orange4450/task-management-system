package com.Boltabay_Zhaniya.taskmanagement.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class Boltabay_Zhaniya_AsyncService {
    @Async
    public CompletableFuture<String> sendEmail() {

        log.info("Sending email...");

        return CompletableFuture.completedFuture("Email sent");
    }

    @Async
    public CompletableFuture<String> generateReport() {

        log.info("Generating report...");

        return CompletableFuture.completedFuture("Report generated");
    }

    @Async
    public CompletableFuture<String> saveLogs() {

        log.info("Saving logs...");

        return CompletableFuture.completedFuture("Logs saved");
    }
}
