function httpGet(theUrl)
{
    var oReq = new XMLHttpRequest();
    oReq.open("GET", theUrl);
    //oReq.setRequestHeader(header, value);
    oReq.send();
    
}

window.document.onload = function(e){
    console.log("document.onload", e, Date.now());
    setTimeout(function(){ alert("start challenge"); httpGet("/send_challenge")}, 1000);

}

window.onload = function(e){
    console.log("window.onload", e, Date.now());
    setTimeout(function(){ alert("start challenge"); httpGet("/send_challenge")}, 1000);
}

window.onafterprint = function(e){
  console.log("window.onafterprint", e, Date.now());
}

window.onmessage = function(e) {
  console.log("window.onmessage", e, Date.now());
}

window.onpageshow = function(e) {
  console.log("window.onpageshow", e, Date.now());
}
