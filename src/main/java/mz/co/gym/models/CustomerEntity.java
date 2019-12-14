
package mz.co.gym.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cliente")
public class CustomerEntity extends DomainEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome_Completo", nullable = false)
	private String nomeCompleto;

	@Column(name = "numero_BI", nullable = true)
	private String numeroBI;

	@Column(name = "natural_De", nullable = false)
	private String naturalDe;

	@Column(name = "profissao", nullable = true)
	private String profissao;

	@Column(name = "contacto", nullable = false)
	private String contacto;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "residencia", nullable = true)
	private String residencia;

	@Column(name = "local_Trabalho", nullable = true)
	private String localDeTrabalho;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_Nascimento", nullable = false)
	private LocalDate dataDeNascimento;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_Inscricao", nullable = false)
	private LocalDate dataDeInscricao = LocalDate.now();

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "data_Inicio", nullable = false)
	private LocalDate dataDeInicio;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNumeroBI() {
		return numeroBI;
	}

	public void setNumeroBI(String numeroBI) {
		this.numeroBI = numeroBI;
	}

	public String getNaturalDe() {
		return naturalDe;
	}

	public void setNaturalDe(String naturalDe) {
		this.naturalDe = naturalDe;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getLocalDeTrabalho() {
		return localDeTrabalho;
	}

	public void setLocalDeTrabalho(String localDeTrabalho) {
		this.localDeTrabalho = localDeTrabalho;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public LocalDate getDataDeInscricao() {
		return dataDeInscricao;
	}

	public void setDataDeInscricao(LocalDate dataDeInscricao) {
		this.dataDeInscricao = dataDeInscricao;
	}

	public LocalDate getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(LocalDate dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public String dataDeInscricaoFormatada() {
		return this.dataDeInscricao.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

	public String dataDeInicioFormatada() {
		return this.dataDeInicio.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
	}

}
