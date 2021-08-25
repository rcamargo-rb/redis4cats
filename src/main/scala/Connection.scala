import cats.effect.IO
import cats.effect.kernel.Resource
import dev.profunktor.redis4cats.{Redis, RedisCommands}
import dev.profunktor.redis4cats.effect.Log.Stdout.instance

object Connection {

  def redis: Resource[IO, RedisCommands[IO, String, String]] = Redis[IO].utf8("redis://localhost:6379")
}
