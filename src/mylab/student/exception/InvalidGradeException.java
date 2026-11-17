package mylab.student.exception;

public class InvalidGradeException extends Exception {

    public InvalidGradeException (String message, int currentGrade){
        super(message);
    }

}
