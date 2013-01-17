
object Operators extends App {

  // Porque extiende AnyVal esta clase no "boxea" el int.
  // El constructor es privado ... ver abajo.
  class Entero private (val i:Int) extends AnyVal {
    //Operators are methods
    def +(otro:Entero) = Entero(i+otro.i)
    def *(otro:Entero) = Entero(i*otro.i)

    // Alcanza con que tenga un solo parámetro
    def mas(otro:Entero) = Entero(i+otro.i)

    override def toString() = i.toString

  }

  // Objeto con el mismo nombre que la clase,
  //   declarado en el mismo archivo que la clase,
  //   se llama companion y puede ver las partes privadas de
  //   la clase homónima.
  //   Se usa comunmente como factory;
  //    en este caso es una función que puedo usar sin necesidad de new
  object Entero {
    def apply(i:Int) = new Entero(i)
  }

  val uno = Entero(1)
  val dos = Entero(2)

  val tres = uno + dos
  println( s"Uno mas dos es $tres")

  val cuatro = dos * dos
  println( s"Dos mas dos es $cuatro")

  val seis = tres mas tres
  println( s"Tres mas tres es $seis" )

}
