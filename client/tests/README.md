# Automatic Test

This directory contains the Python tests for the project that test features of the python based application.

The Tests are written using the [PyTest](https://docs.pytest.org/en/stable/) framework.

## Test Plan

### test_api

Tests that the [Flask](https://flask.palletsprojects.com/en/stable/) [API](/Client/api/src/api.py) works properly.

- [TestApiInfo](test_api.py)
  - test_api_info_full
    - Tests that the api call `/api/info/full` returns a `200` status code and the expected data.
    - Intended outcome: **PASS**
  - TestRequestMethodFullInfo
    - test_api_info_full_fail_post
      - Tests that the api call `/api/info/full` returns a `405` status code when the `POST` request method is used.
      - Intended outcome: **FAIL**
    - test_api_info_full_fail_put
      - Tests that the api call `/api/info/full` returns a `405` status code when the `PUT` request method is used.
      - Intended outcome: **FAIL**
    - test_api_info_full_fail_delete
      - Tests that the api call `/api/info/full` returns a `405` status code when the `DELETE` request method is used.
      - Intended outcome: **FAIL**

  - TestAPIOSInfo
    - test_api_info_os
      - Tests that the api call `/api/info/os` returns a `200` status code and the expected data.
      - Intended outcome: **PASS**
    - TestRequestMethodOS
      - test_api_info_os_fail_post
        - Tests that the api call `/api/info/os` returns a `405` status code when the `POST` request method is used.
        - Intended outcome: **FAIL**
      - test_api_info_os_fail_put
        - Tests that the api call `/api/info/os` returns a `405` status code when the `PUT` request method is used.
        - Intended outcome: **FAIL**
      - test_api_info_os_fail_delete
        - Tests that the api call `/api/info/os` returns a `405` status code when the `DELETE` request method is used.
        - Intended outcome: **FAIL**

  - TestApiOSInfoNetwork
    - test_api_info_os_network
      - Tests that the api call `/api/info/os/network` returns a `200` status code and the expected data.
      - Intended outcome: **PASS**
    - TestRequestMethodNetwork
      - test_api_info_os_network_fail_post
        - Tests that the api call `/api/info/os/network` returns a `405` status code when the `POST` request method is used.
        - Intended outcome: **FAIL**
      - test_api_info_os_network_fail_put
        - Tests that the api call `/api/info/os/network` returns a `405` status code when the `PUT` request method is used.
        - Intended outcome: **FAIL**
      - test_api_info_os_network_fail_delete
        - Tests that the api call `/api/info/os/network` returns a `405` status code when the `DELETE` request method is used.
        - Intended outcome: **FAIL**

  - TestApiHardwareInfo
    - test_api_info_hardware
      - Tests that the api call `/api/info/hardware` returns a `200` status code and the expected data.
      - Intended outcome: **PASS**
    - TestRequestMethodHardware
      - test_api_info_hardware_fail_post
        - Tests that the api call `/api/info/hardware` returns a `405` status code when the `POST` request method is used.
        - Intended outcome: **FAIL**
      - test_api_info_hardware_fail_put
        - Tests that the api call `/api/info/hardware` returns a `405` status code when the `PUT` request method is used.
        - Intended outcome: **FAIL**
      - test_api_info_hardware_fail_delete
        - Tests that the api call `/api/info/hardware` returns a `405` status code when the `DELETE` request method is used.
        - Intended outcome: **FAIL**

    - TestApiHardwareInfoCPU
      - test_api_info_hardware_cpu
        - Tests that the api call `/api/info/hardware/cpu` returns a `200` status code and the expected data.
        - Intended outcome: **PASS**
      - TestRequestMethodHardwareCPU
        - test_api_info_hardware_cpu_fail_post
          - Tests that the api call `/api/info/hardware/cpu` returns a `405` status code when the `POST` request method is used.
          - Intended outcome: **FAIL**
        - test_api_info_hardware_cpu_fail_put
          - Tests that the api call `/api/info/hardware/cpu` returns a `405` status code when the `PUT` request method is used.
          - Intended outcome: **FAIL**
        - test_api_info_hardware_cpu_fail_delete
          - Tests that the api call `/api/info/hardware/cpu` returns a `405` status code when the `DELETE` request method is used.
          - Intended outcome: **FAIL**

    - TestApiHardwareInfoRAM
      - test_api_info_hardware_ram
        - Tests that the api call `/api/info/hardware/ram` returns a `200` status code and the expected data.
        - Intended outcome: **PASS**
      - TestRequestMethodHardwareRAM
        - test_api_info_hardware_ram_fail_post
          - Tests that the api call `/api/info/hardware/ram` returns a `405` status code when the `POST` request method is used.
          - Intended outcome: **FAIL**
        - test_api_info_hardware_ram_fail_put
          - Tests that the api call `/api/info/hardware/ram` returns a `405` status code when the `PUT` request method is used.
          - Intended outcome: **FAIL**
        - test_api_info_hardware_ram_fail_delete
          - Tests that the api call `/api/info/hardware/ram` returns a `405` status code when the `DELETE` request method is used.
          - Intended outcome: **FAIL**

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
