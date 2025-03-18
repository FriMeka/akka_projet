package simulation
import stockdata.controller.YahooStockData
import stockdata.util.Config
object test {
  def main(args: Array[String]): Unit = {

    val controller = YahooStockData.loadFromTicker("AAPL")
    val response = controller.getResponse
    println(response.currPrice)


  }
}
