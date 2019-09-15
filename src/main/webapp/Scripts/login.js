var xhr = new XMLHttpRequest();
var token='';
function SignIn()
{
  var url = "http://localhost:8080/auth/signin";
  xhr.open("POST", url, true);
  xhr.setRequestHeader('Content-type','application/json');

  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var json = JSON.parse(xhr.responseText);
      token=json.token;
      window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/index.html";
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
