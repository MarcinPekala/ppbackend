package com.app.ppbackend.scheduler;

import com.app.ppbackend.controller.BookController;
import com.app.ppbackend.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSize {
    @Autowired
    private BookRepository bookRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Scheduled(fixedDelay = 10000)
    public void countBooks() {
       LOGGER.info("Books' size in the database: " + bookRepository.count());
    }
}
