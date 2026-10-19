
package com.mycompany.chatapp;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private int messageNumber;

    // Constructor
    public Message(String recipient, String message,
                   int messageNumber) {

        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;

        Random random = new Random();

        long number = random.nextLong(
                10_000_000_000L);

        this.messageID =
                String.format("%010d", number);
    }

    // Check Message ID
    public boolean checkMessageID() {
        return messageID != null
                && messageID.matches("\\d{10}");
    }

    // Check recipient number
    
public String checkRecipientCell() {

    if (recipient != null
            && recipient.matches("\\+27[0-9]{9}")) {

        return "Cell phone number successfully captured.";
    }

    return "Cell phone number is incorrectly formatted "
            + "or does not contain an international code. "
            + "Please correct the number and try again.";
}


    // Check message length
    public String checkMessageLength() {

        if (message.length() <= 250) {
            return "Message ready to send.";
        }

        int extra = message.length() - 250;

        return "Message exceeds 250 characters by "
                + extra
                + "; please reduce the size.";
    }

    // Create Message Hash
    public String createMessageHash() {

        String[] words =
                message.trim().split("\\s+");

        String firstWord = words[0];

        String lastWord =
                words[words.length - 1];

        messageHash = (
                messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord + lastWord
                ).toUpperCase();

        return messageHash;
    }

    // Send, discard or store
    public String SentMessage(int choice) {

        switch (choice) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete the message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Display message information
    
public String storeMessage() {

    java.io.File file =
            new java.io.File("messages.json");

    try {
        String json = "{"
                + "\"messageID\":\""
                + escapeJson(messageID) + "\","
                + "\"messageHash\":\""
                + escapeJson(messageHash) + "\","
                + "\"recipient\":\""
                + escapeJson(recipient) + "\","
                + "\"message\":\""
                + escapeJson(message) + "\""
                + "}";

        String existing = "[]";

        if (file.exists()) {
            existing = java.nio.file.Files.readString(
                    file.toPath()).trim();
        }

        if (!existing.startsWith("[")
                || !existing.endsWith("]")) {
            return "Error: Existing file is not a JSON array.";
        }

        String content = existing.substring(
                1, existing.length() - 1).trim();

        String updated;

        if (content.isEmpty()) {
            updated = "[\n" + json + "\n]";
        } else {
            updated = "[\n" + content
                    + ",\n" + json + "\n]";
        }

        java.nio.file.Files.writeString(
                file.toPath(), updated);

        return "Message successfully stored.";

    } catch (java.io.IOException e) {
        return "Error storing message: "
                + e.getMessage();
    }
}
