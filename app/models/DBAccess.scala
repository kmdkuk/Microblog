package models

import javax.inject._
import play.api.mvc._
import play.api.db._
import play.api.libs.json.Json
import anorm._
import anorm.SqlParser._

case class User(id: String, name: String)
object User {
  implicit val jsonWrites = Json.writes[User]
  implicit val jsonReads = Json.reads[User]
}

@Singleton
class DBAccess @Inject()(db: Database) {
  val userParser = str("id") ~ str("name")
  val userMapper = userParser.map {
    case id~name => User(id,name)
  }

  def userList: List[User] = {
    db.withConnection { implicit c =>
      SQL("SELECT id, name FROM test_users").as(userMapper.*)
    }
  }
}