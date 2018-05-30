
function routineThings() {
    ColorMode();
    putHideButtons();
  
   
}
function getDate() {
    return  new Date().getDay() + "/" + new Date().getMonth() + "/" + new Date().getYear();
}
function putHideButtons(){
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
        
        if ($('body').width() <= 1024){
             $('#aside_right').css("top", "128px");
        }
        
        if ($('body').width() <= 480) {
            $('#aside_right').css("top", "90px");
            //se la dimensione della finestra è <= 480 allora controllo se spostare anche il contenuto
            if ($('#authList').css("font-size") === "0px") {
               $('#content').css("top", "96px");
               $('#aside_right').css("top", "72px");
            }
            else{
                 $('#content').css("top", "96px");
            }
            
        }  

    } else if (document.getElementById("hideCat").value === "v") {
        $('#hideCat').text("^");
        document.getElementById("hideCat").value = "^";
        $('#catList').css("font-size", "16px");
        if ($('body').width() <= 480) {
            $('#aside_right').css("top", "+=10px");
        }
    }


}