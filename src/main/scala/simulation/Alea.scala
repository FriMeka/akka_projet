package simulation
import scala.util.Random
object Alea {
  def nombreAlea(moy:Double,range:Double): Double = {
    val r=new Random()
    r.nextDouble()*range+(moy-0.5*range)
  }
  def AleaGauss(moy:Double,range:Double):Double={
    val r=new Random()
    r.nextGaussian()*range+moy
  }
}
