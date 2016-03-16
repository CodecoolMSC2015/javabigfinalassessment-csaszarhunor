package employeeManager;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Set;

public class PersonStoreClientSocket {

    public void fetch(String host, int port, String criteria, SearchType searchType) {
        try {
            Socket socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            
            objectOutputStream.writeObject(criteria);
            objectOutputStream.writeObject(searchType);
            Set<Person> sortedPersons = (Set<Person>) objectInputStream.readObject();
            
            objectInputStream.close();
            inputStream.close();
            objectOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e){
        	e.printStackTrace();
        	}
        }
}
