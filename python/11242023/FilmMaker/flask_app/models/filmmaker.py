from ..config.mysqlconnectin import connectToMySQL
from flask_app import db

class FilmMaker:
    def __init__(self,data):
        self.id=data['id']
        self.name=data['name']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']


    # Read All
    @classmethod
    def get_all(cls):
        query="""
                SELECT * FROM film_makers;
            """
        results=connectToMySQL(db).query_db(query)
        film_maker=[]
        for row in results:
            film_maker.append(cls(row))
        return film_maker
    
    # Create
    @classmethod
    def save(cls,data):
        query="""
                insert into film_makers (name) values (%(name)s);
                """
        return connectToMySQL(db).query_db(query,data)
    
    #Read one
    @classmethod
    def get_by_id(cls,data):
        query="""
                Select * from film_makers where id=(%(id)s);
                """
        result=connectToMySQL(db).query_db(query,data)
        return cls(result[0])