#!/usr/bin/env python3
from argparse import ArgumentParser
from term_ui import main_tui
from api import app

if __name__ == "__main__":
    arg_pars: ArgumentParser = (
        ArgumentParser(  # TODO: Come up with a good description for the application
            description="""
		Server management:
		The client that connects to the server.
		"""
        )
    )

    arg_pars.add_argument(
        "--settings",
        help="Opens up the applications configuration menu",
        action="store_true",
    )

    args = arg_pars.parse_args()

    if args.settings:
        main_tui.main_menu()
    else:
        app.run(host="0.0.0.0", port=5000)
