package br.com.mycompany.support;

import br.com.mycompany.model.dao.HibernateDAO;
import br.com.mycompany.model.dao.InterfaceDAO;
import br.com.mycompany.model.entities.TipoEndereco;
import br.com.mycompany.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name = "bbTipoEndereco")
@RequestScoped
public class BbTipoEndereco implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
     public List<TipoEndereco> getTipoEndereco(){
       Session session = FacesContextUtil.getRequestSession();
       InterfaceDAO<TipoEndereco>tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, session); 
       return tipoEnderecoDAO.getEntities();
    }
}
