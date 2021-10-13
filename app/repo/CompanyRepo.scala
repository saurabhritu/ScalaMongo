package repo

//import reactivemongo.api.bson.BSONDocument
//import scala.concurrent.Future
//import scala.concurrent.ExecutionContext.Implicits.global
//import reactivemongo.api.{AsyncDriver, MongoConnection}
//import reactivemongo.api.bson.collection.BSONCollection

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import play.modules.reactivemongo.ReactiveMongoApi
import reactivemongo.play.json._
import reactivemongo.play.json.collection.JSONCollection
import reactivemongo.bson.{BSONDocument, BSONObjectID}
import reactivemongo.api.{Cursor, ReadPreference}
import models.employee
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.api.commands.WriteResult

class CompanyRepo @Inject()(
                           implicit executionContext: ExecutionContext,
                           val reactiveMongoApi: ReactiveMongoApi
                           ) {
  private def collection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection("employee"))

  def list(limit: Int = 100): Future[Seq[employee]]= {
    collection.flatMap(
      _.find(BSONDocument(),Option.empty[employee])
        .cursor[employee](ReadPreference.primary)
    .collect[Seq](limit, Cursor.FailOnError[Seq[employee]]())
    )
  }

  def insertEmp(post: BSONDocument): Future[WriteResult] = {
    collection.flatMap(_.insert.one(post))
  }


//  def insertEmp(post: employee): Future[WriteResult] = {
//    collection.flatMap(_.insert.one(post))
//  }

//  def read(id: BSONObjectID): Future[Option[BSONDocument]] ={
////    val query = BSONDocument("_id" -> BSONDocument("$eq" -> id))
////    collection.flatMap(_.find(BSONDocument("_id" -> id)).one[BSONDocument])
//  }

//  def findEmp(id: BSONObjectID, limit: Int = 100): Future[Seq[employee]]= {
//    collection.flatMap(
//      _.find(BSONDocument("_id" -> BSONDocument("$eq" -> id)), Option.empty[employee])
//        .cursor[employee](ReadPreference.primary)
//        .collect[Seq](limit, Cursor.FailOnError[Seq[employee]]())
//    )
//  }

  def findEmp(name: String, limit: Int = 100): Future[Seq[employee]]= {
    collection.flatMap(
      _.find(BSONDocument("name" -> BSONDocument("$eq" -> name)), Option.empty[employee])
        .cursor[employee](ReadPreference.primary)
        .collect[Seq](limit, Cursor.FailOnError[Seq[employee]]())
    )
  }

  def findEmpById(id: BSONObjectID, limit: Int = 100): Future[Seq[employee]]= {
    collection.flatMap(
      _.find(BSONDocument("_id" -> BSONDocument("$eq" -> id)), Option.empty[employee])
        .cursor[employee](ReadPreference.primary)
        .collect[Seq](limit, Cursor.FailOnError[Seq[employee]]())
    )
  }


  def updateEmp(name: String, post: BSONDocument ): Future[WriteResult]={
    collection.flatMap(
      _.update.one(BSONDocument("name"-> name), BSONDocument(
        f"$$set" -> BSONDocument(post)
      )
      )
    )
  }

  def deleteEmp(name: String): Future[WriteResult]={
    collection.flatMap(
      _.delete.one(BSONDocument("name"-> name)
      )
    )
  }

}
