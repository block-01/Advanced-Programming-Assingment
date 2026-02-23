"""
Functions related to the terminal user interface for managing the server-side application.
"""

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
                _display_info()
            elif menu == 1:
                print("Settings selected")
                time.sleep(5)
            elif menu == 2:
                print("Exiting program")
                return True
        return False

    except Exception:
        return False


def _display_info():
    """Display client system info"""

    core_usage = ""
    for i, perc in sys_info.sys_hardware.cpu.usage.per_core.items():
        core_usage += f"\n                {i}: {perc}"
    info_menu: str = f"""
        OS Info:
          Hostname: {sys_info.software.os.hostname}
          OS platform: {sys_info.software.os.platform}
          OS shell type: {sys_info.software.os.shell}
          OS version: {sys_info.software.os.version}
          net_ip: #TODO

        Hardware Info:
          CPU:
            CPU architecture: {sys_info.sys_hardware.cpu.cpu_arch}
            CPU cores: {sys_info.sys_hardware.cpu.cpu_cores}
            CPU threads: {sys_info.sys_hardware.cpu.cpu_threads}
            CPU max clock speed: {sys_info.sys_hardware.cpu.cpu_core_clock_max}
            CPU min clock speed: {sys_info.sys_hardware.cpu.cpu_core_clock_min}
            Usage:
              CPU total usage: {sys_info.sys_hardware.cpu.usage.total}
              CPU per core usage: {core_usage}
          RAM:
            RAM: {sys_info.sys_hardware.ram.size}
            Usage:
              available: {sys_info.sys_hardware.ram.usage.available}
              user: {sys_info.sys_hardware.ram.usage.used}
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
