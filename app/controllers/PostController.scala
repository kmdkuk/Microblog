package controllers

import javax.inject._
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import anorm._

import models._



/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class PostController @Inject()(cc: ControllerComponents, db: DBAccess) extends AbstractController(cc) {
  val posts = "hello world"
  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(db.userList))
  }

  def explore() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(posts))
  }

  def tutorial() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.toJson(posts))
  }

}