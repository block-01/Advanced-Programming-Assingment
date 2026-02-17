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
def _system_info_full() -> dict[str, str | int]:
    """Full system info

    Request type: GET

    Path: /api/info/full

    Return:
        Information about the systems OS and hardware.
    """
    logger.api("/api/info/full", logger.request_type.GET)
    return {
        "os_version": sys_info.software.os.version,
        "os_hostname": sys_info.software.os.hostname,
        "os_shell": sys_info.software.os.shell,
        "net_ip": sys_info.software.network.net_ip,
        "net_mac_address": sys_info.software.network.net_mac_address,
        "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
        "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
        "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
        "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
        "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
        "os_hard_ram": sys_info.sys_hardware.ram.size,
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
        "os_platform": sys_info.software.os.hostname,
        "os_version": sys_info.software.os.version,
        "os_hostname": sys_info.software.os.hostname,
        "os_shell": sys_info.software.os.shell,
        "net_ip": sys_info.software.network.net_ip,
        "net_mac_address": sys_info.software.network.net_mac_address,
    }


@app.route("/api/info/os/usage")
def _system_info_os_usage() -> dict[str, str]:
    """OS usage info

    Request type: GET

    Path: /api/info/os/usage

    Return:
        Information about the usage of the OS running on the server.
    """
    logger.api("/api/info/os/usage", logger.request_type.GET)
    return {"os_uptime": sys_info.software.os.usage.uptime}


@app.route("/api/info/os/network")
def _system_info_os_network() -> dict[str, str]:
    """network info

    Request type: GET

    Path: /api/info/os/network

    Return:
        Information about servers network.
    """
    logger.api("/api/info/os/network", logger.request_type.GET)
    return {
        "net_ip": sys_info.software.network.net_ip,
        "net_mac_address": sys_info.software.network.net_mac_address,
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
        "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
        "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
        "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
        "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
        "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
        "os_hard_ram": sys_info.sys_hardware.ram.size,
    }


@app.route("/api/info/hardware/cpu")
def _system_info_hardware_cpu() -> dict[str, str]:
    """CPU info

    Request type: GET

    Path: /api/info/hardware/cpu

    Return:
        Information about the servers CPU.
    """
    logger.api("/api/info/hardware/cpu", logger.request_type.GET)
    return {
        "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
        "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
        "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
        "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
        "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
    }


@app.route("/api/info/hardware/ram")
def _system_info_hardware_ram() -> dict[str, str]:
    """RAM info.

    Request type: GET

    Path: /api/info/hardware/ram

    Return:
        Information about the servers RAM.
    """
    logger.api("/api/info/hardware/ram", logger.request_type.GET)
    return {
        "os_hard_ram": sys_info.sys_hardware.ram.size,
    }


@app.route("/api/info/hardware/cpu/usage")
def _system_info_hardware_cpu_usage() -> dict[str, str | dict[str, str]]:
    """CPU usage info.

    Request type: GET

    Path: /api/info/hardware/cpu/usage

    Return:
        Information about the servers CPU usage.
    """
    logger.api("/api/info/hardware/cpu/usage", logger.request_type.GET)
    return {
        "cpu_usage_per_core": sys_info.sys_hardware.cpu.usage.per_core,
        "cpu_usage_total": sys_info.sys_hardware.cpu.usage.total,
    }


@app.route("/api/info/hardware/ram/usage")
def _system_info_hardware_ram_usage() -> dict[str, str]:
    """RAM usage info.

    Request type: GET

    Path: /api/info/hardware/ram/usage

    Return:
        Information about the servers RAM usage.
    """
    logger.api("/api/info/hardware/ram/usage", logger.request_type.GET)
    return {
        "ram_available": sys_info.sys_hardware.ram.usage.available,
        "ram_used": sys_info.sys_hardware.ram.usage.used,
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
