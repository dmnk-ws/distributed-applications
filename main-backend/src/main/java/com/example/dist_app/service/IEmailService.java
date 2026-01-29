package com.example.dist_app.service;

/**
 * Service interface for email operations.
 * Provides methods for sending email notifications to users.
 */
public interface IEmailService {
    /**
     * Sends an email notification to the specified user.
     *
     * @param userId the ID of the user to send the email to
     */
    void sendEMail(Long userId);
}
