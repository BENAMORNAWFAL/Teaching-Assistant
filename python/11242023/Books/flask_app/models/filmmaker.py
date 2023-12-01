from ..config.mysqlconnection import connectToMySQL

class FilmMaker:
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM film_maker;"
        film_maker = []
        results = connectToMySQL('filmmaker_db').query_db(query)
        for row in results:
            film_maker.append(cls(row))
        return film_maker

    @classmethod
    def save(cls,data):
        query = "INSERT INTO film_maker (name) VALUES (%(name)s);"
        return connectToMySQL('filmmaker_db').query_db(query,data)

    @classmethod
    def get_by_id(cls,data):
        query = "SELECT * FROM film_maker WHERE id = %(id)s;"
        result = connectToMySQL('filmmaker_db').query_db(query,data)
        return cls(result[0])