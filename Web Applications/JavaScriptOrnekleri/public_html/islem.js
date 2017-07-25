/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function topla()
            {
                var i1 = document.getElementById("n1");
                var sayi1 = parseInt(i1.value);
                
                var sayi2 = parseInt(document.getElementById("n2").value);
                
                console.log("Okunan değerler: " + sayi1 + " ve " + sayi2);
                
                var sonucAlani = document.getElementById("sonuc");
                sonucAlani.innerHTML = sayi1 + " + " + sayi2 + " = " + (sayi1+sayi2);
            }

