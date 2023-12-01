
from flask_app import app
# import routes from the controller file
from flask_app.controllers import filmaker
from flask_app.controllers import movie



if __name__ == '__main__':
    app.run(debug =True)