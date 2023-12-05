from flask_app import app
from flask import render_template,redirect, request , session
from flask_app.models.pokemonmodel import Pokemon




#===============render route ===========
@app.route('/pokemon/create')
def create():
    return render_template('create.html')

#==============Action route ==============
@app.route('/create/pokemon', methods=['POST'])
def createPokemon():
    data={
        **request.form,
        'user_id':session['user_id']
    }
    print("============",data)
    Pokemon.createPokemon(data)
    return redirect('/dashboard')

#==============show==============
@app.route('/show/pokemon/<int:id>')
def show(id):
    data={
        'id':id
    }
    one_pokemon=Pokemon.get_one_by_id(data)
    print("+++++++++++++++++++++",one_pokemon)
    return render_template('show.html',pokemon=one_pokemon)

#===============Edit==============
# ====render route=======
@app.route('/edit/pokemon/<int:id>')
def edit(id):
    data={
        'id':id
    }
    session['id']=id
    pokemon=Pokemon.get_one_by_id(data)
    return render_template('edit.html',pokemon=pokemon)

#===action route=====
@app.route('/edit', methods=['POST'])
def update():
    data={
        'id':session['id'],
        **request.form
    }
    Pokemon.update(data)
    return redirect(f'/show/pokemon/{session['id']}')

#=============Delete=============
@app.route('/delete/pokemon/<int:id>')
def delete(id):
    data={
        'id':id
    }
    Pokemon.delete(data)
    return redirect("/dashboard")