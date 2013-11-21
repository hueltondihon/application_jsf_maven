package br.com.mycompany.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idPessoa", nullable = false)
    private Integer idPessoa;
    @Column(name="nome",nullable = false,length = 80)
    private String nome;
    @Column(name="email",nullable = false,length = 80)
    private String email;
    @Column(name="telefone",nullable = false,length = 14)//(011)4541-8000
    private String Telefone;
    @Column(name="cpf",nullable = false,length = 14)//256.243.567-54
    private String cpf;
    @Column(name="data de nascimento",nullable = false,length = 80)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeNascimento;
    @Column(name="data de cadastro",nullable = false,length = 80)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDeCadastro;
    
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    private Endereco endereco;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "pessoaSexo")
    @JoinColumn(name = "idSexo", referencedColumnName = "idSexo")
    private Sexo sexo;

    public Pessoa() {
    }

        
    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    
    }    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }
    
    
    
    
}
