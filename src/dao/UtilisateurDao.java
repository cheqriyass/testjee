package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Utilisateur;

@Stateless
public class UtilisateurDao {
    private static final String JPQL_SELECT_PAR_EMAIL = "SELECT u FROM Utilisateur u WHERE u.email=:email";
    private static final String PARAM_EMAIL           = "email";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "ensam_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouvel utilisateur
    public void creer( Utilisateur utilisateur ){
        try {
//        	em.getTransaction().begin();
            em.persist( utilisateur );
//            em.getTransaction().commit();
        } catch ( Exception e ) {
            throw e;
        }
    }

    // Recherche d'un utilisateur à partir de son adresse email
    public Utilisateur trouver( String email ){
    	if (email==null) return null;
        Utilisateur utilisateur = null;
        Query requete = em.createQuery( JPQL_SELECT_PAR_EMAIL );
        requete.setParameter( PARAM_EMAIL, email );
        try {
            utilisateur = (Utilisateur) requete.getSingleResult();
        } catch ( NoResultException e ) {
            return null;
        } catch ( Exception e ) {
            throw e;
        }
        return utilisateur;
    }
}