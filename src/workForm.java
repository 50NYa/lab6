import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class workForm extends JFrame{
    private JPanel panel1;
    private JButton readFile2;
    private JButton readFile1;
    private JPanel panelWorking;
    private JButton serializationButton;
    private JButton deserializationButton1;
    private JButton button3;
    private JButton deserializationButton;
    private JList list1;
    private JList list2;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private ArrayList<Manager> managersList;
    private ArrayList<Employee> employeesList;


    public workForm() {
        setContentPane(panel1);
        setTitle("My program");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        readFile1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(managersList == null)){
                    try {
                        employeesList = Connector.setEmployee(managersList);
                        list2.setListData(employeesList.toArray());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty managers list!!!");
                }
            }
        });
        //Серіалізація Employee
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(managersList == null)) {
                    try {
                        Connector.serialization("Employee.txt", employeesList, null);
                        JOptionPane.showMessageDialog(null, "Serialization employee done success!!!");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty managers list!!!");
                }
            }
        });
        //Десеріалізація Employee
        deserializationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(managersList == null)) {
                    try {
                        Connector.deserialization("Employee.txt", employeesList, null);
                        JOptionPane.showMessageDialog(null, "Deserialization employee done success!!!");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Empty managers list!!!");
                }
            }
        });

        //Зчитування з файла Employee

        readFile2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    managersList = Connector.setManager();
                    list1.setListData(managersList.toArray());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        serializationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.serialization("Manager.txt", null, managersList);
                    JOptionPane.showMessageDialog(null, "Serialization managers done success!!!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        deserializationButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connector.deserialization("Manager.txt", null, managersList);
                    JOptionPane.showMessageDialog(null, "Deserialization managers done success!!!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    };
}
