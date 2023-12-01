from Ninjaclass import Ninja
#Class Pet
class Pet:
    def __init__(self,name,type,tricks,health,energy):
        self.name=name
        self.type=type
        self.tricks=tricks
        self.health=health
        self.energy=energy
    
# implement the Following methods of class Pet
    def sleep(self):      # sleep() - increases the pets energy by 25
        self.energy+=25
    
    def eat(self):       # eat() - increases the pet's energy by 5 & health by 10
        self.energy+=5
        self.health+=10

    def play(self):       # play() - increases the pet's health by 5
        self.health+=5
        print(self.health)

    def noise(self):     # noise() - prints out the pet's sound
        print(f'the sound of {self.name}')
class Dog(Pet):
    def __init__(self, name, type, tricks, health, energy , age):
        super().__init__(name, type, tricks, health, energy)
        self.age=age
    
cat=Pet('kahla','cat','scratch',100,10)
houssem=Ninja('houssem','bahri','kroket','salami',cat)

houssem.walk()
houssem.feed()
houssem.bathe()

dog=Dog("rex",'dog','danger',100,20,5)
dog.play()