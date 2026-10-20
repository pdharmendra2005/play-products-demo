package controllers

import javax.inject.Inject
import play.api.mvc._
import services.ProductService

// Handles the home page: shows a list of all products with links to each one.
class HomeController @Inject() (
    productService: ProductService,
    cc: ControllerComponents
) extends AbstractController(cc) {

  def index(): Action[AnyContent] = Action {
    Ok(views.html.index(productService.findAll()))
  }
}
