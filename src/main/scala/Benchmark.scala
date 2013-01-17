/**
 * Created with IntelliJ IDEA.
 * User: f
 * Date: 17/01/13
 * Time: 13:27
 * To change this template use File | Settings | File Templates.
 */
object Benchmark {

  def time[T](label: String)( block: => T ):T = {
    val t1  = System.currentTimeMillis()
    val res = block
    val t2  = System.currentTimeMillis() - t1
    println( s" ${label.toUpperCase} : tiempo transcurrido: $t2 milisegundos." )
    res
  }

}
