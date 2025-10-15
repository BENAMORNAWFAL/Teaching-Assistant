// Configurations to connect monDB database
const mongoose=require('mongoose')

const uri=process.env.uri
mongoose.connect(uri)
    .then(()=>console.log("Established a connection to the database"))
    .catch(err=>console.log("Somehing went wrong when connecting to the database ", err))