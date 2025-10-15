const StundetController=require('../controllers/student.contoller')

module.exports=(app)=>{
    app.post('/api/students/new',StundetController.createStudent)
    app.get('/api/students', StundetController.getAllStudent)
    app.get('/api/students/:id', StundetController.getOneStudent)
    app.put('/api/students/update/:id', StundetController.updateStudent)
    app.delete('/api/students/delete/:id', StundetController.deleteStudent)
}