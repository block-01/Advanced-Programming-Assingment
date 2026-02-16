"""
Tests that logger functions work properly
"""

from logger import logger
import pytest


class TestLogger:
    def test_debug(self) -> None:
        """Tests that the debug logger works."""

        logger.test.test_case_start(self, "Debug logger test")
        try:
            logger.debug("debug test")
        except pytest.fail.Exception:
            logger.test.test_case_fail("test_debug")

    def test_warning(self) -> None:
        """Tests that the warning logger works."""

        logger.test.test_case_start(self, "Warning logger test")
        try:
            logger.warning("warning test")
        except pytest.fail.Exception:
            logger.test.test_case_fail("test_warning")

    def test_exception(self) -> None:
        """Tests that the exception logger works."""

        logger.test.test_case_start(self, "Exception logger test")
        try:
            logger.exception("exception test")
        except pytest.fail.Exception:
            logger.test.test_case_fail("test_exception")
