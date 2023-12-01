from flask_app import app
from flask import redirect, render_template,request
from flask_app.models.filmmaker import FilmMaker
from flask_app.models.movie import Movie

@app.route('/movies')
def movies():
    all_movies=Movie.get_all()
    return render_template('movie.html',all_movies=Movie.get_all(),all_films=FilmMaker.get_all())

@app.route('/create/movie',methods=['POST'])
def create_Movie():
    data = {
        "title":request.form['title'],
        "num_of_pages": request.form['num_of_pages'],
        "film_maker_id": request.form['film_maker_id']
    }
    movie_id = Movie.save(data)
    return redirect('/movies')

@app.route('/movie/<int:id>')
def show_movie(id):
    data = {
        "id":id,
    }
    movie=Movie.get_by_id(data)
    data = {
        "id":movie.film_maker_id,
    }
    film=FilmMaker.get_by_id(data)
    return render_template('show_movie.html',movie=movie,film=film)

@app.route('/join/movie',methods=['POST'])
def join_movie():
    data = {
        'film_maker_id': request.form['film_maker_id'],
        'movie_id': request.form['movie_id']
    }
    FilmMaker.add_favorite(data)
    return redirect(f"/movie/{request.form['movie_id']}")

@app.route('/movie/<int:id>/edit')
def edit_movie(id):
    data = {
        "id":id,
    }
    movie=Movie.get_by_id(data)
    return render_template('edit_movie.html',movie=movie)

@app.route('/update/movie',methods=['POST'])
def update_movie():
    data = {
        "title":request.form['title'],
        "num_of_pages": request.form['num_of_pages'],
        "id": request.form['id']
    }
    movie_id = Movie.update(data)
    return redirect(f'/movie/{data["id"]}')