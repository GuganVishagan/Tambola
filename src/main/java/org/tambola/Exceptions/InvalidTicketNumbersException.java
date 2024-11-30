package org.tambola.Exceptions;

public class InvalidTicketNumbersException extends RuntimeException{
    public InvalidTicketNumbersException(String message) {
        super(message);
    }
}
