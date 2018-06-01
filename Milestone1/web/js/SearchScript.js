/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(single_news)
{
    
    var titolo = $("<label><br/>").html(single_news.title);
    var contenuto = $("<a class=\"searchLink\" href=notizia.html?nid="+single_news.id+">").html(single_news.content);
    
    return $("<label>").append(titolo).append("<br/>").append(contenuto).append("<br/>");
}


function showNews(news){
    var news_div = $("#resultCore");
   
    news_div.empty();
    $(news_div).append("<h3>Risultati Ricerca per \""+$("#querybox").val()+"\"</h3>");
    for(var instance in news){
      
        $(news_div).append(createElement(news[instance]));
    }
}


$(document).ready(function () {
    $("#querybox").click(function () {
        

    });
    $("#querybox").keyup(function () {
        if ($("#resultBox").css("visibility") === "hidden" && $("#querybox").val().length > 0) {
            $("#resultBox").css("visibility", "visible");
        }
        if ($("#querybox").val().length === 0) {
            $("#resultBox").css("visibility", "hidden");
        }
        $.ajax({
            url: "filter.json",
            data: {
                cmd: "search",
                q: $("#querybox").val()
            },
            dataType: 'json',
            success: function (data, state) {
               
               showNews(data);
            },
            error: function (data, state) {
             
            }
        });

        
    });



});

