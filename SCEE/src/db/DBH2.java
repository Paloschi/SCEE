package db;

import java.sql.DriverManager;

public class DBH2 extends DB {
	
	// instancia do Singleton
	private static DBH2 instance;
	private static final String CONEXAO = "jdbc:h2:~/SCEE/db/sceeDB";

	// Método construtor do Singleton
	private DBH2() throws Exception {
		Class.forName("org.h2.Driver");
		con = DriverManager.getConnection(CONEXAO, "", "");

	}

	// M�todo que retorna a instancia do Singleton
	public synchronized static DB getInstance() throws Exception {
		if (instance == null) {
			instance = new DBH2();
		}
		return instance;
	}
}