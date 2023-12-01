from flask_app import app
from flask import redirect, render_template,request
from flask_app.models.filmmaker import FilmMaker
from flask_app.models.movie import Movie


@app.route('/')
def index():
    return redirect('/film')

@app.route('/film')
def films():
    return render_template('film.html',all_films=FilmMaker.get_all())

@app.route('/create/film',methods=['POST'])
def create_film():
    data = {
        "name": request.form['name']
    }
    FilmMaker.save(data)
    return redirect('/film')

@app.route('/film/<int:id>')
def show_film(id):
    data = {
        "id": id
    }
    return render_template('show_film.html',film=FilmMaker.get_by_id(data),Movie=Movie.get_by_film_id(data))
