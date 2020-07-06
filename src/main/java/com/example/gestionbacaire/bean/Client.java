package com.example.gestionbacaire.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;


@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String cin;
	private String nom;
	private String prenom;
	private String age;
	private String email;
	private String username;
	private String salt;
	private String passworld;
	
	private Date date;
	private Long codeContrat;
	@ManyToOne
	private Employe employe;
	@OneToOne
	private User user;
	 
	/**
	 * @return the codeContrat
	 */
	public Long getCodeContrat() {
		return codeContrat;
	}



	/**
	 * @return the employe
	 */
	public Employe getEmploye() {
		return employe;
	}



	/**
	 * @param codeContrat the codeContrat to set
	 */
	public void setCodeContrat(Long codeContrat) {
		this.codeContrat = codeContrat;
	}



	/**
	 * @param employe the employe to set
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}



	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}



	/**
	 * @return the passworld
	 */
	public String getPassworld() {
		return passworld;
	}



	/**
	 * @param salt the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}



	/**
	 * @param passworld the passworld to set
	 */
	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}



	public User getUser() {
		return user;
	}



	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	 private Agence agence;
     public Agence getAgence() {
				return agence;
			}



			public void setAgence(Agence agence) {
				this.agence = agence;
			}


	public String getCin() {
		return cin;
	}

	
	public void setCin(String cin) {
		this.cin = cin;
	}

	
	public Long getId() {
		return id;
	}

	
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

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
	 * @return the age
	 */
	public String getAge() {
		return age;
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
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long id, String code, String nom, String prenom, String age) {
		super();
		this.id = id;
		this.cin = code;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", code=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age
				+ ", typeClient=" +  "]";
	}

}
