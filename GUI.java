import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;

public class GUI {
    JFrame frame;
    JPanel panelMenu;
    JTextField firstName;
    JTextField lastName;
    JTextField domain;
    JTextField username;
    JTextField password;
    JTextField lookupName;
    JTextField delete;
    Email newEmail;
    ArrayList<Email> emails = new ArrayList<>();
    File file = new File("emails");

    public GUI() {
        checkForExisting();
        
        frame = new JFrame();
        panelMenu = new JPanel();
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(panelMenu);
        panelMenu.setLayout(null);
        frame.setTitle("Email Application");

        JLabel intro = new JLabel("Welcome! This program is designed to generate an email and password to use and to store them.");
        intro.setBounds(50, 10, 1000, 100);
        panelMenu.add(intro);

        JButton create = new JButton("Create");
        create.setBounds(50, 150, 100, 100);
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });
        panelMenu.add(create);

        JButton lookup = new JButton("Lookup");
        lookup.setBounds(200, 150, 100, 100);
        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lookup();
            }
        });
        panelMenu.add(lookup);

        JButton delete = new JButton("Delete");
        delete.setBounds(350, 150, 100, 100);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });
        panelMenu.add(delete);

        JButton showAll = new JButton("Show All");
        showAll.setBounds(500, 150, 100, 100);
        showAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAll();
            }
        });
        panelMenu.add(showAll);

        JButton quit = new JButton("Quit");
        quit.setBounds(290, 300, 90, 90);
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writeToFile();
                System.exit(0);
            }
        });
        panelMenu.add(quit);
    }

    public void checkForExisting() {
        if (file.exists() && file.length() != 0) {
            try {
                FileInputStream fis = new FileInputStream("emails");
                ObjectInputStream ois = new ObjectInputStream(fis);
                emails = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
                return;
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class not found");
                c.printStackTrace();
                return;
            }
        }
    }

    public void writeToFile() {
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
    }

    public void create() {
        JPanel createPanel = new JPanel();
        frame.getContentPane().remove(panelMenu);
        frame.getContentPane().add(createPanel);
        frame.validate();

        JLabel firstNamePrompt = new JLabel("Enter first name:");
        firstNamePrompt.setBounds(50, 10, 1000, 100);
        createPanel.add(firstNamePrompt);
        
        firstName = new JTextField(20);
        firstName.setBounds(50, 70, 500, 30);
        createPanel.add(firstName);
        createPanel.revalidate();

        JPanel createPanel2 = new JPanel();

        JLabel lastNamePrompt = new JLabel("Enter last name:");
        lastNamePrompt.setBounds(50, 80, 1000, 100);
        createPanel2.add(lastNamePrompt);

        lastName = new JTextField(20);
        lastName.setBounds(50, 140, 500, 30);
        createPanel2.add(lastName);

        firstName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPanel.add(createPanel2);
                createPanel.revalidate();
            }
        });

        JPanel createPanel3 = new JPanel();
        
        JLabel domainPrompt = new JLabel("Enter domain:");
        domainPrompt.setBounds(50, 150, 1000, 100);
        createPanel3.add(domainPrompt);

        domain = new JTextField(20);
        domain.setBounds(50, 210, 500, 30);
        createPanel3.add(domain);

        lastName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPanel.add(createPanel3);
                createPanel.revalidate();
            }
        });

        JPanel createPanel4 = new JPanel();
        
        JLabel usernamePrompt = new JLabel("Enter username or choose default:");
        usernamePrompt.setBounds(50, 220, 1000, 100);
        createPanel4.add(usernamePrompt);

        username = new JTextField(20);
        username.setBounds(50, 280, 500, 30);
        createPanel4.add(username);

        JButton defaultUsername = new JButton("Default");
        defaultUsername.setBounds(400, 280, 100, 30);
        createPanel4.add(defaultUsername);

        domain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createPanel.add(createPanel4);
                createPanel.revalidate();
            }
        });

        JPanel createPanel5 = new JPanel();

        JLabel passwordPrompt = new JLabel("Enter password or generate random:");
        passwordPrompt.setBounds(50, 290, 1000, 100);
        createPanel5.add(passwordPrompt);

        password = new JTextField(20);
        password.setBounds(50, 350, 500, 30);
        createPanel5.add(password);

        JButton randomPassword = new JButton("Random");
        randomPassword.setBounds(400, 350, 100, 30);
        createPanel5.add(randomPassword);
        
        username.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newEmail = new Email(firstName.getText(), lastName.getText(), username.getText(), domain.getText());
                createPanel.add(createPanel5);
                createPanel.revalidate();
            }
        });

        defaultUsername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newEmail = new Email(firstName.getText(), lastName.getText(), domain.getText());
                createPanel.add(createPanel5);
                createPanel.revalidate();
            }
        });

        JPanel createPanel6 = new JPanel();

        password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newEmail.setPassword(password.getText());

                JLabel email = new JLabel(newEmail.getInfo());
                createPanel6.add(email);

                JButton done = new JButton("Done");
                done.setBounds(1000, 1000, 100, 30);
                createPanel6.add(done);

                createPanel.add(createPanel6);
                createPanel.revalidate();

                done.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        emails.add(newEmail);
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().add(panelMenu);
                        frame.validate();
                    }
                });
            }
        });

        randomPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel passwordLength = new JLabel("Enter length you would like:");
                passwordLength.setBounds(50, 300, 1000, 100);
                createPanel6.add(passwordLength);

                JTextField length = new JTextField(20);
                length.setBounds(50, 360, 500, 30);
                createPanel6.add(length);

                createPanel.add(createPanel6);
                createPanel.revalidate();

                length.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        JPanel createPanel7 = new JPanel();
                        
                        newEmail.setRandomPassword(Integer.parseInt(length.getText()));
                        JLabel email = new JLabel(newEmail.getInfo());
                        createPanel7.add(email);

                        JButton done = new JButton("Done");
                        done.setBounds(1000, 1000, 100, 30);
                        createPanel7.add(done);

                        createPanel.add(createPanel7);
                        createPanel.revalidate();

                        done.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                emails.add(newEmail);
                                frame.getContentPane().removeAll();
                                frame.repaint();
                                frame.getContentPane().add(panelMenu);
                                frame.validate();
                            }
                        });
                    }
                });
            }
        });
    }

    public void showAll() {
        JPanel showAllPanel = new JPanel();
        frame.getContentPane().remove(panelMenu);
        frame.getContentPane().add(showAllPanel);
        frame.validate();
        
        if (emails.size() == 0) {
            JLabel none = new JLabel("There are no emails stored.");
            none.setBounds(250, 10, 1000, 100);
            showAllPanel.add(none);

            JButton returnButton = new JButton("Return");
            returnButton.setBounds(280, 80, 100, 30);
            showAllPanel.add(returnButton);

            returnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.getContentPane().add(panelMenu);
                    frame.validate();
                }
            });
        }
        
        else {
            int startColumn = 50;
            int columns = 1;
            int startRow = 10;
            for (int i = 0; i < emails.size(); i++) {
                JLabel email = new JLabel(emails.get(i).getInfo());
                email.setBounds(startColumn, startRow, 1000, 100);
                showAllPanel.add(email);
                startColumn += 250;
                columns++;
                if (columns == 3) {
                    startColumn = 50;
                    startRow += 100;
                    columns = 1;
                }
            }

            JButton returnButton = new JButton("Return");
            returnButton.setBounds(startColumn + 50, startRow, 100, 30);
            showAllPanel.add(returnButton);

            returnButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.getContentPane().add(panelMenu);
                    frame.validate();
                }
            });
        }
    }

    public void lookup() {
        JPanel lookupPanel = new JPanel();
        frame.getContentPane().remove(panelMenu);
        frame.getContentPane().add(lookupPanel);
        frame.validate();

        JLabel lookupPrompt = new JLabel("Enter name to lookup:");
        lookupPrompt.setBounds(50, 10, 1000, 100);
        lookupPanel.add(lookupPrompt);
        
        lookupName = new JTextField(20);
        lookupName.setBounds(50, 70, 500, 30);
        lookupPanel.add(lookupName);

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(250, 150, 100, 30);
        lookupPanel.add(menuButton);
        lookupPanel.revalidate();

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.getContentPane().add(panelMenu);
                    frame.validate();
            }
        });
        
        lookupName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel foundPanel = new JPanel();
                
                int startColumn = 100;
                int columns = 1;
                int startRow = 10;
                boolean found = false;
                for (int i = 0; i < emails.size(); i++) {
                    if (lookupName.getText().equals(emails.get(i).getName())) {
                        JLabel email = new JLabel(emails.get(i).getInfo());
                        email.setBounds(startColumn, startRow, 1000, 100);
                        foundPanel.add(email);
                        
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().add(foundPanel);
                        frame.validate();

                        startColumn += 250;
                        columns++;
                        if (columns == 3) {
                            startColumn = 50;
                            startRow += 100;
                            columns = 1;
                        }

                        found = true;
                    }
                }

                if (!found) {
                    JLabel notFound = new JLabel("Name and Email not found!");
                    notFound.setBounds(350, 40, 1000, 100);
                    foundPanel.add(notFound);
                }

                JButton returnButton = new JButton("Return");
                returnButton.setBounds(startColumn + 50, startRow, 100, 30);
                foundPanel.add(returnButton);

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().add(foundPanel);
                frame.validate();

                returnButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().add(lookupPanel);
                        frame.validate();
                    }
                });
            }
        });
    }

    public void delete() {
        JPanel deletePanel = new JPanel();
        frame.getContentPane().remove(panelMenu);
        frame.getContentPane().add(deletePanel);
        frame.validate();

        JLabel deletePrompt = new JLabel("Enter name to delete:");
        deletePrompt.setBounds(50, 10, 1000, 100);
        deletePanel.add(deletePrompt);
        
        delete = new JTextField(20);
        delete.setBounds(50, 70, 500, 30);
        deletePanel.add(delete);

        JButton menuButton = new JButton("Menu");
        menuButton.setBounds(250, 150, 100, 30);
        deletePanel.add(menuButton);
        deletePanel.revalidate();

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                    frame.repaint();
                    frame.getContentPane().add(panelMenu);
                    frame.validate();
            }
        });

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel foundPanel = new JPanel();
                
                int startColumn = 100;
                int columns = 1;
                int startRow = 10;
                boolean found = false;
                for (int i = 0; i < emails.size(); i++) {
                    if (lookupName.getText().equals(emails.get(i).getName())) {
                        JLabel removedEmail = new JLabel("Email Removed:");
                        removedEmail.setBounds(100, 5, 1000, 100);
                        foundPanel.add(removedEmail);
                        
                        JLabel email = new JLabel(emails.get(i).getInfo());
                        email.setBounds(startColumn, startRow, 1000, 100);
                        foundPanel.add(email);

                        emails.remove(i);
                                
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().add(foundPanel);
                        frame.validate();

                        startColumn += 250;
                        columns++;
                        if (columns == 3) {
                            startColumn = 50;
                            startRow += 100;
                            columns = 1;
                        }

                        found = true;
                    }
                }

                if (!found) {
                    JLabel notFound = new JLabel("Name and Email not found!");
                    notFound.setBounds(350, 40, 1000, 100);
                    foundPanel.add(notFound);
                }

                JButton returnButton = new JButton("Return");
                returnButton.setBounds(startColumn + 50, startRow, 100, 30);
                foundPanel.add(returnButton);

                frame.getContentPane().removeAll();
                frame.repaint();
                frame.getContentPane().add(foundPanel);
                frame.validate();

                returnButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.getContentPane().removeAll();
                        frame.repaint();
                        frame.getContentPane().add(deletePanel);
                        frame.validate();
                    }
                });
            }
        });
    }
}
