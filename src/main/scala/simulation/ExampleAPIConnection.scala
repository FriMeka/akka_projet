package simulation
import yahoofinance.controller.YahooStockData
import yahoofinance.util.Config
import avs.Api
object ExampleAPIConnection {
  def main(args: Array[String]): Unit = {

    /*val controller = YahooStockData.loadFromTicker("AAPL")
    val response = controller.getResponse
    println(response.currPrice)*/

    val api=new Api("G8FTXLSXEWGRL2BM")
    val result=api.timeSeriesDaily("MSFT")
    result.timeSeries match {
      case None => println("It didn't work! Check input parameters, or rawJson.")
      case Some(ts) => ts.prices.map(p => p.price.open).foreach(println)
    }
  }
}
