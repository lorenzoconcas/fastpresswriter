function routineThings() {
    populateCategories();
    populateAuthors();
    putHideButtons();
    ColorMode();
}
function getDate() {
    return  new Date().getDay() + "/" + new Date().getMonth() + "/" + new Date().getYear();
}
function putHideButtons() {
    var hideButton = document.createElement("button");
    hideButton.id = "hideCat";
    hideButton.value = "^";
    hideButton.onclick = "expandCats()";
    hideButton.class = "hideButton";
    document.getElementById("aside_left").appendChild(hideButton);
    $('#hideCat').css("position", "absolute");
    $('#hideCat').css("float", "left");
    $('#hideCat').css("left", "13px");
    $('#hideCat').css("top", "4px");
    $('#hideCat').text("^");
    $('#hideCat').on("click", expandCats);

    var hideButton2 = document.createElement("button");
    hideButton2.id = "hideAuth";
    hideButton2.value = "^";
    hideButton2.onclick = "expandAuth()";
    hideButton2.class = "hideButton";
    document.getElementById("aside_right").appendChild(hideButton2);
    $('#hideAuth').css("position", "absolute");
    $('#hideAuth').css("float", "left");
    $('#hideAuth').css("left", "13px");
    $('#hideAuth').css("top", "6px");
    $('#hideAuth').text("^");
    $('#hideAuth').on("click", expandAuth);
}


function populateCategories() {
    $.ajax({
        url: "filter.json",
        data: {
            cmd: "getCat"
            
        },
        dataType: 'json',
        success: function (data, state) {
            $("#catList").empty();
            for (var instance in data) {   
                $("#catList").append(insertCatLI(data[instance]));    
            }

        },
        error: function (data, state) {
            console.log("Qualcosa andò storto");
        }
    });



}

function populateAuthors() {
    $.ajax({
        url: "filter.json",
        data: {
            cmd: "getAuths"
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
function insertAuthLI(item) {
   
    var auths = $("<label onClick='loadNewsByAuth(" + item.authID + ", \"" + (item.authName + " " + item.authSurname) + "\")'>").html(item.authName + " " + item.authSurname);

    return $("<li>").append(auths);
}

function insertCatLI(item) {
   
    var cat = $("<label onClick='loadNewsByCat(\"" + item.catName + "\")'>").html(item.catName);

    return $("<li>").append(cat);

}


function loadNewsByAuth(filter, authName) {
    $("#content").empty();

    $("#content").append("<h1>Articoli scritti da " + authName + "</h1>");

    $.ajax({
        url: "notizie.html",
        data: {
            author: filter
        },
        dataType: 'json',
        success: function (data, state) {

            populateNews(data, authName);
        },
        error: function (data, state) {
            console.log("Qualcosa andò storto nelle notizie");
        }
    });

}

function loadNewsByCat(filter) {
    $("#content").empty();
    if(filter !== "Tutte")
     $("#content").append("<h1>Articoli nella categoria " + filter + "</h1>");

    $.ajax({
        url: "notizie.html",
        data: {
            category: filter
        },
        dataType: 'json',
        success: function (data, state) {
           
            populateNews(data);
        },
        error: function (data, state) {
            console.log("Qualcosa andò storto nelle notizie");
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


