// C R U D FOR DATABASE

const {Country}=require('../models/country.model')

// ******************* CREATE COUNTRY ***************
module.exports.create=(req,res)=>{
    Country.create(req.body)
        .then(obj=>res.json(obj))
        .catch(err=>{res.status(400).json(err)})
}

// ********************* READ ALL COUNTRIES ***********
module.exports.getAll=(req,res)=>{
    Country.find()
        .then(obj=>res.json(obj))
        .catch(err=>{res.json(err)})
}
// *********************** READ ONE *****************
module.exports.getOne=(req,res)=>{
    Country.findOne({_id:req.params.id})
    .then(obj=>res.json(obj))
    .catch(err=>{res.json(err)})
}
// ******************** UPDATE ONE COUNTRY ************
module.exports.update=(req,res)=>{
    Country.findOneAndUpdate({_id:req.params.id},req.body,{new:true, runValidators:true})
        .then(obj=>res.json(obj))
        .catch(err=>{res.status(400).json(err)})
}
// ********************** DELETE COUNTRY ***********
module.exports.delete=(req,res)=>{
    Country.deleteOne({_id:req.params.id})
        .then(del=>res.json(del))
        .catch(err=>{console.log("you have an error on delete ",res.json(err))})
    }