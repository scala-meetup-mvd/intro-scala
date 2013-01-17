
//
// Este documento es muy bueno, ofrece una buena recorrida por la librería
//   y tiene un apartado sobre rendimiento (BigO) de cada una.
// http://docs.scala-lang.org/overviews/collections/introduction.html
//
object SimpleCollections extends App {

  // Prácticos constructores para tipos comunes
  val lista   = List(1,2,3,4,5,5)
  val vector  = Vector(1,2,3,4,5,6)
  val mapa    = Map( 1 -> "a", 2 -> "b", 3 -> "c" )

  //Tuplas
  val fedeT    = ( "Federico", 40  )
  val matíasT  = ( "Matías",   2   )

  val nombres: Seq[String] = List( fedeT, matíasT ) map ( t => t._1 )
  println( s"Nombres: $nombres" )

  val edades: Seq[Int] = List( fedeT, matíasT ) map ( t => t._2 )
  println( s"Edades: $edades" )

  val bienvenida = s"${nombres.mkString(", ")}, les doy la bienvenida"
  println(bienvenida)

  val personas = List(fedeT,matíasT)

  // val (menores, mayores) = personas filter ( t => t._1 > 19 ) // Error
  val (mayores, menores) = personas partition ( t => t._2 > 19 )

  println( s"Mayores y menores segregados: $mayores, $menores")

}


// Las colecciones que usamos hasta ahora son persistentes.
// Esto quiere decir que son inmutables, no se hacen updates destructivos, in-place.
// Cada update genera una colección nueva.
// Pero a no temer, no se copia toda la colección, se usa una estructura interna que se
// comparte y cada referencia "ve" una parte de la colección de acuerdo a la operación aplicada.
object FunctionalUpdates extends App {

  val lista = List(1,2,3)
  println( s"Lista: $lista" )

  val lista2 = 0 +: lista
  println( s"Lista2: $lista2" )

  val lista3 = lista2 drop 1
  println( s"Lista3: $lista3" )

  println( s"Son iguales lista3 y lista? : ${lista3 == lista }")
  println( s"Son la misma lista3 y lista?: ${ lista3.eq( lista ) }")

  val lista4 = List( 1, 2, 3 )
  println( s"Son iguales lista4 y lista? : ${lista4 == lista }")
  println( s"Son la misma lista4 y lista?: ${ lista4 eq  lista  }")

}


object ParCollections extends App {

  import Benchmark._

  val range     = (1 to 50).toList

  val duplicar  = (i:Int) => i*2

  val dormir    = (i:Int) => {
    Thread.sleep( i )
    i
  }
  val duplicarLento = duplicar andThen dormir

  val duplicadoSecuencial = time( "Duplicado Secuencial" ) {
    range map duplicar
  }
  println( s"Result: $duplicadoSecuencial" )

  val duplicadoParalelo = time( "Duplicado Paralelo" ) {
    range.par map duplicar
  }
  println( s"Result: $duplicadoParalelo" )

  val duplicadoSecuencialLento = time( "Duplicado Secuencial Lento" ) {
    range map duplicarLento
  }
  println( s"Result: $duplicadoSecuencialLento" )

  val duplicadoParaleloLento = time( "Duplicado Paralelo Lento" ) {
    range.par map duplicar
  }
  println( s"Result: $duplicadoParaleloLento" )

}



