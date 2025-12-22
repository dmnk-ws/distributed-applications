package com.example.dist_app.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 * Service implementation for email operations.
 * Handles sending email notifications to users.
 */
@Service
public class EmailService implements IEmailService {
    /**
     * Default constructor.
     */
    public EmailService() {
    }

    /**
     * Sends an email notification to the specified user.
     * Currently, logs the email action for demonstration purposes.
     *
     * @param userId the ID of the user to send the email to
     */
    @Override
    public void sendEMail(Long userId) {
        Logger logger = Logger.getLogger("email");

        logger.info("An email has been sent to userId: " + userId);
    }
}
