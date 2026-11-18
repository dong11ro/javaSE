package chapter5.oop.bad;

public abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
//    public abstract String getName() ;
//
//    public abstract double getSalary();
//
//    public abstract void manageSalary(double rate);
}
