
//
//   CLASS DECLARATIONS
//


// Representamos una persona.
// Mas o menos lo mismo de siempre.
// Podemos mejorar ...
class Person( _nombre: String, _apellido: String, _edad: Int ) {

  var nombre    = _nombre
  var apellido  = _apellido
  var edad      = _edad

}

// No hay necesidad de declarar los vars en el cuerpo de la clase.
// Pero aún podemos mejorar ...
class Person2( var nombre: String, var apellido: String, var edad: Int )

// Mejor que los miembros sean inmutables ...
class Person3( val nombre: String, val apellido: String, val edad: Int )


// Metodos
class Calculadora {

  def suma(a: Int, b: Int) = a+b
  def producto(a: Int, b: Int) = a*b

}


//
//   OBJECTS
//
//   Objects son singletons. Unicos miembros de su propia clase.
//

// Un singleton puede ser usado como módulo.
// Siempre es bueno usarlos cuando solo vamos a tener (obviamente) una sola instancia
//  de una clase que no depende de valores (via constructor).
object SingletonCalculadora {

  // Método
  def sum(a: Int, b: Int) = a+b

}

class Calculadora2 {
  import SingletonCalculadora._
  def suma(a:Int, b:Int) = sum(a,b)
}

//
//   traits
//
//   Básicamente son interfaces con implementación.
//   La diferencia con una clase abstracta es que no tienen constructores y
//      que se pueden extender todos los traits que quieras pero no mas de una clase.
//


trait T1 {
  def computeSomething(a:Int) = a*2 // With an implementation!
}


class A(a:Int)

class B1 extends T1

class B2(a:Int) extends A(a) with T1

//class B2 extends A
// No compila por: Unspecified value parameter a.
//class B2 extends T1 with A
// No compila por: class A needs to be a trait to be mixed in


trait T2 {
  def computeSomething(a:Int) = compute( a ) // With an implementation!
  def compute(a:Int): Int                    // Abstract: does not provide implementation.
}

//class B3 extends T2
// No compila: class B3 needs to be abstract, since method compute in trait T2 of type (a: Int)Int is not defined

class B3 extends T2 {
  def compute(a:Int) = a*2
}

class AssortedSamples {

  def suma(a:Int, b:Int) = a+b                // infiere el tipo de retorno

  def sideEffects(a:Int): Unit = println(a)   // Unit es como void

  def sideEffects2(a:Int) { println(a) }      // Notese que no tiene "=". Quiere decir que retorna Unit

}

// Como se resuelve la herencia múltiple?
/**
  Example5.1.3 Considerthefollowingclassdefinitions.
  abstract class AbsIterator extends AnyRef { ... }
  trait RichIterator extends AbsIterator { ... }
  class StringIterator extends AbsIterator { ... }
  class Iter extends StringIterator with RichIterator { ... }
  Then the linearization of class Iter is
  { Iter, RichIterator, StringIterator, AbsIterator, ScalaObject, AnyRef, Any }
*/

