"""
Contains classes and functions to fetch information about the system it is being ran on.
"""

import os, psutil


class sys_info:
    """
    A class containing information about the system it's being ran on, including:
    - CPU arch
    - RAM
    - System ip
    - OS platform
    - OS version
    - System Hostname
    - Environment type
    """

    class software:
        class os:
            platform: str = os.uname().sysname
            version: str = os.uname().version
            hostname: str = os.uname().nodename
            shell: str = os.name

            class usage:
                uptime = os.popen("uptime -p").read()[:-1]

        class network:
            net_ip: str = ""  # TODO: implement fetching the system net_ip
            net_mac_address: str = ""  # TODO: Implement support for Mac Addresses

    class sys_hardware:
        class cpu:
            cpu_arch: str = os.uname().machine
            cpu_cores: str = f"{psutil.cpu_count(logical=False)}"
            cpu_threads: str = f"{psutil.cpu_count(logical=True)}"
            cpu_core_clock_max: str = f"{psutil.cpu_freq().max:.2f}Mhz"
            cpu_core_clock_min: str = f"{psutil.cpu_freq().min:.2f}Mhz"

            class usage:
                per_core: dict[str, str] = {
                    f"core {i}": f"{percentage}%"
                    for i, percentage in enumerate(psutil.cpu_percent(percpu=True, interval=1))
                }

                total: str = f"{psutil.cpu_percent()}%"

        class ram:
            size: str = f"{round(psutil.virtual_memory().total / (1024.0**3))}GB"

            class usage:
                available: str = f"{round(psutil.virtual_memory().available / (1024.0**3))}GB"
                used: str = f"{round(psutil.virtual_memory().used / (1024.0**3))}GB ({psutil.virtual_memory().percent}%)"
