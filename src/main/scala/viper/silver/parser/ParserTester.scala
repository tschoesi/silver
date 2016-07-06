package viper.silver.parser

import java.nio.file.Path

import viper.silver.parser.Parser.RecParser

import scala.collection.mutable

/**
  * Created by sahil on 24.05.16.
  */
object ParserTester extends BaseParser {
  override def file = _file
  var _file: Path = null
  def main(args: Array[String]) {
    parse("", null)
  }

  def parse(s: String, f: Path) = {

    val rp = RecParser(f)
    rp.parse(s) match {
      case rp.Success(a, b) => {
        println(a)
        Success(a, b)
      }
      case rp.Failure(a, b) => Failure(a, b)
      case rp.Error(a, b) => Error(a, b)
    }
  }

  case class RecParser(file: Path) extends BaseParser {
    def parse(s: String) = parseAll(parser, s)
  }
}