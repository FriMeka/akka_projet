package simulation

class RegressionLin {
  def estimateCoef(y:List[Double],t:List[Double]):List[Double]={
    //retourne le a et b estimé dans l'equation y(t)= at + b
    val moyY=y.sum/y.length
    val moyT=t.sum/t.length



    val covariance =y.lazyZip(t).map(_*_).sum-t.length*moyT*moyY
    val variance = t.foldLeft(0.0)((acc,x)=>acc+x*x)-t.length*moyT*moyY

    val a=covariance/variance
    val b=moyY-a*moyT

    List(a,b)
  }
  def predict(y:List[Double],t:List[Double],t_future:Double):Double={
    val coef = estimateCoef(y,t)
    coef(1)+coef(0)*t_future
  }
}
