

// Algunos ejemplos simples de funciones de alto orden.
object Funciones extends App {



  val lista       = List(1,2,3,4,5)
  val duplicada   = lista.map( i => i*2 )

  println( s"$lista, duplicada $duplicada")

  //functions are values
  val triplica      = (i:Int) => i*3
  val triplicada    = lista.map(triplica)

  println( s"$lista, triplicada $triplicada" )

  val duplica     = (i:Int) => i*2
  val cuadruplica = (i:Int) => i*4

  // Composición funcional!
  val compuesta = duplica andThen triplica andThen cuadruplica
  val mucho = lista map compuesta

  println( s"$lista, muchificada $mucho " )

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

  def multFun = mult _

  val duplica     = multFun(_:Int, 2)
  val triplica    = multFun(_:Int, 3)
  val cuadruplica = mult(_:Int, 4)

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

