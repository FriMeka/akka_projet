package simulation

object Estimation {
  def stockVal(numStock:Double,price:Double): Double = {
    numStock*price
  }

  def calcProfit(numStockBefore:Double,numStockAfter:Double,priceBefore:Double,priceAfter:Double): Double = {
    if(numStockAfter>numStockBefore) {
      val numStockBought = numStockAfter - numStockBefore
      stockVal(numStockAfter, priceAfter) - stockVal(numStockBefore, priceBefore) - numStockBought * priceBefore
    }
    else if(numStockAfter==numStockBefore) {
      stockVal(numStockAfter,priceAfter)-stockVal(numStockBefore,priceBefore)
    }
    else {
      val numStockSold = numStockBefore - numStockAfter
      stockVal(numStockAfter, priceAfter) - stockVal(numStockBefore, priceBefore) + numStockSold * priceBefore
    }
  }
}
