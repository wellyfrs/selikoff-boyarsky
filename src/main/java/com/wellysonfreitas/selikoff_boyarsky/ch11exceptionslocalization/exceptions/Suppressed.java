package com.wellysonfreitas.selikoff_boyarsky.ch11exceptionslocalization.exceptions;

// UNDERSTANDING SUPPRESSED EXCEPTIONS
// When multiples exceptions are thrown, all but the first are called suppressed exceptions.

class SuppressedCheckedException {
    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("Turkeys ran off"); // This checked exception is not the suppressed one
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
            for (Throwable t: e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage()); // Close exception is suppressed
            }
        }
    }
}

class SuppressedRuntimeException {
    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new RuntimeException("Turkeys ran off"); // This runtime exception is not the suppressed one
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage()); // Close exception is suppressed
        }
    }
}

// Suppressed exceptions apply only to exceptions thrown in the try clause
@SuppressWarnings("ThrowFromFinallyBlock")
class SuppressedException {
    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("Turkeys ran off");
        } finally {
            throw new RuntimeException("and we couldn't find them"); // Not suppressed 
        }
    }
}

class JammedTurkeyCage implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close"); // exception in the close method
    }

    public static void main(String[] args) {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("Put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
