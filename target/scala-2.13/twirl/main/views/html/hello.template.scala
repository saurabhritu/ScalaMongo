
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object hello extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Hello")/*1.15*/ {_display_(Seq[Any](format.raw/*1.17*/("""
"""),format.raw/*2.1*/("""<section id="content">
    <div class="wrapper doc">
        <article>
            <h1 style="color: green;">HR Management [ CRUD ]</h1>

            <ul>
                <li><a href="/empList" target="_parent"><button>Employee List</button></a> </li>
            </ul>

            <h3>.</h3>

            <h4 style="color: green;">You can add employee here! <inline style="color: indianred;"> [ Create ]</inline></h4>
            <form action=""""),_display_(/*14.28*/routes/*14.34*/.HomeController.createEmp()),format.raw/*14.61*/("""" method="post">
                <input name="name" type="text" placeholder="Name">
                <input name="sex", type="text" placeholder="sex = M or F">
                <input name="team" type="text" placeholder="team">
                <button>Submit</button>
            </form>

            <h3>.</h3>

            <h4 style="color: green;">Search the employee! <inline style="color: indianred;"> [ Read ]</inline></h4>
            <form action="getEmp" method="get">
                <input name="name" type="text" placeholder="Search by Name">
                <button>Search!</button>
            </form>

            <h3>.</h3>

            <h4 style="color: green;">You can update employee's information here!<inlne style="color: indianred;"> [ Update ]</inlne> </h4>
            <form action=""""),_display_(/*32.28*/routes/*32.34*/.HomeController.updateEmp()),format.raw/*32.61*/("""" method="post">
                <input name="Older_Name" type="text" placeholder="Older Name">
                <input name="name" type="text" placeholder="New Name">
                <input name="sex", type="text" placeholder="sex = M or F">
                <input name="team" type="text" placeholder="team">
                <button>Update!</button>
            </form>

            <h3>.</h3>


            <h4 style="color: green;">You can remove employee from here! <inline style="color: indianred;"> [ Delete ]</inline></h4>
            <form action=""""),_display_(/*44.28*/routes/*44.34*/.HomeController.removeEmp()),format.raw/*44.61*/("""" method="post">
                <input name="name" type="text" placeholder="Candidate's Name!">
                <button>Delete!</button>
            </form>

            <h3>.</h3>

            <h4 style="color: green;">Search the employee by Id!</h4>
            <h5 style="color: red; font-weight: bold;">Warning: feature is Under Development !</h5>
            <form action="getEmpById" method="get">
                <input name="id" type="text" placeholder="Search by Id">
                <button>Submit</button>
            </form>

        </article>
        <aside>
            """),_display_(/*60.14*/commonSidebar()),format.raw/*60.29*/("""
        """),format.raw/*61.9*/("""</aside>
    </div>
</section>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/hello.scala.html
                  HASH: 9525ea8fd096e6387044fe1ee54ae0f4c6810257
                  MATRIX: 811->1|832->14|871->16|899->18|1385->477|1400->483|1448->510|2299->1334|2314->1340|2362->1367|2957->1935|2972->1941|3020->1968|3650->2571|3686->2586|3723->2596
                  LINES: 26->1|26->1|26->1|27->2|39->14|39->14|39->14|57->32|57->32|57->32|69->44|69->44|69->44|85->60|85->60|86->61
                  -- GENERATED --
              */
          