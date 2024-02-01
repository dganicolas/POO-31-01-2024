open class Vehiculo ( val marca: String, val modelo: String, val capacidadCombustible:Int){
    override fun toString(): String = "Marca: $marca, modelo: $modelo, Capacidad combustible: $capacidadCombustible"
    open fun calcularAutonomia(): Int{
        return capacidadCombustible * 10
    }
}

class Automovil(marca: String,modelo: String,capacidadCombustible: Int, val tipo: String):Vehiculo(marca,modelo,capacidadCombustible){
    override fun calcularAutonomia(): Int{
        return super.calcularAutonomia() + 100
    }

}
class Motocicletas