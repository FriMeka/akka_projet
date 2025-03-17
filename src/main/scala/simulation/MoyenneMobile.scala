package simulation
import scala.annotation.tailrec
class MoyenneMobile {
  private def moyenne(l:List[Double]):Double={
    l.sum/l.length
  }
  @tailrec
  final def moyMobile(l:List[Double], size:Int, acc:List[Double]=Nil):List[Double]={
    if(l.length<size)
      acc
    else
      moyMobile(l.slice(1,l.size),size,acc:::List(moyenne(l.slice(0,size))))
  }
}

