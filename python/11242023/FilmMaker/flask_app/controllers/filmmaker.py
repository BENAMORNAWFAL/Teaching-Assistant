from flask_app import app
from flask import redirect, render_template,request
from ..models.filmmaker import FilmMaker
from ..models.movie import Movie


# render route
@app.route('/')
def index():
    return redirect('/film')
@app.route('/film')
def indexs():
    all_makers=FilmMaker.get_all()
    return render_template('film.html', all_makers=all_makers)
# action route
@app.route('/create/maker', methods=['POST'])
def create_maker():
    data={'name':request.form['name']}
    FilmMaker.save(data)
    return redirect('/')


@app.route('/maker/<int:id>')
def show_maker(id):
    data={
        'id':id
    }
    maker=FilmMaker.get_by_id(data)
    movies=Movie.get_by_makerId(data)
    return render_template('show_maker.html',maker=maker,movies=movies)