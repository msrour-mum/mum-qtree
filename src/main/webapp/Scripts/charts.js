var xhr = new XMLHttpRequest();
function ViewChart( charType)
{
    var url = "http://localhost:8080/Statistics/ChartUserQuestion";
    var chartTitle ="Users Questions"
    if(charType=="a") {
        url = "http://localhost:8080/Statistics/ChartUserAnswer";
        chartTitle ="Users Answers"
    }
    xhr.open("GET", url, true);

    xhr.setRequestHeader('Content-type','application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);

            document.getElementById("demo").innerHTML = xhr.responseText;

            var obj = JSON.parse(xhr.responseText);
            //window.alert(obj.length);



            // Load the Visualization API and the corechart package.
            google.charts.load('current', {'packages':['corechart']});

            // Set a callback to run when the Google Visualization API is loaded.
            google.charts.setOnLoadCallback(drawChart);

            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {

                // Create the data table.
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Topping');
                data.addColumn('number', 'Slices');

                for (var i =0 ; i<obj.length;i++)
                {
                    data.addRows([
                        [obj[i].name, obj[i].itemNumber]
                    ]);
                }


                // Set chart options
                var options = {'title':chartTitle,
                    'width':800,
                    'height':600};

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(document.getElementById('chart_divQuestions'));
                chart.draw(data, options);


            }






            //return xhr.responseText;
        }else if (xhr.readyState === 4 && xhr.status == 403) {
            window.alert("Wrong user name or password");
            window.location.href = "http://localhost:63342/qtree/src/main/webapp/views/login.html";
        }
    };
    xhr.send();
}