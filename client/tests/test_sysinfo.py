"""
Tests that system info can be fetched and that the fetched info is correct.
"""

from sys_info import sys_info
from logger import logger
import os, psutil


test_platform: str = os.uname().sysname
test_version: str = os.uname().version
test_hostname: str = os.uname().nodename
test_shell: str = os.name
test_ip: str = ""  # TODO: Implement fetching the net_ip address
test_mac_address: str = ""  # TODO: Implement support for Mac Addresses

test_cpu_arch: str = os.uname().machine
test_cpu_cores: str = f"{psutil.cpu_count(logical=False)}"
test_cpu_threads: str = f"{psutil.cpu_count(logical=True)}"
test_cpu_max_clock: str = f"{psutil.cpu_freq().max:.2f}Mhz"
test_cpu_min_clock: str = f"{psutil.cpu_freq().min:.2f}Mhz"
test_ram: str = str(round(psutil.virtual_memory().total / (1024.0**3))) + "GB"


class TestSysinfo:
    def test_sysinfo(self):
        """Tests that the system information can be fetched."""

        logger.test.test_case_start(self, "system info test")

        assert test_platform == sys_info.software.os.platform
        assert test_version == sys_info.software.os.version
        assert test_hostname == sys_info.software.os.hostname
        assert test_shell == sys_info.software.os.shell

        assert test_ip == sys_info.software.network.net_ip
        assert test_mac_address == sys_info.software.network.net_mac_address

        assert test_cpu_arch == sys_info.sys_hardware.cpu.cpu_arch
        assert test_cpu_cores == sys_info.sys_hardware.cpu.cpu_cores
        assert test_cpu_max_clock == sys_info.sys_hardware.cpu.cpu_core_clock_max
        assert test_cpu_min_clock == sys_info.sys_hardware.cpu.cpu_core_clock_min
        assert test_cpu_threads == sys_info.sys_hardware.cpu.cpu_threads

        assert test_ram == sys_info.sys_hardware.ram.size
