const express = require("express");
//express app
const app = express();

const port = 5000;

app.use(express.static('public'))
app.use(express.urlencoded({extended:false}));
app.use('/css',express.static(__dirname + 'public/css'))

//Templating Engine
app.set('views','./src/views')
app.set('view engine','ejs')

//Routes
const routeRouter= require('./src/routes/route')


app.use('/',routeRouter)



//listen on port 5000
app.listen(port, () =>console.log(`Listening on port ${port}`))

