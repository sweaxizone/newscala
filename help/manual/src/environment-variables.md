# Environment variables

## Environment variables used by the New Scala SDK

- `NEWSCALA_HOME` - Path to the New Scala SDK.

## Environment variables New Scala sets for packages

These environment variables are available for use with `Env("VAR_NAME")` expressions within New Scala packages, their build scripts and unit-testing classes.

> **Note**: `Env(...)` is a compiler-processed function.

```scala
import com.sweaxizone.newscala.Env._

Env("NEWSCALA_MANIFEST_DIR")
```

- `TARGET` - Path to the artifact target directory based on platform and build profile.
- `NEWSCALA_MANIFEST_DIR` - Path to the directory containing the manifest of your package.
- `NEWSCALA_MANIFEST_PATH` - Path to the manifest file of your package.
- `NEWSCALA_PKG_NAME` - Package name.
- `NEWSCALA_PKG_VERSION` - Package SemVer version number.
- `NEWSCALA_PKG_VERSION_MAJOR` - Package major version number.
- `NEWSCALA_PKG_VERSION_MINOR` - Package minor version number.
- `NEWSCALA_PKG_VERSION_PATCH` - Package patch version number.

## Using static DotEnv variables

For setting static DotEnv variables in Scala, create a `.env` file in your package's directory, with contents like:

```
FOO=bar
```

You can then refer to that in Scala with expressions like:

```scala
Env("FOO")
```