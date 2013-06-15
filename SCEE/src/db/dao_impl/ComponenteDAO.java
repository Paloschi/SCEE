package db.dao_impl;

import db.DAO;
import db.DB;
import db.DBH2;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import vo.ComponenteVO;

public class ComponenteDAO implements DAO {

    private DB db;
    private ComponenteVO componenteVO;
    private static final String TABLE = "T1_COMPONENTE";
    private static final String ATTR_LIST = "comp_codigo, comp_nome, comp_descricao, comp_quantidade";

    public ComponenteDAO(DB db) throws Exception {
        this.db = db;
        componenteVO = new ComponenteVO();
    }

    public ComponenteDAO() throws Exception {
        this(DBH2.getInstance());
    }

    public ComponenteVO getComponenteVO() {
        return componenteVO;
    }

    public void setComponenteVO(ComponenteVO componenteVO) {
        this.componenteVO = componenteVO;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public DB getDb() {
        return db;
    }

    private String getTable() {
        return TABLE;
    }

    @Override
    public void atualizar() throws Exception {

        db.update("UPDATE " + getTable() + " SET "
                + "comp_nome = '" + componenteVO.getNm() + "', "
                + "comp_descricao = '" + componenteVO.getDescricao() + "', "
                + "comp_quantidade = '" + componenteVO.getQuantidade() + "'"
                + " WHERE " + wherePrimaryKeys());
    }

    @Override
    public void excluir() throws Exception {

        db.update("DELETE FROM " + getTable() + " WHERE " + wherePrimaryKeys());

    }

    @Override
    public void excluirTudo() throws Exception {

        db.update("DELETE " + getTable());

    }

    @Override
    public void inserir() throws Exception {

        db.update("INSERT INTO " + getTable() + "(" + ATTR_LIST + ") " + "VALUES( "
                + componenteVO.getCdComponente() + ", '" 
                + componenteVO.getNm() + "', '"
                + componenteVO.getDescricao() + "', '"
                + componenteVO.getQuantidade() + "')");

    }

    @Override
    public Object obter() throws Exception {
        ComponenteVO componenteVOAux;

        db.select("SELECT " + ATTR_LIST + " FROM " + getTable() + " WHERE " + wherePrimaryKeys());
        if (db.moveNext()) {
            componenteVOAux = buildObject();
        } else {
            return null;
        }


        return componenteVOAux;
    }

    @Override
    public List<?> obterLista() throws Exception {

        List<ComponenteVO> lista = new ArrayList<ComponenteVO>();
        db.select("SELECT " + ATTR_LIST + " FROM " + getTable());

        while (db.moveNext()) {
            lista.add(buildObject());
        }
        return lista;

    }

    public boolean existe(ComponenteVO componenteVO) throws Exception {

        db.select("SELECT " + ATTR_LIST + " FROM " + getTable()
                + " WHERE comp_codigo = " + componenteVO.getCdComponente());
        return db.moveNext();

    }
	private String wherePrimaryKeys() {
		return "comp_codigo = '" + componenteVO.getCdComponente() + "'";
	}
        
	private ComponenteVO buildObject() throws Exception {
		ComponenteVO unidadeMedida = new ComponenteVO();
		unidadeMedida.setCdComponente(Long.parseLong(db.getString("comp_codigo")));
		unidadeMedida.setNm(db.getString("comp_nome"));
		unidadeMedida.setQuantidade(Long.parseLong(db.getString("comp_quantidade")));
                unidadeMedida.setDescricao(db.getString("comp_descricao"));
		return unidadeMedida;
	}
}
