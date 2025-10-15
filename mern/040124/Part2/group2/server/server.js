const express=require("express")
const cors=require('cors')
require("dotenv").config()
const app=express()
const port=process.env.port

// ********************* MIDDLEWHERE *****************
app.use(express.json(), express.urlencoded({extended:true}),cors())

// grap the config
require("./config/mongoose.config")
// grap the routes
require("./routes/country.routes")(app)

app.listen(port,()=>{console.log("Listenning to port "+ port)})
