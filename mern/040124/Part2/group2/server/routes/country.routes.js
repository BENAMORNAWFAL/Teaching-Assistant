const CountryController=require('../controllers/countries.controller')

module.exports=(app)=>{
    app.post('/api/countries/new',CountryController.create)
    app.get('/api/countries',CountryController.getAll)
    app.get('/api/countries/:id',CountryController.getOne)
    app.put('/api/countries/update/:id',CountryController.update)
    app.delete('/api/countries/delete/:id',CountryController.delete)
} 