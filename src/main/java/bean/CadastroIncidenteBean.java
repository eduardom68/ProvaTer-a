package bean;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.IncidenteDao;
import entidade.Incidente;

@ManagedBean
@ViewScoped
public class CadastroIncidenteBean {
    private String nomeVitima;
    private String generoVitima;
    private int idadeVitima;
    private String serieTurnoVitima;
    private String enderecoVitima;
    private String nomeAgressor;
    private String generoAgressor;
    private int idadeAgressor;
    private String grauParentescoAgressor;
    private String ocupacaoAgressor;
    private String racaAgressor;
    private String identidadeGeneroAgressor;
    private String orientacaoSexualAgressor;
    private String escolaridadeAgressor;
    private String relatorioIncidente;
    private String tipoViolacao;
    private Date dataHoraSalvo;

    public String getNomeVitima() {
        return nomeVitima;
    }

    public void setNomeVitima(String nomeVitima) {
        this.nomeVitima = nomeVitima;
    }

    public String getGeneroVitima() {
        return generoVitima;
    }

    public void setGeneroVitima(String generoVitima) {
        this.generoVitima = generoVitima;
    }

    public int getIdadeVitima() {
        return idadeVitima;
    }

    public void setIdadeVitima(int idadeVitima) {
        this.idadeVitima = idadeVitima;
    }

    public String getSerieTurnoVitima() {
        return serieTurnoVitima;
    }

    public void setSerieTurnoVitima(String serieTurnoVitima) {
        this.serieTurnoVitima = serieTurnoVitima;
    }

    public String getEnderecoVitima() {
        return enderecoVitima;
    }

    public void setEnderecoVitima(String enderecoVitima) {
        this.enderecoVitima = enderecoVitima;
    }

    public String getNomeAgressor() {
        return nomeAgressor;
    }

    public void setNomeAgressor(String nomeAgressor) {
        this.nomeAgressor = nomeAgressor;
    }

    public String getGeneroAgressor() {
        return generoAgressor;
    }

    public void setGeneroAgressor(String generoAgressor) {
        this.generoAgressor = generoAgressor;
    }

    public int getIdadeAgressor() {
        return idadeAgressor;
    }

    public void setIdadeAgressor(int idadeAgressor) {
        this.idadeAgressor = idadeAgressor;
    }

    public String getGrauParentescoAgressor() {
        return grauParentescoAgressor;
    }

    public void setGrauParentescoAgressor(String grauParentescoAgressor) {
        this.grauParentescoAgressor = grauParentescoAgressor;
    }

    public String getOcupacaoAgressor() {
        return ocupacaoAgressor;
    }

    public void setOcupacaoAgressor(String ocupacaoAgressor) {
        this.ocupacaoAgressor = ocupacaoAgressor;
    }

    public String getRacaAgressor() {
        return racaAgressor;
    }

    public void setRacaAgressor(String racaAgressor) {
        this.racaAgressor = racaAgressor;
    }

    public String getIdentidadeGeneroAgressor() {
        return identidadeGeneroAgressor;
    }

    public void setIdentidadeGeneroAgressor(String identidadeGeneroAgressor) {
        this.identidadeGeneroAgressor = identidadeGeneroAgressor;
    }

    public String getOrientacaoSexualAgressor() {
        return orientacaoSexualAgressor;
    }

    public void setOrientacaoSexualAgressor(String orientacaoSexualAgressor) {
        this.orientacaoSexualAgressor = orientacaoSexualAgressor;
    }

    public String getEscolaridadeAgressor() {
        return escolaridadeAgressor;
    }

    public void setEscolaridadeAgressor(String escolaridadeAgressor) {
        this.escolaridadeAgressor = escolaridadeAgressor;
    }

    public String getRelatorioIncidente() {
        return relatorioIncidente;
    }

    public void setRelatorioIncidente(String relatorioIncidente) {
        this.relatorioIncidente = relatorioIncidente;
    }

    public String getTipoViolacao() {
        return tipoViolacao;
    }

    public void setTipoViolacao(String tipoViolacao) {
        this.tipoViolacao = tipoViolacao;
    }

    public Date getDataHoraSalvo() {
        return dataHoraSalvo;
    }

    public void setDataHoraSalvo(Date dataHoraSalvo) {
        this.dataHoraSalvo = dataHoraSalvo;
    }

    public void salvar() {
        Incidente incidente = new Incidente();
        incidente.setNomeVitima(nomeVitima);
        incidente.setGeneroVitima(generoVitima);
        incidente.setIdadeVitima(idadeVitima);
        incidente.setSerieTurnoVitima(serieTurnoVitima);
        incidente.setEnderecoVitima(enderecoVitima);
        incidente.setNomeAgressor(nomeAgressor);
        incidente.setGeneroAgressor(generoAgressor);
        incidente.setIdadeAgressor(idadeAgressor);
        incidente.setGrauParentescoAgressor(grauParentescoAgressor);
        incidente.setOcupacaoAgressor(ocupacaoAgressor);
        incidente.setRacaAgressor(racaAgressor);
        incidente.setIdentidadeGeneroAgressor(identidadeGeneroAgressor);
        incidente.setOrientacaoSexualAgressor(orientacaoSexualAgressor);
        incidente.setEscolaridadeAgressor(escolaridadeAgressor);
        incidente.setRelatorioIncidente(relatorioIncidente);
        incidente.setTipoViolacao(tipoViolacao);
        incidente.setDataHoraSalvo(dataHoraSalvo);

        IncidenteDao incidenteDao = new IncidenteDao();
        incidenteDao.salvar(incidente);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro de Incidente",
                        "Incidente cadastrado com sucesso"));
        ListagemIncidenteBean listagemBean = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{listagemIncidenteBean}", ListagemIncidenteBean.class);
        listagemBean.init();
        limparCampos();
    }

    private void limparCampos() {
        nomeVitima = null;
        generoVitima = null;
        idadeVitima = 0;
        serieTurnoVitima = null;
        enderecoVitima = null;
        nomeAgressor = null;
        generoAgressor = null;
        idadeAgressor = 0;
        grauParentescoAgressor = null;
        ocupacaoAgressor = null;
        racaAgressor = null;
        identidadeGeneroAgressor = null;
        orientacaoSexualAgressor = null;
        escolaridadeAgressor = null;
        relatorioIncidente = null;
        tipoViolacao = null;
        dataHoraSalvo = null;
    }
}
