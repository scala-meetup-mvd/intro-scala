

object Simplest extends App {
  // Esto en un shell o en un script no necesita siquiera un App.
  println( "Hola, Mundo" )

  val i     = 1
  val name  = "fede"
}

object AppWithParams extends App {

  // Everything is an expression
  val name =  if( args.length > 0 ) 
                args(0)
              else "Anonymous"

  // Podríamos haber hecho esto: el try es una expresión también.
  // val nombre = try {
  //              args(0)
  //            } catch {
  //              case e: ArrayIndexOutOfBoundsException => "Anonymous"
  //            }

  println( s"Hola, $name" )

}

object MiscLittleFeatures extends App {

  val value = 1
  // value = 2 // NO COMPILA
  println( s"Value = $value" )

  var variable = "1"
  variable = "2"
  println( s"Variable = $variable" )

  val hereDocs =
    s"""
      |
      | Esto es un string enorme. Soporta interpolation: $value
      |stripMargin elimina de los pipes hacia la izquierda. Permite indentar.
      |
    """.stripMargin

    println( "Long Text with margin:" + hereDocs)

  def parametersShowOff( nombre: String, edad: Int, color: String = "negro" ) = {
    println( s"$nombre tiene $edad años y gusta del color $color" )
  }

  parametersShowOff( edad = 40, nombre = "Federico" )

}



