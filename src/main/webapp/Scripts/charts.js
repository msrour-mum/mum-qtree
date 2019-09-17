var xhr = new XMLHttpRequest();
function ViewChart()
{
    var url = "http://localhost:8080/Question";
    xhr.open("GET", url, true);
    xhr.setRequestHeader('Content-type','application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
           window.alert(xhr.responseText);
        }else if (xhr.readyState === 4 && xhr.status == 403) {
            window.alert("Wrong user name or password");
            window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/login.html";
        }
    };
    xhr.send();
}