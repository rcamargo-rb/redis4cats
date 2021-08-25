import Repository._
import cats.effect.{ExitCode, IO, IOApp}

object Redis4Cats extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    Connection.redis
      .use { redis =>
        for {
          _ <- simpleSet(redis)
          _ <- get(redis).flatTap(IO.println)
        } yield ()
      }
      .as(ExitCode.Success)
  }

}
