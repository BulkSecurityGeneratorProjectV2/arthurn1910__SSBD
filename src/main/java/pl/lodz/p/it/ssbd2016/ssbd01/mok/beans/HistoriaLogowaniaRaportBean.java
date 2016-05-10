package pl.lodz.p.it.ssbd2016.ssbd01.mok.beans;

import java.io.IOException;
import pl.lodz.p.it.ssbd2016.ssbd01.encje.HistoriaLogowania;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AccessLocalException;
import javax.ejb.EJBAccessException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import pl.lodz.p.it.ssbd2016.ssbd01.wyjatki.WyjatekSystemu;

/**
 * Bean odpowiedzialny za wygenerowanie raportu dla admina
 *
 * @author Kamil Rogowski
 */
@RequestScoped
@Named
public class HistoriaLogowaniaRaportBean {

    @Inject
    private UzytkownikSession uzytkownikSession;
    /**
     * Lista wszystkich historii logowania
     */
    private DataModel<HistoriaLogowania> historiaLogowanKont;


    /**
     * Metoda wywoływana zaraz po stworzeniu obiektu. Inicjalizuje pole
     * historiaLogowanKont wszystkimi kontami
     */
    @PostConstruct
    public void init(){
        try{
            List<HistoriaLogowania> historiaLogowan = uzytkownikSession.pobierzHistorieLogowanUzytkownikow();
            historiaLogowanKont = new ListDataModel(historiaLogowan);
        }catch(EJBAccessException | AccessLocalException e){
            WyjatekSystemu ex=new WyjatekSystemu("brakUprawnien", e);
            uzytkownikSession.setException(e);
            Logger lg=Logger.getLogger("javax.enterprice.system.conteiner.web.faces");
            lg.log(Level.SEVERE, this.getClass()+": Wystąpił wyjątek: ",ex);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest origRequest = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            try {
                externalContext.redirect(origRequest.getContextPath() + "/wyjatki/wyjatek.xhtml");
            } catch (IOException ex1) {
                Logger.getLogger(HistoriaLogowaniaRaportBean.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }

    public DataModel<HistoriaLogowania> getHistoriaLogowanKont() {
        return historiaLogowanKont;
    }

    public UzytkownikSession getUzytkownikSession() {
        return uzytkownikSession;
    }

}
