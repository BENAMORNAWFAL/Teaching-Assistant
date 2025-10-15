// C R U D For the Database

const Country = require("../models/country");

// READ ALL Country
module.exports.findAllCountries = (req, res) => {
    Country.find()
    .then((countries) => {
      res.json(countries);
    })
    .catch((err) => res.json("you have an error on findAll method",err));
};

// READ ONE County BY ID 

module.exports.findOneCountry = (req, res) => {
    Country.findOne({ _id: req.params.id })
    .then((oneCountry) => {
      res.json(oneCountry);
    })
    .catch((err) => res.json("you have an error on findOne method",err));
};

// CREATE Country

module.exports.createNewCountry = (req, res) => {
    Country.create(req.body)
    .then((newCountry) => {
      res.json(newCountry);
    })
    .catch((err) => res.json("you have an error on Create method",err));
};

// UPDATE Country

module.exports.updateExisitingCountry = (req, res) => {
    Country.findOneAndUpdate({ _id: req.params.id }, req.body, {
    new: true,
    runValidators: true,
  })
    .then((updatedCountry) => {
      res.json(updatedCountry);
    })
    .catch((err) => res.json("you have an error on findOneAndUpdate method",err));
};

// DELETE Country
module.exports.deleteOneCountry = (req, res) => {
    Country.deleteOne({ _id: req.params.id })
    .then((result) => {
      res.json(result);
    })
    .catch((err) => res.json("you have an error on deleteOneCoutry method",err));
};