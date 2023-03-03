package nurseAssesment;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JEditorPane;
import java.awt.Panel;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.DropMode;
//import table.TableCustom;

public class main {

	private JFrame frame;
	private JLabel titleLbl;
	
	private ImageIcon ptImage = new ImageIcon("D:\\CS programs\\nurseAssesment\\ssss\\logtu.JPG");
	private Image ptsc = ptImage.getImage();
	private Image modpt = ptsc.getScaledInstance(400,480,java.awt.Image.SCALE_SMOOTH);
	private JTextField textField;
	private JTextField timeInput;
	private JTextField textField_1;
	private JTextField txtThePatientWill;
	private JTable ncpTbl;
	private JTable resultsTbl;
	private List<JCheckBox> checkBoxList = new ArrayList<>();
	private List<JComboBox<String>> comboBoxList = new ArrayList<>();
	private JTable ncpTbl1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	static class WordWrapCellRenderer extends JTextArea implements TableCellRenderer {
	    WordWrapCellRenderer() {
	        setLineWrap(true);
	        setWrapStyleWord(true);
	    }

	    public Component getTableCellRendererComponent(JTable ncpTbl_1, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        setText(value.toString());
	        setFont(new Font("Arial", Font.PLAIN, 17));
	        setSize(ncpTbl_1.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
	        if (ncpTbl_1.getRowHeight(row) != getPreferredSize().height) {
	        	ncpTbl_1.setRowHeight(row, getPreferredSize().height);
	        }
	        return this;
	    }
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public main() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	//main panel
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CS programs\\nurseAssesment\\ssss\\about-logo.png"));
		frame.setBackground(new Color(213, 255, 213));
		frame.setBounds(100, 100, 1920, 1080);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout myLayout = new CardLayout();
		frame.getContentPane().setLayout(myLayout);
		
		JPanel introPn = new JPanel();
		introPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(introPn, "intro");
		introPn.setLayout(null);
		
		JLabel lblENS = new JLabel("E-Nurse System");
		lblENS.setHorizontalAlignment(SwingConstants.CENTER);
		lblENS.setForeground(new Color(0, 102, 51));
		lblENS.setFont(new Font("Times New Roman", Font.BOLD, 64));
		lblENS.setBounds(708, 268, 472, 190);
		introPn.add(lblENS);
		
		JButton enterBtn = new JButton("Enter");
		enterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(),"nursePnl");
			}
		});
		enterBtn.setForeground(new Color(255, 255, 255));
		enterBtn.setBackground(new Color(0, 102, 51));
		enterBtn.setBorderPainted(true);
        enterBtn.setContentAreaFilled(true);
        enterBtn.setFocusPainted(false);
		enterBtn.setFont(new Font("Times New Roman", Font.BOLD, 30));
		enterBtn.setBounds(800, 432, 281, 100);
		introPn.add(enterBtn);
		
		JLabel lblNewLabel = new JLabel("DLSHSI");
		lblNewLabel.setForeground(new Color(0, 102, 51));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 64));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(708, 168, 472, 190);
		introPn.add(lblNewLabel);
		
		
		//e-nurse panel
		
		JPanel generalPn = new JPanel();
		generalPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(generalPn, "nursePnl");
		generalPn.setLayout(null);
		
		JLabel titleLbl = new JLabel("E-Nurse System");
		titleLbl.setForeground(new Color(0, 102, 51));
		titleLbl.setBackground(new Color(0, 102, 51));
		titleLbl.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl.setBounds(10, 0, 745, 77);
		generalPn.add(titleLbl);
		
		JLabel tempLbl = new JLabel();
		tempLbl.setForeground(new Color(0, 102, 51));
		tempLbl.setFont(new Font("Times New Roman", Font.BOLD, 45));
		tempLbl.setBackground(new Color(0, 102, 51));
		tempLbl.setBounds(10, 66, 745, 77);
		generalPn.add(tempLbl);
		tempLbl.setText("");
		
		JButton ptInfoBtn = new JButton("Patient Information");
		ptInfoBtn.setForeground(new Color(255, 255, 255));
		ptInfoBtn.setBackground(new Color(0, 102, 51));
		ptInfoBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn.setBounds(0, 175, 300, 61);
		ptInfoBtn.setBorderPainted(true);
		ptInfoBtn.setContentAreaFilled(true);
		ptInfoBtn.setFocusPainted(false);
		generalPn.add(ptInfoBtn);
		ptInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
			}
		});
		
		JButton ptAssessBtn = new JButton("Assessment");
		ptAssessBtn.setForeground(new Color(255, 255, 255));
		ptAssessBtn.setBackground(new Color(0, 102, 51));
		ptAssessBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn.setBounds(0, 283, 300, 61);
		ptAssessBtn.setBorderPainted(true);
		ptAssessBtn.setContentAreaFilled(true);
		ptAssessBtn.setFocusPainted(false);
		generalPn.add(ptAssessBtn);
		ptAssessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton nsdgBtn = new JButton("Nurse Diagnosis");
		nsdgBtn.setForeground(Color.WHITE);
		nsdgBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn.setFocusPainted(false);
		nsdgBtn.setContentAreaFilled(true);
		nsdgBtn.setBorderPainted(true);
		nsdgBtn.setBackground(new Color(0, 102, 51));
		nsdgBtn.setBounds(0, 393, 300, 61);
		generalPn.add(nsdgBtn);
		nsdgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn = new JButton("Planning");
		planBtn.setBackground(new Color(0, 102, 51));
		planBtn.setForeground(new Color(255, 255, 255));
		planBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn.setBounds(0, 503, 300, 61);
		planBtn.setBorderPainted(true);
		planBtn.setContentAreaFilled(true);
		planBtn.setFocusPainted(false);
		generalPn.add(planBtn);
		planBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn = new JButton("Intervention");
		interventBtn.setBackground(new Color(0, 102, 51));
		interventBtn.setForeground(new Color(255, 255, 255));
		interventBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn.setBounds(0, 613, 300, 61);
		interventBtn.setBorderPainted(true);
		interventBtn.setContentAreaFilled(true);
		interventBtn.setFocusPainted(false);
		generalPn.add(interventBtn);
		interventBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn = new JButton("Evaluation");
		evalBtn.setBackground(new Color(0, 102, 51));
		evalBtn.setForeground(new Color(255, 255, 255));
		evalBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn.setBounds(0, 723, 300, 61);
		evalBtn.setBorderPainted(true);
		evalBtn.setContentAreaFilled(true);
		evalBtn.setFocusPainted(false);
		generalPn.add(evalBtn);
		evalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn = new JButton("NCP");
		genNCPBtn.setBackground(new Color(0, 102, 51));
		genNCPBtn.setForeground(new Color(255, 255, 255));
		genNCPBtn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn.setBounds(0, 833, 300, 61);
		genNCPBtn.setBorderPainted(true);
		genNCPBtn.setContentAreaFilled(true);
		genNCPBtn.setFocusPainted(false);
		generalPn.add(genNCPBtn);
		genNCPBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(true);
		btnBack.setBorderPainted(true);
		btnBack.setBackground(new Color(0, 102, 51));
		btnBack.setBounds(10, 957, 265, 54);
		generalPn.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
				
			}
		});

		// Patient info panel
		
		ptImage = new ImageIcon(modpt);
		
		JPanel ptInfoPn = new JPanel();
		ptInfoPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(ptInfoPn, "ptinfo");
		ptInfoPn.setLayout(null);
		
		JLabel titleLbl_3 = new JLabel("E-Nurse System");
		titleLbl_3.setForeground(new Color(0, 102, 51));
		titleLbl_3.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_3.setBackground(new Color(0, 102, 51));
		titleLbl_3.setBounds(10, 0, 745, 77);
		ptInfoPn.add(titleLbl_3);
		
		JLabel lblPatientInformation = new JLabel();
		lblPatientInformation.setText("Patient Information");
		lblPatientInformation.setForeground(new Color(0, 102, 51));
		lblPatientInformation.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblPatientInformation.setBackground(new Color(0, 102, 51));
		lblPatientInformation.setBounds(10, 66, 745, 77);
		ptInfoPn.add(lblPatientInformation);
		
		JLabel picLbl = new JLabel("");
		picLbl.setBackground(new Color(255, 255, 255));
		picLbl.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl.setBounds(1474, 257, 400, 480);
		ptInfoPn.add(picLbl);
		picLbl.setIcon(ptImage);
		
		JTextPane ptNameTxt = new JTextPane();
		ptNameTxt.setEditable(false);
		ptNameTxt.setForeground(new Color(213, 255, 213));
		ptNameTxt.setText("Patient Name:");
		ptNameTxt.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt.setBackground(new Color(0, 102, 51));
		ptNameTxt.setBounds(1474, 737, 400, 47);
		ptInfoPn.add(ptNameTxt);
		
		JTextPane pttTxt = new JTextPane();
		pttTxt.setEditable(false);
		pttTxt.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt.setForeground(new Color(213, 255, 213));
		pttTxt.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt.setBackground(new Color(0, 102, 51));
		pttTxt.setBounds(1474, 784, 400, 47);
		ptInfoPn.add(pttTxt);
		
		StyledDocument patient = pttTxt.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient.setParagraphAttributes(0, patient.getLength(), center, false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 175, 1154, 656);
		ptInfoPn.add(scrollPane);
		
		JTextArea ptinfoTxt = new JTextArea();
		scrollPane.setViewportView(ptinfoTxt);
		ptinfoTxt.setText("Name: Mrs. Floridia Jocelyn De Leon\r\n"
				+ "Age 38 y/o\r\n"
				+ "Weight 65kg\r\n"
				+ "Height 5’5\r\n"
				+ "24 weeks pregnant\r\n"
				+ "\r\n"
				+ "Primi\r\n"
				+ "Diabetes\r\n"
				+ "HTN\r\n"
				+ "Risk for preeclampsia\r\n"
				+ "\r\n"
				+ "Mrs. De Leon, a 38 year old pregnant woman was brought to a hospital due to reports of nausea, "
				+ "\nvomiting, and severe headaches. During history taking, she verbalized that “Hanggang ngayon po kasi naduduwal at nasusuka pa rin ako. Madalas din pong sumakit yung ulo ko kahit sapat naman yung tulog\nko. "
				+ "Minsan habang masakit siya, biglang lumalabo o mayroong parang nagfflash na maliwanag sa \npaningin ko.” When asked, she also stated that she has diabetes and hypertension. Mrs. De Leon is \nalso 24 weeks pregnant and is a primigravida. Upon initial assessment, the nurse noticed that the \npt was shivering and her fingers were swollen. \n\nMrs. De Leon’s vital signs are: T: 37.8°C, PR: 127 bpm, RR: 19 cpm, BP: 145/95 mmHg "
				+ "\nand her height and weight are 5’5 inches and 65kg, respectively. \r\n"
				+ "(padagdagan po since sabi ni miss na mas maganda if mas complicated :>) \r\n");
		ptinfoTxt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		ptinfoTxt.setLineWrap(true);
		ptinfoTxt.setEditable(false);
		ptinfoTxt.setVisible(true);
		
		
		JButton ptInfoBtn_3 = new JButton("Patient Information");
		ptInfoBtn_3.setForeground(Color.WHITE);
		ptInfoBtn_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_3.setFocusPainted(false);
		ptInfoBtn_3.setContentAreaFilled(true);
		ptInfoBtn_3.setBorderPainted(true);
		ptInfoBtn_3.setBackground(new Color(0, 102, 51));
		ptInfoBtn_3.setBounds(0, 175, 300, 61);
		ptInfoPn.add(ptInfoBtn_3);
		ptInfoBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
				
			}
		});
		
		JButton ptAssessBtn_3 = new JButton("Assessment");
		ptAssessBtn_3.setForeground(Color.WHITE);
		ptAssessBtn_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_3.setFocusPainted(false);
		ptAssessBtn_3.setContentAreaFilled(true);
		ptAssessBtn_3.setBorderPainted(true);
		ptAssessBtn_3.setBackground(new Color(0, 102, 51));
		ptAssessBtn_3.setBounds(0, 283, 300, 61);
		ptInfoPn.add(ptAssessBtn_3);
		ptAssessBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton planBtn_3 = new JButton("Planning");
		planBtn_3.setForeground(Color.WHITE);
		planBtn_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_3.setFocusPainted(false);
		planBtn_3.setContentAreaFilled(true);
		planBtn_3.setBorderPainted(true);
		planBtn_3.setBackground(new Color(0, 102, 51));
		planBtn_3.setBounds(0, 503, 300, 61);
		ptInfoPn.add(planBtn_3);
		planBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn_3 = new JButton("Intervention");
		interventBtn_3.setForeground(Color.WHITE);
		interventBtn_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_3.setFocusPainted(false);
		interventBtn_3.setContentAreaFilled(true);
		interventBtn_3.setBorderPainted(true);
		interventBtn_3.setBackground(new Color(0, 102, 51));
		interventBtn_3.setBounds(0, 613, 300, 61);
		ptInfoPn.add(interventBtn_3);
		interventBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn_3 = new JButton("Evaluation");
		evalBtn_3.setForeground(Color.WHITE);
		evalBtn_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_3.setFocusPainted(false);
		evalBtn_3.setContentAreaFilled(true);
		evalBtn_3.setBorderPainted(true);
		evalBtn_3.setBackground(new Color(0, 102, 51));
		evalBtn_3.setBounds(0, 723, 300, 61);
		ptInfoPn.add(evalBtn_3);
		evalBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn_3 = new JButton("NCP");
		genNCPBtn_3.setForeground(Color.WHITE);
		genNCPBtn_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_3.setFocusPainted(false);
		genNCPBtn_3.setContentAreaFilled(true);
		genNCPBtn_3.setBorderPainted(true);
		genNCPBtn_3.setBackground(new Color(0, 102, 51));
		genNCPBtn_3.setBounds(0, 833, 300, 61);
		ptInfoPn.add(genNCPBtn_3);
		genNCPBtn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
			}
		});
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.setForeground(Color.WHITE);
		btnBack_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_3.setFocusPainted(false);
		btnBack_3.setContentAreaFilled(true);
		btnBack_3.setBorderPainted(true);
		btnBack_3.setBackground(new Color(0, 102, 51));
		btnBack_3.setBounds(10, 957, 265, 54);
		ptInfoPn.add(btnBack_3);
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");		
			}
		});
		
		JButton nsdgBtn2 = new JButton("Nurse Diagnosis");
		nsdgBtn2.setForeground(Color.WHITE);
		nsdgBtn2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn2.setFocusPainted(false);
		nsdgBtn2.setContentAreaFilled(true);
		nsdgBtn2.setBorderPainted(true);
		nsdgBtn2.setBackground(new Color(0, 102, 51));
		nsdgBtn2.setBounds(0, 393, 300, 61);
		ptInfoPn.add(nsdgBtn2);
		nsdgBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		//diagnosis panel
		ptImage = new ImageIcon(modpt);
		
		JPanel diagPn = new JPanel();
		diagPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(diagPn, "diag");
		diagPn.setLayout(null);
		
		JLabel titleLbl_3_1 = new JLabel("E-Nurse System");
		titleLbl_3_1.setForeground(new Color(0, 102, 51));
		titleLbl_3_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_3_1.setBackground(new Color(0, 102, 51));
		titleLbl_3_1.setBounds(10, 0, 745, 77);
		diagPn.add(titleLbl_3_1);
		
		JLabel lblNurseDiagnosis = new JLabel();
		lblNurseDiagnosis.setText("Nurse Diagnosis");
		lblNurseDiagnosis.setForeground(new Color(0, 102, 51));
		lblNurseDiagnosis.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNurseDiagnosis.setBackground(new Color(0, 102, 51));
		lblNurseDiagnosis.setBounds(10, 66, 745, 77);
		diagPn.add(lblNurseDiagnosis);
		
		JLabel picLbl_6 = new JLabel("");
		picLbl_6.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl_6.setBackground(Color.WHITE);
		picLbl_6.setBounds(1474, 257, 400, 480);
		diagPn.add(picLbl_6);
		picLbl_6.setIcon(ptImage);
		
		JTextPane ptNameTxt_1 = new JTextPane();
		ptNameTxt_1.setText("Patient Name:");
		ptNameTxt_1.setForeground(new Color(213, 255, 213));
		ptNameTxt_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt_1.setEditable(false);
		ptNameTxt_1.setBackground(new Color(0, 102, 51));
		ptNameTxt_1.setBounds(1474, 737, 400, 47);
		diagPn.add(ptNameTxt_1);
		
		JTextPane pttTxt_1 = new JTextPane();
		pttTxt_1.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt_1.setForeground(new Color(213, 255, 213));
		pttTxt_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt_1.setEditable(false);
		pttTxt_1.setBackground(new Color(0, 102, 51));
		pttTxt_1.setBounds(1474, 784, 400, 47);
		diagPn.add(pttTxt_1);
		
		JButton ptInfoBtn_3_1 = new JButton("Patient Information");
		ptInfoBtn_3_1.setForeground(Color.WHITE);
		ptInfoBtn_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_3_1.setFocusPainted(false);
		ptInfoBtn_3_1.setContentAreaFilled(true);
		ptInfoBtn_3_1.setBorderPainted(true);
		ptInfoBtn_3_1.setBackground(new Color(0, 102, 51));
		ptInfoBtn_3_1.setBounds(0, 175, 300, 61);
		diagPn.add(ptInfoBtn_3_1);
		ptInfoBtn_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
			}
		});

		StyledDocument patient6 = pttTxt_1.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient6.setParagraphAttributes(0, patient6.getLength(), center, false);
		
		JButton ptAssessBtn_3_1 = new JButton("Assessment");
		ptAssessBtn_3_1.setForeground(Color.WHITE);
		ptAssessBtn_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_3_1.setFocusPainted(false);
		ptAssessBtn_3_1.setContentAreaFilled(true);
		ptAssessBtn_3_1.setBorderPainted(true);
		ptAssessBtn_3_1.setBackground(new Color(0, 102, 51));
		ptAssessBtn_3_1.setBounds(0, 283, 300, 61);
		diagPn.add(ptAssessBtn_3_1);
		ptAssessBtn_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton nsdgBtn3 = new JButton("Nurse Diagnosis");
		nsdgBtn3.setForeground(Color.WHITE);
		nsdgBtn3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn3.setFocusPainted(false);
		nsdgBtn3.setContentAreaFilled(true);
		nsdgBtn3.setBorderPainted(true);
		nsdgBtn3.setBackground(new Color(0, 102, 51));
		nsdgBtn3.setBounds(0, 393, 300, 61);
		diagPn.add(nsdgBtn3);
		nsdgBtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn_3_1 = new JButton("Planning");
		planBtn_3_1.setForeground(Color.WHITE);
		planBtn_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_3_1.setFocusPainted(false);
		planBtn_3_1.setContentAreaFilled(true);
		planBtn_3_1.setBorderPainted(true);
		planBtn_3_1.setBackground(new Color(0, 102, 51));
		planBtn_3_1.setBounds(0, 503, 300, 61);
		diagPn.add(planBtn_3_1);
		planBtn_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn_3_1 = new JButton("Intervention");
		interventBtn_3_1.setForeground(Color.WHITE);
		interventBtn_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_3_1.setFocusPainted(false);
		interventBtn_3_1.setContentAreaFilled(true);
		interventBtn_3_1.setBorderPainted(true);
		interventBtn_3_1.setBackground(new Color(0, 102, 51));
		interventBtn_3_1.setBounds(0, 613, 300, 61);
		diagPn.add(interventBtn_3_1);
		interventBtn_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn_3_1 = new JButton("Evaluation");
		evalBtn_3_1.setForeground(Color.WHITE);
		evalBtn_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_3_1.setFocusPainted(false);
		evalBtn_3_1.setContentAreaFilled(true);
		evalBtn_3_1.setBorderPainted(true);
		evalBtn_3_1.setBackground(new Color(0, 102, 51));
		evalBtn_3_1.setBounds(0, 723, 300, 61);
		diagPn.add(evalBtn_3_1);
		evalBtn_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn_3_1 = new JButton("NCP");
		genNCPBtn_3_1.setForeground(Color.WHITE);
		genNCPBtn_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_3_1.setFocusPainted(false);
		genNCPBtn_3_1.setContentAreaFilled(true);
		genNCPBtn_3_1.setBorderPainted(true);
		genNCPBtn_3_1.setBackground(new Color(0, 102, 51));
		genNCPBtn_3_1.setBounds(0, 833, 300, 61);
		diagPn.add(genNCPBtn_3_1);
		genNCPBtn_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
			}
		});
		
		JButton btnBack_3_1 = new JButton("Back");
		btnBack_3_1.setForeground(Color.WHITE);
		btnBack_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_3_1.setFocusPainted(false);
		btnBack_3_1.setContentAreaFilled(true);
		btnBack_3_1.setBorderPainted(true);
		btnBack_3_1.setBackground(new Color(0, 102, 51));
		btnBack_3_1.setBounds(10, 957, 265, 54);
		diagPn.add(btnBack_3_1);btnBack_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
			}
		});
		
		JTextArea txtrProblem = new JTextArea();
		txtrProblem.setText("Problem 1");
		txtrProblem.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		txtrProblem.setEditable(false);
		txtrProblem.setForeground(new Color(255, 255, 255));
		txtrProblem.setBackground(new Color(0, 102, 51));
		txtrProblem.setBounds(306, 175, 1156, 37);
		diagPn.add(txtrProblem);
		
		JTextArea txtrProblem_2 = new JTextArea();
		txtrProblem_2.setText("Problem 2");
		txtrProblem_2.setForeground(Color.WHITE);
		txtrProblem_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		txtrProblem_2.setEditable(false);
		txtrProblem_2.setBackground(new Color(0, 102, 51));
		txtrProblem_2.setBounds(306, 257, 1156, 37);
		diagPn.add(txtrProblem_2);
		
		JTextArea txtrNa = new JTextArea();
		txtrNa.setText("Risk for Fetal Iniury");
		txtrNa.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtrNa.setEditable(false);
		txtrNa.setBounds(306, 211, 1158, 47);
		diagPn.add(txtrNa);
		
		JTextArea txtrNa_1 = new JTextArea();
		txtrNa_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		txtrNa_1.setText("Ineffective Peripheral Tissue Perfusion");
		txtrNa_1.setEditable(false);
		txtrNa_1.setBounds(306, 293, 1158, 47);
		diagPn.add(txtrNa_1);
		
		JTextArea txtrRelatedFactors = new JTextArea();
		txtrRelatedFactors.setText("Related Factors 1");
		txtrRelatedFactors.setForeground(Color.WHITE);
		txtrRelatedFactors.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		txtrRelatedFactors.setEditable(false);
		txtrRelatedFactors.setBackground(new Color(0, 102, 51));
		txtrRelatedFactors.setBounds(306, 337, 1156, 37);
		diagPn.add(txtrRelatedFactors);
		
		JTextArea txtrRelatedFactors_2 = new JTextArea();
		txtrRelatedFactors_2.setText("Related Factors 2");
		txtrRelatedFactors_2.setForeground(Color.WHITE);
		txtrRelatedFactors_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		txtrRelatedFactors_2.setEditable(false);
		txtrRelatedFactors_2.setBackground(new Color(0, 102, 51));
		txtrRelatedFactors_2.setBounds(306, 429, 1156, 37);
		diagPn.add(txtrRelatedFactors_2);
		
		JTextArea txtrNa_2 = new JTextArea();
		txtrNa_2.setLineWrap(true);
		txtrNa_2.setFont(new Font("Arial", Font.PLAIN, 17));
		txtrNa_2.setText("hyperglycemia and hypertension as evidenced by nausea and vomiting, frequent headaches, blurry vision with flashing lights, shivering, swollen fingers, "
				+ "\nelevated temperature, and elevated blood pressure");
		txtrNa_2.setEditable(false);
		txtrNa_2.setBounds(306, 374, 1158, 55);
		diagPn.add(txtrNa_2);
		
		JTextArea txtrNa_3 = new JTextArea();
		txtrNa_3.setText("arterial insufficiency as evidenced by swollen fingers and shivering");
		txtrNa_3.setFont(new Font("Arial", Font.PLAIN, 17));
		txtrNa_3.setEditable(false);
		txtrNa_3.setBounds(306, 465, 1158, 55);
		diagPn.add(txtrNa_3);
		
		JTextArea txtrRelatedFactors_2_1 = new JTextArea();
		txtrRelatedFactors_2_1.setText("Defining Characteristics");
		txtrRelatedFactors_2_1.setForeground(Color.WHITE);
		txtrRelatedFactors_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 23));
		txtrRelatedFactors_2_1.setEditable(false);
		txtrRelatedFactors_2_1.setBackground(new Color(0, 102, 51));
		txtrRelatedFactors_2_1.setBounds(306, 527, 1156, 37);
		diagPn.add(txtrRelatedFactors_2_1);
		
		JCheckBox chckbxA = new JCheckBox("A");
		chckbxA.setForeground(new Color(0, 102, 51));
		chckbxA.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxA.setBounds(306, 565, 642, 31);
		diagPn.add(chckbxA);
		
		JCheckBox chckbxB = new JCheckBox("B");
		chckbxB.setForeground(new Color(0, 102, 51));
		chckbxB.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxB.setBounds(306, 596, 642, 31);
		diagPn.add(chckbxB);
		
		JCheckBox chckbxC = new JCheckBox("C");
		chckbxC.setForeground(new Color(0, 102, 51));
		chckbxC.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxC.setBounds(306, 626, 642, 31);
		diagPn.add(chckbxC);
		
		JCheckBox chckbxD = new JCheckBox("D");
		chckbxD.setForeground(new Color(0, 102, 51));
		chckbxD.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxD.setBounds(306, 656, 642, 31);
		diagPn.add(chckbxD);
		
		JCheckBox chckbxE = new JCheckBox("E");
		chckbxE.setForeground(new Color(0, 102, 51));
		chckbxE.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxE.setBounds(306, 687, 642, 31);
		diagPn.add(chckbxE);
		
		JCheckBox chckbxF = new JCheckBox("F");
		chckbxF.setForeground(new Color(0, 102, 51));
		chckbxF.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxF.setBounds(306, 717, 642, 31);
		diagPn.add(chckbxF);
		
		JCheckBox chckbxG = new JCheckBox("G");
		chckbxG.setForeground(new Color(0, 102, 51));
		chckbxG.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxG.setBounds(947, 565, 516, 31);
		diagPn.add(chckbxG);
		
		JCheckBox chckbxH = new JCheckBox("H");
		chckbxH.setForeground(new Color(0, 102, 51));
		chckbxH.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxH.setBounds(947, 596, 516, 31);
		diagPn.add(chckbxH);
		
		JCheckBox chckbxI = new JCheckBox("I");
		chckbxI.setForeground(new Color(0, 102, 51));
		chckbxI.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxI.setBounds(947, 626, 516, 31);
		diagPn.add(chckbxI);
		
		JCheckBox chckbxJ = new JCheckBox("J");
		chckbxJ.setForeground(new Color(0, 102, 51));
		chckbxJ.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxJ.setBounds(947, 656, 516, 31);
		diagPn.add(chckbxJ);
		
		JCheckBox chckbxK = new JCheckBox("K");
		chckbxK.setForeground(new Color(0, 102, 51));
		chckbxK.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxK.setBounds(947, 687, 516, 31);
		diagPn.add(chckbxK);
		
		JCheckBox chckbxL = new JCheckBox("L");
		chckbxL.setForeground(new Color(0, 102, 51));
		chckbxL.setFont(new Font("Arial", Font.PLAIN, 17));
		chckbxL.setBounds(947, 717, 516, 31);
		diagPn.add(chckbxL);
		
		checkBoxList.add(chckbxA);
        checkBoxList.add(chckbxB);
        checkBoxList.add(chckbxC);
        checkBoxList.add(chckbxD);
        checkBoxList.add(chckbxE);
        checkBoxList.add(chckbxF);
        checkBoxList.add(chckbxG);
        checkBoxList.add(chckbxH);
        checkBoxList.add(chckbxI);
        checkBoxList.add(chckbxJ);
        checkBoxList.add(chckbxK);
        checkBoxList.add(chckbxL);
		
				
		//assessment panel
		
		JPanel assessmentPn = new JPanel();
		assessmentPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(assessmentPn, "ass");
		assessmentPn.setLayout(null);
		
		JLabel titleLbl_1 = new JLabel("E-Nurse System");
		titleLbl_1.setForeground(new Color(0, 102, 51));
		titleLbl_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_1.setBackground(new Color(0, 102, 51));
		titleLbl_1.setBounds(10, 0, 745, 77);
		assessmentPn.add(titleLbl_1);
		
		JLabel tempLbl_1 = new JLabel();
		tempLbl_1.setText("Assessment");
		tempLbl_1.setForeground(new Color(0, 102, 51));
		tempLbl_1.setFont(new Font("Times New Roman", Font.BOLD, 45));
		tempLbl_1.setBackground(new Color(0, 102, 51));
		tempLbl_1.setBounds(10, 66, 745, 77);
		assessmentPn.add(tempLbl_1);
		
		JLabel picLbl_1 = new JLabel("");
		picLbl_1.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl_1.setBackground(Color.WHITE);
		picLbl_1.setBounds(1474, 257, 400, 480);
		assessmentPn.add(picLbl_1);
		picLbl_1.setIcon(ptImage);
		
		JTextPane ptNameTxt1 = new JTextPane();
		ptNameTxt1.setText("Patient Name:");
		ptNameTxt1.setForeground(new Color(213, 255, 213));
		ptNameTxt1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt1.setEditable(false);
		ptNameTxt1.setBackground(new Color(0, 102, 51));
		ptNameTxt1.setBounds(1474, 737, 400, 47);
		assessmentPn.add(ptNameTxt1);
		
		JTextPane pttTxt1 = new JTextPane();
		pttTxt1.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt1.setForeground(new Color(213, 255, 213));
		pttTxt1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt1.setEditable(false);
		pttTxt1.setBackground(new Color(0, 102, 51));
		pttTxt1.setBounds(1474, 783, 400, 47);
		assessmentPn.add(pttTxt1);
		
		StyledDocument patient1 = pttTxt1.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient1.setParagraphAttributes(0, patient1.getLength(), center, false);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		UIManager.put("TabbedPane.selected", Color.gray);
		tabbedPane.setBorder(new CompoundBorder());
		tabbedPane.setForeground(new Color(0, 102, 51));
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		tabbedPane.setBackground(new Color(166, 238, 164));
		tabbedPane.setBounds(310, 175, 1154, 717);
		assessmentPn.add(tabbedPane);
		
		JTextArea subdataTxt = new JTextArea();
		subdataTxt.setLineWrap(true);
		subdataTxt.setFont(new Font("Arial", Font.PLAIN, 24));
		subdataTxt.setText("“Hanggang ngayon po kasi naduduwal at nasusuka pa rin ako. Madalas din pong sumakit yung ulo ko \nkahit sapat naman yung tulog ko. Minsan habang masakit siya, biglang lumalabo o mayroong parang \nnagfflash na maliwanag sa paningin ko.”");
		subdataTxt.setEditable(false);
		tabbedPane.addTab("Subjective Data", null, subdataTxt, null);
		
		JTextArea objdataTxt = new JTextArea();
		objdataTxt.setLineWrap(true);
		objdataTxt.setText("VS:\r\n"
				+ "T: 37.8°C\r\n"
				+ "PR: 127 bpm\r\n"
				+ "RR: 19 cpm\r\n"
				+ "BP: 145/95 mmHg\r\n"
				+ "Ht: 5’5ft\r\n"
				+ "Wt: 65kg\r\n"
				+ "(+) Swollen digits\r\n"
				+ "(+) Chills");
		objdataTxt.setFont(new Font("Arial", Font.PLAIN, 24));
		objdataTxt.setEditable(false);
		tabbedPane.addTab("Objective Data", null, objdataTxt, null);
		
		//String subjTxt = ("Subjective Data: "+"\n"+subdataTxt);
		//String objTxt = ("Objective Data: "+"\n"+objdataTxt);
		
		JTextArea otherdataTxt = new JTextArea();
		otherdataTxt.setFont(new Font("Arial", Font.PLAIN, 24));
		otherdataTxt.setEditable(false);
		tabbedPane.addTab("Other Related Data", null, otherdataTxt, null);
		
		JButton ptInfoBtn_1 = new JButton("Patient Information");
		ptInfoBtn_1.setForeground(Color.WHITE);
		ptInfoBtn_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_1.setFocusPainted(false);
		ptInfoBtn_1.setContentAreaFilled(true);
		ptInfoBtn_1.setBorderPainted(true);
		ptInfoBtn_1.setBackground(new Color(0, 102, 51));
		ptInfoBtn_1.setBounds(0, 175, 300, 61);
		assessmentPn.add(ptInfoBtn_1);
		ptInfoBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");			
				
			}
		});
		
		JButton ptAssessBtn_1 = new JButton("Assessment");
		ptAssessBtn_1.setForeground(Color.WHITE);
		ptAssessBtn_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_1.setFocusPainted(false);
		ptAssessBtn_1.setContentAreaFilled(true);
		ptAssessBtn_1.setBorderPainted(true);
		ptAssessBtn_1.setBackground(new Color(0, 102, 51));
		ptAssessBtn_1.setBounds(0, 283, 300, 61);
		assessmentPn.add(ptAssessBtn_1);
		ptAssessBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton nsdgBtn4 = new JButton("Nurse Diagnosis");
		nsdgBtn4.setForeground(Color.WHITE);
		nsdgBtn4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn4.setFocusPainted(false);
		nsdgBtn4.setContentAreaFilled(true);
		nsdgBtn4.setBorderPainted(true);
		nsdgBtn4.setBackground(new Color(0, 102, 51));
		nsdgBtn4.setBounds(0, 393, 300, 61);
		assessmentPn.add(nsdgBtn4);
		nsdgBtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn_1 = new JButton("Planning");
		planBtn_1.setForeground(Color.WHITE);
		planBtn_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_1.setFocusPainted(false);
		planBtn_1.setContentAreaFilled(true);
		planBtn_1.setBorderPainted(true);
		planBtn_1.setBackground(new Color(0, 102, 51));
		planBtn_1.setBounds(0, 503, 300, 61);
		assessmentPn.add(planBtn_1);
		planBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn_1 = new JButton("Intervention");
		interventBtn_1.setForeground(Color.WHITE);
		interventBtn_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_1.setFocusPainted(false);
		interventBtn_1.setContentAreaFilled(true);
		interventBtn_1.setBorderPainted(true);
		interventBtn_1.setBackground(new Color(0, 102, 51));
		interventBtn_1.setBounds(0, 613, 300, 61);
		assessmentPn.add(interventBtn_1);
		interventBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn_1 = new JButton("Evaluation");
		evalBtn_1.setForeground(Color.WHITE);
		evalBtn_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_1.setFocusPainted(false);
		evalBtn_1.setContentAreaFilled(true);
		evalBtn_1.setBorderPainted(true);
		evalBtn_1.setBackground(new Color(0, 102, 51));
		evalBtn_1.setBounds(0, 723, 300, 61);
		assessmentPn.add(evalBtn_1);
		evalBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn_1 = new JButton("NCP");
		genNCPBtn_1.setForeground(Color.WHITE);
		genNCPBtn_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_1.setFocusPainted(false);
		genNCPBtn_1.setContentAreaFilled(true);
		genNCPBtn_1.setBorderPainted(true);
		genNCPBtn_1.setBackground(new Color(0, 102, 51));
		genNCPBtn_1.setBounds(0, 833, 300, 61);
		assessmentPn.add(genNCPBtn_1);
		genNCPBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
			}
		});
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setForeground(Color.WHITE);
		btnBack_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_1.setFocusPainted(false);
		btnBack_1.setContentAreaFilled(true);
		btnBack_1.setBorderPainted(true);
		btnBack_1.setBackground(new Color(0, 102, 51));
		btnBack_1.setBounds(10, 957, 265, 54);
		assessmentPn.add(btnBack_1);
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
			}
		});

		//Planning Panel
				
		JPanel planningPn = new JPanel();
		planningPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(planningPn, "plan");
		planningPn.setLayout(null);
		
		JLabel titleLbl_2 = new JLabel("E-Nurse System");
		titleLbl_2.setForeground(new Color(0, 102, 51));
		titleLbl_2.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_2.setBackground(new Color(0, 102, 51));
		titleLbl_2.setBounds(10, 0, 745, 77);
		planningPn.add(titleLbl_2);
		
		JLabel tempLbl_2 = new JLabel();
		tempLbl_2.setText("Planning");
		tempLbl_2.setForeground(new Color(0, 102, 51));
		tempLbl_2.setFont(new Font("Times New Roman", Font.BOLD, 45));
		tempLbl_2.setBackground(new Color(0, 102, 51));
		tempLbl_2.setBounds(10, 66, 745, 77);
		planningPn.add(tempLbl_2);
		
		JLabel picLbl_2 = new JLabel("");
		picLbl_2.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl_2.setBackground(Color.WHITE);
		picLbl_2.setBounds(1474, 257, 400, 480);
		planningPn.add(picLbl_2);
		picLbl_2.setIcon(ptImage);
		
		JTextPane goalsTxt = new JTextPane();
		goalsTxt.setText("Desired Outcome/Goals 1");
		goalsTxt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		goalsTxt.setForeground(new Color(255, 255, 255));
		goalsTxt.setEditable(false);
		goalsTxt.setBackground(new Color(0, 102, 51));
		goalsTxt.setBounds(311, 175, 1149, 30);
		goalsTxt.setAlignmentY(50);
		planningPn.add(goalsTxt);
		
		JTextPane patientTxt = new JTextPane();
		patientTxt.setForeground(new Color(255, 255, 255));
		patientTxt.setText("The patient will be able to:");
		patientTxt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		patientTxt.setEditable(false);
		patientTxt.setBackground(new Color(0, 102, 51));
		patientTxt.setBounds(311, 259, 1149, 54);
		planningPn.add(patientTxt);

		JTextPane timeTxt = new JTextPane();
		timeTxt.setEditable(false);
		timeTxt.setText("Time/Duration");
		timeTxt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		timeTxt.setBackground(Color.WHITE);
		timeTxt.setBounds(311, 210, 520, 38);
		planningPn.add(timeTxt);
		
		JTextPane goalsTxt2 = new JTextPane();
		goalsTxt2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		goalsTxt2.setText("Desired Outcome/Goals 2");
		goalsTxt2.setForeground(new Color(255, 255, 255));
		goalsTxt2.setBackground(new Color(0, 102, 51));
		goalsTxt2.setBounds(311, 440, 1149, 30);
		planningPn.add(goalsTxt2);
		
		JTextPane timeTxt2 = new JTextPane();
		timeTxt2.setText("Time/Duration");
		timeTxt2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 24));
		timeTxt2.setEditable(false);
		timeTxt2.setBackground(new Color(255, 255, 255));
		timeTxt2.setBounds(311, 477, 520, 38);
		planningPn.add(timeTxt2);
		
		JTextPane patientTxt2 = new JTextPane();
		patientTxt2.setForeground(new Color(255, 255, 255));
		patientTxt2.setText("The patient will be able to:");
		patientTxt2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		patientTxt2.setBackground(new Color(0, 102, 51));
		patientTxt2.setBounds(311, 521, 1149, 54);
		planningPn.add(patientTxt2);
		
		JTextPane pttTxt2 = new JTextPane();
		pttTxt2.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt2.setForeground(new Color(213, 255, 213));
		pttTxt2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt2.setEditable(false);
		pttTxt2.setBackground(new Color(0, 102, 51));
		pttTxt2.setBounds(1474, 783, 400, 47);
		planningPn.add(pttTxt2);
		
		JTextPane ptNameTxt2 = new JTextPane();
		ptNameTxt2.setText("Patient Name:");
		ptNameTxt2.setForeground(new Color(213, 255, 213));
		ptNameTxt2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt2.setEditable(false);
		ptNameTxt2.setBackground(new Color(0, 102, 51));
		ptNameTxt2.setBounds(1474, 737, 400, 47);
		planningPn.add(ptNameTxt2);
		
		StyledDocument patient2 = pttTxt2.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient2 .setParagraphAttributes(0, patient2.getLength(), center, false);
		
		StyledDocument goal = goalsTxt.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		goal.setParagraphAttributes(0, goal.getLength(), center, false);

		StyledDocument pt = patientTxt.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		pt.setParagraphAttributes(0, pt.getLength(), center, false);
		
		StyledDocument time = timeTxt.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		time.setParagraphAttributes(0, time.getLength(), center, false);

		StyledDocument goal2 = goalsTxt2.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		goal2.setParagraphAttributes(0, goal2.getLength(), center, false);
		
		StyledDocument pt2 = patientTxt2.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		pt2.setParagraphAttributes(0, pt2.getLength(), center, false);
		
		StyledDocument time2 = timeTxt2.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		time2.setParagraphAttributes(0, time2.getLength(), center, false);
		
		timeInput = new JTextField();
		timeInput.setColumns(1);
		timeInput.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		timeInput.setHorizontalAlignment(SwingConstants.CENTER);
		timeInput.setBounds(837, 210, 623, 38);
		timeInput.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		planningPn.add(timeInput);	
		
		JTextField timeInput2 = new JTextField();
		timeInput2.setBackground(new Color(255, 255, 255));
		timeInput2.setHorizontalAlignment(SwingConstants.CENTER);
		timeInput2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
		timeInput2.setColumns(1);
		timeInput2.setBounds(837, 477, 623, 37);
		timeInput2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		planningPn.add(timeInput2);
	
		JComboBox<String> choice1 = new JComboBox<>();
		choice1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		choice1.setModel(new DefaultComboBoxModel<>(new String[] {"--", "Lorem", "Ipsum", "dolor"}));
		choice1.setMaximumRowCount(4);
		choice1.setBounds(311, 312, 1149, 36);
		planningPn.add(choice1);
		
		JComboBox<String> choice2 = new JComboBox();
		choice2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		choice2.setModel(new DefaultComboBoxModel<>(new String[] {"--", "Lorem", "Ipsum", "dolor"}));
		choice2.setMaximumRowCount(4);
		choice2.setBounds(311, 348, 1149, 36);
		planningPn.add(choice2);
		
		JComboBox<String> choice3 = new JComboBox();
		choice3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		choice3.setModel(new DefaultComboBoxModel<>(new String[] {"--", "Lorem", "Ipsum", "dolor"}));
		choice3.setMaximumRowCount(4);
		choice3.setBounds(311, 384, 1149, 36);
		planningPn.add(choice3);
		
		JComboBox<String> choice4 = new JComboBox();
		choice4.setModel(new DefaultComboBoxModel<>(new String[] {"--", "Lorem", "Ipsum", "dolor"}));
		choice4.setMaximumRowCount(4);
		choice4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		choice4.setBounds(311, 573, 1149, 36);
		planningPn.add(choice4);
		
		JComboBox<String> choice5 = new JComboBox<>();
		choice5.setModel(new DefaultComboBoxModel<>(new String[] {"--", "Lorem", "Ipsum", "dolor"}));
		choice5.setMaximumRowCount(4);
		choice5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		choice5.setBounds(311, 609, 1149, 36);
		planningPn.add(choice5);
		
		JComboBox<String> choice6 = new JComboBox<>();
		choice6.setModel(new DefaultComboBoxModel<>(new String[] {"--", "Lorem", "Ipsum", "dolor"}));
		choice6.setMaximumRowCount(4);
		choice6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		choice6.setBounds(311, 645, 1149, 36);
		planningPn.add(choice6);
		
		comboBoxList.add(choice1);
        comboBoxList.add(choice2);
        comboBoxList.add(choice3);
        
        comboBoxList.add(choice4);
        comboBoxList.add(choice5);
        comboBoxList.add(choice6);
		
		JButton ptInfoBtn_2 = new JButton("Patient Information");
		ptInfoBtn_2.setForeground(Color.WHITE);
		ptInfoBtn_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_2.setFocusPainted(false);
		ptInfoBtn_2.setContentAreaFilled(true);
		ptInfoBtn_2.setBorderPainted(true);
		ptInfoBtn_2.setBackground(new Color(0, 102, 51));
		ptInfoBtn_2.setBounds(0, 175, 300, 61);
		planningPn.add(ptInfoBtn_2);
		ptInfoBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
			}
		});
		
		JButton ptAssessBtn_2 = new JButton("Assessment");
		ptAssessBtn_2.setForeground(Color.WHITE);
		ptAssessBtn_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_2.setFocusPainted(false);
		ptAssessBtn_2.setContentAreaFilled(true);
		ptAssessBtn_2.setBorderPainted(true);
		ptAssessBtn_2.setBackground(new Color(0, 102, 51));
		ptAssessBtn_2.setBounds(0, 283, 300, 61);
		planningPn.add(ptAssessBtn_2);
		ptAssessBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton nsdgBtn5 = new JButton("Nurse Diagnosis");
		nsdgBtn5.setForeground(Color.WHITE);
		nsdgBtn5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn5.setFocusPainted(false);
		nsdgBtn5.setContentAreaFilled(true);
		nsdgBtn5.setBorderPainted(true);
		nsdgBtn5.setBackground(new Color(0, 102, 51));
		nsdgBtn5.setBounds(0, 393, 300, 61);
		planningPn.add(nsdgBtn5);
		nsdgBtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn_2 = new JButton("Planning");
		planBtn_2.setForeground(Color.WHITE);
		planBtn_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_2.setFocusPainted(false);
		planBtn_2.setContentAreaFilled(true);
		planBtn_2.setBorderPainted(true);
		planBtn_2.setBackground(new Color(0, 102, 51));
		planBtn_2.setBounds(0, 503, 300, 61);
		planningPn.add(planBtn_2);
		planBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn_2 = new JButton("Intervention");
		interventBtn_2.setForeground(Color.WHITE);
		interventBtn_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_2.setFocusPainted(false);
		interventBtn_2.setContentAreaFilled(true);
		interventBtn_2.setBorderPainted(true);
		interventBtn_2.setBackground(new Color(0, 102, 51));
		interventBtn_2.setBounds(0, 613, 300, 61);
		planningPn.add(interventBtn_2);
		interventBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn_2 = new JButton("Evaluation");
		evalBtn_2.setForeground(Color.WHITE);
		evalBtn_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_2.setFocusPainted(false);
		evalBtn_2.setContentAreaFilled(true);
		evalBtn_2.setBorderPainted(true);
		evalBtn_2.setBackground(new Color(0, 102, 51));
		evalBtn_2.setBounds(0, 723, 300, 61);
		planningPn.add(evalBtn_2);
		evalBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn_2 = new JButton("NCP");
		genNCPBtn_2.setForeground(Color.WHITE);
		genNCPBtn_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_2.setFocusPainted(false);
		genNCPBtn_2.setContentAreaFilled(true);
		genNCPBtn_2.setBorderPainted(true);
		genNCPBtn_2.setBackground(new Color(0, 102, 51));
		genNCPBtn_2.setBounds(0, 833, 300, 61);
		planningPn.add(genNCPBtn_2);
		genNCPBtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
			}
		});
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.setForeground(Color.WHITE);
		btnBack_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_2.setFocusPainted(false);
		btnBack_2.setContentAreaFilled(true);
		btnBack_2.setBorderPainted(true);
		btnBack_2.setBackground(new Color(0, 102, 51));
		btnBack_2.setBounds(10, 957, 265, 54);
		planningPn.add(btnBack_2);
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
			}
		});
		
		//Intervention Panel
		
		JPanel interventionPn = new JPanel();
		interventionPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(interventionPn, "inter");
		interventionPn.setLayout(null);
		
		JLabel titleLbl_4 = new JLabel("E-Nurse System");
		titleLbl_4.setForeground(new Color(0, 102, 51));
		titleLbl_4.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_4.setBackground(new Color(0, 102, 51));
		titleLbl_4.setBounds(10, 0, 745, 77);
		interventionPn.add(titleLbl_4);
		
		JLabel tempLbl_4 = new JLabel();
		tempLbl_4.setText("Intervention");
		tempLbl_4.setForeground(new Color(0, 102, 51));
		tempLbl_4.setFont(new Font("Times New Roman", Font.BOLD, 45));
		tempLbl_4.setBackground(new Color(0, 102, 51));
		tempLbl_4.setBounds(10, 66, 745, 77);
		interventionPn.add(tempLbl_4);
		
		JLabel picLbl_3 = new JLabel("");
		picLbl_3.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl_3.setBackground(Color.WHITE);
		picLbl_3.setBounds(1474, 257, 400, 480);
		interventionPn.add(picLbl_3);
		picLbl_3.setIcon(ptImage);
		
		JTextPane pttTxt3 = new JTextPane();
		pttTxt3.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt3.setForeground(new Color(213, 255, 213));
		pttTxt3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt3.setEditable(false);
		pttTxt3.setBackground(new Color(0, 102, 51));
		pttTxt3.setBounds(1474, 783, 400, 47);
		interventionPn.add(pttTxt3);

		JTextPane ptNameTxt3 = new JTextPane();
		ptNameTxt3.setText("Patient Name:");
		ptNameTxt3.setForeground(new Color(213, 255, 213));
		ptNameTxt3.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt3.setEditable(false);
		ptNameTxt3.setBackground(new Color(0, 102, 51));
		ptNameTxt3.setBounds(1474, 737, 400, 47);
		interventionPn.add(ptNameTxt3);
		
		StyledDocument patient3 = pttTxt3.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient3 .setParagraphAttributes(0, patient3 .getLength(), center, false);
		
		JButton ptInfoBtn_4 = new JButton("Patient Information");
		ptInfoBtn_4.setForeground(Color.WHITE);
		ptInfoBtn_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_4.setFocusPainted(false);
		ptInfoBtn_4.setContentAreaFilled(true);
		ptInfoBtn_4.setBorderPainted(true);
		ptInfoBtn_4.setBackground(new Color(0, 102, 51));
		ptInfoBtn_4.setBounds(0, 175, 300, 61);
		interventionPn.add(ptInfoBtn_4);
		ptInfoBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
			}
		});
		
		JButton ptAssessBtn_4 = new JButton("Assessment");
		ptAssessBtn_4.setForeground(Color.WHITE);
		ptAssessBtn_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_4.setFocusPainted(false);
		ptAssessBtn_4.setContentAreaFilled(true);
		ptAssessBtn_4.setBorderPainted(true);
		ptAssessBtn_4.setBackground(new Color(0, 102, 51));
		ptAssessBtn_4.setBounds(0, 283, 300, 61);
		interventionPn.add(ptAssessBtn_4);
		ptAssessBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton nsdgBtn6 = new JButton("Nurse Diagnosis");
		nsdgBtn6.setForeground(Color.WHITE);
		nsdgBtn6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn6.setFocusPainted(false);
		nsdgBtn6.setContentAreaFilled(true);
		nsdgBtn6.setBorderPainted(true);
		nsdgBtn6.setBackground(new Color(0, 102, 51));
		nsdgBtn6.setBounds(0, 393, 300, 61);
		interventionPn.add(nsdgBtn6);
		nsdgBtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn_4 = new JButton("Planning");
		planBtn_4.setForeground(Color.WHITE);
		planBtn_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_4.setFocusPainted(false);
		planBtn_4.setContentAreaFilled(true);
		planBtn_4.setBorderPainted(true);
		planBtn_4.setBackground(new Color(0, 102, 51));
		planBtn_4.setBounds(0, 503, 300, 61);
		interventionPn.add(planBtn_4);
		planBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn_4 = new JButton("Intervention");
		interventBtn_4.setForeground(Color.WHITE);
		interventBtn_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_4.setFocusPainted(false);
		interventBtn_4.setContentAreaFilled(true);
		interventBtn_4.setBorderPainted(true);
		interventBtn_4.setBackground(new Color(0, 102, 51));
		interventBtn_4.setBounds(0, 613, 300, 61);
		interventionPn.add(interventBtn_4);
		interventBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn_4 = new JButton("Evaluation");
		evalBtn_4.setForeground(Color.WHITE);
		evalBtn_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_4.setFocusPainted(false);
		evalBtn_4.setContentAreaFilled(true);
		evalBtn_4.setBorderPainted(true);
		evalBtn_4.setBackground(new Color(0, 102, 51));
		evalBtn_4.setBounds(0, 723, 300, 61);
		interventionPn.add(evalBtn_4);
		evalBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn_4 = new JButton("NCP");
		genNCPBtn_4.setForeground(Color.WHITE);
		genNCPBtn_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_4.setFocusPainted(false);
		genNCPBtn_4.setContentAreaFilled(true);
		genNCPBtn_4.setBorderPainted(true);
		genNCPBtn_4.setBackground(new Color(0, 102, 51));
		genNCPBtn_4.setBounds(0, 833, 300, 61);
		interventionPn.add(genNCPBtn_4);
		genNCPBtn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
			}
		});
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.setForeground(Color.WHITE);
		btnBack_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_4.setFocusPainted(false);
		btnBack_4.setContentAreaFilled(true);
		btnBack_4.setBorderPainted(true);
		btnBack_4.setBackground(new Color(0, 102, 51));
		btnBack_4.setBounds(10, 957, 265, 54);
		interventionPn.add(btnBack_4);
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
			}
		});
		
		// Evaluation panel
		
		JPanel evalPn = new JPanel();
		evalPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(evalPn, "eval");
		evalPn.setLayout(null);
		
		JLabel titleLbl_5 = new JLabel("E-Nurse System");
		titleLbl_5.setForeground(new Color(0, 102, 51));
		titleLbl_5.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_5.setBackground(new Color(0, 102, 51));
		titleLbl_5.setBounds(10, 0, 745, 77);
		evalPn.add(titleLbl_5);
		
		JLabel tempLbl_5 = new JLabel();
		tempLbl_5.setText("Evaluation");
		tempLbl_5.setForeground(new Color(0, 102, 51));
		tempLbl_5.setFont(new Font("Times New Roman", Font.BOLD, 45));
		tempLbl_5.setBackground(new Color(0, 102, 51));
		tempLbl_5.setBounds(10, 66, 745, 77);
		evalPn.add(tempLbl_5);
		
		JLabel picLbl_4 = new JLabel("");
		picLbl_4.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl_4.setBackground(Color.WHITE);
		picLbl_4.setBounds(1474, 257, 400, 480);
		evalPn.add(picLbl_4);
		picLbl_4.setIcon(ptImage);
		
		JTextPane pttTxt4 = new JTextPane();
		pttTxt4.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt4.setForeground(new Color(213, 255, 213));
		pttTxt4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt4.setEditable(false);
		pttTxt4.setBackground(new Color(0, 102, 51));
		pttTxt4.setBounds(1474, 783, 400, 47);
		evalPn.add(pttTxt4);
		
		JTextPane ptNameTxt4 = new JTextPane();
		ptNameTxt4.setText("Patient Name:");
		ptNameTxt4.setForeground(new Color(213, 255, 213));
		ptNameTxt4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt4.setEditable(false);
		ptNameTxt4.setBackground(new Color(0, 102, 51));
		ptNameTxt4.setBounds(1474, 737, 400, 47);
		evalPn.add(ptNameTxt4);
		
		StyledDocument patient4 = pttTxt4.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient4.setParagraphAttributes(0, patient4.getLength(), center, false);

		
		JButton ptInfoBtn_5 = new JButton("Patient Information");
		ptInfoBtn_5.setForeground(Color.WHITE);
		ptInfoBtn_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_5.setFocusPainted(false);
		ptInfoBtn_5.setContentAreaFilled(true);
		ptInfoBtn_5.setBorderPainted(true);
		ptInfoBtn_5.setBackground(new Color(0, 102, 51));
		ptInfoBtn_5.setBounds(0, 175, 300, 61);
		evalPn.add(ptInfoBtn_5);
		ptInfoBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
				
			}
		});
		
		JButton ptAssessBtn_5 = new JButton("Assessment");
		ptAssessBtn_5.setForeground(Color.WHITE);
		ptAssessBtn_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_5.setFocusPainted(false);
		ptAssessBtn_5.setContentAreaFilled(true);
		ptAssessBtn_5.setBorderPainted(true);
		ptAssessBtn_5.setBackground(new Color(0, 102, 51));
		ptAssessBtn_5.setBounds(0, 283, 300, 61);
		evalPn.add(ptAssessBtn_5);
		ptAssessBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
				
			}
		});
		
		JButton nsdgBtn7 = new JButton("Nurse Diagnosis");
		nsdgBtn7.setForeground(Color.WHITE);
		nsdgBtn7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn7.setFocusPainted(false);
		nsdgBtn7.setContentAreaFilled(true);
		nsdgBtn7.setBorderPainted(true);
		nsdgBtn7.setBackground(new Color(0, 102, 51));
		nsdgBtn7.setBounds(0, 393, 300, 61);
		evalPn.add(nsdgBtn7);
		nsdgBtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn_5 = new JButton("Planning");
		planBtn_5.setForeground(Color.WHITE);
		planBtn_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_5.setFocusPainted(false);
		planBtn_5.setContentAreaFilled(true);
		planBtn_5.setBorderPainted(true);
		planBtn_5.setBackground(new Color(0, 102, 51));
		planBtn_5.setBounds(0, 503, 300, 61);
		evalPn.add(planBtn_5);
		planBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
				
			}
		});
		
		JButton interventBtn_5 = new JButton("Intervention");
		interventBtn_5.setForeground(Color.WHITE);
		interventBtn_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_5.setFocusPainted(false);
		interventBtn_5.setContentAreaFilled(true);
		interventBtn_5.setBorderPainted(true);
		interventBtn_5.setBackground(new Color(0, 102, 51));
		interventBtn_5.setBounds(0, 613, 300, 61);
		evalPn.add(interventBtn_5);
		interventBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
				
			}
		});
		
		JButton evalBtn_5 = new JButton("Evaluation");
		evalBtn_5.setForeground(Color.WHITE);
		evalBtn_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_5.setFocusPainted(false);
		evalBtn_5.setContentAreaFilled(true);
		evalBtn_5.setBorderPainted(true);
		evalBtn_5.setBackground(new Color(0, 102, 51));
		evalBtn_5.setBounds(0, 723, 300, 61);
		evalPn.add(evalBtn_5);
		evalBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
				
			}
		});
		
		JButton genNCPBtn_5 = new JButton("NCP");
		genNCPBtn_5.setForeground(Color.WHITE);
		genNCPBtn_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_5.setFocusPainted(false);
		genNCPBtn_5.setContentAreaFilled(true);
		genNCPBtn_5.setBorderPainted(true);
		genNCPBtn_5.setBackground(new Color(0, 102, 51));
		genNCPBtn_5.setBounds(0, 833, 300, 61);
		evalPn.add(genNCPBtn_5);
		genNCPBtn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
				
			}
		});
		
		JButton btnBack_5 = new JButton("Back");
		btnBack_5.setForeground(Color.WHITE);
		btnBack_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_5.setFocusPainted(false);
		btnBack_5.setContentAreaFilled(true);
		btnBack_5.setBorderPainted(true);
		btnBack_5.setBackground(new Color(0, 102, 51));
		btnBack_5.setBounds(10, 957, 265, 54);
		evalPn.add(btnBack_5);
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
				;
			}
		});

		//NCP Panel
		
		JPanel ncpPn = new JPanel();
		ncpPn.setBackground(new Color(213, 255, 213));
		frame.getContentPane().add(ncpPn, "ncp");
		ncpPn.setLayout(null);
		
		JLabel titleLbl_6 = new JLabel("E-Nurse System");
		titleLbl_6.setForeground(new Color(0, 102, 51));
		titleLbl_6.setFont(new Font("Times New Roman", Font.BOLD, 45));
		titleLbl_6.setBackground(new Color(0, 102, 51));
		titleLbl_6.setBounds(10, 0, 745, 77);
		ncpPn.add(titleLbl_6);
		
		JLabel tempLbl_6 = new JLabel();
		tempLbl_6.setText("Generate NCP");
		tempLbl_6.setForeground(new Color(0, 102, 51));
		tempLbl_6.setFont(new Font("Times New Roman", Font.BOLD, 45));
		tempLbl_6.setBackground(new Color(0, 102, 51));
		tempLbl_6.setBounds(10, 66, 745, 77);
		ncpPn.add(tempLbl_6);
		
		JLabel picLbl_5 = new JLabel("");
		picLbl_5.setHorizontalAlignment(SwingConstants.LEFT);
		picLbl_5.setBackground(Color.WHITE);
		picLbl_5.setBounds(1474, 257, 400, 480);
		ncpPn.add(picLbl_5);
		picLbl_5.setIcon(ptImage);
		
		JTextPane pttTxt5 = new JTextPane();
		pttTxt5.setText("Mrs. Floridia Jocelyn De Leon");
		pttTxt5.setForeground(new Color(213, 255, 213));
		pttTxt5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		pttTxt5.setEditable(false);
		pttTxt5.setBackground(new Color(0, 102, 51));
		pttTxt5.setBounds(1474, 783, 400, 47);
		ncpPn.add(pttTxt5);
		
		JTextPane ptNameTxt5 = new JTextPane();
		ptNameTxt5.setText("Patient Name:");
		ptNameTxt5.setForeground(new Color(213, 255, 213));
		ptNameTxt5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		ptNameTxt5.setEditable(false);
		ptNameTxt5.setBackground(new Color(0, 102, 51));
		ptNameTxt5.setBounds(1474, 737, 400, 47);
		ncpPn.add(ptNameTxt5);
		
		StyledDocument patient5 = pttTxt5.getStyledDocument();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		patient5.setParagraphAttributes(0, patient5.getLength(), center, false);
		
		JButton ptInfoBtn_6 = new JButton("Patient Information");
		ptInfoBtn_6.setForeground(Color.WHITE);
		ptInfoBtn_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptInfoBtn_6.setFocusPainted(false);
		ptInfoBtn_6.setContentAreaFilled(true);
		ptInfoBtn_6.setBorderPainted(true);
		ptInfoBtn_6.setBackground(new Color(0, 102, 51));
		ptInfoBtn_6.setBounds(0, 175, 300, 61);
		ncpPn.add(ptInfoBtn_6);
		ptInfoBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ptinfo");
			}
		});
		
		JButton ptAssessBtn_6 = new JButton("Assessment");
		ptAssessBtn_6.setForeground(Color.WHITE);
		ptAssessBtn_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		ptAssessBtn_6.setFocusPainted(false);
		ptAssessBtn_6.setContentAreaFilled(true);
		ptAssessBtn_6.setBorderPainted(true);
		ptAssessBtn_6.setBackground(new Color(0, 102, 51));
		ptAssessBtn_6.setBounds(0, 283, 300, 61);
		ncpPn.add(ptAssessBtn_6);
		ptAssessBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ass");
			}
		});
		
		JButton nsdgBtn8 = new JButton("Nurse Diagnosis");
		nsdgBtn8.setForeground(Color.WHITE);
		nsdgBtn8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		nsdgBtn8.setFocusPainted(false);
		nsdgBtn8.setContentAreaFilled(true);
		nsdgBtn8.setBorderPainted(true);
		nsdgBtn8.setBackground(new Color(0, 102, 51));
		nsdgBtn8.setBounds(0, 393, 300, 61);
		ncpPn.add(nsdgBtn8);
		nsdgBtn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "diag");
			}
		});
		
		JButton planBtn_6 = new JButton("Planning");
		planBtn_6.setForeground(Color.WHITE);
		planBtn_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		planBtn_6.setFocusPainted(false);
		planBtn_6.setContentAreaFilled(true);
		planBtn_6.setBorderPainted(true);
		planBtn_6.setBackground(new Color(0, 102, 51));
		planBtn_6.setBounds(0, 503, 300, 61);
		ncpPn.add(planBtn_6);
		planBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "plan");
			}
		});
		
		JButton interventBtn_6 = new JButton("Intervention");
		interventBtn_6.setForeground(Color.WHITE);
		interventBtn_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		interventBtn_6.setFocusPainted(false);
		interventBtn_6.setContentAreaFilled(true);
		interventBtn_6.setBorderPainted(true);
		interventBtn_6.setBackground(new Color(0, 102, 51));
		interventBtn_6.setBounds(0, 613, 300, 61);
		ncpPn.add(interventBtn_6);
		interventBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "inter");
			}
		});
		
		JButton evalBtn_6 = new JButton("Evaluation");
		evalBtn_6.setForeground(Color.WHITE);
		evalBtn_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		evalBtn_6.setFocusPainted(false);
		evalBtn_6.setContentAreaFilled(true);
		evalBtn_6.setBorderPainted(true);
		evalBtn_6.setBackground(new Color(0, 102, 51));
		evalBtn_6.setBounds(0, 723, 300, 61);
		ncpPn.add(evalBtn_6);
		evalBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "eval");
			}
		});
		
		JButton genNCPBtn_6 = new JButton("NCP");
		genNCPBtn_6.setForeground(Color.WHITE);
		genNCPBtn_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		genNCPBtn_6.setFocusPainted(false);
		genNCPBtn_6.setContentAreaFilled(true);
		genNCPBtn_6.setBorderPainted(true);
		genNCPBtn_6.setBackground(new Color(0, 102, 51));
		genNCPBtn_6.setBounds(0, 833, 300, 61);
		ncpPn.add(genNCPBtn_6);
		genNCPBtn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "ncp");
				
			}
		});
		
		JButton btnBack_6 = new JButton("Back");
		btnBack_6.setForeground(Color.WHITE);
		btnBack_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		btnBack_6.setFocusPainted(false);
		btnBack_6.setContentAreaFilled(true);
		btnBack_6.setBorderPainted(true);
		btnBack_6.setBackground(new Color(0, 102, 51));
		btnBack_6.setBounds(10, 957, 265, 54);
		ncpPn.add(btnBack_6);
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "intro");
			}
		});

		 JScrollPane scrollPane_1 = new JScrollPane(ncpTbl);
		 scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		 scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		 scrollPane_1.setBounds(310, 176, 1154, 718);
		 ncpPn.add(scrollPane_1);
		 scrollPane_1.setVisible(true);
		// add(scrollPane_1);

	     String[] columnNames = {"Assessment","Nurse Diagnosis","Planning","Intervention","Evaluation"};
	     DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		 JTable ncpTbl_1 = new JTable(new DefaultTableModel(
		 	new Object[][] {
		 	},
		 	new String[] {
		 		"Assessment","Nurse Diagnosis", "Planning", "Intervention", "Evaluation"
		 	}
		 ));
		ncpTbl_1.setFillsViewportHeight(true);
		ncpTbl_1.setSize(new Dimension(500, 500));
		ncpTbl_1.setRowSelectionAllowed(false);
		ncpTbl_1.setIntercellSpacing(new Dimension(10, 10));
		ncpTbl_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		ncpTbl_1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		ncpTbl_1.setPreferredScrollableViewportSize(new Dimension(19996, 409991));
		ncpTbl_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		ncpTbl_1.setRowMargin(3);
		ncpTbl_1.setRowHeight(150);
		ncpTbl_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane_1.setViewportView(ncpTbl_1);

		ncpTbl_1.getColumnModel().getColumn(0).setCellRenderer(new WordWrapCellRenderer());
		ncpTbl_1.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
		
		JTableHeader Theader = ncpTbl_1.getTableHeader();
		ncpTbl_1.setFont(new Font("Arial", Font.PLAIN, 17));
	    Theader.setBackground(new Color(0, 102, 51));
	    Theader.setForeground(Color.WHITE);
	    Theader.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
   		
   		
	        JButton genTbl = new JButton("Generate Nurse Care Plan");
	        genTbl.setForeground(Color.WHITE);
	        genTbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
	        genTbl.setFocusPainted(false);
	        genTbl.setContentAreaFilled(true);
	        genTbl.setBorderPainted(true);
	        genTbl.setBackground(new Color(0, 102, 51));
	        genTbl.setBounds(1151, 957, 313, 54);
	        ncpPn.add(genTbl);
	        genTbl.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String text1 = timeInput.getText();
	                String text2 = timeInput2.getText();
	                String text3 = subdataTxt.getText() +"\n\n"+ objdataTxt.getText();
	                
	                
	        		String checkedItems = " ";
	                for (JCheckBox checkBox : checkBoxList) {
	                    if (checkBox.isSelected()) {
	                        checkedItems += checkBox.getText() + ", ";
	                    }
	                }
	                checkedItems = checkedItems.replaceAll(", $", ""); // remove the last comma and space
	                
	                String selectedValues1 = (String) choice1.getSelectedItem()+" "+choice2.getSelectedItem()+" "+choice3.getSelectedItem();
	                String selectedValues2 = (String) choice4.getSelectedItem()+" "+choice5.getSelectedItem()+" "+choice6.getSelectedItem();

	                
	                // Create a new row for the table
	                DefaultTableModel model = (DefaultTableModel) ncpTbl_1.getModel();
	                Object[] row = {text3, checkedItems +"  ","After "+text1 +" of nursing interventions, the patient will be able to "+ selectedValues1+"  "+"\n\nAfter "+
	                text2+" of nursing interventions, "+selectedValues2};
	                model.addRow(row);
	        	}
	        });
	}

		
	

	
		
	

}

