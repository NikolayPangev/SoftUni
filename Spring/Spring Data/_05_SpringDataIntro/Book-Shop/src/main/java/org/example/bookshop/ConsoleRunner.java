package org.example.bookshop;

import org.example.bookshop.service.SeedService;
import org.springframework.boot.CommandLineRunner;

public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;

    public ConsoleRunner(SeedService seedService) {
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAllData();

    }
}
