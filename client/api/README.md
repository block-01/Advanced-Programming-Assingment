# API

The api for the application on the server which is having information fetched about.

Once the application has been started the API can be accessed through the systems IP on port 5000 followed by the url path for the api call.
Invalid API calls return a 404 error.

## Requests

### Full system info

Path: **/api/info/full**

Request Type: **GET**

This API call returns all information about the systems hardware and OS.

#### Example

**123.0.0.1:5000/api/info/full**

```json
{
  "os_cpu_arch": "x86_64",
  "os_cpu_core_clock": "",
  "os_cpu_cores": "",
  "os_cpu_threads": "",
  "os_hard_ram": "8 GB",
  "os_hostname": "[REDACTED]",
  "os_ip": "123.0.0.1",
  "os_mac_address": "",
  "os_platform": "Linux",
  "os_shell": "posix",
  "os_version": "#91-Ubuntu SMP PREEMPT_DYNAMIC Tue Nov 18 14:14:30 UTC 2025"
}
```

### Hardware Info

Path: **/api/info/hardware**

Request Type: **GET**

This API call returns all information about the systems hardware.

#### Example

**123.0.0.1:5000/api/info/hardware**

```json
{
  "os_cpu_arch": "x86_64",
  "os_cpu_core_clock": "",
  "os_cpu_cores": "",
  "os_cpu_threads": "",
  "os_hard_ram": "8 GB"
}
```

### OS Info

Path: **/api/info/os**

Request Type: **GET**

This API call returns all information about the systems OS.

#### Example

**123.0.0.1:5000/api/info/os**

```json
{
  "os_hostname": "[REDACTED]",
  "os_ip": "123.0.0.1",
  "os_mac_address": "",
  "os_platform": "Linux",
  "os_shell": "posix",
  "os_version": "#91-Ubuntu SMP PREEMPT_DYNAMIC Tue Nov 18 14:14:30 UTC 2025"
}
```
