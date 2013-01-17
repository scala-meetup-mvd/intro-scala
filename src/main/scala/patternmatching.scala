

object PatternMatching extends App {

  def matcher(x:Any) = x match {
    case 1        => "Es uno"
    case "A"      => "Es una A"
    case x:Int    => s"Es un Int cualquiera : $x"
    case x:String => s"Es un String cualquiera : $x "
    case x        => s"Es algo de lo que no se nada $x"
  }

  println(matcher("Hola"))
  println(matcher(1))
  println(matcher("Scala!"))
  println(matcher(2.0))
  println(matcher("A"))

}

// Los case classes permiten que se matchee y se extraigan los
// parámetros de construcción.
// El mecanismo en realidad es abierto y puede ser "enchufado" en tus propias clases.
object IntroducingCaseClasses extends App {

  case class Persona( nombre:String, edad: Int, favColor:String = "black")
  val personas = List( Persona("Federico", 40), Persona("Matías", 2, "red"), Persona("Markus", 35, "green") )

  personas.head match {
    case Persona(n, a, _) => println( s"Encontré a $n con $a años"  )
  }

  // Filtrar usando una guarda. (el if)
  val menores = personas collect {
    case Persona( n, a, _ ) if a < 19 => n
  }

  println( s"Los nombres de los menores son $menores" )

}


object Extractors extends App {

  case class Persona( nombre:String, edad: Int, favColor:String = "black")
  val personas = List( Persona("Federico", 40), Persona("Matías", 2, "red"), Persona("Markus", 35, "green") )

  val mayores = personas collect {
    case Mayor(n) => n
  }

  println( s"Lista de mayores "+mayores)

  val menores = personas collect {
    case Menor(n) => n
  }

  println( s"Lista de menores "+menores)

  object Menor {
    def unapply(p:Persona) = {
      if(p.edad < 19) Some(p.nombre)
      else None
    }
  }

  object Mayor {
    def unapply(p:Persona) = {
      if(p.edad > 19) Some(p.nombre)
      else None
    }
  }

}

