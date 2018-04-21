package ctci.oop.Q7_2_CallCenter;

public class Manager extends Employee {

    public Manager(Employee director){
        this.supervisor = director;
    }
}
