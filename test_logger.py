from logger import logger
import pytest


class TestLogger:
        def test_debug(self):

                try:
                        logger.debug("debug test")
                except pytest.fail.Exception:
                        logger.test.test_case_fail("test_debug")

        def test_warning(self):
                try:
                        logger.warning("warning test")
                except pytest.fail.Exception:
                        logger.test.test_case_fail("test_warning")

        def test_exception(self):
                try:
                        logger.exception("exception test")
                except pytest.fail.Exception:
                        logger.test.test_case_fail("test_exception")
