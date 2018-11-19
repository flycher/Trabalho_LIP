package interacao

class Entrada {

  def readInt: Int = {
    var inteiro: Int = 0
    try {
      inteiro = scala.io.StdIn.readInt()
    } catch {
      case _ : NumberFormatException => {
        println("Insira uma opcao valida.")
        inteiro = readInt
      }
    }
    inteiro
  }

  def readDouble: Double = {
    var flutuante: Double = 0
    try {
      flutuante = scala.io.StdIn.readDouble()
    } catch {
      case _ : NumberFormatException => {
        println("Insira uma opcao valida.")
        flutuante = readDouble
      }
    }
    flutuante
  }

  def readBoolean: Boolean = {
    var booleano: String = "none"
    booleano = scala.io.StdIn.readLine()
    if (booleano == "true") {
      true
    } else if (booleano == "false") {
      false
    } else {
      println("Insira uma opcao valida.")
      readBoolean
    }
  }
}
