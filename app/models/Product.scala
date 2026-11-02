package models

import play.api.libs.json.{Json, OWrites}

// A "model" is just a simple container for data.
// This one represents a single product with an id, a name and a price.
case class Product(id: Long, name: String, price: BigDecimal)

object Product {
  // Teaches Play how to turn a Product into JSON:
  //   Product(42, "Monitor", 199.00)  ->  {"id":42,"name":"Monitor","price":199}
  // Json.writes looks at the case class fields and writes one JSON field per field.
  implicit val productWrites: OWrites[Product] = Json.writes[Product]
}
