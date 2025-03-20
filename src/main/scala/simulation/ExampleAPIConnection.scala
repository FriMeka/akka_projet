package simulation
import yahoofinance.controller.YahooStockData
import yahoofinance.util.Config
import avs.Api
object ExampleAPIConnection {
  def main(args: Array[String]): Unit = {
    /*
    val controller = YahooStockData.loadFromTicker("AAPL")
    val response = controller.getResponse
    println(response.currPrice)
    */




    val api=new Api("G8FTXLSXEWGRL2BM")
    val result=api.timeSeriesDaily("MSFT")

    result.timeSeries match {
      case None => println("It didn't work! Check input parameters, or rawJson.")
      case Some(ts) => ts.prices.map(p => p.price.open).foreach(println)

    }

    //val timeSeries=result.timeSeries.slice(0,9)
    //val prices=timeSeries.map(ts=>ts.prices.map(p=>p.price.open))
    //println(prices)
    //println(MoyenneMobile.moyMobile(prices,2))
    val li=List(93.25,
    92.75,
    92.94,
    92.31,
    91.81,
    84.81,
    89.75,
    88.12,
    88.25,
    89.75)

    println(MoyenneMobile.moyMobile(li,2))
    val dates=Array("1999-11-01",
      "1999-11-02",
      "1999-11-03",
      "1999-11-04",
      "1999-11-05",
      "1999-11-08",
      "1999-11-09",
      "1999-11-10",
      "1999-11-11",
      "1999-11-12")
    ListeDate.listeDate(dates).foreach(d=>println(d))
  }
}
