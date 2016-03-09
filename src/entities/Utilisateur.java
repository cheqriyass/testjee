package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long      id;
    private String    email;
    @Column( name = "mot_de_passe" )
    private String    motDePasse;
    private String    nom;

    public Utilisateur(){}
    
	public Utilisateur(Long id, String email, String motDePasse, String nom) {
		super();
		this.id = id;
		this.email = email;
		this.motDePasse = motDePasse;
		this.nom = nom;
	}

	public Utilisateur(String email, String motDePasse, String nom) {

		this.email = email;
		this.motDePasse = motDePasse;
		this.nom = nom;
	}
	
	public Utilisateur(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


    
}