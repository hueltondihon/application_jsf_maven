package br.com.mycompany.support;

import br.com.mycompany.model.dao.HibernateDAO;
import br.com.mycompany.model.dao.InterfaceDAO;
import br.com.mycompany.model.entities.Estado;
import br.com.mycompany.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name = "bbEstado")
@RequestScoped
public class BbEstado implements Serializable{
  
    private static final long serialVersionUID = 1L;
    
     public List<Estado> getEstados(){
       Session session = FacesContextUtil.getRequestSession();
       InterfaceDAO<Estado>estadoDAO = new HibernateDAO<Estado>(Estado.class, session); 
       return estadoDAO.getEntities();
    }
    
}
