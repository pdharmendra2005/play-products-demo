package controllers

import javax.inject.Inject
import play.api.mvc._
import services.ProductService

// A "controller" is the traffic director. Each method (called an "action")
// handles one kind of request: it gathers data and returns a response.
//
// `@Inject()` asks Play to hand us the pieces we need (here: the
// ProductService and the ControllerComponents) — we don't build them ourselves.
class ProductController @Inject() (
    productService: ProductService,
    cc: ControllerComponents
) extends AbstractController(cc) {

  // This is the method the routes file points at for  GET /products/:id
  def show(id: Long): Action[AnyContent] = Action {
    productService.findById(id) match {
      // Found it -> respond 200 OK and render the product page with the data.
      case Some(product) =>
        Ok(views.html.product(product))

      // Not found -> respond 404 Not Found with a friendly message.
      case None =>
        NotFound(s"Sorry, no product found with id = $id")
    }
  }
}
