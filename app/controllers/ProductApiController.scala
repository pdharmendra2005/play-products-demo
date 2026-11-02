package controllers

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc._
import services.ProductService

// Same data as ProductController, but answers with JSON instead of an HTML page.
// This is what API tests (curl, Postman, REST Assured) talk to.
class ProductApiController @Inject() (
    productService: ProductService,
    cc: ControllerComponents
) extends AbstractController(cc) {

  def show(id: Long): Action[AnyContent] = Action {
    productService.findById(id) match {
      case Some(product) =>
        Ok(Json.toJson(product)) // 200 + Content-Type: application/json

      case None =>
        NotFound(Json.obj("error" -> "Product not found", "id" -> id)) // 404, still JSON
    }
  }
}
