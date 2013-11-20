package br.com.mycompany.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;


public class PhaseListenerMyCompany implements PhaseListener {
    
    //inicio da fase
    @Override
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            
           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           FacesContextUtil.setRequestSession(session);
        }
    }
    //depois da fase
    @Override
    public void afterPhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            
           Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if(session.getTransaction().isActive()){
                    session.getTransaction().rollback();//salva o que tiver no banco de dados
                }
            }finally{
                 session.close();//fecha o banco 
            }
        }
    }    

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
