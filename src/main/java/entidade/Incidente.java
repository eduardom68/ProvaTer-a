package entidade;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
	@Column(name = "data_HoraSalvo")
	private Date dataHoraSalvo;

	@Column(name = "nome_vitima")
    private String nomeVitima;

    @Column(name = "genero_vitima")
    private String generoVitima;

    @Column(name = "idade_vitima")
    private int idadeVitima;

    @Column(name = "serie")
    private String serieTurnoVitima;

    @Column(name = "endereco")
    private String EnderecoVitima;

    @Column(name = "nome_agressor")
    private String nomeAgressor;

    @Column(name = "genero_agressor")
    private String generoAgressor;

    @Column(name = "idade_agressor")
    private int idadeAgressor;

    @Column(name = "grau_parentesco_agressor")
    private String grauParentescoAgressor;

    @Column(name = "ocupacao_agressor")
    private String ocupacaoAgressor;

    @Column(name = "raca_agressor")
    private String racaAgressor;

    @Column(name = "identidade_genero_agressor")
    private String identidadeGeneroAgressor;

    @Column(name = "orientacao_sexual_agressor")
    private String orientacaoSexualAgressor;

    @Column(name = "escolaridade_agressor")
    private String escolaridadeAgressor;

    @Column(name = "relatorio_incidente", length = 50000000)
    private String relatorioIncidente;

    @Column(name = "tipo_violacao")
    private String tipoViolacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHoraSalvo() {
		return dataHoraSalvo;
	}

	public void setDataHoraSalvo(Date dataHoraSalvo) {
		this.dataHoraSalvo = dataHoraSalvo;
	}

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
		return EnderecoVitima;
	}

	public void setEnderecoVitima(String endereco) {
		this.EnderecoVitima = endereco;
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
}
