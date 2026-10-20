package models

// A "model" is just a simple container for data.
// This one represents a single product with an id, a name and a price.
case class Product(id: Long, name: String, price: BigDecimal)
