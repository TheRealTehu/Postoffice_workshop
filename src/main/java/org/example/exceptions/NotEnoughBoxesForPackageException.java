package org.example.exceptions;

public class NotEnoughBoxesForPackageException extends RuntimeException {
    public NotEnoughBoxesForPackageException(String message) {
        super(message);
    }
}
