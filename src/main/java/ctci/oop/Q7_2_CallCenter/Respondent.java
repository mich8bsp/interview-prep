package ctci.oop.Q7_2_CallCenter;

public class Respondent extends Employee {

    public Respondent(Employee manager) {
        this.supervisor = manager;
    }
}
