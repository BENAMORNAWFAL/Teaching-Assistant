from flask_app import app
from flask_app.controllers import logreg
from flask_app.controllers import pokemon

if __name__=="__main__":
    app.run(debug=True)