// hightCharts圆环图形显示小插件
// 在使用之前必须顺序引入jquery和hightCharts的js框架

function showCircleChars(chartsId){
	// 设置改圆环的挂载div的id
    var chartsView = "charts";
	// 圆环显示的数据比例值
    var successRate = 20

    // 设置圆环属性出现位置的属性
    $("#"+chartsView).css("height","140px").css("width","130px").css("position","relative").css("top","0px");

    successRate = parseInt(successRate);
    var categories = ['成功率', '未成功率'];
    data = [{drilldown: {
        name: '',
        categories: categories,
        data: [successRate, (100 - successRate)],
    }
    }];
    // 创建数组
    var fuhuiData = [];
    var percentData = [];
    for (var i = 0; i < data.length; i++) {
        // 添加名称
        fuhuiData.push({
            name: categories[i],
            y: data[i].y,
        });
        // 添加百分比
        for (var j = 0; j < data[i].drilldown.data.length; j++) {
            var brightness = 0.2 - (j / data[i].drilldown.data.length) / 5 ;
            percentData.push({
                name: data[i].drilldown.categories[j],
                y: data[i].drilldown.data[j],
            });
        }
    }
    // 创建图表
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: chartsView,
            type: 'pie'   //图表的类型
        },
        title: {  //设置标题并将标题置于环形图表中间
            text: '<span style="font-size:20px;font-family:Arial;color:#606060;" ></span>',
            verticalAlign: 'middle',
            x:-50,
            y:-60
        },
        yAxis: {title: {text: ''}},
        xAxis: {enabled: false},
        plotOptions: {
            pie: {
                size: '50%',
                innerSize: '70%',   //配置环形大小
                shadow: false,
                center: ['40%', '25%'],  //水平和垂直方向居中
                dataLabels: {enabled: false},
                showInLegend: false
            }
        },
        tooltip: {enabled:true},
        series: [{
            name: '%',  //数据列名
            data: percentData,
            dataLabels: {
                formatter: function() {
                    return this.y > 1 ? ''+ this.point.name +': '+ this.y +'%'  : null;
                }
            }
        }],
        colors: [  '#1fca9c', '#38b1eb'],
        credits: {enabled:false,}
    });
}