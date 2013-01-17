
object Operators extends App {

  class Entero(val i:Int) extends AnyVal {
    def +(otro:Entero) = Entero(i+otro.i)
    def *(otro:Entero) = Entero(i*otro.i)

    override def toString() = i.toString

  }

  object Entero {
    def apply(i:Int) = new Entero(i)
  }

  val uno = Entero(1)
  val dos = Entero(2)

  val tres = uno + dos
  println( s"Uno mas dos es $tres")

  val cuatro = dos * dos
  println( s"Dos mas dos es $cuatro")

}
