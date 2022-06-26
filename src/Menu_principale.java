import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Menu_principale {

	private JFrame frame;
	private JTextField textNom;
	private JTextField textPrix;
	private JTextField textTotal;
	private JTextField textPayer;
	private JTextField textReste;
	private JTable textTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_principale window = new Menu_principale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection com;
	PreparedStatement pst;
	ResultSet rs;
	//private String[] String[];
	public Menu_principale() {
		initialize();
	
	}
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			com = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pharma","root","");
			System.out.println("Connection etablie");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	@SuppressWarnings("unused")
	private void Table() {
		try {
			Connect();
			String[] entet = {"code" ,"nom", "prix" ,"quantite" ,"total" ,"payer" ,"reste"};
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 571, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 22, 535, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION DE PHARMACIE");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 515, 39);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 94, 535, 193);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 15, 91, 32);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prix:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 58, 91, 32);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantit\u00E9:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(10, 96, 91, 32);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(481, 15, -197, 32);
		panel_1.add(lblNewLabel_1_4);
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNom.setColumns(10);
		textNom.setBounds(69, 19, 165, 28);
		panel_1.add(textNom);
		
		textPrix = new JTextField();
		textPrix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrix.setColumns(10);
		textPrix.setBounds(69, 58, 165, 28);
		panel_1.add(textPrix);
		
		JSpinner textQuantite = new JSpinner();
		textQuantite.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int prix = Integer.parseInt(textPrix.getText());
				int quantite = Integer.parseInt(textQuantite.getValue().toString());
				
				int total = prix * quantite;
				textTotal.setText(String.valueOf(total));
			}
		});
		textQuantite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textQuantite.setBounds(69, 98, 165, 30);
		panel_1.add(textQuantite);
		
		JLabel lblNewLabel_1_5 = new JLabel("Total:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(282, 11, 91, 32);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Payer:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(282, 53, 76, 32);
		panel_1.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Reste:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(282, 96, 91, 32);
		panel_1.add(lblNewLabel_1_7);
		
		textTotal = new JTextField();
		textTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textTotal.setForeground(Color.RED);
		textTotal.setBackground(Color.BLACK);
		textTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTotal.setColumns(10);
		textTotal.setBounds(337, 19, 165, 28);
		panel_1.add(textTotal);
		
		textPayer = new JTextField();
		textPayer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
			
			}
			@Override
			public void keyReleased(KeyEvent e) {
				int total = Integer.parseInt(textTotal.getText());
				int payer = Integer.parseInt(textPayer.getText());
			int reste = total - payer ;
			textReste.setText(String.valueOf(reste));
			}
		});
		textPayer.setHorizontalAlignment(SwingConstants.CENTER);
		textPayer.setForeground(Color.BLACK);
		textPayer.setBackground(Color.GREEN);
		textPayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPayer.setColumns(10);
		textPayer.setBounds(337, 61, 165, 28);
		panel_1.add(textPayer);
		
		textReste = new JTextField();
		textReste.setHorizontalAlignment(SwingConstants.CENTER);
		textReste.setForeground(Color.WHITE);
		textReste.setBackground(Color.DARK_GRAY);
		textReste.setFont(new Font("Tahoma", Font.BOLD, 12));
		textReste.setColumns(10);
		textReste.setBounds(337, 104, 165, 28);
		panel_1.add(textReste);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connect();
					pst =  ((java.sql.Connection) com).prepareStatement("insert into tb_pharma(nom,prix,quantite,total,payer,reste) values(?,?,?,?,?,?)");
					pst.setString(1, textNom.getText());
					pst.setString(2, textPrix.getText());
					pst.setString(3, textQuantite.getValue().toString());
					pst.setString(4, textTotal.getText());
					pst.setString(5, textPayer.getText());
					pst.setString(6, textReste.getText());
					pst.executeUpdate();
					com.close();
					JOptionPane.showMessageDialog(null, textNom.getText()+" Ajouter");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(337, 143, 165, 25);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 407, 535, -108);
		frame.getContentPane().add(scrollPane);
		
		textTable = new JTable();
		textTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				/*
				 * //java.awt.List produits = new java.awt.List(); Connect(); try { pst =
				 * com.prepareStatement("select * from tb_pharma"); ResultSet rs =
				 * pst.executeQuery(); while(rs.next()) {
				 * 
				 * } //pst.executeQuery();
				 * 
				 * } catch (SQLException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */
			}
		});
		textTable.setBackground(Color.GRAY);
		textTable.setBounds(10, 298, 533, 98);
		frame.getContentPane().add(textTable);
		textTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
}
