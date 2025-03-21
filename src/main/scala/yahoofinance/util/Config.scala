package yahoofinance.util

import com.typesafe.config._

import java.io.File

object Config {

  /**
   * com.typesafe.config config instance
   */
  private val conf = ConfigFactory.parseFile(new File("application.conf"))

  /**
   * Wrapper method for typesafe config to return null
   * upon config not found rather than throwing an exception
   * @param path the path to the desired configuration
   * @return value of the config
   */
  def getString(path: String): String = {
    try {
      conf.getString(path)
    } catch {
      case e: Throwable => null
    }
  }
}