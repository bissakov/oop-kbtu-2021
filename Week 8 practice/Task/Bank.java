import java.util.ArrayList;

public class Bank {
	private ArrayList<Client> clients;
	private ArrayList<Account> accounts;
	private String name;

	public Bank(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name can not be empty!");
		}
		this.name = name;
		accounts = new ArrayList<>();
		clients = new ArrayList<>();
	}

	public boolean createAccount(Account account) {
		accounts.add(account);
		return true;
	}

	public boolean createClient(Client client) {
		clients.add(client);
		return true;
	}

	public String makeReport() {
		return "{Clients:" + countClients() + " Accounts:" + countAccounts() + "}"; 
	}

	private int countClients() {
		return clients.size();
	}

	private int countAccounts() {
		return accounts.size();
	}

}