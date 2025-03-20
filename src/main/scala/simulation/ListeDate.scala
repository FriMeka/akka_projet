package simulation

import java.time.LocalDate

object ListeDate {

  //Takes a list of dates and returns a list with the number of days between the first date and each date in the list l
  def listeDate(l:Array[String]):Array[Double]={
    val fromDate=LocalDate.parse(l(0))
    l.foldLeft(Array.empty[Double])((acc,date)=>acc++Array((LocalDate.parse(date).toEpochDay-fromDate.toEpochDay).toDouble))
  }
}
