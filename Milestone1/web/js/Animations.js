function showSearch() {

    if ($("#querybox").css("visibility") === "visible") {
        
        $('#home_logo').css('left', '-=232px');
        $('.navbar_buttons').css('left', '-=232px');
        $("#querybox").css("visibility", "hidden");

    } else {
        $('#home_logo').css('left', '+=232px');
        $('.navbar_buttons').css('left', '+=232px');
        $("#querybox").css("visibility", "visible");
        
    }
    
}

function expandAuth() {
    //se gli autori sono espansi
    if (document.getElementById("hideAuth").value === "^") {
        document.getElementById("hideAuth").value = "v";
        $('#hideAuth').text("v");
        $('#authList').css("font-size", "0px");
        $('#hideAuth').css("top", "2px");

        if ($('body').width() <= 480) {
            $('#content').css("top", "120px");
        }
    }
    //se gli autori sono ridotti
    else if (document.getElementById("hideAuth").value === "v") {
        $('#hideAuth').css("top", "6px");
        $('#hideAuth').text("^");
        document.getElementById("hideAuth").value = "^";
        $('#authList').css("font-size", "16px");
        //se la finestra è di 480 o inferiore
        if ($('body').width() <= 480) {
            //se catList è ridotto           
            $('#content').css("top", "100px");
        }
    }
}

function expandCats() {
    //se devo ridurre
    if (document.getElementById("hideCat").value === "^") {
        document.getElementById("hideCat").value = "v";
        $('#hideCat').text("v");
        $('#catList').css("font-size", "0px");
        $('#hideCat').css("top", "2px");

        if ($('body').width() <= 1024) {
            $('#aside_right').css("top", "128px");
        }

        if ($('body').width() <= 480) {
            $('#aside_right').css("top", "90px");
            //se la dimensione della finestra è <= 480 allora controllo se spostare anche il contenuto
            if ($('#authList').css("font-size") === "0px") {
                $('#content').css("top", "96px");
                $('#aside_right').css("top", "72px");
            } else {
                $('#content').css("top", "96px");
            }

        }

    } else if (document.getElementById("hideCat").value === "v") {
        $('#hideCat').text("^");
        document.getElementById("hideCat").value = "^";
        $('#catList').css("font-size", "16px");
         if ($('body').width() <= 1024) {
            $('#aside_right').css("top", "300px");
        }
        
        
        if ($('body').width() <= 480) {
            $('#aside_right').css("top", "+=10px");
        }
    }


}

