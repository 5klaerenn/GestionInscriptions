<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Confirmation</title>
    </head>
    <body>
        
        <h1>Merci d'avoir ajouté un nouvel étudiant</h1>
       
        <p>Voici les informations entrées : </p>
        
        <label>Prénom: </label>
        <span>${personnes.id}</span><br>
        <label>Nom: </label>
        <span>${personnes.name}</span><br>

        
        <p>Pour inscrire un nouvel étudiant :</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
        
        <p>Pour revnir a la liste des tous les etudiants :</p>
        <form action="listeEtudiants" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
                
    </body>
</html>
