fun isValid(sudoku: MutableList<MutableList<Int>>, row: Int, col: Int, num: Int): Boolean {
    for (i in 0..8) {
        if (sudoku[row][i] == num || sudoku[i][col] == num) {
            return false
        }
    }

    val box_X_start = row - row % 3
    val box_Y_start = col - col % 3
    for (i in box_X_start until box_X_start + 3) {
        for (j in box_Y_start until box_Y_start + 3) {
            if (sudoku[i][j] == num) {
                return false
            }
        }
    }
    return true
}

fun solver(sudoku: MutableList<MutableList<Int>>): MutableList<MutableList<Int>>? {
    for (i in sudoku.indices) {
        for (j in sudoku[i].indices) {
            if (sudoku[i][j] == 0) {
                for (num in 1..9) {
                    if (isValid(sudoku, i, j, num)) {
                        sudoku[i][j] = num
                        val result = solver(sudoku)
                        if (result != null) {
                            return result
                        }
                        sudoku[i][j] = 0
                    }
                }
                return null
            }
        }
    }
    return sudoku
}

fun main(args: Array<String>) {
    if (args.isEmpty() || args.size > 1) {
        println("Por favor, proporciona una cadena de 81 dígitos como unico argumento.")
        return
    }
    
    val sudokustring = args[0]
    if (sudokustring.length != 81 || !sudokustring.all { it.isDigit() }) {
        println("La entrada no es valida, deben ser 81 digitos del 0 al 9.")
        return
    }

    val rows = sudokustring.chunked(9)
    var sudokutrix = rows.map { row -> row.map { it.toString().toInt() }.toMutableList() }.toMutableList()
    val solutiontrix = solver(sudokutrix)
    if (solutiontrix == null) {
        println("NOSOLUTION")
        return
    }

    val solutionstring = solutiontrix.flatten().joinToString("")
    println(solutionstring)
}