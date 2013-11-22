package br.com.mycompany.controller;

import br.com.mycompany.model.dao.HibernateDAO;
import br.com.mycompany.model.dao.InterfaceDAO;
import br.com.mycompany.model.entities.Endereco;
import br.com.mycompany.model.entities.Pessoa;
import br.com.mycompany.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbPessoa")
@SessionScoped
public class MbPessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;

    public MbPessoa() {        
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
    
    public String limpaPessoa(){
        pessoa = new Pessoa();
        endereco = new Endereco();        
        return editPessoa();
    }
    
     public String editPessoa(){
              
        return "/restrict/cadastrarpessoa.jsf";
    }
    public String addPessoa(){
        Date date = new Date();
      if(pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0 ){
          pessoa.setDataDeCadastro(date);
         insertPessoa();
      }else{
         updatePessoa();
      }
      limpaPessoa();
      return null;
    }
     
     private void insertPessoa(){
       pessoaDAO().save(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravacao efetuada com sucesso!",""));
    }
     
     private void updatePessoa(){
       pessoaDAO().update(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizacao efetuada com sucesso!",""));
    }
     
     public void deletaPessoa(){
        pessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Deletado com sucesso!",""));
    }

    public List<Pessoa> getPessoas() {
         pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
     
    
    
}
