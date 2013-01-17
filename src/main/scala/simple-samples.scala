

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

  // Could have also been this, as trys are also expressions.
  // val name = try {
  //              args(0)
  //            } catch {
  //              case e: ArrayIndexOutOfBoundsException => "Anonymous"
  //            }


  println( s"Hola, $name" )

}

object MiscLittleFeatures {

  val value = 1
  // value = 2 // NO COMPILA
  println( "Value = $value" )

  var variable = "1"
  variable = "2"
  println( "Variable = $variable" )

  val hereDocs =
    """
      |
      | Esto es un string enorme. Soporta interpolation: $value
      | stripMargin elimina de los pipes hacia la izquierda. Permite indentar.
      |
    """.stripMargin

}



