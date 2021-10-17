package colaboradores;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ListaItens extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tItens;
	private void listarItens() {
		try {
			
			bancoDeDados bdDAO = new bancoDeDados();
			bdDAO.conectar();	
			DefaultTableModel model = (DefaultTableModel) tItens.getModel();
			model.setNumRows(0);
			
			ArrayList<itens> lista = bdDAO.Listar();
			
			for(int n = 0; n < lista.size(); n ++) {
				model.addRow(new Object[] {
						lista.get(n).getid(),
						lista.get(n).getCpf_colaboradores(),
						lista.get(n).getNome()
				});
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaItens frame = new ListaItens();
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
	public ListaItens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		bancoDeDados bdDAO = new bancoDeDados();
		bdDAO.conectar();	
		
		JButton btnListarItens_1 = new JButton("Listar Itens");
		btnListarItens_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarItens();
			}
		});
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnListarItens_1.setBounds(717, 92, 89, 23);
		contentPane.add(btnListarItens_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 100, 521, 300);
		contentPane.add(scrollPane);
		
	}
}


