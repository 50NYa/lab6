import java.io.Serializable;

public class Employee implements Serializable {
    protected int id;
    private static int nextId = 1;
    protected String name;
    protected String surname;
    protected double salary;
    protected Manager manager;

    public Employee(String name, String surname, double salary, Manager manager) {
        this.id = setId();
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.manager = manager;
    }

    public Employee() {
    }

    public void raiseSalary(double percent){
        this.salary += this.salary*percent;
    }
    public int setId(){
        return nextId++;
    }

    public String toString(){
        return "Employee " + this.id + ". Name - " + this.name + " " + this.surname + ". Salary - " + this.salary +  ". Manager - " + this.manager.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    final public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    final public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}

