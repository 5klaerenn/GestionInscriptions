<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Confirmation</title>
    </head>
    <body>
        
        <h3>L'étudiant a bien été modifié</h3>
       
        <p> </p>
        
        <label>Prénom: </label>
        <span>${personnes.firstName}</span><br>
        <label>Nom: </label>
        <span>${personnes.lastName}</span><br>

        
        <p>Pour inscrire un nouvel étudiant :</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
        
                
    </body>
</html>