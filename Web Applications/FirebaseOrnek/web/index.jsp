<%-- 
    Document   : index
    Created on : Jul 12, 2017, 9:35:41 AM
    Author     : HilalSener
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Firebase Ornek</title>

        <script src="https://www.gstatic.com/firebasejs/4.1.3/firebase.js"></script>
        <script src="https://www.gstatic.com/firebasejs/4.1.3/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/4.1.3/firebase-auth.js"></script>
        <script src="https://www.gstatic.com/firebasejs/4.1.3/firebase-database.js"></script>
        <script src="https://www.gstatic.com/firebasejs/4.1.3/firebase-messaging.js"></script>
        <script>
            var config = {
                apiKey: "AIzaSyDpHXXkCVlpWT6KGFC-22w1-_h0HXFHah0",
                authDomain: "myapp-4f43a.firebaseapp.com",
                databaseURL: "https://myapp-4f43a.firebaseio.com",
                projectId: "myapp-4f43a",
                storageBucket: "myapp-4f43a.appspot.com",
                messagingSenderId: "77697197765"
            };
            var app = firebase.initializeApp(config);
            var db = app.database();

            var myBook =
                    {
                        id: "kitap001",
                        author: "Falan Filan",
                        title: "Calismiyor",
                        genre: "Firebase",
                        price: "25",
                        publish_date: "2017-07-12",
                        description: "Realtime DB Aciklama"
                    }

            db.ref('kitaplar/' + "12").set(myBook);
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
