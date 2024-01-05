import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class GradeCalculator extends JFrame implements ActionListener
{
	JLabel l1,name,rollno,sub1,sub2,sub3,sub4,sub5,totalmarks,percentage,grade;
	JTextField tfname,tfrollno,tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tftotalmarks,tfpercentage,tfgrade;
	JButton jbcalculate,jbclear,jbexit;
	double per;
	GradeCalculator()
	{
		getContentPane().setBackground(Color.WHITE);
       	setLayout(null);
       
		l1 = new JLabel("Student Grade Calculator");
		l1.setBounds(150,20,1200,60);
		l1.setFont(new Font("Serif",Font.BOLD,50));
		add(l1);

		name = new JLabel("Student Name");
		name.setBounds(100,100,150,30);
		name.setFont(new Font("Serif",Font.BOLD,20));
		add(name);

		tfname = new JTextField();
		tfname.setBounds(250,100,150,30);
		add(tfname);

		rollno = new JLabel("Student RollNo");
		rollno.setBounds(100,150,150,30);
		rollno.setFont(new Font("Serif",Font.BOLD,20));
		add(rollno);

		tfrollno = new JTextField();
		tfrollno.setBounds(250,150,150,30);
		add(tfrollno);

		sub1 = new JLabel("Physics");
		sub1.setBounds(100,200,150,30);
		sub1.setFont(new Font("Serif",Font.BOLD,20));
		add(sub1);

		tfsub1 = new JTextField();
		tfsub1.setBounds(250,200,150,30);
		add(tfsub1);

		sub2 = new JLabel("Chemistry");
		sub2.setBounds(100,250,150,30);
		sub2.setFont(new Font("Serif",Font.BOLD,20));
		add(sub2);

		tfsub2 = new JTextField();
		tfsub2.setBounds(250,250,150,30);
		add(tfsub2);

		sub3 = new JLabel("Maths");
		sub3.setBounds(100,300,150,30);
		sub3.setFont(new Font("Serif",Font.BOLD,20));
		add(sub3);

		tfsub3 = new JTextField();
		tfsub3.setBounds(250,300,150,30);
		add(tfsub3);

		sub4 = new JLabel("English");
		sub4.setBounds(100,350,150,30);
		sub4.setFont(new Font("Serif",Font.BOLD,20));
		add(sub4);

		tfsub4 = new JTextField();
		tfsub4.setBounds(250,350,150,30);
		add(tfsub4);

		sub5 = new JLabel("Biology");
		sub5.setBounds(100,400,150,30);
		sub5.setFont(new Font("Serif",Font.BOLD,20));
		add(sub5);

		tfsub5 = new JTextField();
		tfsub5.setBounds(250,400,150,30);
		add(tfsub5);

		totalmarks = new JLabel("Total Marks");
		totalmarks.setBounds(500,150,150,30);
		totalmarks.setFont(new Font("Serif",Font.BOLD,20));
		add(totalmarks);

		tftotalmarks = new JTextField();
		tftotalmarks.setBounds(650,150,150,30);
		add(tftotalmarks);

		percentage = new JLabel("Percentage");
		percentage.setBounds(500,200,150,30);
		percentage.setFont(new Font("Serif",Font.BOLD,20));
		add(percentage);

		tfpercentage = new JTextField();
		tfpercentage.setBounds(650,200,150,30);
		add(tfpercentage);

		grade = new JLabel("Grade");
		grade.setBounds(500,250,150,30);
		grade.setFont(new Font("Serif",Font.BOLD,20));
		add(grade);

		tfgrade = new JTextField();
		tfgrade.setBounds(650,250,150,30);
		add(tfgrade);

		jbcalculate = new JButton("Calculate");
		jbcalculate.setBounds(150,500,150,30);
		jbcalculate.setBackground(Color.BLACK);
		jbcalculate.setForeground(Color.WHITE);
		jbcalculate.addActionListener(this);
		add(jbcalculate);

		jbclear = new JButton("Clear");
		jbclear.setBounds(350,500,150,30);
		jbclear.setBackground(Color.BLACK);
		jbclear.setForeground(Color.WHITE);
		jbclear.addActionListener(this);
		add(jbclear);

		jbexit = new JButton("Exit");
		jbexit.setBounds(550,500,150,30);
		jbexit.setBackground(Color.BLACK);
		jbexit.setForeground(Color.WHITE);
		jbexit.addActionListener(this);
		add(jbexit);

		setSize(900,600);
		setLocation(200,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ee)
	{
		try{
			if(ee.getSource()==jbcalculate)
			{
				String s_name = tfname.getText();
				int r_no = Integer.parseInt(tfrollno.getText());
				double phy = Double.parseDouble(tfsub1.getText());
				double chem = Double.parseDouble(tfsub2.getText());
				double mths = Double.parseDouble(tfsub3.getText());
				double eng = Double.parseDouble(tfsub4.getText());
				double bio = Double.parseDouble(tfsub5.getText());
				double total = phy+chem+mths+eng+bio;
				 per = (total/500)*100;
				tftotalmarks.setText(""+total);
				tfpercentage.setText(Double.toString(per));
			}
			if(ee.getSource()==jbclear)
			{
				tfname.setText("");
				tfrollno.setText("");
				tfsub1.setText("");
				tfsub2.setText("");
				tfsub3.setText("");
				tfsub4.setText("");
				tfsub5.setText("");
				tftotalmarks.setText("");
				tfpercentage.setText("");
				tfgrade.setText("");
			}
			else if(ee.getSource()==jbexit)
			{
				System.exit(0);
			}
			else if(per>=95)
			{
				tfgrade.setText("O (Outstanding)");
			}
			else if(per>=85 && per<95)
			{
				tfgrade.setText("A+ (Excellent)");
			}
			else if(per>=75 && per<85)
			{
				tfgrade.setText("A (Very Good");
			}
			else if(per>=65 && per<75)
			{
				tfgrade.setText("B+ (Good)");
			}
			else if(per>=55 && per<65)
			{
				tfgrade.setText("B (Above Average");
			}
			else if(per>=45 && per<55)
			{
				tfgrade.setText("C (Average)");
			}
			else if(per>=40 && per<45)
			{
				tfgrade.setText("P (Pass)");
			}
			else
			{
				tfgrade.setText("F (Fail)");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please Input All Fields");
		}

	}
public static void main(String[] args)
{
	new GradeCalculator();
}
}