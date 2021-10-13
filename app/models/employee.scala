package models

import play.api.libs.json._
import reactivemongo.bson.BSONObjectID
import reactivemongo.play.json._
//import reactivemongo.play.json.compat._

case class employee(
                     _id: Option[BSONObjectID],
                     name: String,
                     sex: String,
                     team: String
                   )

object employee {

  implicit val fmt : OFormat[employee] = Json.format[employee]

}

