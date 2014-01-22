package lab0;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
@SuppressWarnings("serial")

public class UserInterface extends JFrame //implements ActionListener
{
	public JTextField name;
	public JPasswordField password;
	public File file;
	public String name_str;
	public String pw_str;
	public BufferedWriter bw;
	public UserInterface()
	{
		super("MyJFrame");
		setSize(480, 320);
		setLocation(500, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //add(MyJPanel());
	}
	
}
