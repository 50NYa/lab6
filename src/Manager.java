import java.io.Serializable;

public class Manager extends Employee implements Serializable {
    private double bonus;

    public Manager(String name, String surname, double salary, Manager manager, double bonus) {
        super(name, surname, salary, manager);
        this.bonus = bonus;
    }

    @Override
    public double getSalary(){
        return this.salary + this.bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString(){
        return "Manager " + this.id + ". Name - " + this.name + " " + this.surname + ". Salary - " + this.salary +
                ". Bonus - " + this.bonus;
    }
}

