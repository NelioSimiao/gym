
package mz.co.gym.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable , Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "nome_Completo", nullable = false)
	private String nomeCompleto;

	@NotNull
	@Column(name = "numero_BI", nullable = true)
	private String numeroBI;

	@NotNull
	@Column(name = "natural_De", nullable = false)
	private String naturalDe;

	@NotNull
	@Column(name = "profissao", nullable = true)
	private String profissao;

	@NotNull
	@Column(name = "contacto", nullable = false)
	private String contacto;

	@NotNull
	@Column(name = "email", nullable = true)
	private String email;

	@NotNull
	@Column(name = "residencia", nullable = true)
	private String residencia;

	@NotNull
	@Column(name = "local_Trabalho", nullable = true)
	private String localDeTrabalho;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_Nascimento", nullable = false)
	private LocalDate dataDeNascimento;

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_Inscricao", nullable = false)
	private LocalDate dataDeInscricao = LocalDate.now();

	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_Inicio", nullable = false)
	private LocalDate dataDeInicio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return this.dataDeInscricao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public String dataDeInicioFormatada() {
		return this.dataDeInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
