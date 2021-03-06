/*
 * HTTP request for send challenge file
 */
function send_challenge(theUrl, data)
{
    var formData = new FormData();
    formData.append("challenge", data);
    formData.append("user-id", "111111");
    formData.append("jwt","eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImlicDA5ZyJ9.eyJpc3MiOiJodHRwczovL2Nsb3VkLmdvb2dsZS5jb20vaWFwIiwic3ViIjoiYWNjb3VudHMuZ29vZ2xlLmNvbToxMTE0MTE2ODA0NjI2NTY1NjU2NjAiLCJlbWFpbCI6ImNhbmRpY2VmZW5nQGdtYWlsLmNvbSIsImF");
    console.log(formData);
    var oReq = new XMLHttpRequest();

    oReq.open("POST", theUrl, true);
    oReq.setRequestHeader("Content-Type","multipart/form-data");
    oReq.responseType = "arraybuffer";
    oReq.onreadystatechange = function() {
    if (this.readyState == 4 ) {
      console.log(this.response);
      //parse UnlockToken
      let unlockToken = this.response;
      //sendToken to device
      sendToken2Device(unlockToken);
    }
  }
    oReq.send(formData);
}

/*
 * Call WebUSB API to send response.bin to device
 */
function sendToken2Device (unlockToken) {

}

/*
 * Unlock button action
 */
function do_unlock () {
  //get challenge file
  var challenge_file = getChallenge();
  send_challenge("/send_challenge", challenge_file);
}

/*
 * Call WebUSB API to get challenge.bin from device
 */
function getChallenge () {

  //Fake data
  var randomData = [];


    var bytes = new Uint8Array(4);
    for (var i=4; i--; ) {
      let longRandomNumber = Math.floor(Math.random() * 1000000000);
        bytes[i] = longRandomNumber & (255);
        longRandomNumber = longRandomNumber >> 8
    }
    randomData.push(bytes);
  console.log(randomData);
  var blob = new Blob(randomData);
  blob["lastModifiedDate"] = "";
  blob["name"] = "challenge.bin";
  var fakeF = blob;
  console.log(fakeF);
  return fakeF;
}

