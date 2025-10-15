const CountryController=require('../controllers/countries.controller')

module.exports=(app)=>{
    app.post('/api/country/',CountryController.create)
    app.get('/api/countries',CountryController.getAll)
    app.get('/api/country/:id',CountryController.getOne)
    app.put('/api/country/update/:id',CountryController.update)
    app.delete('/api/country/delete/:id',CountryController.delete)
}