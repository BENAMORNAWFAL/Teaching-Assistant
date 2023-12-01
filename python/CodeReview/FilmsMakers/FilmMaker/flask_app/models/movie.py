from ..config.mysqlconnectin import connectToMySQL
from flask_app import db

class Movie:
    def __init__(self,data):
        self.id=data['id']
        self.title=data['title']
        self.year=data['year']
        self.film_maker_id=data['film_maker_id']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']

    # create
    @classmethod
    def save(cls,data):
        query="""
                INSERT INTO movies (title,year,film_maker_id) VALUES (%(title)s,%(year)s,%(film_maker_id)s);
                """
        return connectToMySQL(db).query_db(query,data)
    
    #REad
    @classmethod
    def get_all(cls):
        query="""
                SELECT * FROM movies;
            """
        result=connectToMySQL(db).query_db(query)
        movies=[]
        for row in result:
            movies.append(cls(row))
        return movies
    
    @classmethod
    def get_by_makerId(cls,data):
        query="""
                SELECT * FROM movies WHERE film_maker_id=%(id)s;
                """
        results=connectToMySQL(db).query_db(query,data)
        movies=[]
        for row in results:
            movies.append(cls(row))

        return movies
    
    @classmethod
    def get_movie_by_id(cls,data):
        query="""
                SELECT * FROM movies WHERE id=%(id)s;
                """
        result=connectToMySQL(db).query_db(query,data)
        return cls(result[0])
    
    @classmethod
    def update(cls,data):
        query="""
                UPDATE movies SET title=%(title)s, year=%(year)s WHERE id=%(id)s;

                """
        return connectToMySQL(db).query_db(query,data)