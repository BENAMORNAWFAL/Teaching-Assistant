from ..config.mysqlconnection import connectToMySQL ## default existing in models
from flask_app import DATABASE

class FilmMaker:
    def __init__(self,data):
        self.id=data['id']
        self.name=data['name']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']

    
    #create
    @classmethod
    def save(cls,data):
        query="""
                insert into film_makers (name) values (%(name)s);
                """
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @classmethod
    def get_all(cls):
        query="""
                select * from film_makers;

            """
        results=connectToMySQL(DATABASE).query_db(query)
        film_makers=[]
        for row in results:
            film_makers.append(cls(row))
        return film_makers
    
    @classmethod
    def get_one_by_id(cls,data):
        query="""
                select * from film_makers where id=%(id)s;
                """
        result=connectToMySQL(DATABASE).query_db(query,data)
        return cls(result[0])