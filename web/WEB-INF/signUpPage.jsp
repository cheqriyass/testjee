<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <form method="post" action="signUpServlet">
        <fieldset>
            <legend>Sign Up</legend>

            <label for="email">Adresse email <span class="requis">*</span></label>
            <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
            <span class="erreur">${form.erreurs['email']}</span>
            <br />

            <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
            <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
            <span class="erreur">${form.erreurs['motdepasse']}</span>
            <br />

            <input type="submit" value="Connexion" class="sansLabel" />
            <br />

            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
        </fieldset>
    </form>
</body>
</html>
