# Sys info
A package that fetches info about the system that it is running on

## Example

```python
from sys_info import sys_info

print(f"""
OS Info:
\tHostname: {sys_info.os_software.os_hostname}
\tOS platform: {sys_info.os_software.os_platform}
\tOS shell type: {sys_info.os_software.os_shell}
\tOS version: {sys_info.os_software.os_version}

Hardware Info:
\tCPU architecture: {sys_info.sys_hardware.os_cpu_arch}
\tRAM: {sys_info.sys_hardware.os_hard_ram}
 """)
```
