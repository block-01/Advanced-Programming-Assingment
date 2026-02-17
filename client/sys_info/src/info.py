"""
Contains classes and functions to fetch information about the system it is being ran on.
"""

import os, psutil


class sys_info:
    """
    A class containing information about the system it's being ran on, including:
    - CPU arch
    - RAM
    - System IP
    - OS platform
    - OS version
    - System Hostname
    - Environment type
    """

    class os_software:
        os_platform: str = os.uname().sysname
        os_version: str = os.uname().version
        os_hostname: str = os.uname().nodename
        os_shell: str = os.name
        os_ip: str = ""  # TODO: implement fetching the system IP
        os_mac_address: str = ""  # TODO: Implement support for Mac Addresses

    class sys_hardware:
        os_cpu_arch: str = os.uname().machine
        os_cpu_cores: str = ""  # TODO: Implement fetching the core count
        os_cpu_core_clock: str = ""  # TODO: Implement fetching the core clock speed
        os_cpu_threads: str = ""  # TODO: Implement fetching the the CPUs threads
        os_hard_ram: str = str(round(psutil.virtual_memory().total / (1024.0**3))) + " GB"
