package com.example.calculadoraluis

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNum = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonigual.isClickable = false


    }

    fun numero(view: View) {
        if (isNewOp) {
            pantalla.text = ""
            introduce.text = ""
        }
        isNewOp = false
        var btClickValue = pantalla.text.toString()
        var btPressed = view as Button
        when (btPressed.id) {
            boton0.id -> {
                btClickValue += "0"
            }
            boton1.id -> {
                btClickValue += "1"
            }
            boton2.id -> {
                btClickValue += "2"
            }
            boton3.id -> {
                btClickValue += "3"
            }
            boton4.id -> {
                btClickValue += "4"
            }
            boton5.id -> {
                btClickValue += "5"
            }
            boton6.id -> {
                btClickValue += "6"
            }
            boton7.id -> {
                btClickValue += "7"
            }
            boton8.id -> {
                btClickValue += "8"
            }
            boton9.id -> {
                btClickValue += "9"
            }
            botonresta.id -> {
                btClickValue = "-$btClickValue"
                botonresta.isClickable = false
            }
            botoncoma.id -> {
                if (btClickValue.isNotEmpty()) {
                    btClickValue += "."
                } else {
                    btClickValue += "0."
                }
                botoncoma.isClickable = false
            }
        }
        pantalla.setText(btClickValue)
    }

    fun operacion(view: View) {
        botonresta.isClickable = true
        botoncoma.isClickable = true
        var btPressed = view as Button
        when (btPressed.id) {
            botonsuma.id -> {
                op = "+"
            }
            botonresta.id -> {
                op = "-"
            }
            botonmult.id -> {
                op = "x"
            }
            botondiv.id -> {
                op = "/"
            }
        }
        oldNum = pantalla.text.toString()
        isNewOp = true
        botonigual.isClickable = true
    }

    fun borrar(view: View) {
        val chain = pantalla.text.toString()
        if (chain.isNotEmpty()) {
            pantalla.text = chain.substring(0, chain.length - 1)
        }


    }

    fun reset(view: View) {

        oldNum = 0.toString()
        pantalla.text = "0"
        introduce.text = ""
        isNewOp = true
        botonigual.isClickable = true
    }


    fun igual(view: View) {
        var newNum = pantalla.text.toString()
        var result = 0.0
        when (op) {
            "+" -> {
                result = oldNum.toDouble() + newNum.toDouble()
            }
            "-" -> {
                result = oldNum.toDouble() - newNum.toDouble()
            }
            "x" -> {
                result = oldNum.toDouble() * newNum.toDouble()
                if (result.isInfinite() || result.isNaN()) {
                    result = 0.0;
                }
            }
            "/" -> {
                result = oldNum.toDouble() / newNum.toDouble()
                if (result.isInfinite() || result.isNaN()) {
                    result = 0.0
                    Toast.makeText(
                        applicationContext,
                        "Illo entre 0 no se puede dividir",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        introduce.setText(oldNum + op + newNum)
        pantalla.text = result.toString()
        isNewOp = true
    }

    var isNewOpLand = true
    var oldNumLand = ""
    var opLand = "+"

    fun numhor(view: View) {
        if (isNewOpLand) {
            pantalla.text = ""
        }
        isNewOpLand = false
        var btClickValue = pantalla.text.toString()
        var btPressed = view as Button
        when (btPressed.id) {
            boton0.id -> {
                btClickValue += "0"
            }
            boton1.id -> {
                btClickValue += "1"
            }
            boton2.id -> {
                btClickValue += "2"
            }
            boton3.id -> {
                btClickValue += "3"
            }
            boton4.id -> {
                btClickValue += "4"
            }
            boton5.id -> {
                btClickValue += "5"
            }
            boton6.id -> {
                btClickValue += "6"
            }
            boton7.id -> {
                btClickValue += "7"
            }
            boton8.id -> {
                btClickValue += "8"
            }
            boton9.id -> {
                btClickValue += "9"
            }
            botoncoma.id -> {
                if (btClickValue.isNotEmpty()) {
                    btClickValue += "."
                } else {
                    btClickValue += "0."
                }
                botoncoma.isClickable = false
            }
        }
        pantalla.setText(btClickValue)
    }

    fun letra(view: View) {
        if (isNewOpLand) {
            pantalla.text = ""
        }
        isNewOpLand = false
        var btClickValue = pantalla.text.toString()
        var btPressed = view as Button
        when (btPressed.id) {
            botonA.id -> {
                btClickValue += "a"
            }
            botonB.id -> {
                btClickValue += "b"
            }
            botonC.id -> {
                btClickValue += "c"
            }
            botonD.id -> {
                btClickValue += "d"
            }
            botonE.id -> {
                btClickValue += "e"
            }
            botonF.id -> {
                btClickValue += "f"
            }
        }
        pantalla.setText(btClickValue)
    }

    fun operacionhor(view: View) {
        botoncoma.isClickable = true
        var btPressed = view as Button

        if (!botonbin.isEnabled) {
            var numero = pantalla.text.toString().toLong()
            var a = binarioadecimal(numero)
            oldNumLand = a.toString()
            pantalla.setText("0")
        }
        if (!botonhex.isEnabled) {
            var x = hexadecimal(pantalla.text.toString());
            oldNumLand = x.toString()
            pantalla.setText("0")
        }
        if (!botondec.isEnabled) {
            oldNumLand = pantalla.text.toString()
            pantalla.setText("0")
        }
        when (btPressed.id) {
            botonsuma.id -> {
                opLand = "+"
            }
            botonresta.id -> {
                opLand = "-"
            }
            botonmult.id -> {
                opLand = "x"
            }
            botondiv.id -> {
                opLand = "/"
            }
        }
        isNewOpLand = true
        botonigual.isClickable = true
    }

    fun igualhor(view: View) {
        var currentNum = pantalla.text
        var result = 0
        try {
            var newNum = pantalla.text.toString()
            if (!botonbin.isEnabled) {
                var numero = pantalla.text.toString().toLong()
                var x = binarioadecimal(numero)
                newNum = x.toString()
            }
            if (!botonhex.isEnabled) {
                var x = hexadecimal(pantalla.text.toString());
                newNum = x.toString()
            }
            if (!botondec.isEnabled) {
                newNum = pantalla.text.toString()
            }

            when (opLand) {

                "+" -> {
                result = oldNumLand.toInt() + newNum.toInt()
            }
                "-" -> {
                    result = oldNumLand.toInt() - newNum.toInt()
                }
                "x" -> {
                    result = oldNumLand.toInt() * newNum.toInt()

                }
                "/" -> {
                    result = oldNumLand.toInt() / newNum.toInt()

                }

            }

            if (!botonbin.isEnabled) {
                var bin = result.toString()

                var resBin = Integer.toBinaryString(bin.toInt())
                pantalla.setText(resBin.toString())
            }
            if (!botonhex.isEnabled) {
                var e = result.toString()
                var r = Integer.toHexString(e.toInt())
                pantalla.setText(r)
            }
            if (!botondec.isEnabled) {
                pantalla.setText(result.toString())
            }

            isNewOpLand = true
        } catch (ae: ArithmeticException) {
            Toast.makeText(applicationContext, "No puedes dividir entre 0", Toast.LENGTH_SHORT)
                .show()
            result = 0

        } catch (ex: NumberFormatException) {
            currentNum = pantalla.text
        } catch (e: Exception) {
        }

    }

    fun binarioadecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun hexadecimal(hexadecimal: String): Long {
        var decimal: Long = 0
        var potencia = 0
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor: Int = letrahexadecimal(hexadecimal[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toLong() * valor
            decimal += elevado
            potencia++
        }
        return decimal
    }

    fun letrahexadecimal(caracter: Char): Int {
        return when (caracter) {
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            else -> caracter.toString().toInt()
        }
    }

    fun binario(view: View) {

        Toast.makeText(applicationContext, "Modo BINARIO activado", Toast.LENGTH_SHORT)
            .show()
        boton2.visibility = View.INVISIBLE
        boton3.visibility = View.INVISIBLE
        boton4.visibility = View.INVISIBLE
        boton5.visibility = View.INVISIBLE
        boton6.visibility = View.INVISIBLE
        boton7.visibility = View.INVISIBLE
        boton8.visibility = View.INVISIBLE
        boton9.visibility = View.INVISIBLE

        botonA.visibility = View.INVISIBLE
        botonB.visibility = View.INVISIBLE
        botonC.visibility = View.INVISIBLE
        botonD.visibility = View.INVISIBLE
        botonE.visibility = View.INVISIBLE
        botonF.visibility = View.INVISIBLE

        if (!botondec.isEnabled) {
            if (pantalla.text == "") {
                pantalla.text = "0"
            } else {
                try {
                    var toBi = pantalla.text.toString().toLong()
                    pantalla.setText(Integer.toBinaryString(toBi.toInt()))
                } catch (ae: NumberFormatException) {
                    Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                        .show()
                    pantalla.text = "0"
                }

            }
        }

        if (!botonhex.isEnabled) {
            try {
                var toDec = hexadecimal(pantalla.text.toString())
                pantalla.setText(Integer.toBinaryString(toDec.toInt()))
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                pantalla.text = "0"
            }

        }

        botonbin.setEnabled(false)
        botondec.setEnabled(true)
        botonhex.setEnabled(true)
    }

    fun decimal(view: View) {
        Toast.makeText(applicationContext, "Modo DECIMAL activado", Toast.LENGTH_SHORT)
            .show()

        boton2.visibility = View.VISIBLE
        boton3.visibility = View.VISIBLE
        boton4.visibility = View.VISIBLE
        boton5.visibility = View.VISIBLE
        boton6.visibility = View.VISIBLE
        boton7.visibility = View.VISIBLE
        boton8.visibility = View.VISIBLE
        boton9.visibility = View.VISIBLE

        botonA.visibility = View.INVISIBLE
        botonB.visibility = View.INVISIBLE
        botonC.visibility = View.INVISIBLE
        botonD.visibility = View.INVISIBLE
        botonE.visibility = View.INVISIBLE
        botonF.visibility = View.INVISIBLE

        if (!botonbin.isEnabled) {
            try {
                var toBi = pantalla.text.toString().toLong()
                var a = binarioadecimal(toBi)
                pantalla.setText(a.toString())
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                pantalla.text = "0"
            }
        }
        if (!botonhex.isEnabled) {
            try {
                var toDec = hexadecimal(pantalla.text.toString())
                pantalla.setText(toDec.toString())
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                pantalla.text = "0"
            }
        }
        botonbin.setEnabled(true)
        botondec.setEnabled(false)
        botonhex.setEnabled(true)
    }

    fun hex(view: View) {
        Toast.makeText(applicationContext, "Modo HEXADECIMAL activado", Toast.LENGTH_SHORT)
            .show()
        boton2.visibility = View.VISIBLE
        boton3.visibility = View.VISIBLE
        boton4.visibility = View.VISIBLE
        boton5.visibility = View.VISIBLE
        boton6.visibility = View.VISIBLE
        boton7.visibility = View.VISIBLE
        boton8.visibility = View.VISIBLE
        boton9.visibility = View.VISIBLE

        botonA.visibility = View.VISIBLE
        botonB.visibility = View.VISIBLE
        botonC.visibility = View.VISIBLE
        botonD.visibility = View.VISIBLE
        botonD.visibility = View.VISIBLE
        botonF.visibility = View.VISIBLE

        if (!botonbin.isEnabled) {

            try {
                var toBi = pantalla.text.toString().toLong()
                var toDec = binarioadecimal(toBi)
                pantalla.setText(Integer.toHexString(toDec))
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                pantalla.text = "0"
            }
        }
        if (!botondec.isEnabled) {
            try {
                var toDec = hexadecimal(pantalla.text.toString())
                pantalla.setText(Integer.toHexString(toDec.toInt()))
            } catch (ae: NumberFormatException) {
                Toast.makeText(applicationContext, "Numero demasiado largo", Toast.LENGTH_LONG)
                    .show()
                pantalla.text = "0"
            }
        }
        botonbin.setEnabled(true)
        botondec.setEnabled(true)
        botonhex.setEnabled(false)
    }


}