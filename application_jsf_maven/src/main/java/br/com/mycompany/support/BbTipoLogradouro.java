 package br.com.mycompany.support;

import br.com.mycompany.model.dao.HibernateDAO;
import br.com.mycompany.model.dao.InterfaceDAO;
import br.com.mycompany.model.entities.TipoLogradouro;
import br.com.mycompany.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name = "bbTipoLogradouro")
@RequestScoped
public class BbTipoLogradouro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
     public List<TipoLogradouro> getTipoLogradouro(){
       Session session = FacesContextUtil.getRequestSession();
       InterfaceDAO<TipoLogradouro>tipoLogradouroDAO = new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, session); 
       return tipoLogradouroDAO.getEntities();
    }
}
