var dom = document.getElementById('chart-container');
var myChart = echarts.init(dom, null, {
    renderer: 'svg',
    useDirtyRect: false,
    disableTouchZoom: true,
});
var app = {};

var option;

let data = [];

const symbolSize = 10;

let uptoN;

let selectedPoints = [];
window.onload = function() {
    updatePosition();
}

function useJavaArray(javaArray, n){
    const arr = JSON.parse(javaArray);
    uptoN = JSON.parse(n) + 10;

    for (let i = 0; i < arr.length; i++) {
        let element = arr[i];
        data.push([i + 1, element]);
    }


    myChart.setOption({
        series: [{
            data: data,
        }],
        xAxis: {
            max : uptoN
        }
    })
}

function getMyData(){
    return data;
}
let convergence;
function getConvergence(converge){
     convergence = JSON.parse(converge);

    //后选择的year
    let pop1 = selectedPoints.pop();
    //先选择的year
    let pop2 = selectedPoints.pop();



    let yearStart = pop2;
    let yearEnd = pop1;

    let startValue;
    let startValueArr = data[pop1];
    startValue = startValueArr[1];

    let difference = Math.abs((startValue - convergence))/ (yearEnd - yearStart);

    let tempArr = data[pop2];
    let cnt = tempArr[1];

    for (let i = 1; i <= (pop1 - pop2); i++) {
        cnt -= difference;
        data[pop2+i] = [pop2+i+1, cnt];
    }

    myChart.setOption({
        series: [{
            data: data,
            itemStyle: {
                color: "#0077be"
            }
        }]
    })

    updatePosition();

    return difference;
}



option = {
    title: {
        text: 'Chart',
        left: 'center'
    },
    tooltip: {
        triggerOn: 'none',
        formatter: function (params) {
            return (
                'Year: ' +
                params.data[0] +
                '<br>Rate: ' +
                params.data[1].toFixed(2)
            );
        }
    },
    grid: {
        top: '10%',
        bottom: '12%'
    },
    xAxis: {
        min: 1,
        max: 15,
        type: 'value',
        axisLine: { onZero: false }
    },
    yAxis: {
        min: -100,
        max: 100,
        type: 'value',
        axisLine: { onZero: false }
    },
    dataZoom: [
        {
            type: 'slider',
            xAxisIndex: 0,
            filterMode: 'none'
        },
        {
            type: 'slider',
            yAxisIndex: 0,
            filterMode: 'none'
        },
        {
            type: 'inside',
            xAxisIndex: 0,
            filterMode: 'none'
        },
        {
            type: 'inside',
            yAxisIndex: 0,
            filterMode: 'none'
        }
    ],
    series: [
        {
            id: 'a',
            type: 'line',
            smooth: true,
            symbolSize: symbolSize,
            data: data
        }
    ]
};
setTimeout(function () {
    // Add shadow circles (which is not visible) to enable drag.
    myChart.setOption({
        graphic: data.map(function (item, dataIndex) {
            return {
                type: 'circle',
                position: myChart.convertToPixel('grid', item),
                shape: {
                    cx: 0,
                    cy: 0,
                    r: symbolSize / 2
                },
                invisible: true,
                draggable: true,
                ondrag: function (dx, dy) {
                    onPointDragging(dataIndex, [this.x, this.y]);
                    event.preventDefault();
                },
                onclick:function(){
                    onSelectedPoint(dataIndex);
                },
                onmousemove: function () {
                    showTooltip(dataIndex);
                },
                onmouseout: function () {
                    hideTooltip(dataIndex);
                },
                z: 100
            };
        })
    });
}, 0);

window.addEventListener('resize', updatePosition);
myChart.on('dataZoom', updatePosition);
function updatePosition() {
    myChart.setOption({
        graphic: data.map(function (item, dataIndex) {
            return {
                position: myChart.convertToPixel('grid', item)
            };
        })
    });
}
function showTooltip(dataIndex) {
    myChart.dispatchAction({
        type: 'showTip',
        seriesIndex: 0,
        dataIndex: dataIndex
    });
}

function hideTooltip(dataIndex) {
    myChart.dispatchAction({
        type: 'hideTip'
    });
}

function onPointDragging(dataIndex, pos) {
    data[dataIndex][1] = myChart.convertFromPixel('grid', pos)[1];
    // Update data
    myChart.setOption({
        series: [
            {
                id: 'a',
                data: data
            }
        ]
    });
}

function setDataZoomRange(chart, xAxisStart, xAxisEnd, yAxisStart, yAxisEnd) {
    chart.setOption({
        dataZoom: [
            {
                type: 'slider',
                xAxisIndex: 0,
                filterMode: 'none',
                start: xAxisStart,
                end: xAxisEnd
            },
            {
                type: 'slider',
                yAxisIndex: 0,
                filterMode: 'none',
                start: yAxisStart,
                end: yAxisEnd
            }
        ]
    });
}

function onSelectedPoint(dataIndex) {
    if (selectedPoints.length < 2) {
        selectedPoints.push(dataIndex);
        myChart.setOption({
            series: [
                {
                    itemStyle: {
                        color: function (params) {
                            if (selectedPoints.includes(params.dataIndex)) {
                                return "#FF8C00";
                            } else if (params.dataIndex === dataIndex) {
                                return "#FF8C00";
                            } else {
                                return "#0077be";
                            }
                        }
                    }
                }
            ]
        });
    } else {
        return "#0077be";
    }
}


if (option && typeof option === 'object') {
    myChart.setOption(option);
}

window.addEventListener('resize', myChart.resize);

