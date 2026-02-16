"""
The python file contains all functions related to the flask API which can be started through
running main.py with no extra arguments which will automatically start the application
on port 5000.
"""

from logger import logger
from sys_info import sys_info
from flask import Flask


app = Flask(__name__)


@app.route("/api/info/full")
def _system_info_full() -> dict[str, str]:
    """Full system info

    Request type: GET

    Path: /api/info/full

    Return:
        Information about the systems OS and hardware.
    """
    logger.api("/api/info/full", logger.request_type.GET)
    return {
        "os_platform": sys_info.os_software.os_platform,
        "os_version": sys_info.os_software.os_version,
        "os_hostname": sys_info.os_software.os_hostname,
        "os_shell": sys_info.os_software.os_shell,
        "os_ip": sys_info.os_software.os_ip,
        "os_mac_address": sys_info.os_software.os_mac_address,
        "os_cpu_arch": sys_info.sys_hardware.os_cpu_arch,
        "os_cpu_cores": sys_info.sys_hardware.os_cpu_cores,
        "os_cpu_core_clock": sys_info.sys_hardware.os_cpu_core_clock,
        "os_cpu_threads": sys_info.sys_hardware.os_cpu_threads,
        "os_hard_ram": sys_info.sys_hardware.os_hard_ram,
    }


@app.route("/api/info/os")
def _system_info_os() -> dict[str, str]:
    """OS info

    Request type: GET

    Path: /api/info/os

    Return:
        Information about the OS running on the server.
    """
    logger.api("/api/info/os", logger.request_type.GET)
    return {
        "os_platform": sys_info.os_software.os_platform,
        "os_version": sys_info.os_software.os_version,
        "os_hostname": sys_info.os_software.os_hostname,
        "os_shell": sys_info.os_software.os_shell,
        "os_ip": sys_info.os_software.os_ip,
        "os_mac_address": sys_info.os_software.os_mac_address,
    }


@app.route("/api/info/hardware")
def _system_info_hardware() -> dict[str, str]:
    """Hardware info

    Request type: GET

    Path: /api/info/hardware

    Return:
        Information about the servers hardware.
    """
    logger.api("/api/info/hardware", logger.request_type.GET)
    return {
        "os_cpu_arch": sys_info.sys_hardware.os_cpu_arch,
        "os_cpu_cores": sys_info.sys_hardware.os_cpu_cores,
        "os_cpu_core_clock": sys_info.sys_hardware.os_cpu_core_clock,
        "os_cpu_threads": sys_info.sys_hardware.os_cpu_threads,
        "os_hard_ram": sys_info.sys_hardware.os_hard_ram,
    }


@app.errorhandler(404)
def _error(error) -> dict[str, int]:
    """error

    Request type: GET

    Return:
        404 error.
    """
    logger.api("ERROR: Invalid or malformed API request", logger.request_type.GET)
    return {"error": 404}
