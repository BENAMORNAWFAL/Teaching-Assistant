// C R U D for database


const { model } = require('mongoose')
const {Country}= require('../models/country.model')

//******************* */ Create Country*****************
module.exports.create=(req,res)=>{
    Country.create(req.body)
    .then(obj=>res.json(obj))
    .catch(err=>{console.log(res.status(400)),res.status(400).json(err)})
}
//******************* Read All Countries*****************
module.exports.getAll = (req, res) => {
    Country.find({})
        .then(objects => res.json(objects))
        .catch(err => res.json(err))
}
// ************************ Read One Country **************
module.exports.getOne = (req, res) => {
    Country.findOne({_id:req.params.id})
        .then(object => res.json(object))
        .catch(err => res.json(err))
}

// *********************** Update Country ************
module.exports.update=(req,res)=>{
    Country.findOneAndUpdate({_id:req.params.id},req.body,{new:true, runValidators: true})
    .then(object=>res.json(object))
    .catch(err=>res.status(400).json(err))
}

// ******************* Delete Country*********************
module.exports.delete=(req,res)=>{
    Country.deleteOne({_id:req.params.id})
    .then(del=>res.json(del))
    .catch(err=>res.json(err))
}