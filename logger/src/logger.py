import datetime
import pytest

time = datetime.datetime.now()


def debug(message: str) -> None:
    """debug

    Args:
        message: The debug message that will be logged.
    """
    print("\033[0;35m" + f"[{time}]DEBUG: {message}" + "\033[0m")


def warning(message: str) -> None:
    """warning

    Args:
        message: The warning message that will be logged.
    """
    print("\033[1;33m" + f"[{time}]WARNING: {message}" + "\033[0m")


def exception(message: str, exception: Exception | None = None) -> None:
    """exception

    Args:
        message: The message that will be logged
        exception: If not None will contain the exception that occurred.
    """
    exception_message: str = "\033[1m\033[0;31m" + f"[{time}]EXCEPTION: {message}" + "\033[0m"

    if exception:
        exception_message += str(exception)
    print(exception_message)


class test:
    def test_case_start(self, test_case: str) -> None:
        """test_case_start

        Args:
            test_case: The name of the testcase.
        """
        print("\033[0;35m" + f"RUNNING TEST CASE: {test_case}" + "\033[0m")

    def test_case_fail(self, test_case: str) -> None:
        """test_case_fail

        Args:
            test_case: The name of the testcase that failed.
        """
        pytest.fail("\033[1m\033[0;31m" + f"TEST CASE: '{test_case}' has failed" + "\033[0m")
