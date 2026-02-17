# Logger

This python package is a basic logger for logging events to the terminal and saving them to a file.

## Functions

### API

This logs information about the api to the terminal in cyan.

#### Example

```python
from logger import logger

logger.api("/api/logger/example", logger.request_type.GET)
```

### Debug

This logs debug messages to the terminal outputting them in purple.

#### Example

```python
from logger import logger

logger.debug("Debug logger example.")
```

### Warning

This logs warning messages to the terminal outputting them in yellow.

#### Example

```python
from logger import logger

logger.warning("Warning logger example.")
```

### Exception

This logs exception messages to the terminal outputting them in Red along with the exception that occurred.

#### Example

```python
from logger import logger

logger.exception("Exception logger example.")
```
