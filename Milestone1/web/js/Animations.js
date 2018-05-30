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
function goToUrl(url) {
    window.location = url;
}
function runScript(e) {
    //See notes about 'which' and 'key'
    if (e.keyCode === 13) {
        goToUrl("cerca.html?query=" + document.getElementById('querybox').value);
    }
}
