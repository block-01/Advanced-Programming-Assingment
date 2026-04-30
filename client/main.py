#!/usr/bin/env python3
from argparse import ArgumentParser
import sys
from settings import settings
from reservation import reservation
from term_ui import main_tui
from api import app

accepted_durations: list = [
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18,
    19,
    20,
    21,
    22,
    23,
    24,
]
if __name__ == "__main__":
    arg_pars: ArgumentParser = ArgumentParser(
        description="""
		Server management and information client:
		This is the client that the sends data and information to the central dashboard application.
		"""
    )
    settings.fetch_settings()
    arg_pars.add_argument(
        "--settings",
        help="Opens up the applications configuration menu",
        action="store_true",
    )

    arg_pars.add_argument(
        "--reserve",
        "-r",
        help="Reserves a server for a specified duration",
        type=int,
        choices=accepted_durations,
    )

    arg_pars.add_argument(
        "--lsr",
        help="Lists all of the current server reservations.",
        action="store_true",
    )

    arg_pars.add_argument(
        "--rmr",
        help="Remove the reservation for the current server.",
        action="store_true",
    )

    arg_pars.add_argument(
        "--version",
        "-v",
        help="Returns the applications Version",
        action="store_true",
    )

    args = arg_pars.parse_args()

    if args.reserve in accepted_durations:
        if reservation.reserve(args.reserve, settings.get_settings_ip()):
            reservation.return_reservations(settings.get_settings_ip())
        else:
            print("""
                  Failed to reserve Server.
                  Either unable to connect to dashboard or Server is already reserved.
                  Use the option `--lsr` to check if the server is already reserved.
                  """)
        sys.exit(0)

    if args.lsr:
        reservation.return_reservations(settings.get_settings_ip())
        sys.exit(0)

    if args.rmr:
        reservation.remove_reservation(settings.get_settings_ip())
        sys.exit(0)

    if args.version:
        print("Running Client version: 1.0.0\nDate: 29/04/2026")
        sys.exit(0)

    if args.settings:
        main_tui.main_menu()
    else:
        app.run(host="0.0.0.0", port=5000)
