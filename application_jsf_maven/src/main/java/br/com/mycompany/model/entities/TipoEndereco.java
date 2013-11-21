package br.com.mycompany.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tipoendereco")
public class TipoEndereco implements Serializable {
    
        private static final long serialVersionUID = 1L;
        
        @Id
        @GeneratedValue
        @Column(name = "idTipoEndereco",nullable = false)
        private Integer IdTipoEndereco;
        @Column(name = "descricaoTipoEndereco",nullable = false, length = 50)
        private String descricaoTipoEndereco;
        
        @OneToMany(mappedBy = "tipoendereco", fetch = FetchType.LAZY)
        @ForeignKey(name = "Endereco_TipoEndereco")
        private List<Endereco> enderecos;

    public TipoEndereco() {
    }

    public Integer getIdTipoEndereco() {
        return IdTipoEndereco;
    }

    public void setIdTipoEndereco(Integer IdTipoEndereco) {
        this.IdTipoEndereco = IdTipoEndereco;
    }

    public String getDescricaoTipoEndereco() {
        return descricaoTipoEndereco;
    }

    public void setDescricaoTipoEndereco(String descricaoTipoEndereco) {
        this.descricaoTipoEndereco = descricaoTipoEndereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.IdTipoEndereco != null ? this.IdTipoEndereco.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.IdTipoEndereco != other.IdTipoEndereco && (this.IdTipoEndereco == null || !this.IdTipoEndereco.equals(other.IdTipoEndereco))) {
            return false;
        }
        return true;
    }
        
        

}
