import cats.effect.{ExitCode, IO, IOApp}
import Repository._
import dev.profunktor.redis4cats.transactions.RedisTransaction
import dev.profunktor.redis4cats.effect.Log.Stdout.instance
import dev.profunktor.redis4cats.hlist.HNil

object Transactions extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    Connection.redis.use { redis =>
      val tx = RedisTransaction(redis)
      val commands = get(redis) :: get(redis) :: HNil

      tx.exec(commands).flatTap(IO.println)
    }.as(ExitCode.Success)
}
