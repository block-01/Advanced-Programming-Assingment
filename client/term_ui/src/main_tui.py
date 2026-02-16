from simple_term_menu import TerminalMenu
from sys_info import sys_info
import time


def main_menu() -> bool:
    """Main menu function for client side info and settings"""

    main_menu_title = "Client Setting and Info"
    options = ["[i] System Info", "[s] Settings", "[q] Quit"]
    main_menu_cursor = "> "
    main_menu_exit = False

    main_menu = TerminalMenu(
        menu_entries=options,
        title=main_menu_title,
        menu_cursor=main_menu_cursor,
        cycle_cursor=True,
        clear_screen=True,
    )
    try:
        while not main_menu_exit:
            menu = main_menu.show()
            if menu == 0:
                display_info()
            elif menu == 1:
                print("Settings selected")
                time.sleep(5)
            elif menu == 2:
                print("Exiting program")
                return True
        return False

    except Exception:
        return False


def display_info():
    """Display client system info"""

    info_menu: str = f"""
OS Info:
\tHostname: {sys_info.os_software.os_hostname}
\tOS platform: {sys_info.os_software.os_platform}
\tOS shell type: {sys_info.os_software.os_shell}
\tOS version: {sys_info.os_software.os_version}
\tIP: #TODO

Hardware Info:
\tCPU architecture: {sys_info.sys_hardware.os_cpu_arch}
\tCPU cores: #TODO
\tCPU clock speed: #TODO
\tRAM: {sys_info.sys_hardware.os_hard_ram}
	"""

    options = ["[b] Back to Main Menu"]
    info_display = TerminalMenu(
        options,
        title=info_menu,
        cycle_cursor=True,
        clear_screen=True,
    )
    info = info_display.show()
    if info == 0:
        print("Back Selected")
        return True
    return False
