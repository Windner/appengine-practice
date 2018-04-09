function send_challenge(theUrl, data)
{
    var formData = new FormData();
    formData.append("challenge", data);
    console.log(formData);
    var oReq = new XMLHttpRequest();
    oReq.open("POST", theUrl, true);
    oReq.setRequestHeader("Content-Type","multipart/form-data");


    oReq.send(formData);
}

function do_unlock () {
  //get challenge file
  var challenge_file = getChallenge();
  send_challenge("/send_challenge", challenge_file);
}

function getChallenge () {
  var randomData = [];
// while randomData.length < 308

    var bytes = new Uint8Array(4);
    for (var i=4; i--; ) {
      let longRandomNumber = Math.floor(Math.random() * 1000000000);
        bytes[i] = longRandomNumber & (255);
        longRandomNumber = longRandomNumber >> 8
    }
    randomData.push(bytes);

  var blob = new Blob(randomData);
  blob["lastModifiedDate"] = "";
  blob["name"] = "challenge.bin";
  var fakeF = blob;
  console.log(fakeF);
  return fakeF;
}

