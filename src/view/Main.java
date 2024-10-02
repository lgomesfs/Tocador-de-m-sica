package view;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		Scanner sc = new Scanner(System.in);

		String op = "";

		while (!op.equals("N")) {

			System.out.print("Digite o nome da música que deseja tocar (Obs.: o arquivo deve ser .wav): ");
			String musica = sc.nextLine();

			File file = new File(musica);
			
			if(!file.exists()) {
				System.out.println("O arquivo não existe");
				break;
			}

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

			Clip clip = AudioSystem.getClip();

			clip.open(audioStream);

			String resposta = "";

			while (!resposta.equals("Q")) {
				
				System.out.println("Pressione:");
				System.out.println("P - Play;");
				System.out.println("S - Parar;");
				System.out.println("R - Voltar;");
				System.out.println("Q - Sair.");

				resposta = sc.nextLine();
				resposta = resposta.toUpperCase();

				switch (resposta) {
				
				case ("P"):
				
					clip.start();
					break;
				
				case ("S"):
				
					clip.stop();
					break;
				
				case ("R"):
					
					clip.setMicrosecondPosition(0);
					break;
				
				case ("Q"):
				
					clip.close();
					break;
				
				default:
					
					System.out.println("Resposta inválida.");
					break;
				
				}
			}
			
			System.out.print("Deseja tocar outra música?(S/N): ");
			
			op = sc.nextLine();
			op=op.toUpperCase();
		}
		
		System.out.println("Encerrando o programa...");
		sc.close();
	}

}
