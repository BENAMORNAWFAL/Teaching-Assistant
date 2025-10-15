const express=require("express")
const cors=require('cors')
const app=express()
require("dotenv").config()
const port=process.env.port

// ******************* MIDDLEWHERE *****************
app.use(express.json(), express.urlencoded({extended:true}),cors())

// grab the config
require("./config/mogoose.config")
// grab the routes
require("./routes/country.route")(app);


app.listen(port,()=>{console.log("Listennig to port "+ port)})
