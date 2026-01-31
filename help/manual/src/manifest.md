# The manifest format

This section describes the manifest format file `new_scala.toml`, placed at a project's root directory.

A manifest may describe a package and a workspace simultaneously.

## Example

```toml
[package]
name = "com.ninja.game"
version = "0.1.0"
runtime = "http://www.scala-js.org/2013/scala/3/web"

[compiler-options]
main-class = "com.ninja.game.Main"
```

## Package section

```toml
[package]
# The package ID.
#
# Patterns (may use subnamespaces):
#
# - `com.<company>.<project-name>`
# - `org.<organisation>.<project-name>`
# - `net.<organisation>.<project-name>`
# - `me.<author>.<project-name>`
# - `goog.<project-name>`
# - `<project-name>`
#
name = "com.company.project-name"

# SemVer-compatible version number.
#
version = "0.1.0"

# Target platform. This influences certain behaviors
# of the compiler, including the Embed(...) function
# and certain commands.
#
# Supported values:
#
# - "http://www.scala-lang.org/2021/scala/3/compat"
#   - Compatible with all the other runtimes.
# - "http://www.scala-lang.org/2021/scala/3/jvm"
# - "http://www.scala-js.org/2013/scala/3"
# - "http://www.scala-js.org/2013/scala/3/web" (web browser)
# - "http://www.scala-js.org/2013/scala/3/node" (NodeJS)
#
runtime = "http://www.scala-js.org/2013/scala/3"

# Author list.
#
authors = ["John Doe <johndoe@example.com>"]

# Homepage URL.
#
homepage = "https://project.com"

# Source repository URL.
#
repository = "https://example.com/johndoe/project"

# License type.
#
# Examples:
#
# "MIT", "Apache-2.0", "MIT OR Apache-2.0"
#
license = "MIT OR Apache-2.0"

# Description.
#
description = "Package description."

# Keywords.
#
keywords = []

# Categories.
#
categories = []

# Files to exclude/include when publishing.
# (Similiar to .gitignore entries, possibly with an exclamation prefix.)
#
ignore = []

# Shared objects (.so or .dll) to contribute alongside
# the program. This may be used by certain New Scala frameworks.
#
# Entries in this option can interpolate `{target}`
# for the arfifact directory.
#
# Entries not found here are ignored; for instance,
# you could have a .dll on Windows, but not on other platforms.
#
shared-objects = [
    "{target}/so/org.makers.plus/libcore.so",
]

# Plain metadata ignored by New Scala
[package.metadata]
plain = 0
```

## Workspace section

```toml
[workspace]
members = [
    "packages/foo",
    "packages/bar",
]
```

## Dependencies sections

```toml
# Dependencies.
#
[dependencies]
com.maxima.move = "0.1"
com.maxima.move = { path = "../move", version = "0.1" }
# git dependencies may have a `rev`, `tag` or `branch` keys.
#
# rev examples:
#
# - rev = "4c59b707" (a commit by its SHA1 hash)
# - rev = "refs/pull/493/head" (HEAD commit of PR 493)
#
# tag examples:
#
# - tag = "1.10.3"
#
# branch examples:
#
# - branch = "master"
#
# If it's a workspace, then New Scala will look for the
# matching member, inheriting any dependencies.
#
com.maxima.move = { git = "https://github.com/maxima/move", version = "0.1" }

# Development dependencies. *Used by unit-testing.*
#
[dev-dependencies]
com.alpha.lets-go = "1"

# Build dependencies. *Used by build scripts.*
#
[build-dependencies]
com.omega.game = "1"

# NPM dependencies, used for the Scala.js runtime.
#
[npm-dependencies]
"decimal.js" = "1"
```

## Compiler options section

```toml
[compiler-options]
# Directory at which to find Scala source files.
# (Defaults to "src".)
#
source-path = "src"

# Main component script, for an application package.
#
main-class = "com.ninja.game.Main"

# Resources path (for "Embed(...)").
#
resources-path = "res/embed"

# following: "error", "warn" or "allow"
unreachable-code = "warn"
unused = "warn"
```

## Terminal section

Used for contributing terminal applications, installable through `newscala terminal install`.

```toml
[[terminal]]
name = "mycmd1"
main-class = "com.ninja.gate.terminal.MyCommand1"

[[terminal]]
name = "mycmd2"
main-class = "com.ninja.gate.terminal.MyCommand2"
```

## Unit-testing sections

```toml
[[test]]
# Test ID.
#
# This may be omitted if there is only one [[test]]
# section, defaulting to "test".
#
# This is required internally.
name = "test"

# Runtime. Accepts the same values as `application.runtime`.
#
# Defaults to "http://www.scala-lang.org/2021/scala/3/jvm".
#
runtime = "http://www.scala-js.org/2013/scala/3/node"

# Directory at which to find Scala unit-testing source files.
#
# Defaults to "test" if there is only one [[test]] section.
#
source-path = "test/scala"

# Directory for attaching Java-like resource files.
# If unspecified, no resources files are attached.
# (Embed() can also be used instead.)
#
resources-path = "test/resources"
```

If there is no `[[test]]` section and there is a `test` directory, then a virtual `[[test]]` section is added with the default options.

## Formatting section

```toml
[formatting]
# Number of spaces per indentation-level.
#
# Default: 4
tab-width = 4
# Use tabs for indentation?
#
# Default: false
use-tabs = false
```

## Application section

The `application` section is reserved for visual-interactive application frameworks.

```toml
[application]
# Human name (`en` is the default locale).
human-name."en" = "Application 1"
human-name."pt" = "Aplicativo 1"
# Description
description."en" = "Description"
description."pt" = "Descrição"
# Frames per second.
framerate = 30
# Background color.
background = "#000"
# App-installation resources directory. Used by
# the Whack framework.
#
# In Whack, this is used by the `app:` scheme for resolving
# assets from the app's installation directory.
#
# Default: res/app.
#
resources = "res/app"

# For Scala.js web projects, indicates the
# absolute path of the web project in its host.
#
wwwroot = "/"

[application.initial-window]
# Window size
width = 800
height = 600
```