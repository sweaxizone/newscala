# Unit testing

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