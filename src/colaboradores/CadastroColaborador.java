package colaboradores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import colaboradores.Colaborador;
import javax.swing.JTextPane;

public class CadastroColaborador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane txtpnCadastroEfetuado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroColaborador frame = new CadastroColaborador();
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
	public CadastroColaborador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(10, 11, 47, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(56, 8, 368, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 60, 47, 14);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 57, 133, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancoDeDados bdDAO = new bancoDeDados();
				bdDAO.conectar();
				String nome = textField.getText();
				String cpf = textField_1.getText();
				
				Colaborador colaborador = new Colaborador();
				colaborador.setCpf(cpf);
				colaborador.setNome(nome);
				
				if(cpf.isEmpty() || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Favor, preencher nome e cpf");
				}else {
					bdDAO.insereColaboradores(cpf, nome);
					
					bdDAO.desconectar();
					txtpnCadastroEfetuado = new JTextPane();
					txtpnCadastroEfetuado.setText("Cadastro Efetuado");
					txtpnCadastroEfetuado.setBounds(170, 230, 167, 20);
					contentPane.add(txtpnCadastroEfetuado);	
				}	
			}	
		});
		btnCadastrar.setBounds(178, 185, 119, 23);
		contentPane.add(btnCadastrar);
	}
}
