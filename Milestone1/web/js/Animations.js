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
