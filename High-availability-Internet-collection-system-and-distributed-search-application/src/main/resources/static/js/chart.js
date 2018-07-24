
//chartDiv

var defaultColor = [
  '#d70206', '#d70206', '#f4c63d', '#d17905',
  '#453d3f', '#59922b', '#0544d3', '#6b0392', '#f05b4f',
  '#dda458', '#eacf7d', '#86797d', '#b2c326', '#6188e2', '#a748ca'
];

//type:"line","bar",""
function newChart(x, y, taken, type, id) {
  var chart = document.getElementById(id);
  chart.setAttribute("class","ct-chart ct-golden-section")

  //create data
  var data = createData(x, y, taken);

  //draw chart
  if (type == "line") {
    drawLine(data, id);
  } else if (type == "bar") {
    drawBar(data, id);
  } else if (type == "bipolar") {
    drawBipolar(data, id);
  }
}
function biChart(x, y, taken, type, user, id) {
  var chart = document.getElementById(id);
  chart.setAttribute("class","ct-chart ct-golden-section")
  var data = createBiData(x, y, taken, user);
  //draw chart
  if (type == "line") {
    drawLine(data, id);
  } else if (type == "bar") {
    drawBar(data, id);
  }

}

function createData(x, y, taken) {
  var data = {
    labels: [],
    series: []
  }
  data.labels = x;

  for (var i = 0; i < y.length; i++) {
    var t = [];
    for (var n = 0; n < x.length; n++) {
      t[n] = { meta: taken[i], value: y[i][n] };
    }
    data.series[i] = t;
  };
  return data;
}
function createBiData(x, y, taken, user) {
  var data = {
    labels: [],
    series: []
  }
  data.labels = x;

  for (var i = 0; i < y.length; i++) {
    var t = [];
    for (var n = 0; n < x.length; n++) {
      if (y[i][n])
        t[n] = { meta: taken[i], value: (y[i][n] - user) };
      else {
        t[n] = { meta: taken[i], value: null }
      }
    }
    data.series[i] = t;
  };
  return data;
}

function drawLine(data, id) {
  //options
  var options = {
    plugins: [
      Chartist.plugins.tooltip({
      })
    ],
    // Don't draw the line chart points
    showPoint: true,
    fullWidth: true,
    // X-Axis specific configuration
    axisX: {
      position: 'start',
      // We can disable the grid for this axis
      showGrid: true,
      // and also don't show the label
      showLabel: true,
    },
    // Y-Axis specific configuration
    axisY: {
      position: 'end',
      onlyInteger: true,
      // Lets offset the chart a bit from the labels
      offset: 20,
      // The label interpolation function enables you to modify the values
      // used for the labels on each axis. Here we are converting the
      // values into million pound.
    },
    lineSmooth: Chartist.Interpolation.simple({
      divisor: 100
    }),
    fullWidth: true,
    chartPadding: {
      right: 20
    },
  };

  var responsiveOptions = [
    // Options override for media > 400px
    ['screen and (min-width: 400px)', {
      reverseData: true,
      horizontalBars: true,
      axisX: {
        labelInterpolationFnc: Chartist.noop
      },
      axisY: {
        offset: 20
      }
    }],
    // Options override for media > 800px
    ['screen and (min-width: 800px)', {
      stackBars: false,
      seriesBarDistance: 10
    }],
    // Options override for media > 1000px
    ['screen and (min-width: 1000px)', {
      reverseData: false,
      horizontalBars: false,
      seriesBarDistance: 20
    }]
  ];

  //draw
  var line = new Chartist.Line('#' + id, data, options, responsiveOptions);
  //add text

}
function drawBar(data, id) {
  //options
  var options = {
    plugins: [
      Chartist.plugins.tooltip({
        appendToBody: true
      })
    ],

    seriesBarDistance: 20,

    axisX: {
      position: 'start',
      // We can disable the grid for this axis
      showGrid: true,
      // and also don't show the label
      showLabel: true,
    },
    // Y-Axis specific configuration
    axisY: {
      position: 'end',
      onlyInteger: true,
      // Lets offset the chart a bit from the labels
      offset: 20,
      // The label interpolation function enables you to modify the values
      // used for the labels on each axis. Here we are converting the
      // values into million pound.
    },
    fullWidth: true,
    chartPadding: {
      right: 20
    },
  };

  var responsiveOptions = [
    // Options override for media > 400px
    ['screen and (min-width: 400px)', {
      reverseData: true,
      horizontalBars: true,
      axisY: {
        offset: 20
      }
    }],
    // Options override for media > 800px
    ['screen and (min-width: 800px)', {
      stackBars: false,
      seriesBarDistance: 20
    }],
    // Options override for media > 1000px
    ['screen and (min-width: 1000px)', {
      reverseData: false,
      horizontalBars: false,
      seriesBarDistance: 20
    }]
  ];

  //draw
  var bar = new Chartist.Bar("#" + id, data, options, responsiveOptions);
  //add text
}


