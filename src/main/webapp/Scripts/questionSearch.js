var xhr = new XMLHttpRequest();
function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
function SearchQuestions()
{
  var url = "http://localhost:8080/Question/Info";
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
  var data =GetSearchParam();
  xhr.send(data);
  event.preventDefault();
  event.stopPropagation();
}
function GetSearchParam()
{
  var jsonText = {
    Authorization: getCookie('qtree_access_token')
  };
  return JSON.stringify(jsonText);
}

