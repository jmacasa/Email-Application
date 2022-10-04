import java.util.*;

import javax.swing.*;

import java.io.*;

public class EmailApp {
    public static void main(String[] args) throws Exception {
        new GUI();
        /*Scanner scnr = new Scanner(System.in);
        String firstName;
        String lastName;
        String domain;
        int length;
        String username;
        String password;
        String name;
        ArrayList<Email> emails = new ArrayList<>();
        Email newEmail;
        File file = new File("emails");
        System.out.println("Welcome! This program is designed to generate an email and password to use and store them.");
        if (file.exists() && file.length() != 0) {
            System.out.println("Current emails stored: ");
            System.out.println("");

            try {
                FileInputStream fis = new FileInputStream("emails");
                ObjectInputStream ois = new ObjectInputStream(fis);
                emails = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                scnr.close();
                return;
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
                scnr.close();
                return;
            }

            for (int i = 0; i < emails.size(); i++) {
                System.out.println(emails.get(i).getInfo());
                System.out.println("");
            }
        }
        String command;
        while (true) {
            command = "";
            System.out.print("Enter command: (c)reate new email and password, (l)ookup email and password, (s)how all emails, (d)elete an email, or (q)uit: ");
            command = scnr.nextLine();

            if (command.equals("q")) {
                break;
            }

            switch (command) {
                case "c":
                    System.out.print("Enter first name: ");
                    firstName = scnr.nextLine();
                    System.out.print("Enter last name: ");
                    lastName = scnr.nextLine();
                    System.out.print("Enter the domain you want to use: ");
                    domain = scnr.nextLine();
                    System.out.print("Enter username you would like or (d)efault username: ");
                    username = scnr.nextLine();
                    if (username.equals("d")) {
                        newEmail = new Email(firstName, lastName, domain);
                    }
                    else {
                        newEmail = new Email(firstName, lastName, username, domain);
                    }
                    System.out.print("Enter password you would like or (r)andom password: ");
                    password = scnr.nextLine();
                    if (password.equals("r")) {
                        System.out.print("Enter the length of the password you would like: ");
                        length = scnr.nextInt();
                        newEmail.setRandomPassword(length);
                        scnr.nextLine();
                    }
                    else {
                        newEmail.setPassword(password);
                    }
                    System.out.println(newEmail.getInfo());
                    emails.add(newEmail);
                    break;
                
                case "s":
                    System.out.println("");
                    for (int i = 0; i < emails.size(); i++) {
                        System.out.println(emails.get(i).getInfo());
                        System.out.println("");
                    }
                    break;
                
                case "l":
                    boolean found = false;
                    System.out.print("Enter name of person to search: ");
                    name = scnr.nextLine();
                    for (int i = 0; i < emails.size(); i++) {
                        if (name.equals(emails.get(i).getName())) {
                            System.out.println(emails.get(i).getInfo());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Name not found!");
                    }
                    break;
                
                case "d":
                    System.out.print("Enter exact name of person to delete: ");
                    name = scnr.nextLine();
                    for (int i = 0; i < emails.size(); i++) {
                        if (name.equals(emails.get(i).getName())) {
                            System.out.println("Email removed: ");
                            System.out.println(emails.get(i).getInfo());
                            emails.remove(i);
                        }
                    }

            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("emails");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emails);
            oos.close();
            fos.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        scnr.close();*/
    }
}
