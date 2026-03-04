# Código referente al segundo lab de algoritmos 3. Brian Orta 21-10447

## Instrucciones de uso:
Colocar el archivo Sudoku.kt, el archico sudoku.sh y el makefile en una carpeta, ejecutar el comando "make" para crear el archivo .jar y luego usar el comando "./sudoku.sh <entrada_sudoku>", donde entrada_sudoku es una cadena de 81 caracteres numéricos.

## Descripción del programa:
Este programa usa la estrategia conocida como "Backtracking" inspirada por algoritmos vistos en clase para encontrar una solución para un sudoku, si es que existe.

Al recibir el string de entrada, primero el programa lo convierte en una matriz 9x9 para mejor legibilidad y facilidad de uso. Luego, llama a la función "solver" para iniciar el proceso de solución. Solver itera sobre todas las celdas de la matriz buscando alguna que tenga el valor 0 (cuadro vacío), al encontrar un 0, va probando reemplazarlo con cada número del 1 al 9 hasta que encuentre uno valido, la prueba conciste en en relizar la sustitución, llamar a la función "isValid" que verifica que después del cambio todavía se cumplan las reglas del sudoku, y de ser así, retornar la matriz modificada y pasar a la siguiente celda vacía. Si en algún momento el algoritmo no encuentra números que probar y no ha llegado a una solución, revierte su movimiento anterior y prueba otra opción. Este proceso se cumple hasta que logre reemplazar todos los 0 de la matriz o se quede sin opciones. Si logra sustituir todos los 0, retorna la matriz solucionada, si no, returna null.

Finalmente, si el algoritmo recibe la matriz solución, la convierte de nuevo en un string y lo imprime, si retorna null, imprime "NOSOLUTION".
