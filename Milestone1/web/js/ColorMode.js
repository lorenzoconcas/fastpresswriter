function ColorMode() {
    //imposto il tema che verrà attivato se necessario
    change();
    //se si sta avvicinando l'ora di cambiarlo farò in modo che succeda in automatico
    var test;
    if(new Date().getHours() === 17 && new Date().getMinutes() > 54){
        test = window.setInterval(change, 1000);
    }
     if(new Date().getHours() > 17 && new Date().getHours() > 6){
        clearInterval(test);
    }
    
}
function change(){
    if (isNight()) {
        tintItBlack();
    }
   
}
function isNight() {
    
   var time = new Date().getHours();
   if(time === 17 && new Date().getMinutes() > 54){
        document.title="Il sito entrerà in modalità notturna fra : "+ (60 - new Date().getMinutes())+" minuto/i";
    }
    return  (time < 7 || time > 17);
}
function tintItBlack() {
    $('#metaelement').attr('theme-color', '#333333');
    $('body').css("background", "#333333");
    $('#background').css("background", "black");
    $('#header').css("background", "rgba(0,0, 0, 0.6)");
    $('#home_logo').css("color", "white");
    $('#search_image').css("filter", "invert(100%)");
    $('.navbar_buttons').css("color", "white");

    $('#aside_left').css("color", "white");
    $('#aside_left').css("background", "linear-gradient(#040404,#101010)");
    $('#aside_left').css("border-color", "#202020");
    // $('#aside_left').css(" border-color", "#101010");
    $('#aside_right').css("color", "white");
    $('#aside_right').css("background", "linear-gradient(#040404,#101010)");
    $('#aside_right').css("border-color", "#202020");

    $('.post').css("background", '#101010');
    $('.post').css("color", 'white');
    $('.post_title').css("color", 'white');
    $('.post_content').css("color", 'white');
    $('.post_open').css("color", 'white');
    $('.post_category').css("color", 'white');
    $('.post').css("border-color", '#101010');

    $('.post_author').css("color", 'white');
    $('#footer').css("color", 'white');
    $('#footer').css("background", 'rgba(0,0,0, 0.6)');


    $('#content').css("color", 'white');
    $('a').css("color", 'white');
    $('#loginButton').css("border-style", 'none');
    
    $('#invalid').css("color", 'red');

    $('#personal_articles_table').css("background", 'black');
    $('#personal_articles_table').css("border-color", '#202020');
    $('#new_article_button').css("border-color", '#202020');
    $('#new_article_button').css("background", 'black');
    $('#new_article_button').css("color", 'white');

    $('#new_article_section').css("background", 'black');
    $('#new_article_section').css("border-color", '#202020');
    
    $('#new_article_text').css("border-color", '#202020');
    $('#new_article_text').css("background", '#333333');    
    $('#new_article_text').css("color", 'white');
    
    $('.new_article_generic_input').css("border-color", '#202020');
    $('.new_article_generic_input').css("background", '#333333');    
    $('.new_article_generic_input').css("color", 'white');
    
    $('#new_article_upload_button').css("border-color", '#202020');
    $('#new_article_upload_button').css("background", '#333333');    
    $('#new_article_upload_button').css("color", 'white');
    
    $('#profile_section').css("background", 'black')    ;
    $('#profile_section').css("border-color", '#202020');
    $('.generic_input').css("border-color", '#202020');
    $('.generic_input').css("background", 'black');
    $('.generic_input').css("color", 'white');
   
    $('#comment_section').css("background", 'black');
    $('#comment_section').css("border-color", '#202020');
    $('#comment_section').css("color", 'white');
    
    
    
    $('#personal_comment_textarea').css("background", 'black');
    $('#personal_comment_textarea').css("border-color", '#202020');
    $('#personal_comment_textarea').css("color", 'white');
    $('#pers_comment_title').css("color", 'white');
    
    $('#personal_post_comment').css("background", 'black');
    $('#personal_post_comment').css("border-color", '#202020');
    $('#personal_post_comment').css("color", 'white');
    
    $('#resultBox').css("background", 'rgba(0, 0, 0, 0.8)');    
    $('#resultBox').css("color", 'white');
     $('.searchLink').css("text-color", 'white');
    
    
    $('#personal_comment').css("color", 'black');
    
    $('#personal_post_comment').css("background", 'rgba(0, 0, 0, 0.8)');
      
   
   if(document.getElementById("edit_button") !== null){
        if(document.getElementById("edit_button").value === "Salva"){
             $('#edit_button').css("background", '#333333');
            $('#edit_button').css("color", 'white');
       }
   }
    if(document.getElementById("delete_button").value === "Elimina Profilo"){
      $('#delete_button').css("background", 'red');
      $('#delete_button').css("color", 'white');
   }
   
   
   
}

