import dev.profunktor.redis4cats.RedisCommands

import scala.util.Random

object Repository {
  type RedisIO[F[_], A] = RedisCommands[F, String, String] => F[A]

  def simpleSet[F[_]]: RedisIO[F, Unit] = _.set("abc", Random.nextInt().toString)

  def setNx[F[_]]: RedisIO[F, Boolean] = _.setNx("abc", Random.nextInt().toString)

  def get[F[_]]: RedisIO[F, Option[String]] = _.get("abc")

}
