$(document).ready(function () {
   populateCategories();
    populateAuthors();
    putHideButtons();
    ColorMode();
    $("#querybox").keyup(function () {
        if ($("#querybox").val().length === 0) {
            $("#resultBox").css("visibility", "hidden");
        }
       ajaxCalls();
    });
});

function showNews(news){
    
    $("#content").empty();
    $("#catList").empty();
    $("#authList").empty();
    $("content").append("<h3>Risultati Ricerca per \""+$("#querybox").val()+"\"</h3>");
    populateNews(news);
   
}
function ajaxCalls(){
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
             console.log("Qualcosa andò storto nelle notizie");
            }
        });
        $.ajax({
        url: "filter.json",
        data: {
            cmd: "getCat",
             q: $("#querybox").val()
        },
        dataType: 'json',
        success: function (data, state) {
            $("#catList").empty();
            for (var instance in data) {   
                $("#catList").append(insertCatLI(data[instance]));    
            }

        },
        error: function (data, state) {
            console.log("Qualcosa andò storto nelle categorie");
        }
    });
        $.ajax({
        url: "filter.json",
        data: {
            cmd: "getAuths",
             q: $("#querybox").val()
        },
        dataType: 'json',
        success: function (data, state) {

            $("#authList").empty();
            for (var instance in data) {
                $("#authList").append(insertAuthLI(data[instance]));
                
            }
        },
        error: function (data, state) {
            console.log("Qualcosa andò storto negli autori");
        }
    });
}
function populateNews(newsList) {
   
    for (var instance in newsList) {
        $("#content").append(putNews(newsList[instance]));
        $("#content").append("<br/>");
    }
        if(newsList.length === 0){
             $("#content").append("<h4>Non ho trovato niente qui...</h4>");
        }
         
       

}
function putNews(news) {
    

    var titolo = '<label class="post_title">' + news.post_title + '</label>';
    var author = '<label class="post_author">' + news.post_author + '</label>';
    var author_icon = '<img class="post_user_icon" src=' + news.post_user_icon + ' alt="immagine"/>';
    var pic = '<img class="news_pic" src="' + news.news_pic + '"/>';
    var content = '<label class="post_content">' + news.post_content + '</label>';
    var date = '<label class="post_category">' + news.post_date + '</label>';
    var category = '<label class="post_category">' + news.post_category + '</label>';
    var link = news.post_open;//'<label class="post_open"' + news.post_open + '></label>';
    var nLine = '<br/>';
    var innerPost = '<a href=' + link + '>';


    var oneLine = "<div class='post'>" 
            + innerPost
            + author_icon 
            + author
            + nLine 
            + pic 
            + nLine 
            + titolo
            + nLine
            + content
            + nLine 
            + category 
            + nLine 
            + date
            + nLine
            +innerPost
            + "Apri Articolo</a>";
            +"</a></div>";
    return oneLine;

}


