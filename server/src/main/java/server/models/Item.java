package server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Item datatype
 *
 * The Datatype and related functions for the Item table within the database.
 *
 * @author Lily Wilks
 * @since 1.0.0
 */
@Entity
public class Item {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String server_name;
	private String os_version;
	private String os_hostname;
	private String os_shell;
	private String net_ip;
	private String net_mac_address;
	private String os_cpu_arch;
	private String os_cpu_cores;
	private String os_cpu_core_clock_max;
	private String os_cpu_core_clock_min;
	private String os_cpu_threads;
	private String os_hard_ram;

	/**
	 * The Item datatype
	 */
	public Item(){}

	/**
	 * @param server_name The name of the server.
	 * @param os_version The version of the Operating System.
	 * @param os_hostname The hostname of the server.
	 * @param os_shell The shell environment that the server uses.
	 * @param net_ip The servers IP address.
	 * @param net_mac_address The server mac address.
	 * @param os_cpu_arch The CPU architecture.
	 * @param os_cpu_cores The number of CPU cores
	 * @param os_cpu_core_clock_max The max CPU clock frequency.
	 * @param os_cpu_core_clock_min The minimum CPU clock frequency.
	 * @param os_cpu_threads The number of CPU threads.
	 * @param os_hard_ram The amount of system RAM.
	 */
	public Item(
		String server_name,
		String os_version,
		String os_hostname,
		String os_shell,
		String net_ip,
		String net_mac_address,
		String os_cpu_arch,
		String os_cpu_cores,
		String os_cpu_core_clock_max,
		String os_cpu_core_clock_min,
		String os_cpu_threads,
		String os_hard_ram
	){
		 this.server_name = server_name;
		 this.os_version = os_version;
		 this.os_hostname = os_hostname;
		 this.os_shell = os_shell;
		 this.net_ip = net_ip;
		 this.net_mac_address = net_mac_address;
		 this.os_cpu_arch = os_cpu_arch;
		 this.os_cpu_cores = os_cpu_cores;
		 this.os_cpu_core_clock_max = os_cpu_core_clock_max;
		 this.os_cpu_core_clock_min = os_cpu_core_clock_min;
		 this.os_cpu_threads = os_cpu_threads;
		 this.os_hard_ram = os_hard_ram;
	}


	/**
	 * Setting an items ID.
	 *
	 * @param id The id that is being set.
	 */
	public void SetID(Long id){
		this.id = id;
	}

	/**
	 * Fetches the ID of the Item.
	 *
	 * @return The id of the item in the database.
	 */
	public Long GetID() {
		return id;
	}

	/**
	 * Set the name of the server.
	 *
	 * @param ServerName The name of the server.
	 */
	public void SetServerName(String ServerName){
		this.server_name = ServerName;
	}

	/**
	 * Fetch the name of the server.
	 *
	 * @return The name of the server.
	 */
	public String GetServerName(){
		return server_name;
	}

	/**
	 * Sets the OS's Hostname.
	 *
	 * @param Hostname The hostname of the Operating System.
	 */
	public void SetOsHostname(String Hostname) {
		this.os_hostname = Hostname;
	}

	/**
	 * Fetch the OS's hostname.
	 *
	 * @return The hostname of the Operating System.
	 */
	public String GetOsHostname() {
		return os_hostname;
	}

	/**
	 * Set the version of the Operating System.
	 *
	 * @param Version The version of the Operating System.
	 */
	public void SetOsVersion(String Version) {
		this.os_version = Version;
	}

	/**
	 * Fetch the Operating Systems Version.
	 *
	 * @return The version of the Operating System.
	 */
	public String GetOsVersion() {
		return os_version;
	}

	/**
	 * Set the shell environment that the Operating System uses.
	 *
	 * @param Shell The Shell that the Operating System uses.
	 */
	public void SetOsShell(String Shell) {
		this.os_shell = Shell;
	}

	/**
	 * Fetch the shell environment that the Operating System uses.
	 *
	 * @return The Shell that the Operating System uses.
	 */
	public String GetOsShell() {
		return os_shell;
	}

	/**
	 * Set the IP address that the Operating System uses.
	 *
	 * @param IP The Operating Systems IP address.
	 */
	public void SetNetIP(String IP) {
		this.net_ip = IP;
	}

	/**
	 * Fetch the Operating Systems IP address.
	 *
	 * @return The Operating Systems IP address.
	 */
	public String GetNetIP(){
		return net_ip;
	}

	/**
	 * Set the Mac Address that the server has.
	 *
	 * @param MacAddress The Mac Address of the server.
	 */
	public void SetNetMacAddress(String MacAddress) {
		this.net_mac_address = MacAddress;
	}

	/**
	 * Fetch the servers Mac Address.
	 *
	 * @return The servers Mac Address
	 */
	public String GetNetMacAddress() {
		return net_mac_address;
	}

	/**
	 * Set the CPU architecture that the server uses.
	 *
	 * @param Arch The CPU architecture of the server.
	 */
	public void SetCpuArch(String Arch) {
		this.os_cpu_arch = Arch;
	}

	/**
	 * Fetch the servers CPU architecture.
	 *
	 * @return The CPU architecture of the server.
	 */
	public String GetCpuArch(){
		return os_cpu_arch;
	}

	/**
	 * Set the number of CPU Cores that the server has.
	 *
	 * @param Cores The number of CPU cores that the servers CPU has.
	 */
	public void SetCpuCores(String Cores) {
		this.os_cpu_cores = Cores;
	}

	/**
	 * Fetch the number of CPU cores that the server has.
	 *
	 * @return The number of CPU cores that the servers CPU has.
	 */
	public String GetCpuCores() {
		return os_cpu_cores;
	}

	/**
	 * Set the maximum Clock speed of the CPU cores.
	 *
	 * @param ClockMax The maximum Clock speed of the CPU cores.
	 */
	public void SetCpuCoreClockMax(String ClockMax) {
		this.os_cpu_core_clock_max = ClockMax;
	}

	/**
	 * Fetch the maximum Clock speed of the CPU cores.
	 *
	 * @return The maximum Clock speed of the CPU cores.
	 */
	public String GetCpuCoreClockMax() {
		return os_cpu_core_clock_max;
	}

	/**
	 * Set the minimum Clock speed of the CPU cores.
	 *
	 * @param ClockMin The minimum Clock speed of the CPU cores.
	 */
	public void SetCpuCoreClockMin(String ClockMin) {
		this.os_cpu_core_clock_min = ClockMin;
	}

	/**
	 * Fetch the minimum Clock speed of the CPU cores.
	 *
	 * @return The minimum Clock speed of the CPU cores.
	 */
	public String GetCpuCoreClockMin() {
		return os_cpu_core_clock_min;
	}

	/**
	 * Set the number of CPU threads that the servers CPU has.
	 *
	 * @param Threads The number of CPU threads that the server has.
	 */
	public void SetCpuThreads(String Threads) {
		this.os_cpu_threads = Threads;
	}

	/**
	 * Fetch the number of CPU threads that the servers CPU has.
	 *
	 * @return The number of CPU threads that the server has.
	 */
	public String GetCpuThreads() {
		return os_cpu_threads;
	}

	/**
	 * Set the amount of RAM (GB) that the server has.
	 *
	 * @param Ram The amount of RAM (GB) that the server has.
	 */
	public void SetRam(String Ram) {
		this.os_hard_ram = Ram;
	}

	/**
	 * Fetch the amount of RAM (GB) that the server has.
	 *
	 * @return The amount of RAM (GB) that the server has.
	 */
	public String GetRam(){
		return os_hard_ram;
	}
}
