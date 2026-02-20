"""
Tests that the Flask Api functions properly returning the expected valve and return code when ran.
"""

from typing import Any, Generator

from flask.testing import FlaskClient
from api import app
from logger import logger
from sys_info import sys_info
import pytest

server_status_url: str = "/api/serverstatus"
expected_server_status_output: dict[str, str] = {"status": "online"}

full_info_url: str = "/api/info/full"
expected_api_output_full: dict[str, str] = {
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

os_url: str = "/api/info/os"
expected_api_output_os: dict[str, str] = {
    "os_platform": sys_info.software.os.hostname,
    "os_version": sys_info.software.os.version,
    "os_hostname": sys_info.software.os.hostname,
    "os_shell": sys_info.software.os.shell,
    "net_ip": sys_info.software.network.net_ip,
    "net_mac_address": sys_info.software.network.net_mac_address,
}

network_url: str = "/api/info/os/network"
expected_api_output_network: dict[str, str] = {
    "net_ip": sys_info.software.network.net_ip,
    "net_mac_address": sys_info.software.network.net_mac_address,
}

hardware_url: str = "/api/info/hardware"
expected_api_output_hardware: dict[str, str] = {
    "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
    "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
    "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
    "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
    "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
    "os_hard_ram": sys_info.sys_hardware.ram.size,
}

cpu_url: str = "/api/info/hardware/cpu"
expected_api_output_cpu: dict[str, str] = {
    "os_cpu_arch": sys_info.sys_hardware.cpu.cpu_arch,
    "os_cpu_cores": sys_info.sys_hardware.cpu.cpu_cores,
    "os_cpu_core_clock_max": sys_info.sys_hardware.cpu.cpu_core_clock_max,
    "os_cpu_core_clock_min": sys_info.sys_hardware.cpu.cpu_core_clock_min,
    "os_cpu_threads": sys_info.sys_hardware.cpu.cpu_threads,
}

ram_url: str = "/api/info/hardware/ram"
expected_api_output_ram: dict[str, str] = {
    "os_hard_ram": sys_info.sys_hardware.ram.size,
}

reserve_url: str = "/api/reserve-server"
expected_api_server_booking: dict[str, str | int] = {"username": "test", "duration": 0}

expected_api_output_404: dict[str, str] = {"error": "Not Found"}


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


class TestApiServerStatus:
    def test_api_server_status(self, client) -> None:
        """Tests that the server status api returns the expected output."""

        logger.test.test_case_start(self, "Api server status")
        api = client.get(server_status_url)
        assert api.status_code == 200
        assert api.json == expected_server_status_output


class TestApiInfo:
    def test_api_info_full(self, client) -> None:
        """Tests that the api returns the full system info."""

        logger.test.test_case_start(self, "Api Full info")
        api = client.get(full_info_url)
        assert api.json == expected_api_output_full

    class TestRequestMethodFullInfo:
        def test_api_info_full_fail_post(self, client) -> None:
            """Tests that the api will return status code 405
            when using the api with the 'POST' method.
            """

            logger.test.test_case_start(self, "Api Full info 'POST' method")
            api = client.post(full_info_url)

            assert api.status_code == 405

        def test_api_info_full_fail_put(self, client) -> None:
            """Tests that the api will return status code 405
            when using the api with the 'PUT' method.
            """

            logger.test.test_case_start(self, "Api Full info 'PUT' method")
            api = client.put(full_info_url)
            assert api.status_code == 405

        def test_api_info_full_fail_delete(self, client) -> None:
            """Tests that the api will return status code 405
            when using the api with the 'DELETE' method.
            """

            logger.test.test_case_start(self, "Api Full info 'DELETE' method")
            api = client.delete(full_info_url)
            assert api.status_code == 405

    class TestApiOSInfo:
        def test_api_info_os(self, client) -> None:
            """Tests that the api returns the OS info."""

            logger.test.test_case_start(self, "Api os info test")
            api = client.get(os_url)
            assert api.json == expected_api_output_os

        class TestRequestMethodOS:
            def test_api_info_os_fail_post(self, client) -> None:
                """Tests that the api will return status code 405
                when using the api with the 'POST' method.
                """

                logger.test.test_case_start(self, "Api OS info 'POST' method")
                api = client.post(os_url)

                assert api.status_code == 405

            def test_api_info_os_fail_put(self, client) -> None:
                """Tests that the api will return status code 405
                when using the api with the 'PUT' method.
                """

                logger.test.test_case_start(self, "Api OS info 'PUT' method")
                api = client.put(os_url)
                assert api.status_code == 405

            def test_api_info_os_fail_delete(self, client) -> None:
                """Tests that the api will return status code 405
                when using the api with the 'DELETE' method.
                """

                logger.test.test_case_start(self, "Api OS info 'DELETE' method")
                api = client.delete(os_url)
                assert api.status_code == 405

        class TestApiOSInfoNetwork:
            def test_api_info_os_network(self, client) -> None:
                """Tests that the api returns the OS info."""

                logger.test.test_case_start(self, "Api network info test")
                api = client.get(network_url)
                assert api.json == expected_api_output_network

            class TestRequestMethodNetwork:
                def test_api_info_os_network_fail_post(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'POST' method.
                    """

                    logger.test.test_case_start(self, "Api Network info 'POST' method")
                    api = client.post(network_url)

                    assert api.status_code == 405

                def test_api_info_os_network_fail_put(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'PUT' method.
                    """

                    logger.test.test_case_start(self, "Api Network info 'PUT' method")
                    api = client.put(network_url)
                    assert api.status_code == 405

                def test_api_info_os_network_fail_delete(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'DELETE' method.
                    """

                    logger.test.test_case_start(self, "Api Network info 'DELETE' method")
                    api = client.delete(network_url)
                    assert api.status_code == 405

    class TestApiHardwareInfo:
        def test_api_info_hardware(self, client) -> None:
            """Tests that the api returns the hardware info."""

            logger.test.test_case_start(self, "Api hardware info test")
            api = client.get(hardware_url)
            assert api.json == expected_api_output_hardware

        class TestRequestMethodHardware:
            def test_api_info_hardware_fail_post(self, client) -> None:
                """Tests that the api will return status code 405
                when using the api with the 'POST' method.
                """

                logger.test.test_case_start(self, "Api Hardware info 'POST' method")
                api = client.post(hardware_url)

                assert api.status_code == 405

            def test_api_info_hardware_fail_put(self, client) -> None:
                """Tests that the api will return status code 405
                when using the api with the 'PUT' method.
                """

                logger.test.test_case_start(self, "Api Hardware info 'PUT' method")
                api = client.put(hardware_url)
                assert api.status_code == 405

            def test_api_info_hardware_fail_delete(self, client) -> None:
                """Tests that the api will return status code 405
                when using the api with the 'DELETE' method.
                """

                logger.test.test_case_start(self, "Api Hardware info 'DELETE' method")
                api = client.delete(hardware_url)
                assert api.status_code == 405

        class TestApiHardwareInfoCPU:
            def test_api_info_hardware_cpu(self, client) -> None:
                """Tests that the api returns the cpu hardware info."""

                logger.test.test_case_start(self, "Api cpu hardware info test")
                api = client.get(cpu_url)
                assert api.json == expected_api_output_cpu

            class TestRequestMethodHardwareCPU:
                def test_api_info_hardware_cpu_fail_post(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'POST' method.
                    """

                    logger.test.test_case_start(self, "Api CPU info 'POST' method")
                    api = client.post(cpu_url)
                    assert api.status_code == 405

                def test_api_info_hardware_cpu_fail_put(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'PUT' method.
                    """

                    logger.test.test_case_start(self, "Api CPU info 'PUT' method")
                    api = client.put(cpu_url)
                    assert api.status_code == 405

                def test_api_info_hardware_cpu_fail_delete(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'DELETE' method.
                    """

                    logger.test.test_case_start(self, "Api CPU info 'DELETE' method")
                    api = client.delete(cpu_url)
                    assert api.status_code == 405

        class TestApiHardwareInfoRAM:
            def test_api_info_hardware_ram(self, client) -> None:
                """Tests that the api returns the hardware info."""

                logger.test.test_case_start(self, "Api hardware info test")
                api = client.get(ram_url)
                assert api.json == expected_api_output_ram

            class TestRequestMethodHardwareRAM:
                def test_api_info_hardware_ram_fail_post(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'POST' method.
                    """

                    logger.test.test_case_start(self, "Api RAM info 'POST' method")
                    api = client.post(ram_url)

                    assert api.status_code == 405

                def test_api_info_hardware_ram_fail_put(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'PUT' method.
                    """

                    logger.test.test_case_start(self, "Api RAM info 'PUT' method")
                    api = client.put(ram_url)
                    assert api.status_code == 405

                def test_api_info_hardware_ram_fail_delete(self, client) -> None:
                    """Tests that the api will return status code 405
                    when using the api with the 'DELETE' method.
                    """

                    logger.test.test_case_start(self, "Api RAM info 'DELETE' method")
                    api = client.delete(ram_url)
                    assert api.status_code == 405

    def test_api_404_error(self, client) -> None:
        """Tests that the api returns a 404 error when the url is invalid."""

        logger.test.test_case_start(self, "Api 404 'GET' error test")
        api = client.get("/invalid_404")
        assert api.status_code == 404
        assert api.json == expected_api_output_404


class TestApiServerBooking:
    def test_api_server_booking(self, client) -> None:
        """Tests that the server booking api returns a status code of 200
        and that the arguments inputted are accepted.
        """

        logger.test.test_case_start(self, "Api server booking")
        api = client.post(reserve_url, data={"username": "test", "duration": 0})
        assert api.status_code == 200
        assert api.json == expected_api_server_booking

    def test_api_server_booking_fail(self, client) -> None:
        """Tests that the server booking api returns a status code of 400 due to
        the request missing an argument or arguments are invalid.
        """

        logger.test.test_case_start(self, "Api server booking invalid input")
        api = client.post(reserve_url, data={"duration": 0})
        assert api.status_code == 400

    class TestRequestMethodServerBooking:
        def test_api_server_booking_fail_get(self, client) -> None:
            """Tests that the api will return status code 405
            when using the api with the 'GET' method.
            """

            logger.test.test_case_start(self, "Api server booking 'GET' method")
            api = client.get(reserve_url)

            assert api.status_code == 405

        def test_api_server_booking_fail_put(self, client) -> None:
            """Tests that the api will return status code 405
            when using the api with the 'PUT' method.
            """

            logger.test.test_case_start(self, "Api server booking 'PUT' method")
            api = client.put(reserve_url)
            assert api.status_code == 405

        def test_api_server_booking_fail_delete(self, client) -> None:
            """Tests that the api will return status code 405
            when using the api with the 'DELETE' method.
            """

            logger.test.test_case_start(self, "Api server booking 'DELETE' method")
            api = client.delete(reserve_url)
            assert api.status_code == 405
