$(function(){
    Highcharts.chart('container', {
        chart: {
            type: 'column',
            backgroundColor: '#f4f4f4'
        },
        xAxis: {
            categories: ${JSON.stringify(labels)},
            crosshair: false,
            labels: {
                style: {
                    fontSize: '15px' // измените размер текста на 16 пикселей
                }
            }
        },
        title: {
            text: ''
        },
        yAxis: {
            min: 0,
            max:1e6 / 2,
            title: {
                text: 'Amounts',
                style: {
                    fontSize: '15px' // измените размер текста на 16 пикселей
                }
            },
            labels: {
                style: {
                    fontSize: '15px' // измените размер текста на 16 пикселей
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">Amount: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'Dates',
            color: '#4CAF50',
            data: [[${values}]],
        }]
      });

});