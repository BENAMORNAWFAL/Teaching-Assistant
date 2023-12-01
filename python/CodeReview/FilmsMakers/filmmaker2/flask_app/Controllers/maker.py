from flask_app import app
from flask import redirect, render_template,request
from ..Models.maker import FilmMaker

# render route
@app.route('/')
def index():
    all_makers=FilmMaker.get_all()
    return render_template("maker.html",all_makers=all_makers)


# action route
@app.route('/create/maker', methods=['POST'])
def create():
    data={
    'name':request.form['name']
    }
    FilmMaker.save(data)
    return redirect('/')

@app.route('/showmaker/<int:id>')
def  read(id):
    data={
        'id':id
    }
    maker=FilmMaker.get_one_by_id(data)
    movie=Movie.get_by_makerId(data)
    return render_template('showmaker.html',maker=maker,movie=movie)    



