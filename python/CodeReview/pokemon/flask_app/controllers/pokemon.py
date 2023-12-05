from flask import Flask
from flask_app import app
from flask import request ,render_template, session, redirect, flash
from flask_app.models.pokemon import Pokemon

#============render Route ========
@app.route('/pokemon/create')
def create():
    return render_template('create.html')
#============= action route ========
@app.route('/create', methods=['POST'])
def actioncreate():
    data={
        'name':request.form['name'],
        'type':request.form['type'],
        'power':request.form['power'],
        'hp':request.form['hp'],
        'image':request.form['image'],
        "user_id":session['user_id']
    }
    Pokemon.create_pokemon(data)
    return redirect("/dashboard")

#============= edit =============
@app.route('/pokemon/edit/<int:id>')
def edit(id):
    print("===========",id)
    data={
        'id':id
    }
    pokemon=Pokemon.get_by_id(data)
    session['pok_id']=id
    return render_template("editpokemon.html", pokemon=pokemon)

@app.route('/edit', methods=['POST'])
def editaction():
    data={
        'id':session['pok_id'],
        'name':request.form['name'],
        'type':request.form['type'],
        'power':request.form['power'],
        'hp':request.form['hp'],
        'image':request.form['image'],
    }
    print("*************",data)
    Pokemon.update(data)
    return redirect('/dashboard')

#========= show one ==========
@app.route('/pokemon/show/<int:id>')
def showone(id):
    data={
        'id':id
    }
    pokemon=Pokemon.get_by_id(data)
    return render_template("showone.html",pokemon=pokemon)


#============Delete==============
@app.route('/pokemon/delete/<int:id>')
def delete(id):
    data={
        'id':id
    }
    Pokemon.Delete(data)
    return redirect('/dashboard')