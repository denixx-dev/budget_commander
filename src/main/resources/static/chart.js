google.charts.load("current", {packages:["corechart"]});
google.charts.setOnLoadCallback(drawChart);
function drawChart(data) {
    var chartData = [['Date', 'Amount']];

      // Преобразуйте данные транзакций в формат, ожидаемый Google Charts
      transactions.forEach(function(transaction) {
        chartData.push([transaction.transactionDate, transaction.amount]);
      });

      var data = google.visualization.arrayToDataTable(chartData);

      var options = {
        title: 'Transaction Amounts Over Time',
        legend: { position: 'none' },
        colors: ['#4CAF50'],
        backgroundColor: '#f4f4f4',
      };

      var chart = new google.visualization.Histogram(document.getElementById('chart_div'));
      chart.draw(data, options);
}