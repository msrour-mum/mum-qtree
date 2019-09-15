var xhr = new XMLHttpRequest();
var token='';
function SearchQuestions()
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
function GetSearchParam()
{
  var username = document.getElementById("uname").value;
  var password= document.getElementById("pwd").value;
  var jsonText = {
    username: username,
    password: password
  };

  return JSON.stringify(jsonText);
}

