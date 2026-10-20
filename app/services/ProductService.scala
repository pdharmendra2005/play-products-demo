package services

import javax.inject.Singleton
import models.Product

// A "service" holds the business logic / data access. In a real app this
// would talk to a database. Here we just use a small in-memory list so the
// example runs with no database setup.
@Singleton
class ProductService {

  private val products: Map[Long, Product] = Map(
    1L  -> Product(1L,  "Keyboard",  29.99),
    2L  -> Product(2L,  "Mouse",     14.50),
    42L -> Product(42L, "Monitor",  199.00)
  )

  // Returns Some(product) if found, or None if there is no product with that id.
  def findById(id: Long): Option[Product] = products.get(id)

  // Returns every product (used by the home page).
  def findAll(): Seq[Product] = products.values.toSeq.sortBy(_.id)
}
