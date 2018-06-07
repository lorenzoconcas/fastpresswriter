
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

