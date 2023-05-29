package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.FuncionarioDao;
import entidade.Funcionario;

@ManagedBean
@SessionScoped
public class IndexBean {
    
    private String username;
    private String password;
    
    public String login() {
        // Verifica se o login e a senha correspondem a um funcionário cadastrado
        Funcionario funcionario = FuncionarioDao.buscarFuncionarioPorLogin(username);
        
        if (funcionario != null && funcionario.getSenha().equals(password)) {
            // Armazena temporariamente o funcionário na sessão
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("funcionarioLogado", funcionario);
            return "listagem_incidente.xhtml?faces-redirect=true";
        } else {
            // Exibe mensagem de erro de login inválido
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de login", "Credenciais inválidas"));
            return null;
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml?faces-redirect=true";
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}