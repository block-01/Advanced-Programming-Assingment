package server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	public Item(){}

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



	public void SetID(Long id){
		this.id = id;
	}

	public Long GetID() {
		return id;
	}

	public void SetServerName(String ServerName){
		this.server_name = ServerName;
	}

	public String GetServerName(){
		return server_name;
	}

	public void SetOsHostname(String Hostname) {
		this.os_hostname = Hostname;
	}

	public String GetOsHostname() {
		return os_hostname;
	}

	public void SetOsVersion(String Version) {
		this.os_version = Version;
	}

	public String GetOsVersion() {
		return os_version;
	}

	public void SetOsShell(String Shell) {
		this.os_shell = Shell;
	}

	public String GetOsShell() {
		return os_shell;
	}

	public void SetNetIP(String IP) {
		this.net_ip = IP;
	}

	public String GetNetIP(){
		return net_ip;
	}

	public void SetNetMacAddress(String MacAddress) {
		this.net_mac_address = MacAddress;
	}

	public String GetNetMacAddress() {
		return net_mac_address;
	}

	public void SetCpuArch(String Arch) {
		this.os_cpu_arch = Arch;
	}

	public String GetCpuArch(){
		return os_cpu_arch;
	}

	public void SetCpuCores(String Cores) {
		this.os_cpu_cores = Cores;
	}

	public String GetCpuCores() {
		return os_cpu_cores;
	}

	public void SetCpuCoreClockMax(String ClockMax) {
		this.os_cpu_core_clock_max = ClockMax;
	}

	public String GetCpuCoreClockMax() {
		return os_cpu_core_clock_max;
	}

	public void SetCpuCoreClockMin(String ClockMin) {
		this.os_cpu_core_clock_min = ClockMin;
	}

	public String GetCpuCoreClockMin() {
		return os_cpu_core_clock_min;
	}

	public void SetCpuThreads(String Threads) {
		this.os_cpu_threads = Threads;
	}

	public String GetCpuThreads() {
		return os_cpu_threads;
	}

	public void SetRam(String Ram) {
		this.os_hard_ram = Ram;
	}

	public String GetRam(){
		return os_hard_ram;
	}
}
