const CountryController = require("../controllers/country.controller");

module.exports = (app) => {
  app.get("/api/countries", CountryController.findAllCountries);
  app.post("/api/country", CountryController.createNewCountry);
  app.get("/api/country/:id", CountryController.findOneCountry);
  app.patch("/api/country/:id", CountryController.updateExisitingCountry);
  app.delete("/api/country/:id", CountryController.deleteOneCountry);
};