package colaboradores;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

	public class bancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset;
	ArrayList<itens> lista = new ArrayList<>();
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/colaboradores";
		String usuario = "root";
		String senha = "";	
	    String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection=DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		}catch(Exception e) {
			System.out.println("Erro :"+ e.getMessage());
		}
	}
	public boolean estaConectado() {
		if(this.connection!= null) {
			return true ;
		}else {
			return false;
		}	
		

	}
	//Seleciona colaboradores
	public void listarColaboradores() {
		try{
			String query = "SELECT * FROM COLABORADORES ORDER BY NOME";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				System.out.println("cpf :"+ this.resultset.getString("cpf") + "- nome:"+this.resultset.getString("nome"));
			}
		}
			catch(Exception e){
				System.out.println("Erro "+ e.getMessage());
			}
			
				
		}
			//Inserir colaboradores
	public void insereColaboradores(String CPF, String NOME) {
		try {
			String query = "INSERT INTO COLABORADORES(CPF, NOME) VALUES ('" + CPF + "' , '" + NOME + "');";
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
		//Deletar colaboradores
	public void deletarColaboradores(String id) {
		try {
			String query = "DELETE FROM COLABORADORES WHERE id =" + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}

	// Atualizar Colaboradores
	public void atualizarColaboradores(String id, String CPF, String NOME) {
		try {
			String query = "UPDATE colaboradores SET cpf = '" + CPF + "', nome ='" + NOME + "' + WHERE id = '" + id+ ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	//Selecionar Itens
	public void itens() {
		try{
			String query = "SELECT * FROM itens ORDER BY NOME";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()){
				System.out.println("id :"+ this.resultset.getString("id") + "- nome:"+this.resultset.getString("nome")+ " - Cpf do Colaborador : "+ this.resultset.getString("cpf_colaboradores"));
			}
		}
			catch(Exception e){
				System.out.println("Erro "+ e.getMessage());		
		
			}
	}
	
	public ArrayList<itens> Listar(){
		String sql = "SELECT * FROM itens ORDER BY NOME";
		try {
			this.resultset = this.statement.executeQuery(sql);
			while(this.resultset.next()){
				itens obtItem = new itens();
				obtItem.setNome(this.resultset.getString("id"));
				obtItem.setNome(this.resultset.getString("nome"));
				obtItem.setNome(this.resultset.getString("cpf_colaboradores"));
				//System.out.println("id :"+ this.resultset.getString("id") + "- nome:"+this.resultset.getString("nome")+ " - Cpf do Colaborador : "+ this.resultset.getString("cpf_colaboradores"));
				lista.add(obtItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	//Inserir Itens
	public void insereitens(String ID, String NOME) {
		try {
			String query = "INSERT INTO itens(ID, NOME,Cpf_Colaboradores) VALUES ('" + ID + "' , '" + NOME + "');";
			this.statement.executeUpdate(query);

		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	//deletar itens
	public void deletarintens(String id) {
		try {
			String query = "DELETE FROM itens WHERE id =" + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	//Atualizar itens
	public void atualizaritens(String id, String NOME) {try {
		String query = "UPDATE itens SET id = '"+ id + "', nome ='"+ NOME + "' + WHERE id = '" + id + ";"; 
		this.statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}
	public void desconectar() {
		// TODO Auto-generated method stub
		
	}
	}

	
