var xhr = new XMLHttpRequest();
function setCookie(cname, cvalue, exdays) {
  var d = new Date();
  d.setTime(d.getTime() + (exdays*24*60*60*1000));
  var expires = "expires="+ d.toUTCString();
  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}
function SignIn()
{
  var url = "http://localhost:8080/auth/signin";
  xhr.open("POST", url, true);
  xhr.setRequestHeader('Content-type','application/json');

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var json = JSON.parse(xhr.responseText);
      setCookie('qtree_access_token',json.token,10);
      window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/searcQ.html";
    }else if (xhr.readyState === 4 && xhr.status == 403) {
      window.alert("Wrong user name or password");
      window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/login.html";
    }
  };
  var data =GetSignInParam();
  xhr.send(data);
  event.preventDefault();
  event.stopPropagation();
}
function GetSignInParam()
{
  var username = document.getElementById("uname").value;
  var password= document.getElementById("pwd").value;
  var jsonText = {
    username: username,
    password: password
  };

  return JSON.stringify(jsonText);
}
// Disable form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Get the forms we want to add validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        else SignIn();
        form.classList.add('was-validated');
      }, false);
    });
  }, false);

})();
