import math

class VectorTridimensional:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    #Sobrecarga del operador de suma (+)
    def __add__(self, otro):
        return VectorTridimensional(
            self.x + otro.x,
            self.y + otro.y,
            self.z + otro.z
        )

    #Sobrecarga del operador de resta (-)
    def __sub__(self, otro):
        return VectorTridimensional(
            self.x - otro.x,
            self.y - otro.y,
            self.z - otro.z
        )

    #Sobrecarga de la multiplicación por escalar (r * a)
    def __mul__(self, escalar):
        return VectorTridimensional(
            self.x * escalar,
            self.y * escalar,
            self.z * escalar
        )
    
    #Permite la multiplicación en el otro orden (a * r)
    def __rmul__(self, escalar):
        return self.__mul__(escalar)

    #Longitud del vector
    def longitud(self):
        return math.sqrt(self.x**2 + self.y**2 + self.z**2)

    #Vector normal
    def normal(self):
        longitud = self.longitud()
        if longitud == 0:
            return VectorTridimensional(0, 0, 0)
        return self * (1 / longitud)

    #Producto escalar
    def producto_escalar(self, otro):
        return (self.x * otro.x) + (self.y * otro.y) + (self.z * otro.z)
    
    #Producto vectorial
    def producto_vectorial(self, otro):
        nuevo_x = (self.y * otro.z) - (self.z * otro.y)
        nuevo_y = (self.z * otro.x) - (self.x * otro.z)
        nuevo_z = (self.x * otro.y) - (self.y * otro.x)
        return VectorTridimensional(nuevo_x, nuevo_y, nuevo_z)

    #Representación en cadena
    def __repr__(self):
        return f"[{self.x:.2f}, {self.y:.2f}, {self.z:.2f}]"

#MAIN
a = VectorTridimensional(1, 2, 3)
b = VectorTridimensional(4, 5, 6)

print("RODRIGO CATUNTA SIRPA")
print(f"Vector a: {a}")
print(f"Vector b: {b}")

#Operaciones con sobrecarga
suma = a + b
print(f"Suma (a + b): {suma}")

escalar = 2
mult_escalar = a * escalar
print(f"Multiplicación por escalar ({escalar} * a): {mult_escalar}")

print(f"Longitud de a: {a.longitud():.2f}")

normal = a.normal()
print(f"Normal de a: {normal}")

producto_escalar = a.producto_escalar(b)
print(f"Producto escalar (a · b): {producto_escalar}")

producto_vectorial = a.producto_vectorial(b)
print(f"Producto vectorial (a x b): {producto_vectorial}")