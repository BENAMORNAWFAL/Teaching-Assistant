class Ninja:
    def __init__(self, first_name , last_name , treats , pet_food , pet ):
        self.fname=first_name
        self.lname=last_name
        self.treats=treats
        self.food=pet_food
        self.pet=pet

# implement the following methods:

    def walk(self):# walk() - walks the ninja's pet invoking the pet play() method
        self.pet.play()
    def feed(self):# feed() - feeds the ninja's pet invoking the pet eat() method
        self.pet.eat()
    def bathe(self):# bathe() - cleans the ninja's pet invoking the pet noise() method
        self.pet.noise()

class Pet:
# implement __init__( name , type , tricks ):
    def __init__(self,name,type,tricks,health,energy):
        self.name=name
        self.type=type
        self.tricks=tricks
        self.health=health
        self.energy=energy
    
# implement the following methods:
    def sleep(self):# sleep() - increases the pets energy by 25
        self.energy+=25
    def eat(self):# eat() - increases the pet's energy by 5 & health by 10
        self.energy+=5
        self.health+=10
    def play(self):# play() - increases the pet's health by 5
        self.health+=5
    def noise(self):# noise() - prints out the pet's sound
        if(self.type=='dog'):
            print(f"{self.name} barks: Woof! Woof!")
        else:
            print(f'the sound of {self.name} ')

class Dog(Pet):
    def __init__(self, name, type, tricks, health, energy):
        super().__init__(name, type, tricks, health, energy)


    
    
    


cat=Pet('kiti','chats','fast_moves',10,100)
lion=Ninja('naruto','shippuden','fast','meat',cat)

lion.bathe()

cat.noise()

dog=Dog("rex","dog","danger",20,100)
dog.noise()
dog.play()