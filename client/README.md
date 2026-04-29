# Client

This directory contains the server application that the dashboard requests data from.

## Setup and execution

### Dependencies

Python 3.12

#### Linux/MacOS

1. `python3.12 -m venv .venv`
2. `python3 -m pip install -r requirements.txt`
3. `source .venv/bin/activate`
4. `./client/main.py`

#### Windows **(IMPORTANT)**

Windows is currently not supported due to the [simple_term_menu](https://pypi.org/project/simple-term-menu/) package and multiple of the system information functions within the api not being supported in windows.
