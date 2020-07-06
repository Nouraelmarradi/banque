package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Employe  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nom;
	private String prenom;
	private String cin;
	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	private Date datenaissance;
	@ManyToOne
	private Agence agence;
	private String mission;
	private String passworld;
	private String username;
	private String salet;
	@ManyToOne
	private User user;
	
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the salet
	 */
	public String getSalet() {
		return salet;
	}
	/**
	 * @param salet the salet to set
	 */
	public void setSalet(String salet) {
		this.salet = salet;
	}
	/**
	 * @return the mission
	 */
	public String getMission() {
		return mission;
	}
	/**
	 * @return the passworld
	 */
	public String getPassworld() {
		return passworld;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param passworld the passworld to set
	 */
	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param mission the mission to set
	 */
	public void setMission(String mission) {
		this.mission = mission;
	}
	/**
	 * @return the cin
	 */
	public String getCin() {
		return cin;
	}
	/**
	 * @param cin the cin to set
	 */
	public void setCin(String cin) {
		this.cin = cin;
	}
	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}
	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public Employe(Long id, String nom, String prenom, Date datenaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaissance = datenaissance;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @return the datenaissance
	 */
	public Date getDatenaissance() {
		return datenaissance;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @param datenaissance the datenaissance to set
	 */
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + "]";
	}
	
}
