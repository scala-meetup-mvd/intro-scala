

object Implicits extends App {

  implicit class BetterString(val s:String ) {
    def dashed = s"--$s"
  }

  println( "no-download" )

}
