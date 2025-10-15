// C R U D DATABASE

const {Student}=require('../models/student.model')

// *******************Create Student***************

module.exports.createStudent=(req,res)=>{
    Student.create(req.body)
        .then(object=>{res.json(object)})
        .catch(err=>{res.status(400).json(err)})
}

// ************* READ ALL Students *********
module.exports.getAllStudent=(req,res)=>{
    Student.find()
        .then(object=>res.json(object))
        .catch(err=>{res.json(err)})
}

// ************* READ One Student *********
module.exports.getOneStudent=(req,res)=>{
    Student.findOne({_id:req.params.id})
        .then(object=>res.json(object))
        .catch(err=>{res.json(err)})
}

// ************* Update one Student *********
module.exports.updateStudent=(req,res)=>{
    Student.findOneAndUpdate({_id:req.params.id},req.body,{new:true, runValidators:true})
        .then(object=>res.json(object))
        .catch(err=>{res.status(400).json(err)})
}
// ***************** Delete one Student ***********
module.exports.deleteStudent=(req,res)=>{
    Student.deleteOne({_id:req.params.id})
        .then(re=>res.json(re))
        .catch(err=>{console.log("you have an error on delete ",res.json(err))})
}
