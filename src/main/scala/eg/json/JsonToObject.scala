package eg.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.typesafe.scalalogging.LazyLogging

case class Person(name : String, age : Int)

case class Address(street : String, buildingNumber : Int, zipCode : Int)

case class Rent(amount : Double, month : String)

//there are many other case classes

object JsonToObject extends LazyLogging{

  import logger._

  def toJsonString(ref : Any) : String = {
    val gson = new Gson()
    val jsonString = gson.toJson(ref)
    jsonString
  }

  def main(args: Array[String]): Unit = {
    val person = Person("John", 35)
    val jsonString = toJsonString(person)

    //here requirement is to generate convert json string to case class instance, provided the type of case class instance

    val gsonObj = toInstanceUsingGson( jsonString, Person.getClass )
    debug(s"main : object deserialized using gson : $gsonObj")

    val jacksonObj = toInstanceUsingJackson( jsonString, Person.getClass )
    debug(s"main : object deserialized using gson : $jacksonObj")

  }

  def toInstanceUsingGson[T](jsonString : String, caseClassType : Class[T]) : T = {

    val gson = new Gson()
    val ref = gson.fromJson(jsonString, caseClassType)
    ref
  }

  def toInstanceUsingJackson[T](jsonString : String, caseClassType : Class[T]) : T = {

    val mapper = new ObjectMapper()
    val ref = mapper.readValue(jsonString, caseClassType)
    ref
  }
}
