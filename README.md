# Play Products Demo

A tiny [Play Framework](https://www.playframework.com/) app built to teach the
**`GET /products/:id`** request flow, one step at a time.

It has just enough code to show the full journey of a web request:

```
Browser  →  conf/routes  →  Controller  →  Service (data)  →  View (HTML)  →  Browser
```

---

## What each file does (read these in order!)

| File | Role | What to look at |
|------|------|-----------------|
| `conf/routes` | The URL map | `GET /products/:id → ProductController.show(id)` |
| `app/controllers/ProductController.scala` | Traffic director | fetches the product, returns `Ok(...)` (200) or `NotFound(...)` (404) |
| `app/services/ProductService.scala` | The "data" | an in-memory list of 3 products (no DB needed) |
| `app/models/Product.scala` | Data shape | a product = id + name + price |
| `app/views/product.scala.html` | Builds the HTML | `@product.name` inserts the value into the page |
| `app/views/index.scala.html` | Home page | lists all products with links |
| `app/views/main.scala.html` | Shared layout | the common HTML shell |

---

## How to run it

You need **Java (JDK 11 or 17)** installed. Play uses **sbt** (the build tool),
which the project downloads automatically.

### Option A — command line
```bash
cd play-products-demo
sbt run
```
Then open **http://localhost:9000** in your browser.

### Option B — IntelliJ IDEA
1. **File → Open** and select this `play-products-demo` folder.
2. IntelliJ detects `build.sbt` and imports it as an **sbt project** (let it finish
   downloading dependencies — the first time is slow).
3. Open the **sbt shell** (View → Tool Windows → sbt shell) and type: `run`
   *(or use the Terminal and run `sbt run`)*.
4. Open **http://localhost:9000**.

> Tip: the **Scala plugin** should be installed in IntelliJ for the best
> experience (Settings → Plugins → search "Scala").

---

## Things to try (great for a tester!)

- Open **http://localhost:9000** → the home page lists all products.
- Open **http://localhost:9000/products/42** → the Monitor detail page (**200 OK**).
- Open **http://localhost:9000/products/1** → the Keyboard detail page.
- Open **http://localhost:9000/products/999** → a **404** (no such product) —
  see how the controller decides this.
- Open **http://localhost:9000/nope** → a different **404** (no matching *route*).

Notice the difference between the last two: one is "route matched but no data"
(handled in the controller) and one is "no route matched at all" (handled by Play).

## Hot reload

While `sbt run` is running, change some text in `app/views/product.scala.html`,
save, and refresh the browser. Play recompiles automatically — no restart needed.
This is exactly how your developers work in IntelliJ.

## Next: MongoDB

Want to know where products would live in a real app? Read
[docs/mongodb-document-guide.md](docs/mongodb-document-guide.md). It covers
MongoDB, what a "document" is, and where it lives, with two sketches.
