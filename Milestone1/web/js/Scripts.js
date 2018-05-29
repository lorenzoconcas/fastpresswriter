function routineThings(){
    ColorMode();
}
function getDate(){
   return  new Date().getDay()+"/"+new Date().getMonth()+"/"+new Date().getYear();
}
function prepareThings(){
   
     $('#dateBox').value = getDate();
    
}