from ..config.mysqlconnection import connectToMySQL

class Movie:
    def __init__(self, data):
        self.id = data['id']
        self.title = data['title']
        self.film_maker_id = data['film_maker_id']
        self.year = data['year']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM movie;"
        movie = []
        results = connectToMySQL('filmmaker_db').query_db(query)
        for row in results:
            movie.append(cls(row))
        return movie
    
    @classmethod
    def save(cls,data):
        query = "INSERT INTO movie (title,year,film_maker_id) VALUES (%(title)s,%(year)s,%(film_maker_id)s);"
        return connectToMySQL('filmmaker_db').query_db(query,data)

    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM movie WHERE movie.id = %(id)s;"
        result = connectToMySQL('filmmaker_db').query_db(query,data)
        return cls(result[0])
    
    @classmethod
    def get_by_film_id(cls,data):
        query = "SELECT * FROM movie WHERE film_maker_id = %(id)s;"
        movie = []
        results = connectToMySQL('filmmaker_db').query_db(query,data)
        for row in results:
            movie.append(cls(row))
        return movie

    @classmethod
    def update(cls, data):
        query = """
        UPDATE movie SET title = %(title)s, year = %(year)s
        WHERE id = %(id)s;
        """
        return connectToMySQL("filmmaker_db").query_db(query,data)