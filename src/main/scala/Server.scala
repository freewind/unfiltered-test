import unfiltered.request._
import unfiltered.response._

object Server extends App {

  val port = 8058

  val echo = unfiltered.filter.Planify {
    case Path("/") => ResponseString("Hello!")
    case Path(Seg(p :: Nil)) => ResponseString(p)
  }

  println(s"Will start on http://localhost:$port")

  unfiltered.jetty.Server.http(port).plan(echo).run()

}
