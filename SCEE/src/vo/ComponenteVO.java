package vo; 

import java.io.Serializable;


public class ComponenteVO implements Serializable { 
    
    private static final long serialVersionUID = 1L;
    
    private long cdComponente;
    private String nm;
    private long quantidade;
    private String descricao;

    public void setCdComponente(long cdComponente) {
        this.cdComponente = cdComponente;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public long getCdComponente() {
        return cdComponente;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNm() {
        return nm;
    }

    public long getQuantidade() {
        return quantidade;
    }
    
    

} 
