
package br.com.mycompany.support;

import br.com.mycompany.model.dao.HibernateDAO;
import br.com.mycompany.model.dao.InterfaceDAO;
import br.com.mycompany.model.entities.Cidade;
import br.com.mycompany.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbCidade")
@RequestScoped
public class BbCidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
     public List<Cidade> getCidades(){
       InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession()); 
       return cidadeDAO.getEntities();
    }
    
}
