import java.io.*;
import java.util.ArrayList;

public class Connector {

    public static ArrayList<Employee> setEmployee(ArrayList<Manager> managerList) throws IOException {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        Employee firstEmployee = null;
        BufferedReader reader = new BufferedReader(new FileReader("InputEmployeers.txt"));
        try {
            String stringFile;
            ArrayList input = new ArrayList<String>();
            while ((stringFile = reader.readLine()) != null) {
                input.add(stringFile);
            }
            for (int i = 0; i < input.size(); i++) {
                if (((String) input.get(i)).trim().length() == 0) {
                    i++;
                }
                String name = (String) input.get(i);
                i++;
                String surname = (String) input.get(i);
                i++;
                double salary = Double.parseDouble((String) input.get(i));
                i++;
                String managerIndexString = (String) input.get(i);
                Manager manager = null;
                if (managerIndexString != "null") {
                    manager = (Manager) managerList.get(Integer.parseInt(managerIndexString));
                }
                firstEmployee = new Employee(name, surname, salary, manager);
                employeeList.add(firstEmployee);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return employeeList;
    }

    public static ArrayList<Manager> setManager() throws IOException {
        ArrayList<Manager> managerList = new ArrayList<Manager>();
        Manager firstManager = null;
        BufferedReader reader = new BufferedReader(new FileReader("InputManager.txt"));
        try {
            String stringFile;
            ArrayList input = new ArrayList<String>();
            while ((stringFile = reader.readLine()) != null) {
                input.add(stringFile);
            }
            for (int i = 0; i < input.size(); i++) {
                if (((String) input.get(i)).trim().length() == 0) {
                    i++;
                }
                String name = (String) input.get(i);
                i++;
                String surname = (String) input.get(i);
                i++;
                double salary = Double.parseDouble((String) input.get(i));
                i++;
                double bonus = Double.parseDouble((String) input.get(i));
                firstManager = new Manager(name, surname, salary, null, bonus);
                managerList.add(firstManager);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return managerList;
    }

    public static void serialization(String fileNameSerialization, ArrayList<Employee> employeeList, ArrayList<Manager> managerList) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileNameSerialization);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        if (employeeList == null) {
            for (Manager manager : managerList) {
                oos.writeObject(manager);
                System.out.println(manager.toString());
                oos.flush();
            }
        } else {
            for (Employee employee : employeeList) {
                oos.writeObject(employee);
                System.out.println(employee.toString());
                oos.flush();
            }
        }
        oos.close();
    }

    public static void deserialization(String fileNameDeserialization, ArrayList<Employee> employeeList, ArrayList<Manager> manageList) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileNameDeserialization);
        ObjectInputStream ois = new ObjectInputStream(fis);
        if (employeeList == null) {
            for (int i = 0; i < manageList.size(); i++) {
                Manager manager = (Manager) ois.readObject();
                System.out.println(manager.toString());
            }
        } else {
            for (int i = 0; i < employeeList.size(); i++) {
                Employee employee = (Employee) ois.readObject();
                System.out.println(employee.toString());
            }
        }
    }
}

