package colaboradores;

public class equipe {

	public static void main(String[] args) {
     bancoDeDados bancoDeDados = new bancoDeDados();
     bancoDeDados.conectar();
if (bancoDeDados.estaConectado()) {
	bancoDeDados.listarColaboradores();
	bancoDeDados.insereColaboradores("Ganso", "000.111.222-33");
	bancoDeDados.listarColaboradores();
	//bancoDeDados.itens();
	//bancoDeDados.Colaboradores();
	//bancoDeDados.insereColaborador("113.555.874-74","Kaio");
	bancoDeDados.desconectar();
}else {
	System.out.println("não foi possivel conectar ao banco de dados");
}
	}

}
