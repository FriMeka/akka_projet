package yahoofinance.controller

import org.jsoup.nodes.Document

import yahoofinance.jsoup.YahooStockDataParser
import yahoofinance.model.YahooStockResponse

class YahooStockData(parser: YahooStockDataParser, ticker: String = "") {

  /**
   * Gets response from parser
   * @return YahooStockResponse
   */
  def getResponse: YahooStockResponse = {
    new YahooStockResponse(
      ticker = ticker,
      currPrice = parser.getCurrPrice,
      dayChange = parser.getDayChange,
      open = parser.getOpen,
      prevClose = parser.getPrevClose,
      peRatio = parser.getPeRatio,
      beta = parser.getBeta,
      marketCap = parser.getMarketCap,
      yearRange = parser.getYearRange,
      avgVolume = parser.getAvgVolume,
      volume = parser.getVolume,
      askInfo = parser.getAskInfo,
      bidInfo = parser.getBidInfo,
      daysRange = parser.getDaysRange,
      eps = parser.getEps,
      // The below four fields are sometimes
      // broken depending on what you are viewing.
      // This data should likely not be depended on.
      earningsDate = parser.getEarningsDate,
      forwardDividendYield = parser.getForwardDividendYield,
      yearTargetEst = parser.getYearTargetEst,
      exDividendDate = parser.getExDividendDate
    )
  }
}

object YahooStockData {

  /**
   * Loads a controller instance from a ticker
   * @return YahooStockData controller
   */
  def loadFromTicker(ticker: String): YahooStockData = {
    val parser = YahooStockDataParser
      .loadFromTicker(ticker)
      .get
    new YahooStockData(parser, ticker)
  }

  /**
   * Loads a controller instance from an existing document
   * Useful for testing or other local use cases
   * @return YahooStockData controller
   */
  def loadFromDocument(document: Document): YahooStockData = {
    val parser = YahooStockDataParser
      .loadFromDocument(document)
      .get
    new YahooStockData(parser)
  }
}