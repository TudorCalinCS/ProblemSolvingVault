require('dotenv').config()
require('body-parser')
require('mongoose ')

const bodyParser = require('body-parser');
let express = require('express');
let app = express();

app.get("/", function (req, res) {
    //res.send("Hello Express")
    absolutePath = __dirname + '/views/index.html';
    res.sendFile(absolutePath);
});


app.use("/public", express.static(__dirname + "/public"));

app.get("/json", function (req, res) {
    var response = "Hello json";
    if (process.env.MESSAGE_STYLE === "uppercase")
        response = "Hello json".toUpperCase();
    res.json({ "message": response });
})

/*
app.use(function middleware(req,res,next){
    //console.log(req.method+" "+req.path+" - "+req.ip);
    console.log(`${req.method} ${req.path} - ${req.ip}`);
    next();
})
    */
app.get("/now",
    function (req, res, next) {
        req.time = new Date().toString();
        next();
    },
    function (req, res) {
        res.send({ time: req.time });
    });

app.get(`/:word/echo`, function (req, res) {
    var word = req.params.word;
    res.send({ echo: word });
});

app.get("/name", function (req, res) {
    var first = req.query.first;
    var last = req.query.last;
    res.send({ name: `${first} ${last}` });
});

app.use(bodyParser.urlencoded({ extended: false }));

app.post("/name", function (req, res) {
    //console.log(req.body);
    var first = req.body.first;
    var last = req.body.last;
    res.send({ name: `${first} ${last}` });
});



module.exports = app;
