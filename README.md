# New Scala

Scala, but easier to set up.

- New Scala supports projects that rely on the JVM and Scala.js runtimes.
- New Scala has its own package registry, similar to crates.io.
- New Scala configuration is close to [Cargo](https://doc.rust-lang.org/cargo/), rather than SBT/Maven.

New Scala's implementation uses the Scala's Dotty compiler since:

- It will futurely support an `Embed()` expression for embedding resources similarly to Vite.js/Turbopack (but better)
- It generates ScalaDoc with a JavaDoc 20 look
- It implements its own language server

## License

Apache 2.0
