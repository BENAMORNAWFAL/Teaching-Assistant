from flask_app.config.mysqlconnection import connectToMySQL
from flask_app import DATABASE

class Pokemon:
    def __init__(self,data):
        self.id=data['id']
        self.name=data['name']
        self.type=data['type']
        self.power=data['power']
        self.hp=data['hp']
        self.image=data['image']
        self.user_id=data['user_id']
        self.created_at=data['created_at']
        self.updated_at=data['updated_at']

    @classmethod
    def createPokemon(cls,data):
        query="""
            INSERT INTO pokemons (name, type , power, hp , image ,user_id)
            VALUES (%(name)s ,%(type)s,%(power)s,%(hp)s,%(image)s,%(user_id)s);
            """
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @classmethod
    def get_all(cls,data):
        query="""
                SELECT * FROM Pokemons
                join users ON pokemons.user_id= %(user_id)s ;
                """
        results=connectToMySQL(DATABASE).query_db(query,data)
        pokemons=[]
        print(len(results))
        for row in results:
                pokemons.append(cls(row))
                print("************************",pokemons)
        
        return pokemons
    
    @classmethod
    def get_one_by_id(cls,data):
        query="""
            SELECT * FROM pokemons WHERE id=%(id)s;
            """
        result=connectToMySQL(DATABASE).query_db(query,data)
        if result:
            return cls(result[0])
        
    @classmethod
    def update(cls,data):
        query="""UPDATE pokemons SET name=%(name)s,type=%(type)s,power=%(power)s,hp=%(hp)s,image=%(image)s WHERE id=%(id)s;"""
        return connectToMySQL(DATABASE).query_db(query,data)
    
    @classmethod
    def delete(cls,data):
        query="""
            DELETE FROM pokemons WHERE id=%(id)s;
            """
        return connectToMySQL(DATABASE).query_db(query,data)