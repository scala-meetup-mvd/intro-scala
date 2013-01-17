

object OptionAndErrorHandling extends App {

  // Definamos un alias.
  type ErrorHandler = PartialFunction[Throwable,Unit]

  // Definamos un error handler (un partial function)
  val defaultErrorHandler: ErrorHandler = {
    case e: Exception => e.printStackTrace(); throw e
  }

  // Definamos otro error handler (un partial function)
  val NoSuchElementHandler: ErrorHandler = {
    case nse: java.util.NoSuchElementException => println ("El elemento no existe")
  }


  // Saves you from null
  val mapa = Map ( 1 -> "a", 2 -> "b", 3 -> "c")

  // Map is a function from keys to values
  // Estas llamadas no revientan porque sabemos que los valores existen.
  val a = mapa(1)
  val b = mapa(2)
  val c = mapa(3)

  // Pero esta si revienta
  try {
    val x = mapa(4)
  }
  catch NoSuchElementHandler orElse defaultErrorHandler

  //Safe call, returns an option
  val cuatro = mapa.get(4)

  cuatro match {
    case Some(value)  => println(s" We got a value: $value")
    case None         => println( s"We got none" )
  }

  // We can do better:
  val defaulting = cuatro.getOrElse("d")
  println( s"We got: $defaulting" )

  // Wrap unsafe calls
  val userhome = System.getProperty( "user.home" )
  println( s"User home: ${userhome.toUpperCase} " )

  //What if we don't have the property? getProperty returns null
  val usercar = Option(System.getProperty("user.casa")).getOrElse("").toUpperCase

  val data = for {
    home    <- Option(System.getProperty( "user.home" ))
    office  <- Option(System.getProperty("user.office"))
  } yield ( home, office )

  println( s"User data $data" )

}


object EitherAndErrorHandling extends App {

  val mapa = Map ( 1 -> "a", 2 -> "b", 3 -> "c")

  def read(i:Int): Either[Throwable,String] =
    try {
      Right(mapa(i))
    } catch {
      case e: Exception => Left(e)
    }

  read(1) match {
    case Right(c) => println(s"We got '$c'")
    case Left(e)  => println(s"Something went wrong ${e.getMessage}")
  }

  read(6) match {
    case Right(c) => println(s"We got $c")
    case Left(e)  => println(s"Something went wrong ${e.getMessage}")
  }

  // We can do better, let's use HOFs
  read(2) fold(
      e => println(s"Something went wrong ${e.getMessage}"),
      c => println(s"We got $c")
    )

  read(22).fold(
    e => println(s"Something went wrong ${e.getMessage}"),
    c => println(s"We got $c")
   )

}
