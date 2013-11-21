package br.com.mycompany.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Integer idEndereco;
    @Column(name = "Bairro", nullable = false, length = 80)
    private String bairro;
    @Column(name = "Nomelogradouro", nullable = false, length = 100)
    private String nomeLogradouro;
    @Column(name = "Cep", nullable = false, length = 9)
    private String cep;
    @Column(name = "Numero", nullable = false)
    private Integer numero;      
    @Column(name = "Complemento")
    private Integer complemento; 
    
    
    
    @ManyToOne
    @ForeignKey(name = "")
    private List<Endereco> enderecos;
    
}
