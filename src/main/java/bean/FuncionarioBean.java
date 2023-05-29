package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.tomcat.util.http.fileupload.RequestContext;

import dao.FuncionarioDao;
import entidade.Funcionario;

import static Util.MessageUtil.*;
import static Util.MessageUtil.erro;
import static Util.MessageUtil.sucesso;

@ManagedBean
public class FuncionarioBean {
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> lista;
    private boolean editarDialogVisible;

    public String salvar() {
        try {
            FuncionarioDao.salvar(funcionario);
            sucesso("Sucesso", "Funcionário salvo com sucesso");
            funcionario = new Funcionario();
        } catch (Exception e) {
            erro("Erro", "Erro ao salvar o funcionário");
        }
        return null;
    }

    public void salvarEdicao() {
        try {
            FuncionarioDao.editar(funcionario);
            sucesso("Sucesso", "Funcionário editado com sucesso");
            lista.removeIf(f -> f.getId().equals(funcionario.getId()));

            lista = FuncionarioDao.listarTodos();

            funcionario = new Funcionario();

            setEditarDialogVisible(false);
        } catch (Exception e) {
            erro("Erro", "Erro ao editar o funcionário");
        }
    }



	public boolean isEditarDialogVisible() {
		return editarDialogVisible;
	}

	public void setEditarDialogVisible(boolean editarDialogVisible) {
		this.editarDialogVisible = editarDialogVisible;
	}


    public String excluir(Funcionario funcionario) {
        try {
            FuncionarioDao.excluir(funcionario);
            sucesso("Sucesso", "Funcionário excluído com sucesso");
        } catch (Exception e) {
            erro("Erro", "Erro ao excluir o funcionário");
        }
        return null;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getLista() {
        if (lista == null) {
            lista = FuncionarioDao.listarTodos();
        }
        return lista;
    }

    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }
}
