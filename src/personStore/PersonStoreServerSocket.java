package personStore;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

public class PersonStoreServerSocket {

	int PORT = 123;
	DataReader store = new CSVDataReader("persons.csv");
	
	private void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			Socket socket = serverSocket.accept();
			System.out.println("client connected");
			InputStream inputStream = socket.getInputStream();
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			System.out.println("streams established");

			String criteria = (String) objectInputStream.readObject();
			System.out.println("criteria received");
			SearchType searchType = (SearchType) objectInputStream.readObject();
			System.out.println("searchtype recieved");
			Set<Person> sortedPersons = store.getPersons(criteria, searchType);
			objectOutputStream.writeObject(sortedPersons);
			System.out.println("persons sorted and sent");

			objectOutputStream.close();
			outputStream.close();
			objectInputStream.close();
			inputStream.close();
			socket.close();
			serverSocket.close();
			System.out.println("server closed.");
			}
		catch (Exception e){
			e.printStackTrace();
			}
		}
	
	public static void main(String[] args) {
		
		new PersonStoreServerSocket().start();
		
	}
}
