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
  "net_ip": "",
  "net_mac_address": "",
  "os_cpu_arch": "x86_64",
  "os_cpu_core_clock_max": "4000.00Mhz",
  "os_cpu_core_clock_min": "400.00Mhz",
  "os_cpu_cores": "10",
  "os_cpu_threads": 12,
  "os_hard_ram": "15GB",
  "os_hostname": "Linux",
  "os_platform": "Linux",
  "os_shell": "posix",
  "os_version": "#91-Ubuntu SMP PREEMPT_DYNAMIC Tue Nov 18 14:14:30 UTC 2025"
}
```

### OS info

Path: **/api/info/os**

Request Type: **GET**

This API call returns all information about the systems OS.

#### Example

**123.0.0.1:5000/api/info/os**

```json
{
  "net_ip": "",
  "net_mac_address": "",
  "os_hostname": "Linux",
  "os_platform": "Linux",
  "os_shell": "posix",
  "os_version": "#91-Ubuntu SMP PREEMPT_DYNAMIC Tue Nov 18 14:14:30 UTC 2025"
}
```

### OS usage info

Path: **/api/info/os/usage**

Request Type: **GET**

This API call returns all information about the OS's usage info.

#### Example

**123.0.0.1:5000/api/info/os/usage**

```json
{
  "os_uptime": "up 6 hours, 54 minutes"
}
```

### Network info

Path: **/api/info/os/network**

Request Type: **GET**

This API call returns all information about the OS's network.

#### Example

**123.0.0.1:5000/api/info/os/network**

```json
{
  "ip": "",
  "mac_address": ""
}
```

### Hardware info

Path: **/api/info/hardware**

Request Type: **GET**

This API call returns all information about the systems hardware.

#### Example

**123.0.0.1:5000/api/info/hardware**

```json
{
  "os_cpu_arch": "x86_64",
  "os_cpu_core_clock_max": "4000.00Mhz",
  "os_cpu_core_clock_min": "400.00Mhz",
  "os_cpu_cores": "10",
  "os_cpu_threads": 12,
  "os_hard_ram": "15GB"
}
```

### CPU info

Path: **/api/info/hardware/cpu**

Request Type: **GET**

This API call returns all information about the CPU.

#### Example

**123.0.0.1:5000/api/info/hardware/cpu**

```json
{
  "os_cpu_arch": "x86_64",
  "os_cpu_core_clock_max": "4000.00Mhz",
  "os_cpu_core_clock_min": "400.00Mhz",
  "os_cpu_cores": "10",
  "os_cpu_threads": 12
}
```

### CPU usage info

Path: **/api/info/hardware/cpu/usage**

Request Type: **GET**

This API call returns all information about the CPU's usage.

#### Example

**123.0.0.1:5000/api/info/hardware/cpu/usage**

```json
{
  "cpu_usage_per_core": {
    "core 0": "7.1%",
    "core 1": "3.0%",
    "core 10": "3.0%",
    "core 11": "3.0%",
    "core 2": "11.1%",
    "core 3": "2.0%",
    "core 4": "4.1%",
    "core 5": "5.1%",
    "core 6": "4.0%",
    "core 7": "3.0%",
    "core 8": "2.0%",
    "core 9": "2.0%"
  },
  "cpu_usage_total": "4.3%"
}
```

### RAM info

Path: **/api/info/hardware/ram**

Request Type: **GET**

This API call returns all information about the RAM.

#### Example

**123.0.0.1:5000/api/info/hardware/ram**

```json
{
  "os_hard_ram": "15GB"
}
```

### RAM usage info

Path: **/api/info/hardware/ram/usage**

Request Type: **GET**

This API call returns all information about the RAM's usage.

#### Example

**123.0.0.1:5000/api/info/hardware/ram/usage**

```json
{
  "ram_available": "3GB",
  "ram_used": "13GB (81.9%)"
}
```

### Server reservation

Path: **/api/reserve-server**

Request Type: **POST**

This API call is used by the dashboard to reserve a server.

#### Example

**123.0.0.1:5000/api/reserve-server?username=ExampleUser&duration=1**

```json
{
  "duration": 1,
  "username": "ExampleUser"
}
```
