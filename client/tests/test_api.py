"""
Tests that the Flask API functions properly returning the expected valve when ran.
"""

from typing import Any, Generator

from flask.testing import FlaskClient
from api import app
from logger import logger
from sys_info import sys_info
import pytest

expected_api_output_full = {
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

excepted_api_output_os = {
    "os_platform": sys_info.os_software.os_platform,
    "os_version": sys_info.os_software.os_version,
    "os_hostname": sys_info.os_software.os_hostname,
    "os_shell": sys_info.os_software.os_shell,
    "os_ip": sys_info.os_software.os_ip,
    "os_mac_address": sys_info.os_software.os_mac_address,
}

expected_api_output_hardware = {
    "os_cpu_arch": sys_info.sys_hardware.os_cpu_arch,
    "os_cpu_cores": sys_info.sys_hardware.os_cpu_cores,
    "os_cpu_core_clock": sys_info.sys_hardware.os_cpu_core_clock,
    "os_cpu_threads": sys_info.sys_hardware.os_cpu_threads,
    "os_hard_ram": sys_info.sys_hardware.os_hard_ram,
}

expected_api_output_404 = {"error": 404}


@pytest.fixture(scope="module")
def client() -> Generator[FlaskClient, Any, None]:
    """Test client

    Setups test environment.

    Yields:
        testing_client: The Flask client that is being tested.
    """
    with app.test_client() as testing_client:
        with app.app_context():
            yield testing_client


class TestAPI:
    def test_api_info_full(self, client) -> None:
        """Tests that the api returns the full system info.

        Args:
            client: The flask client being tested
        """

        logger.test.test_case_start(self, "Api full info test")
        api = client.get("/api/info/full")
        assert api.json == expected_api_output_full

    def test_api_info_os(self, client) -> None:
        """Tests that the api returns the OS info.

        Args:
            client: The flask client being tested
        """

        logger.test.test_case_start(self, "Api os info test")
        api = client.get("/api/info/os")
        assert api.json == excepted_api_output_os

    def test_api_info_hardware(self, client) -> None:
        """Tests that the api returns the hardware info.

        Args:
            client: The flask client being tested
        """

        logger.test.test_case_start(self, "Api hardware info test")
        api = client.get("/api/info/hardware")
        assert api.json == expected_api_output_hardware

    def test_api_404_error(self, client) -> None:
        """Tests that the api returns a 404 error when the url is invalid.

        Args:
            client: The flask client being tested
        """

        logger.test.test_case_start(self, "Api 404 error test")
        api = client.get("/invalid_404")
        assert api.json == expected_api_output_404
