

// Algunos ejemplos simples de funciones de alto orden.
object Funciones extends App {

  val lista       = List(1,2,3,4,5)
  val duplicada   = lista.map( i => i*2 )

  println( s"$lista, duplicada $duplicada")

  // Las funciones son valores.
  val triplica      = (i:Int) => i*3
  val triplicada    = lista.map(triplica)

  println( s"$lista, triplicada $triplicada" )

  val duplica     = (i:Int) => i*2
  val cuadruplica = (i:Int) => i*4

  // Composición funcional!
  val muchifica = duplica andThen triplica andThen cuadruplica
  val mucho     = lista map muchifica

  println( s"$lista, muchificada $mucho " )

}

// Todos los números entre cero y hasta que suma suma.
object ForComprehensions extends App {

  def paresQueSuman(hasta: Int, suma: Int) =
    for (i <- 0 until hasta;
         j <- i + 1 until hasta if i + j == suma) yield (i, j)

  // Sneak peak al pattern matching!
  paresQueSuman(20, 32) foreach {
    case (i, j) =>
      println("(" + i + ", " + j + ")")
  }

}


object CurryAndPartialApplications {

  val lista = List(1,2,3,4,5)

  val mult = (a: Int, b:Int) => a*b

  val duplica     = mult(_:Int, 2)
  val triplica    = mult(_:Int, 3)
  val cuadruplica = mult(_:Int, 4)

  val compuesta = duplica andThen triplica andThen cuadruplica
  val mucho     = lista map compuesta

  println( s"$lista, muchificada $mucho " )

}

object LiftingMethods extends App {

  val lista = List(1,2,3,4,5)

  def mult(a: Int, b:Int) = a*b

  // Acá el subguión dice que no le importan los parámetros
  //  y que quiere la función no el resultado.
  def multFun = (mult _).curried

  val duplica     = multFun(2)
  val triplica    = multFun(3)
  val cuadruplica = multFun(4)

  val compuesta = duplica andThen triplica andThen cuadruplica
  val mucho     = lista map compuesta

  println( s"$lista, muchificada $mucho " )

}

// Azúcah!
object FunctionsAreObjects extends App {

  val lista = List(1,2,3,4,5)

  class MultiplicaPor(a:Int) extends (Int => Int) {
    def apply(b: Int): Int = b*a
  }

  val duplica       = new MultiplicaPor(2)
  val triplica      = new MultiplicaPor(3)
  val cuadruplica   = new MultiplicaPor(4)

  val compuesta = duplica andThen triplica andThen cuadruplica
  val mucho     = lista map compuesta

  println( s"$lista, muchificada $mucho " )

}

