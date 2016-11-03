package br.ic.ufal.IA1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// Caminho para a pasta onde será lido o arquivo com a base de dados
		String path = "C:\\Users\\davidson.sestaro\\Dropbox\\IA\\";

		// Carrega os atributos da base de dados
		ListDiscreteAttributes attributes = FileReader.readAttributes(path + "PlayGolf.txt");

		// Carrega os registros da base de dados
		List<record> records = FileReader.readDataset(path + "PlayGolf.txt", attributes);

		// Instância o primeiro ramo da nossa árvore
		Node root = new Node();
		root.setData(records);

		// Inicia o processamento da árvore
		ID3 id3 = new ID3();
		id3.generateTree(records, root, attributes);

		// Imprime a arvore resultante no arquivo Result.txt
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(path + "Result.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		FileWriter.writeTree(root, writer, 0);

		// Fecha o arquivo
		writer.close();

	}

}
