# The Embed function

The `Embed(...)` function is close to as documentated in the [ShockScript language](https://shockscript.github.io/spec/overview/embed.html). The most basic syntax is functionally similar to a Vite.js or Turbopack `import` declaration when importing a file such as a PNG, WEBP, GIF, SVG and so on.

The result of URL-based `Embed(...)` is framework-specific. For instance, in the Scala.js runtime, it returns a `data:` URL for short files; for longer files, it returns an absolute path after copying the file to the World Wide Web root directory.

> **Note**: `Embed(...)` is a compiler-processed function.

```scala
import com.sweaxizone.newscala.Embed._

Embed("flower.webp") // embeds the file either
                     // externally or internally.
```

Use-cases for `Embed` include embedding multiple icon bitmaps in a component library. Traditional JVM resources are fine for SVGs in general, but complex skeumorphic icon designs may be heavier, specially higher resolutions like 1024x1024, which would increase the .class file and, for targets where virtual memory isn't applicable (such as WebAssembly), consume more RAM once the application evaluates.