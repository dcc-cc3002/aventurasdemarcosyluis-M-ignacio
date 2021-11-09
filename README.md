## AventurasdeMarcosyLuis
Se trabajo sobre el repositorio entregado en el curso. Para esto se creó un nuevo package "model" que contiene el código funcional y dentro de la carpeta test
dos códigos para testear la funcionalidad de las clases Hero y Oppontent que implementan la totalidad del código útil.

funcionamiento.

-descargar el repositorio.

-abrir en su entorno de desarrollo.

-ejecutar la carpeta test ubicado en \src\test.

###primera entrega:

En esta primera entrega no se implementó la dinámica de ataques (aunque en un principio era la idea) por falta de tiempo una parte del código queda como comentario. Al no existir 
una interacción entre las clases Hero y Opponent, al crear un objeto de cualquier clase no es posible que su vida disminuya por tanto para cada test se crean dos objectos de una 
misma clase (testMarcos - testMarcosFull, testGoomba - testGomombaFull...) pero con atributos diferentes que permita comprobar el funcionamiento de los métodos. Por lo mismo, por 
el momento la restricción para los puntos de vida mínimos es sencilla. Se comprueba los puntos de vida con el método "KO" si estos son iguales a 0 el personaje pierdes sus puntos 
de ataque y no puede interactuar con otro objeto (aún no existe interacciones, pero esta es la implementación pensada). Los puntos de vida máximos si se encuentran limitados por 
el rango de cada objeto. Para simular un personaje derrotado se setea sus puntos de vida en 0.

Lógica:
Se tiene una clase abstracta AbstractCharacter que implementa una interfaz Character, esta clase es superclase de Hero y Opponent de forma que se planea que dentro de la clase
abstracta definir los métodos para que los objetos de estas clases interactúen. Opponent además de implementar los atributos de AbstractCharacter tiene un atributo Type que define
el tipo de enemigo que representa el objeto. Type es de tipo OpponentType que es un archivo Enum que contiene los tres tipos de oponente (Goomba, Spiny y Boo) que implementan su 
propia versión de cada método de OpponentType. Hero también implementa un atributo Type de tipo HeroType que de forma análoga contiene a los dos tipos de héroes (Marcos y Luis)  y 
ambos con sus respectivos métodos. Además, añade el atributo FightPoints que es único de esta clase que limita los tipos de ataque del objeto. Los item que puede utilizar un héroe 
estan en un archivo Enum donde se implementa su funcionalidad y son llamados con métodos únicos desde la clase Hero.


###Segunda entrega:

Se implementa la logica de ataques mediante interfaces entre los personajes de forma de solo permitir los ataques permitidos dada las instrucciones definidas. Al crear un  Baúl (Chest constructor) no se considero necesario enlazarlo a los perosnajes principales por dos razones de construcción: EL chest solo permite que objetos tipo Heroe ocupen items, solo existe un Chest por partida. 

El controlador permite utilizar las funcionalidades del modelo. Se implementa un sistema de turnos rotativos. No se implemento el orden en que atacan los personajes por falta de una buena idea?). En terminos generales se crea las bases del controlador, para en una entrega posterior general fluides en el juego.


