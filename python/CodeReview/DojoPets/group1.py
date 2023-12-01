from Ninjas import Ninja


#Class Pet
class Pet:
    def __init__(self,name,type,tricks,health,energy):
        self.name=name
        self.type=type
        self.tricks=tricks
        self.health=health
        self.energy=energy

# implement the following methods
    def sleep(self):   # sleep method - increases the pets energy by 25
        self.energy+=25
        print(self.energy)
    def eat(self):    # eat method - increases the pet's energy by 5 & health by 10
        self.energy+=5
        self.health+=10
        print(self.energy,self.health)
    def play(self):   # play method - increases the pet's health by 5
        self.health+=5
        print(self.health)

    def noise(self): # noise method - prints out the pet's sound
        if(self.type=='dog'):
            print(f'{self.name} barks: Woof! Woof!')
        else:
            print(f'sound of {self.name}')
        return None

class Dog(Pet):
    def __init__(self, name, type, tricks, health, energy , age):
        super().__init__(name, type, tricks, health, energy)
        self.age=age


cat=Pet("kiti",'cat','fast_moves',10,100)
naruto=Ninja('naruto','ozomaki','sushi','fish',cat)


naruto.walk().feed().bathe()

dog=Dog("wanda","dog","kind",20,100,2)
dog.noise()
dog.play()
dog.eat()