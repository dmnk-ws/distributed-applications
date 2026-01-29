package com.example.dist_app.review.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configuration class for WebSocket messaging support.
 * Enables STOMP messaging over WebSocket for real-time communication
 * between clients and the server, primarily used for the review system.
 *
 * @see org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * Default constructor.
     */
    public WebSocketConfig() {
    }

    /**
     * Configures the message broker for handling WebSocket messages.
     * Sets up a simple in-memory broker for broadcasting messages to subscribers
     * and defines the application destination prefix for client messages.
     *
     * @param config the message broker registry to configure
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/shop");
    }

    /**
     * Registers STOMP endpoints that clients will use to connect to the WebSocket server.
     * The endpoint /review-websocket is used for establishing WebSocket connections
     * for the review messaging functionality.
     *
     * @param registry the STOMP endpoint registry to configure
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/review-websocket");
    }
}