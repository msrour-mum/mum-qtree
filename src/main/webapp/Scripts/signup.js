var xhr = new XMLHttpRequest();
function AddUser()
{
var url = "http://localhost:8080/auth/signup";
xhr.open("POST", url, true);
xhr.setRequestHeader('Content-type','application/json');

xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        var json = JSON.parse(xhr.responseText);
      window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/login.html";
    }
    else if (xhr.readyState === 4 && (xhr.status == 403 || xhr.status == 500)){
      window.alert("Error in Signup");
      window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/signup.html";
    }
};
var data =GetUserParam();
xhr.send(data);
  event.preventDefault();
  event.stopPropagation();
}

function GetUserParam()
{
var username = document.getElementById("uname").value;
var password= document.getElementById("pwd").value;
var email=document.getElementById("email").value;
  var jsonText = {
    name: username,
    email: email,
    password: password,
    isEnabled: 1,
    roleId: 1
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
        else AddUser();
        form.classList.add('was-validated');
      }, false);
    });
  }, false);

})();
function validateRepeatPassword() {
  var password = document.getElementById("pwd").value;
  var confirmpassword = document.getElementById("pwdRepeat").value;

  if (password != confirmpassword) {
    document.getElementById("pwdRepeatValid").innerHTML='password mismatch';


    event.preventDefault();
    event.stopPropagation();
  }
  else {
    document.getElementById("pwdRepeatValid").innerHTML='';}
}

