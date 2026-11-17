package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;
import workshop.account.exception.InsufficientBalanceException;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("김민수", "컴퓨터공학", 3);
        try{
            student.setGrade(5);
        }
        catch (InvalidGradeException e){
            System.out.println("Error Message!\n" + e.getMessage());
        }

    }
}
