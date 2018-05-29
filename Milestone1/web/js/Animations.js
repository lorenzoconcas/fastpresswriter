function showSearch() {

    if ($("#querybox").css("visibility") === "visible") {
        $("#querybox").css("visibility", "hidden");
        $('#home_logo').css('left', '-=232px');
        $('.navbar_buttons').css('left', '-=232px');

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
