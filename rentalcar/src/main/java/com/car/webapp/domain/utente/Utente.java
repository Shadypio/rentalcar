package com.car.webapp.domain.utente;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.car.webapp.domain.prenotazione.Prenotazione;
import com.car.webapp.domain.ruolo.Ruolo;

@Entity
@Table(name = "utente")
public class Utente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4426740859863822276L;

	@Id
	@Column(name = "idUtente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataDiNascita")
	private Date dataDiNascita;
	
	//@OneToMany(mappedBy = "fk_idUtente")
	//private Set<Prenotazione> prenotazioniEffettuate = new HashSet<Prenotazione>();
	
	/*
	 * con LAZY viene caricato solo all'occorrenza, con EAGER sempre: 
	 * scelta di prestazioni
	 */
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_idRuolo", referencedColumnName = "idRuolo")
	private Ruolo ruolo;
	
	public Utente() {}

	public Utente(String nome, String cognome, String username, String password, Date dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataDiNascita = dataDiNascita;
	}


	/**
	 * @return the idUtente
	 */
	public Long getIdUtente() {
		return idUtente;
	}
	
	/**
	 * @return the idUtente
	 */
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dataDiNascita
	 */
	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	/**
	 * @param dataDiNascita the dataDiNascita to set
	 */
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	/*
	public Set<Prenotazione> getPrenotazioniEffettuate() {
		return prenotazioniEffettuate;
	}

	public void setPrenotazioniEffettuate(Set<Prenotazione> prenotazioniEffettuate) {
		this.prenotazioniEffettuate = prenotazioniEffettuate;
	} */
	
	
}
