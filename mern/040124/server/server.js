const express = require("express");
const app = express();
const cors = require("cors");
require("dotenv").config();
const port = process.env.port;



// MiddleWare
// Make sure these lines are above any app.get or app.post code blocks

app.use(express.json());
app.use(express.urlencoded({extended:true}),cors());

// grab the config
require("./config/mongoose.config");
// grab the routes
require("./routes/countries.routes")(app);


app.get("/",(req,res)=>{
    res.json({message:"hello"})
})


app.listen(port, ()=>{console.log(`server is up and running on port ${port}  🐱‍🏍🐱‍🏍 `)});