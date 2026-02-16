# Automatic Test

This directory contains the Python tests for the project that test features of the python based application.

The Tests are written using the [PyTest](https://docs.pytest.org/en/stable/) framework.

## Test Plan

### test_api

Tests that the [Flask](https://flask.palletsprojects.com/en/stable/) [API](/Client/api/src/api.py) works properly.

- [TestAPI](test_api.py)
	- test_api_info_full
  		- Tests that the api call `/api/info/full` works.
		- Intended outcome: **PASS**
	- test_api_info_os
  		- Tests that the api call `/api/info/os` works.
  		- Intended outcome: **PASS**
	- test_api_info_hardware
    	- Tests that api call `/api/info/hardware` works.
  		- Intended outcome: **PASS**
	- test_api_404_error
		- Tests that the api will return a 404 error when the URL is invalid.
  		- Intended outcome: **FAIL**

### test_logger

Tests that the [logger](/Client/logger/src/logger.py) functions work properly.

- [TestLogger](test_logger.py)
	- test_debug
		- Tests that the debug logger works.
  		- Intended outcome: **PASS**
	- test_warning
		- Tests that the warning logger works.
  		- Intended outcome: **PASS**
	- test_exception
		- Tests that the exception logger works.
  		- Intended outcome: **PASS**

### test_sysinfo

Tests that the [system info](/Client/sys_info/src/info.py) can be fetched.

- [TestSysinfo](test_sysinfo.py)
	- test_sysinfo
		- Tests that system info fetching works.
	 	- Intended outcome: **PASS**
