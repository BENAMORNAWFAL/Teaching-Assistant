const mongoose=require('mongoose')

const StudentSchema=new mongoose.Schema({
    name:{
        type:String,
        required:[true,"{PATH} is required"],
        minlength:[4,"{PATH} must be at least 4 chars"]
    },
    cohortname:{
        type:String,
        required:[true,"{PATH} is required"],
        minlength:[4,"{PATH} must be at least 4 chars"]
    },
    groupexam:{
        type:Number,
        default:1
    }


},{timestamps:true})
module.exports.Student=mongoose.model('Student',StudentSchema)
