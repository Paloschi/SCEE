/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scee;

import db.DAO;
import db.DB;
import db.DBH2;
import db.dao_impl.ComponenteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vo.ComponenteVO;

/**
 *
 * @author Paloschi
 */
public class MainController implements Initializable {

    @FXML
    private TextField cd;
    @FXML
    private TextField nm;
    @FXML
    private TextField desq;
    @FXML
    private TextField qnt;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
    
        DB db = DBH2.getInstance();
        
        ComponenteDAO dao = new ComponenteDAO(db);
        
        ComponenteVO comp = new ComponenteVO();
        
        comp.setCdComponente(Long.parseLong(cd.getText()));
        comp.setDescricao(desq.getText());
        comp.setNm(nm.getText());
        comp.setQuantidade(Long.parseLong(qnt.getText()));
        
        dao.setComponenteVO(comp);
        dao.inserir();
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
