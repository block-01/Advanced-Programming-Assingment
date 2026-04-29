from pathlib import Path
import yaml
import os

from logger import logger

settings_path: Path = Path(
    os.path.dirname(os.path.abspath(__file__)).replace("settings/src", "config/settings.yaml")
)


def fetch_settings():
    """Fetches the applications settings

    Returns:
        The settings file.
    """
    try:
        if settings_path.exists():
            with open(settings_path, "r") as file:
                settings = yaml.load(file, Loader=yaml.FullLoader)
                return settings
        return ""

    except Exception as e:
        logger.exception("Failed to fetch application settings.", e)
        return None


def set_settings_ip(IP: str) -> bool:
    """Sets the IP within the settings file.

    Args:
        IP: The IP to be set within Settings file.

    Returns:
        If the operation to save the IP address was successful.
    """
    try:
        if settings_path.exists():
            current_config = fetch_settings()
            current_config["IP"] = IP

            with open(settings_path, "w") as file:
                file.write(yaml.dump(current_config, default_flow_style=False))
                return True
        with open(settings_path, "w") as file:
            file.write(yaml.dump({"IP": IP}, default_flow_style=False))
            return True

    except Exception as e:
        logger.exception("Failed to set dashboard IP within settings.", e)
        return False


def get_settings_ip() -> str | None:
    """Fetches the IP address for dashboard from the settings file

    Returns:
        The Dashboard IP address.
    """
    try:
        current_config = fetch_settings()

        return current_config["IP"]

    except Exception as e:
        logger.exception("Failed to fetch the dashboard IP address from the settings file.", e)
        return None
