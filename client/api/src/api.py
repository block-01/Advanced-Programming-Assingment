"""
The python file contains all functions related to the flask API which can be started through
running main.py with no extra arguments which will automatically start the application
on port 5000.
"""

from logger import logger
from sys_info import sys_info
from flask import Flask, Response, request, jsonify


app = Flask(__name__)
app.debug = True  # TODO: Disable once development is complete.


@app.route("/api/info/full", methods=["GET"])
def _system_info_full() -> tuple[Response, int]:
    """Full system info

    Request type: GET

    Path: /api/info/full

    Return:
        Information about the systems OS and hardware.
    """

    logger.api("/api/info/full", logger.request_type.GET)
    return (
        jsonify(
            {
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
        ),
        200,
    )


@app.route("/api/info/os", methods=["GET"])
def _system_info_os() -> tuple[Response, int]:
    """OS info

    Request type: GET

    Path: /api/info/os

    Return:
        Information about the OS running on the server.
    """

    logger.api("/api/info/os", logger.request_type.GET)
    return (
        jsonify(
            {
                "os_platform": sys_info.software.os.hostname,
                "os_version": sys_info.software.os.version,
                "os_hostname": sys_info.software.os.hostname,
                "os_shell": sys_info.software.os.shell,
                "net_ip": sys_info.software.network.net_ip,
                "net_mac_address": sys_info.software.network.net_mac_address,
            }
        ),
        200,
    )


@app.route("/api/info/os/usage", methods=["GET"])
def _system_info_os_usage() -> tuple[Response, int]:
    """OS usage info

    Request type: GET

    Path: /api/info/os/usage

    Return:
        Information about the usage of the OS running on the server.
    """

    logger.api("/api/info/os/usage", logger.request_type.GET)
    return jsonify({"os_uptime": sys_info.software.os.usage.uptime}), 200


@app.route("/api/info/os/network", methods=["GET"])
def _system_info_os_network() -> tuple[Response, int]:
    """network info

    Request type: GET

    Path: /api/info/os/network

    Return:
        Information about servers network.
    """

    logger.api("/api/info/os/network", logger.request_type.GET)
    return (
        jsonify(
            {
                "net_ip": sys_info.software.network.net_ip,
                "net_mac_address": sys_info.software.network.net_mac_address,
            }
        ),
        200,
    )


@app.route("/api/info/hardware", methods=["GET"])
def _system_info_hardware() -> tuple[Response, int]:
    """Hardware info

    Request type: GET

    Path: /api/info/hardware

    Return:
        Information about the servers hardware.
    """

    logger.api("/api/info/hardware", logger.request_type.GET)
    return (
        jsonify(
            {
                "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
                "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
                "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
                "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
                "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
                "os_hard_ram": sys_info.sys_hardware.ram.size,
            }
        ),
        200,
    )


@app.route("/api/info/hardware/cpu", methods=["GET"])
def _system_info_hardware_cpu() -> tuple[Response, int]:
    """CPU info

    Request type: GET

    Path: /api/info/hardware/cpu

    Return:
        Information about the servers CPU.
    """

    logger.api("/api/info/hardware/cpu", logger.request_type.GET)
    return (
        jsonify(
            {
                "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
                "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
                "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
                "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
                "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
            }
        ),
        200,
    )


@app.route("/api/info/hardware/ram", methods=["GET"])
def _system_info_hardware_ram() -> tuple[Response, int]:
    """RAM info.

    Request type: GET

    Path: /api/info/hardware/ram

    Return:
        Information about the servers RAM.
    """

    logger.api("/api/info/hardware/ram", logger.request_type.GET)
    return (
        jsonify(
            {
                "os_hard_ram": sys_info.sys_hardware.ram.size,
            }
        ),
        200,
    )


@app.route("/api/info/hardware/cpu/usage", methods=["GET"])
def _system_info_hardware_cpu_usage() -> tuple[Response, int]:
    """CPU usage info.

    Request type: GET

    Path: /api/info/hardware/cpu/usage

    Return:
        Information about the servers CPU usage.
    """

    logger.api("/api/info/hardware/cpu/usage", logger.request_type.GET)
    return (
        jsonify(
            {
                "cpu_usage_per_core": sys_info.sys_hardware.cpu.usage.per_core,
                "cpu_usage_total": sys_info.sys_hardware.cpu.usage.total,
            }
        ),
        200,
    )


@app.route("/api/info/hardware/ram/usage", methods=["GET"])
def _system_info_hardware_ram_usage() -> tuple[Response, int]:
    """RAM usage info.

    Request type: GET

    Path: /api/info/hardware/ram/usage

    Return:
        Information about the servers RAM usage.
    """

    logger.api("/api/info/hardware/ram/usage", logger.request_type.GET)
    return (
        jsonify(
            {
                "ram_available": sys_info.sys_hardware.ram.usage.available,
                "ram_used": sys_info.sys_hardware.ram.usage.used,
            }
        ),
        200,
    )


@app.errorhandler(404)
def _error(error) -> tuple[Response, int]:
    """error

    Request type: GET

    Return:
        404 error.
    """

    logger.api("ERROR: Invalid or malformed API request", logger.request_type.GET)
    return jsonify({"error": "Not Found"}), 404
