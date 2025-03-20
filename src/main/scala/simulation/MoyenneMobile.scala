package simulation
import scala.annotation.tailrec
object MoyenneMobile {
  private def moyenne(l:List[Double]):Double={
    l.sum/l.length
  }
  /*
    Return the moving mean the list l with window size equal to the parameter size
   */
  @tailrec
  def moyMobile(l:List[Double], size:Int, acc:List[Double]=Nil):List[Double]={
    if(l.length<size)
      acc
    else
      moyMobile(l.slice(1,l.size),size,acc:::List(moyenne(l.slice(0,size))))
  }



}

