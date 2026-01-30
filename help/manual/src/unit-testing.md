# Unit testing

Unit-testing sources are put in a separate project source path from the main since they may need a different runtime to run (a bit similar to traditional Java or Scala projects).

## Code snippets

```scala
package com.ninja.spider.core

import com.sweaxizone.newscala.Assert._
import mocha.*

@Test
class TestSuite:
    @Test
    def test(): {
        assertEquals(1 + 1, 2)
    }
end TestSuite
```