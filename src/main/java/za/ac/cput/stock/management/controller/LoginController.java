/**
 *
 * @author Kurtney Clyde Jantjies (218138105)
 * @group: Second Year
 */

package za.ac.cput.stock.management.controller;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import za.ac.cput.stock.management.client.entry.Client;
import za.ac.cput.stock.management.client.gui.MainFrame;
import za.ac.cput.stock.management.common.User;


public class LoginController 
{
    private Client client;
    private MainFrame mainFrame;
    
<<<<<<< HEAD
    public LoginController() 
    {
        try
        {
            client = new Client();
            client.startConnection();
        } 
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(mainFrame, "Server Offline.");
        }
=======
    public LoginController(){
        client = new Client();
>>>>>>> e1abe7b5ed5189d8a3f21f8c89b13931bdf4aa12
    }
    
    public void checkAuthentication(String userName, String password, JFrame frame)
    {
        User validUser = null;
        var user = new User(userName, password);
        
        try
        {
            validUser = this.client.requestLogin(user);
        }
        catch(NullPointerException ex)
        {
            JOptionPane.showMessageDialog(frame, "Server offline.");
            return;
        }
        
        if (validUser != null)
        {
            mainFrame = new MainFrame();
            // admin login
            if (validUser.getUserRole().getRoleCode() == 1 
                    && validUser.isStatus())
            {
                JOptionPane.showMessageDialog(frame, 
                        "Welcome " + userName + "!");
                mainFrame.setVisible(true);
                mainFrame.getLoginIcnLbl().setText(userName);
                mainFrame.getWelcomeLbl().setText("Welcome " + userName + "!!");
                frame.dispose();
            }
            // employee login
            else if (validUser.getUserRole().getRoleCode() == 2 
                    && validUser.isStatus())
            {
                JOptionPane.showMessageDialog(frame, 
                        "Welcome " + userName + "!");
                mainFrame.setVisible(true);
                mainFrame.getAdminMenu().setVisible(false);
                mainFrame.getLoginIcnLbl().setText(userName);
                frame.dispose();
            }
            // account disabled
            else 
            {
<<<<<<< HEAD
                JOptionPane.showMessageDialog(frame, 
                    "Account disabled.");
=======
                
                mainFrame = new MainFrame();
                // admin login
                if (validUser.getUserRole().getRoleCode() == 1 
                        && validUser.isStatus())
                {
                    mainFrame.setVisible(true);
                    mainFrame.getLoginIcnLbl().setText(userName);
                    mainFrame.getWelcomeLbl().setText("Welcome " + userName + "!!");
                    frame.dispose();
                    System.out.println(userName + " logged in");
                }
                // employee login
                else if (validUser.getUserRole().getRoleCode() == 2 
                        && validUser.isStatus())
                {
                    mainFrame.setVisible(true);
                    mainFrame.getAdminMenu().setVisible(false);
                    mainFrame.getLoginIcnLbl().setText(userName);
                    frame.dispose();
                    System.out.println(userName + " logged in.");
                }
                // account disabled
                else 
                {
                    System.out.println("Account is disabled");
                }
            }
            else
            {
                // the user doesnt have an account
                System.out.println("Incorrect username or password. Try again.");
>>>>>>> e1abe7b5ed5189d8a3f21f8c89b13931bdf4aa12
            }
        }
        else
        {
            // the user doesnt have an account
            JOptionPane.showMessageDialog(frame, 
                    "Incorrect username or password.\nTry again.");
        }
    }
}
