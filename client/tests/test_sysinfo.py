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
test_ip: str = ""  # TODO: Implement fetching the IP address
test_mac_address: str = ""  # TODO: Implement support for Mac Addresses

test_cpu_arch: str = os.uname().machine
test_cpu_cores: str = ""  # TODO: Implement fetching the core count
test_cpu_core_clock: str = ""  # TODO: Implement fetching the core clock speed
test_cpu_threads: str = ""  # TODO: Implement fetching the the CPUs threads
test_ram: str = str(round(psutil.virtual_memory().total / (1024.0**3))) + " GB"


class TestSysinfo:
    def test_sysinfo(self):
        """Tests that the system information can be fetched."""

        logger.test.test_case_start(self, "system info test")
        assert test_platform == sys_info.os_software.os_platform
        assert test_version == sys_info.os_software.os_version
        assert test_hostname == sys_info.os_software.os_hostname
        assert test_shell == sys_info.os_software.os_shell
        assert test_ip == sys_info.os_software.os_ip
        assert test_mac_address == sys_info.os_software.os_mac_address
        assert test_cpu_arch == sys_info.sys_hardware.os_cpu_arch
        assert test_cpu_cores == sys_info.sys_hardware.os_cpu_cores
        assert test_cpu_core_clock == sys_info.sys_hardware.os_cpu_core_clock
        assert test_cpu_threads == sys_info.sys_hardware.os_cpu_threads
        assert test_ram == sys_info.sys_hardware.os_hard_ram
