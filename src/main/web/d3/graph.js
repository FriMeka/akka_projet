var prices=[{"name":"price","date":"1999-11-01","price":93.25,"x":0},
    {"name":"price","date":"1999-11-02","price":92.75,"x":1},
    {"name":"price","date":"1999-11-03","price":92.94,"x":2},
    {"name":"price","date":"1999-11-04","price":92.31,"x":3},
    {"name":"price","date":"1999-11-05","price":91.81,"x":4},
    {"name":"price","date":"1999-11-08","price":84.81,"x":7},
    {"name":"price","date":"1999-11-09","price":89.75,"x":8},
    {"name":"price","date":"1999-11-10","price":88.12,"x":9},
    {"name":"price","date":"1999-11-11","price":88.25,"x":10},
    {"name":"price","date":"1999-11-12","price":89.75,"x":11}];

var mean=[{"name":"mean","date":"1999-11-01","price":93.25,"x":0},
    {"name":"mean","date":"1999-11-02","price":93.0,"x":1},
    {"name":"mean","date":"1999-11-03","price":92.845,"x":2},
    {"name":"mean","date":"1999-11-04","price":92.625,"x":3},
    {"name":"mean","date":"1999-11-05","price":92.06,"x":4},
    {"name":"mean","date":"1999-11-08","price":88.31,"x":7},
    {"name":"mean","date":"1999-11-09","price":87.28,"x":8},
    {"name":"mean","date":"1999-11-10","price":88.935,"x":9},
    {"name":"mean","date":"1999-11-11","price":88.185,"x":10},
    {"name":"mean","date":"1999-11-12","price":89.0,"x":11}];

var data=prices.concat(mean)

// set the dimensions and margins of the graph
var margin = {top: 10, right: 30, bottom: 30, left: 60},
    width = 460 - margin.left - margin.right,
    height = 400 - margin.top - margin.bottom;

// append the svg object to the body of the page
var svg = d3.select("#my_dataviz")
    .data(data)
    .append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform",
        "translate(" + margin.left + "," + margin.top + ")");

//Read the data

    // group the data: I want to draw one line per group
    var sumstat = d3.nest() // nest function allows to group the calculation per level of a factor
        .key(function(d) { return d.name;})
        .entries(data);
    console.log(sumstat);
    // Add X axis --> it is a date format
    var x = d3.scaleLinear()
        .domain(d3.extent(data, function(d) {
            return d.x; }))
        .range([ 0, width ]);
    svg.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x).ticks(5));

    // Add Y axis
    var y = d3.scaleLinear()
        .domain([d3.min(data, function(d) { return +d.price; }), d3.max(data, function(d) { return +d.price; })])
        .range([ height, 0 ]);
    svg.append("g")
        .call(d3.axisLeft(y));

    // color palette
    var res = sumstat.map(function(d){ return d.key }) // list of group names
    var color = d3.scaleOrdinal()
        .domain(res)
        .range(['#e41a1c','#377eb8','#4daf4a','#984ea3','#ff7f00','#ffff33','#a65628','#f781bf','#999999'])

    // Draw the line
    svg.selectAll(".line")
        .data(sumstat.slice(0,2))
        .enter()
        .append("path")
        .attr("fill", "none")
        .attr("stroke", function(d){ return color(d.key) })
        .attr("stroke-width", 1.5)
        .attr("d", function(d){
            return d3.line()
                .x(function(d) { return x(d.x); })
                .y(function(d) { return y(+d.price); })
                (d.values)
        })

    //handmade legend
    svg.append("circle").attr("cx",width-60).attr("cy",10).attr("r", 6).style("fill", "#e41a1c")
    svg.append("circle").attr("cx",width-60).attr("cy",40).attr("r", 6).style("fill", "#377eb8")
    svg.append("text").attr("x", width-40).attr("y", 10).text("Stock price").style("font-size", "15px").attr("alignment-baseline","middle")
    svg.append("text").attr("x", width-40).attr("y", 40).text("Mean").style("font-size", "15px").attr("alignment-baseline","middle")
