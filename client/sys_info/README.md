# Sys info
A package that fetches info about the system that it is running on

## Example

```python
from sys_info import sys_info

print(f"""
OS Info:
  Hostname: {sys_info.os_software.os_hostname}
  OS platform: {sys_info.os_software.os_platform}
  OS shell type: {sys_info.os_software.os_shell}
  OS version: {sys_info.os_software.os_version}

Hardware Info:
  CPU architecture: {sys_info.sys_hardware.os_cpu_arch}
  RAM: {sys_info.sys_hardware.os_hard_ram}
 """)
```
