open class Persona( open val nombre:String, edad:Int){
    var edad:Int = edad
        private set

    fun cumple(){
        this.edad++
    }

    override fun toString(): String {
        return "persona (nombre =$nombre , edad = $edad"
    }
}
class Estudiante(nombre: String,edad: Int,val carrera: String):Persona(nombre,edad){
    override var nombre = nombre
        get() = field.uppercase()
}

fun main(args: Array<String>) {
    val persona = Persona("juan",25)
    println(persona)
    persona.cumple()
    println("Nombre: ${persona.nombre} edad: ${persona.edad}")

    val estudiante = Estudiante("marta",19,"Derechos")
    println(estudiante.nombre)
    println(persona.nombre)
}
