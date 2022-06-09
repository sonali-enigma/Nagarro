const express = require ('express');
const bodyparser =require('body-parser');
const cors=require('cors');



const app=express()
const port=4300

app.use(bodyparser.json());
app.use(cors());

//database connection


//listen on port 4300
app.listen(port,()=>console.log(`Listening on port ${port}`))


//Routes
const routeRouter= require('./routes/route')


app.use('/',routeRouter)