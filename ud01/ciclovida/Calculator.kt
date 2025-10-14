class Calculator {
    fun sumar(a: Double, b: Double) = a + b
    fun restar(a: Double, b: Double) = a - b
    fun multiplicar(a: Double, b: Double) = a * b
    fun dividir(a: Double, b: Double): Double {
        if (b == 0.0) throw IllegalArgumentException("No se puede dividir entre cero.")
        return a / b
    }
}


