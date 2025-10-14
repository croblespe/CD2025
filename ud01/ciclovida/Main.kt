fun main() {
    val calc = Calculator()

    print("Introduce el primer número: ")
    val num1 = readLine()?.toDoubleOrNull()

    print("Introduce el segundo número: ")
    val num2 = readLine()?.toDoubleOrNull()

    if (num1 == null || num2 == null) {
        println("Error: Entrada inválida.")
        return
    }

    println("Suma: ${calc.sumar(num1, num2)}")
    println("Resta: ${calc.restar(num1, num2)}")
    println("Multiplicación: ${calc.multiplicar(num1, num2)}")

    try {
        println("División: ${calc.dividir(num1, num2)}")
    } catch (e: IllegalArgumentException) {
        println("Error en la división: ${e.message}")
    }
}
