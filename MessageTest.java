
package com.mycompany.chatapp;

import com.mycompany.chatapp.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message(
            "+27718693002",
            "Hi Mike, can you join us for dinner tonight?",
            1);

        assertEquals("Message ready to send.",
            msg.checkMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {
        String text = "A".repeat(251);

        Message msg = new Message(
            "+27718693002", text, 1);

        assertEquals(
            "Message exceeds 250 characters by 1; "
            + "please reduce the size.",
            msg.checkMessageLength());
    }

    @Test
    public void testRecipientSuccess() {
        Message msg = new Message(
            "+27718693002", "Hello", 1);

        assertEquals(
            "Cell phone number successfully captured.",
            msg.checkRecipientCell());
    }

    @Test
    public void testRecipientFailure() {
        Message msg = new Message(
            "08575975889", "Hello", 1);

        assertTrue(msg.checkRecipientCell()
            .contains("incorrectly formatted"));
    }

    @Test
    public void testMessageID() {
        Message msg = new Message(
            "+27718693002", "Hello", 1);

        assertTrue(msg.checkMessageID());
        assertEquals(10, msg.getMessageID().length());
    }

    @Test
    public void testMessageHash() {
        Message msg = new Message(
            "+27718693002",
            "Hi Mike, can you join us for dinner tonight?",
            1);

        String expected =
            msg.getMessageID().substring(0, 2)
            + ":1:HITONIGHT?";

        assertEquals(expected, msg.createMessageHash());
    }

    @Test
    public void testSendMessage() {
        Message msg = new Message(
            "+27718693002", "Hello", 1);

        assertEquals(
            "Message successfully sent.",
            msg.SentMessage(1));
    }

    @Test
    public void testStoreMessage() {
        Message msg = new Message(
            "+27718693002", "Hello", 1);

        assertEquals(
            "Message successfully stored.",
            msg.SentMessage(3));
    }
}


