package servlets;

import java.io.IOException;
import static java.lang.System.out;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;
import entities.Utilisateur;
import forms.ConnexionForm;

@WebServlet( urlPatterns = { "/connexion" } )
public class Connexion extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";
    public static final String VUE      = "/index.jsp";
    public final int x=10;
    public final int z=10;
    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private UtilisateurDao   utilisateurDao;

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
    	ConnexionForm form = new ConnexionForm( );
        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request,utilisateurDao );


        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
