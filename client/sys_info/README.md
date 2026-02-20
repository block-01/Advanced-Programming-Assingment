# Sys info
A package that fetches info about the system that it is running on

## Example

```python
from sys_info import sys_info

print(f"""
OS Info:
  Hostname: {sys_info.software.os.hostname}
  OS platform: {sys_info.software.os.platform}
  OS shell type: {sys_info.software.os.shell}
  OS version: {sys_info.software.os.version}

Hardware Info:
  CPU architecture: {sys_info.sys_hardware.cpu.cpu_arch}
  RAM: {sys_info.sys_hardware.ram.size}
 """)
```
