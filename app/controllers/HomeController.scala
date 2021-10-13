package controllers

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import play.api._
import play.api.mvc._
import play.api.libs.json._
import repo.CompanyRepo
import models.employee
import reactivemongo.api.bson.{ BSONDocument, BSONObjectID}
//import reactivemongo.bson.BSONDocument

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(
                              implicit executionContext: ExecutionContext,
                              cc: ControllerComponents,
                              companyRepo: CompanyRepo
                              ) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
  
  def explore() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.explore())
  }
  
  def tutorial() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.tutorial())
  }

  def hello() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.hello())
  }

//  def createEmp() = Action { implicit request =>
//    val postVals = request.body.asFormUrlEncoded
//    postVals.map{ args =>
//      val name = args("name").head
//      val sex = args("sex").head
//      val team = args("team").head
//      Ok(s"A $sex candidate named: $name is added in $team team")
//    }.getOrElse(Ok("Oops Something get Wrong!"))
//  }

//  def createEmp() = Action.async(parse.json) {
//    _.body.validate[employee]
//      .map {
//        post => companyRepo.insertEmp(post).map { _ =>
//          Created
//        }
//      }.getOrElse(Future.successful(BadRequest("Invalid format")))
//  }

  def createEmp() = Action { implicit request =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map{ args =>
        val name = args("name").head
        val sex = args("sex").head
        val team = args("team").head

        val post = reactivemongo.bson.BSONDocument(
          "name" -> name,
          "sex" -> sex,
          "team" -> team
        )
        companyRepo.insertEmp(post)

        Created(s"A $sex candidate named: $name is added in $team team")
      }.getOrElse(BadRequest("Oops Something get Wrong!"))
    }

  def empList(): Action[AnyContent] = Action.async {
    Ok(s"This is employee List")
    companyRepo.list().map {
      emps => Ok(Json.toJson(emps))
    }
  }

  def getEmp(name: String): Action[AnyContent] = Action.async {
    Ok(s"This is employee by name")
    companyRepo.findEmp(name).map{
      emps => Ok(Json.toJson(emps))
    }
  }
// Inactive issue id Data conversion [ Must be Converted into DocumentObjectId at route level ]
  def getEmpById(id: reactivemongo.bson.BSONObjectID): Action[AnyContent] = Action.async {
    Ok(s"This is employee by id")
    companyRepo.findEmpById(id).map{
      emps => Ok(Json.toJson(emps))
    }
  }

  def updateEmp() = Action { implicit request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map{ args =>
      val O_name = args("Older_Name").head
      val name = args("name").head
      val sex = args("sex").head
      val team = args("team").head

      val post = reactivemongo.bson.BSONDocument(
        "name" -> name,
        "sex" -> sex,
        "team" -> team
      )
      companyRepo.updateEmp(O_name, post)

      Ok(s"A $sex candidate named: $O_name is changed to name: $name and added in $team team. [ information is Updated Successfully! ]")
    }.getOrElse(Ok("Oops Something get Wrong!"))
  }

  def removeEmp() = Action { implicit request =>
    val postVals = request.body.asFormUrlEncoded
    postVals.map{ args =>
      val name = args("name").head
      companyRepo.deleteEmp(name)

      Ok(s"A candidate named: $name is deleted. [ Candidate is deleted Successfully! ]")
    }.getOrElse(Ok("Oops Something get Wrong!"))
  }

}
