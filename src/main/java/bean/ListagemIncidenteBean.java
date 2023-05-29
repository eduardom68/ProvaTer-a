package bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.IncidenteDao;
import entidade.Incidente;

@ManagedBean
@SessionScoped
public class ListagemIncidenteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Incidente> incidentes;

    @PostConstruct
    public void init() {
        IncidenteDao incidenteDao = new IncidenteDao();
        incidentes = incidenteDao.todos();
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public String deslogar() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Logout", "Usuário deslogado com sucesso"));
        return "index.xhtml?faces-redirect=true";
    }

    public String salvar(Incidente incidente) {
        IncidenteDao incidenteDao = new IncidenteDao();
        incidenteDao.salvar(incidente);
        init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Sucesso", "Incidente salvo com sucesso"));
        return "listagem_incidente.xhtml?faces-redirect=true";
    }
}
