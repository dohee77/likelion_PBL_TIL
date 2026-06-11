package week8_9_10.PBL.global.exception;

public class AssignmentNotFoundException extends RuntimeException {

    public AssignmentNotFoundException(String message) {
        super(message);
    }
}