package com.example.kotlin_proyect

class restas_sucesivas(dividendo: Int, divisor: Int) {
    private var primerResta: Int = 0
    private var cociente: Int = 0
    private var residuo: Int = dividendo

    init {
        while (residuo >= divisor) {
            residuo -= divisor
            if (primerResta == 0) {
                primerResta = dividendo - residuo
            }
            cociente++
        }
    }

    fun obtenerResultado(): Pair<Int, Int> {
        return Pair(cociente, primerResta)
    }


}


