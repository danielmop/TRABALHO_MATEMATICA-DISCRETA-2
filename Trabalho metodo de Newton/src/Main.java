import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JTextArea;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel textInstrucao;
	private JTextField textCoeficiente;
	private JTextField textGrau;
	private JLabel lblX;
	private JTextField textFuncao;
	private Newton x;
	private int expoente=0;
	private JTextPane textRaiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textInstrucao = new JLabel("");
		textInstrucao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textInstrucao.setBounds(222, 10, 42, 36);
		panel.add(textInstrucao);
		
		textCoeficiente = new JTextField();
		textCoeficiente.setBounds(175, 104, 37, 37);
		panel.add(textCoeficiente);
		textCoeficiente.setColumns(10);

		lblX = new JLabel("x^");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblX.setBounds(222, 102, 42, 36);
		panel.add(lblX);

		textGrau = new JTextField();
		textGrau.setText("0");
		textGrau.setBounds(175, 49, 37, 37);
		panel.add(textGrau);
		textGrau.setColumns(10);

		JButton btnGrau = new JButton("grau");
		btnGrau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				x = new Newton(Integer.parseInt(textGrau.getText()+1));
				lblX.setText("x^" + textGrau.getText());
				textGrau.setText("");
				textFuncao.setText("");

			}
		});
		btnGrau.setBounds(47, 49, 118, 37);
		panel.add(btnGrau);

		JButton btnCoeficiente = new JButton("coeficiente");
		btnCoeficiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (expoente != -1) {
				expoente = Integer.parseInt(lblX.getText().substring(2));
				x.coeficientes[expoente] = Integer.parseInt(textCoeficiente.getText());
				if (expoente == 0) {
					textFuncao.setText(textFuncao.getText() + x.coeficientes[expoente] + " x^ " + expoente + "");
				}
				else {
					textFuncao.setText(textFuncao.getText() + x.coeficientes[expoente] + " x^ " + expoente + " + ");
				}
				textCoeficiente.setText("0");
				expoente--;
				
					lblX.setText(lblX.getText().substring(0, 2) + expoente);
				}
			}
		});
		btnCoeficiente.setBounds(47, 104, 118, 37);
		panel.add(btnCoeficiente);

		JButton btnCalcula = new JButton("calcular");
		btnCalcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.raizes.clear();
				x.isolamento();
				/*Iterator<Double> iterator=x.raizes.iterator();
				while(iterator.hasNext()){
					textRaiz.setText(iterator.next()+"\n");
				}*/
				textRaiz.setText(x.raizes.toString());
				
			}
		});
		btnCalcula.setBounds(241, 356, 93, 37);
		panel.add(btnCalcula);

		textFuncao = new JTextField();
		textFuncao.setHorizontalAlignment(SwingConstants.CENTER);
		textFuncao.setEditable(false);
		textFuncao.setBounds(47, 197, 494, 57);
		panel.add(textFuncao);
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o");
		lblFuncao.setForeground(Color.RED);
		lblFuncao.setFont(new Font("Serif", Font.PLAIN, 30));
		lblFuncao.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuncao.setBounds(150, 152, 271, 43);
		panel.add(lblFuncao);
		
		textRaiz = new JTextPane();
		textRaiz.setEnabled(false);
		textRaiz.setEditable(false);
		textRaiz.setBounds(47, 286, 494, 59);
		panel.add(textRaiz);
		//textRaiz.setColumns(10);
		
		JLabel lblFuno = new JLabel("Raizes:");
		lblFuno.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuno.setForeground(Color.BLACK);
		lblFuno.setFont(new Font("Serif", Font.PLAIN, 20));
		lblFuno.setBounds(205, 256, 162, 19);
		panel.add(lblFuno);
		
		JTextArea txtrAperteOBoto = new JTextArea();
		txtrAperteOBoto.setText("Aperte o bot\u00E3o de grau ap\u00F3s \r\n digitar o grau da fun\u00E7\u00E3o.\r\n Ap\u00F3s isso digite o \r\ncoeficiente e pressione o \r\nbot\u00E3o coeficiente.");
		txtrAperteOBoto.setBounds(294, 41, 247, 100);
		panel.add(txtrAperteOBoto);
	}
}
