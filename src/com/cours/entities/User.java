package com.cours.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "User.getConnection", query= "SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
})
public class User {
	
	@Id //cle primaire
	@GeneratedValue(strategy=GenerationType.IDENTITY)//cle primaire autoincrement
	private int id;
	@Column(length=100)//pour dire que ca sera une colonne au niveau de la table
	private String nomU;
	@Column(length=200)
	private String prenomU;
	@Column
	private String email;
	@Column
	private String password;
	@ManyToOne//les profils migrent comme cle etrangere dans user
	@JoinColumn(name="profil_ID")
	private Profil profil = new Profil();
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)//si on supprime par exemple un user ont doit aussi sont role au niveau de la table intermediare qui sera creee entre User et Role
	@JoinTable(name="user_roles",
	                joinColumns={@JoinColumn(name = "idU", nullable = false, updatable = false)},
	                inverseJoinColumns = {@JoinColumn(name = "idR", nullable = false, updatable = false)})
	private List<Roles> roles = new ArrayList<Roles>();
	public User(){
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomU() {
		return nomU;
	}


	public void setNomU(String nomU) {
		this.nomU = nomU;
	}


	public String getPrenomU() {
		return prenomU;
	}


	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Profil getProfil() {
		return profil;
	}


	public void setProfil(Profil profil) {
		this.profil = profil;
	}


	public List<Roles> getRoles() {
		return roles;
	}


	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	

}
