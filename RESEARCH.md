(Some of the information here is based on the AI.)

# Third-party

TOML: https://index.scala-lang.org/indoorvivants/toml-scala
Dotty (Scala compiler): https://index.scala-lang.org/scala/scala3

# Dotty

- Compiling a Scala source file would typically generate a pair of files: TASTy .tasty file and a JVM .class file.
  - To be exact, a Scala source file may generate multiple JVM .class files.
- TASTy (Typed Abstract Syntax Trees) is a lossless, typed AST serialization. It's not meant to be used for execution, but rather the accompanying JVM .class files; nor is TASTy tied to the JVM.
- Header-caching: In some experiments, we have tried caching .d.ts (header-like JavaScript) for third-paty dependencies to boost type-checking without codegen, specially important for the IDE and a `check` command; in New Scala, .d.ts would be .tasty instead, with the .tasty files into an artifact directory (like `target/pkg/dist/local/com.ninja.gate/main/com/ninja/gate/G.tasty`). (TASTy aren't header-only files, but they're more efficient to handle.)
- Notes about sourcepath and classpath for every New Scala project
  - sourcepath = contains .scala
  - classpath = contains .tasty and .class
  - sourcepath and classpath mustn't conflict.
  - If anything in sourcepath or resourcespath changed relative to last build, best to remove all cached .tasty before invoking the Dotty compiler, and don't supply the classpath.
  - If nothing in sourcepath or resourcespath changed relative to last build, then don't supply the sourcepath to Dotty; supply only the classpath.