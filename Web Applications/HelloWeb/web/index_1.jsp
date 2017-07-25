<%-- 
    Document   : index
    Created on : 06.Tem.2017, 12:27:54
    Author     : EmirCivas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body onLoad="getKonum()">
    <h1>Hello World!</h1>
<div id="konumData">
    <iframe id="embedded_map"
  width="600"
  height="450"
  frameborder="0" style="border:0"
  src="" allowfullscreen>

</iframe>
</div>
</body>
<script>
    function getKonum()
    {
        if(navigator.geolocation)
        {
            console.log("Bu Tarayıcı Konum Bulmayı Destekliyor");
            navigator.geolocation.getCurrentPosition(setKonumBilgileri);
            
        }
        else
        {
            console.log("Bu Tarayıcı Konum Bulmayı Desteklemiyor");
        }
    }
    
    function setKonumBilgileri(konum)
    {
        var loc = konum.coords;
        var enlem = loc.latitude;
        var boylam = loc.longitude;
        $("#embedded_map")
                .attr('src','https://www.google.com/maps/embed/v1/place?key=AIzaSyA0IpxRJM8wY87DfVmzjs3BZBpw8Od2NFg&q='+enlem+','+boylam+'&zoom=16')
        
        console.log("Konum Bilgileri : "+loc.latitude+","+loc.longitude);
    }
</script>    
</html>
