import os
import requests
from logger import logger
from tabulate import tabulate

username: str = os.environ["USER"]
hostname: str = os.uname().nodename


def reserve(duration: int, ip: str | None) -> bool:
    """Reserves a server for use by a single user

    Args:
        duration: How long the user is going to use the server for.
        ip: The IP address of the dashboard.

    Returns:
        bool: If the server was successfully reserved.
    """
    try:
        if not ip:
            return False

        if not _check_dashboard_status(ip):
            return False

        reserve: bool = _reserve_server_API(ip=ip, duration=duration)

        if not reserve:
            return False

        return True

    except Exception as e:
        logger.exception("Failed to reserve the server", e)
        return False


def remove_reservation(ip: str | None) -> bool:
    """Removes the reservation from the server

    Args:
        ip: The IP address of the server that is being unreserved.

    Returns:
        bool: If the server was successfully unreserved or not.
    """
    try:
        if not ip:
            return False
        return True

    except Exception as e:
        logger.exception("Failed to remove the reservation from the server", e)
        return False


def return_reservations(ip: str | None) -> None:
    """_summary_"""
    try:
        if ip:
            server_reservations: requests.Response = requests.get(
                f"http://{ip}:25580/reservations/all"
            )
            if server_reservations.status_code != 200:
                return None
            reservations = server_reservations.json()
            print(tabulate(reservations, headers="keys", tablefmt="grid"))
            return None
        print("Unable to fetch server reservations")
    except Exception as e:
        logger.exception("Failed to fetch list of all server reservations", e)


def _check_dashboard_status(ip: str) -> bool:
    """Checks the status of the dashboard.

    Args:
        ip: The IP address of the dashboard's status being checked

    Returns:
       bool: If the dashboard is online or not
    """
    try:
        dashboard_status = requests.get(f"http://{ip}:25580/api/dashboard-status")

        if dashboard_status.status_code != 200:
            logger.warning(f"Dashboard at `{ip}:25580` is not online.")
            return False
        return True

    except Exception as e:
        logger.exception("Failed to check Dashboard status", e)
        return False


def _reserve_server_API(ip: str, duration: int) -> bool:
    """Checks the status of the dashboard.

    Args:
        ip: The IP address of the dashboard's status being checked

    Returns:
       bool: If the dashboard is online or not
    """
    try:
        dashboard_status = requests.post(
            f"http://{ip}:25580/reservation/add",
            {"Username": username, "Duration": duration, "Hostname": hostname},
        )

        if dashboard_status.status_code == 500:
            print("Failed to reserve server, please try again later.")
            return False

        if dashboard_status.status_code != 200:
            logger.warning(f"Dashboard at `{ip}:25580` is not online.")
            return False

        print(f"Server has been reserved by {username} for {duration} hours.")
        return True

    except Exception as e:
        logger.exception("Failed to check Dashboard status", e)
        return False
