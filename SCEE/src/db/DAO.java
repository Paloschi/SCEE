
package db;

import java.util.List;

public interface DAO {
	
	public void inserir() throws Exception;
	public void atualizar() throws Exception;
	public void excluir() throws Exception;
	public void excluirTudo() throws Exception;
	public Object obter() throws Exception;
	public List<?> obterLista() throws Exception;

}
