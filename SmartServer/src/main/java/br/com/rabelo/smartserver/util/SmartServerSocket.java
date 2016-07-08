package br.com.rabelo.smartserver.util;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SmartServerSocket {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private BufferedReader inFromClient;
	private InputStreamReader inputClient;
	private String clientSentence;

	public SmartServerSocket() {
		try {

			server = new ServerSocket(5001);

			while (true) {

				System.out.println("Aguardando conexão ...");
				connection = server.accept();
				inputClient = new InputStreamReader(connection.getInputStream());
				inFromClient = new BufferedReader(inputClient);
				clientSentence = inFromClient.readLine();
				System.out.println(clientSentence);

				ThreadServer ts = new ThreadServer();
				ts.start();

			}
		} catch (EOFException eofException) {
			System.out.println("Cliente fechou conexão.");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public class ThreadServer extends Thread {

		public void run() {
			try {
				output = new ObjectOutputStream(connection.getOutputStream());
				input = new ObjectInputStream(connection.getInputStream());
				ProcessaConexao();
				closeConnection();
			} catch (IOException ex) {
			}
		}
	}

	private void ProcessaConexao() throws IOException {
		String message = "Conectado";
		output.writeObject(message);

		while (true) {
			try {
				message = (String) input.readObject();
				output.writeObject(message);
			} catch (ClassNotFoundException classNotFoundException) {
			}
		}
	}

	private void closeConnection() throws IOException {
		output.close();
		input.close();
		connection.close();
	}

	/*
	 * public static void main(String args[]) { SmartServerSocket app = new
	 * SmartServerSocket();
	 * System.out.println(app); }
	 */
}
