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
        // Carregar a lista de incidentes do banco de dados
        IncidenteDao incidenteDao = new IncidenteDao();
        incidentes = incidenteDao.todos();
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public String deslogar() {
        // Lógica para efetuar o logout do usuário
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Logout", "Usuário deslogado com sucesso"));

        // Retornar a próxima página a ser exibida após o logout (por exemplo, a página de login)
        return "index.xhtml?faces-redirect=true";
    }

    public String salvar(Incidente incidente) {
        // Chamar o método salvar do IncidenteDao para persistir o incidente no banco de dados
        IncidenteDao incidenteDao = new IncidenteDao();
        incidenteDao.salvar(incidente);

        // Atualizar a lista de incidentes
        init();

        // Adicionar mensagem de sucesso
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Sucesso", "Incidente salvo com sucesso"));

        // Redirecionar para a página de listagem
        return "listagem_incidente.xhtml?faces-redirect=true";
    }
}
