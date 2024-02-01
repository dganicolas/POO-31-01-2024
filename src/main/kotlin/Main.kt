import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
/**
 * leyenda: si ves esto "--" esta en proceso si ves esto "----" esta terminado esa parte
Ejercicio: Persona y Estudiante
1. Clases y Objetos Básicos:
----Crea una clase Persona que tenga dos propiedades: nombre y edad. Luego, en el main crea un objeto de esta clase e imprime sus propiedades.

. Métodos Simples:
----Añade un método cumple a la clase Persona que incremente la edad de la persona en uno cada vez que se llama.

----Sobreescribe el método toString() y prográmalo para que se muestre una persona con todas sus propiedades. Por ejemplo "Persona (nombre = Lucía, edad = 21)".
----En el main ejecuta el cumple de la persona y muestra su información de dos formas: accediendo a sus propiedades y mediante el método toString() (recuerda que no es necesario llamar al método toString(), sino que se invocará automáticamente cuando necesite realizar la conversión del contenido a String)
3. Encapsulamiento:
---- Modifica la clase Persona para hacer la propiedad edad privada y añade un método mostrarEdad() para acceder a su valor.
4. Herencia:
----Crea una clase Estudiante que herede de Persona y añade una propiedad carrera. Las propiedades deben incluir el modificador open (vuelve a dejar la propiedad edad pública)
• Realiza de nuevo un override de toString() para completar la información de Estudiante (intenta usar el resultado del método de la clase padre y completarlo).
5. Polimorfismo:
• Añade un método actividad() a la clase Persona que imprima "Lucía está realizando una actividad." y sobrescríbelo en Estudiante para que muestre un mensaje específico para estudiantes.
• Crea en el main a una persona y un estudiante y muestra la actividad que realizan.
6. Clases y Objetos con Validación:
• Modifica la clase Persona para que no acepte nombres vacíos y edades negativas. Utiliza un constructor primario con valores por defecto para edad.
• Prueba a crer un estudiante con una edad negativa, controlando las excepciones y mostrando el mensaje de error específico.
*/


open class Persona(nombre:String, edad:Int){
    init {
        require(nombre.isNotBlank()){"PUUM"}
        require(edad > 18)
    }
    open val nombre =nombre
    private var edad:Int = edad
       set(value){
       require(value>0) {"la edad no puede ser negativa"}
           field = value
       }
    fun mostrar_edad():String{
        return edad.toString()
    }
    fun cumple(){
        println("el $nombre ha cumplido un año mas")
        this.edad++
        println("el $nombre tiene $edad")
    }
    open fun actividad(): String {
     return "$nombre esta haciendo una actividad"
    }

    override fun toString(): String {
        return "Persona (nombre = $nombre, edad = $edad)"
    }
}
class Estudiante(nombre: String,edad: Int,val carrera: String):Persona(nombre,edad){
    override var nombre = nombre
        get() = field.uppercase()

    override fun toString(): String {
        return "${super.toString().dropLast(1).replace("Persona (","Estudiante (")}, carrera = ${carrera})"
    }
    override fun actividad(): String{
        return "$nombre esta estudiando"
    }
}
/**
fun pedirPersona(): Persona{
    var p:Persona? = null
    do{
        try {
            print("introduce tu nombre: ")
            val nombre = readln()
            print("introduce tu edad: ")
            val edad = readln().toInt()
            p = Persona(nombre,edad)
        }catch(e :IllegalArgumentException){
            println(e.message)
        }
        catch (e:NumberFormatException){
            println("La edad debe ser positiva")
        }
    }while(p ==null)
    return p
}
*/
fun main(args: Array<String>) {
    val persona = Persona("juan",25)
    println(persona)
    persona.cumple()
    println(persona.toString())
    println("Nombre: ${persona.nombre} edad: ${persona.mostrar_edad()}")

    val estudiante = Estudiante("marta",19,"Derechos")
    println(estudiante.nombre)
    println(persona.nombre)
    persona.toString()
    estudiante.toString()
}
