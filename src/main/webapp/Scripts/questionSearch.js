var xhr = new XMLHttpRequest();

function SearchQuestions()
{
  var url = "http://localhost:8080/Question/search/"+GetSearchParamter();
  xhr.open("GET", url, true);
  xhr.setRequestHeader('Content-type','application/json');
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      var json = JSON.parse(xhr.responseText);
      //window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/index.html";
      CreateDynamicQuestions(json);
    }else if (xhr.readyState === 4 && xhr.status == 403) {
      window.alert("Wrong user name or password");
      //window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/login.html";
    }
  };
  xhr.send();
  event.preventDefault();
  event.stopPropagation();
}
function CreateDynamicQuestions(data)
{
      for (x in data) {
        var textInputId= 'searchBtn'+x;
        var onclickFuntion="AddAnswer("+data[x].id+",'"+textInputId+"',1);";
        document.getElementById("questionContainer").innerHTML+=
            '<button class="accordion">'+data[x].text+'</button>'+
            '<div class="panel" >'+
            '<p> Created By: ' + data[x].userName+ '</p>'+
            '<label for="comment">Answer:</label>'+
            '<textarea class="form-control" rows="5" name="answer" id = '+textInputId+'> </textarea>' +
            '<p>&nbsp;</p>'+
            '<button type="submit" class="btn btn-primary" onclick="'+onclickFuntion+'">'+
            'Add Answer</button>'+'</div>'+
            '<p>&nbsp;</p>';
      }
  AdjustAccordion();
}
function GetSearchParamter()
{
  return document.getElementById("searchBtn").value;
}
function AdjustAccordion()
{
  var acc = document.getElementsByClassName("accordion");
  var i;

  for (i = 0; i < acc.length; i++) {
    acc[i].addEventListener("click", function() {
      this.classList.toggle("active");
      var panel = this.nextElementSibling;
      if (panel.style.maxHeight){
        panel.style.maxHeight = null;
      } else {
        panel.style.maxHeight = panel.scrollHeight + "px";
      }
    });
  }
}
function AddAnswer(qID,answerText,userId)
{
  var answer=document.getElementById(answerText).value;
  var xhrAnswer = new XMLHttpRequest();
  var addAnswerURL = "http://localhost:8080/Question/Add";
  xhrAnswer.open("POST", addAnswerURL, true);
  xhrAnswer.setRequestHeader('Content-type','application/json');
  xhrAnswer.onreadystatechange = function () {
    if (xhrAnswer.readyState === 4 && xhr.status === 200) {
      var json = JSON.parse(xhr.responseText);
      window.alert("Answer added successfully");
    }else if (xhr.readyState === 4 && xhr.status == 403) {
      window.alert("Error in adding the answer");
    }
  };
  var data =GetAnswerParam(qID,answer,userId);
  xhrAnswer.send(data);
}
function GetAnswerParam(qID,answerText,userId)
{
  var jsonText = {
    text: answerText,
    parentId: qID,
    userId: userId
  };

  return JSON.stringify(jsonText);
}