package multimedial;
import interfacce.*;

public class Video extends ElementoMultimediale implements Play, Brightness {
	//campi
	private int durata;
	private int volume;
	private int luminosita;

	//getter
	public int getDurata() {
		return durata;
	}
	
	//setter
	public void setDurata(int durata) {
		this.durata = durata;
		this.volume=0;//impostato di default
		this.luminosita=0;//impostato di default
	}

	//costruttore
	public Video(String titolo, int durata) {
		super(titolo);
		this.durata=durata;
		
	}

	//metodi interfaccia Play
		@Override
		public void play() {
			for (int i = 0; i < getDurata(); i++) {
				System.out.println(getTitolo()); //stampa il titolo tante volte quanto e' la durata
				
			}
		}

		@Override
		public void louder(int v) {
			volume+=v;//aggiungo il valore passato come parametro
			if ((volume)<=16) {//16 e' il volume massimo impostabile
				
				if (v >= volume) {
					System.out.print(getTitolo()+ " volume aggiornato: ");
					for (int i = 0; i < volume; i++) {
						System.out.print((char)33);//stampa '!' tante volte quanto e' stato impostato il volume
					}
					System.out.println();
				}
			}else
				System.out.println("Volume massimo raggiunto");//se il volume e' superiore a 16
		}

		@Override
		public void weaker(int v) {
			if (v>=0) {// verifica se il parametro e intero positivo
				volume-=v;// decremento volume 
				System.out.print(getTitolo()+ " volume aggiornato: ");
				for (int i = volume; i > 0; i--) {
					System.out.print((char)33);//stampo il nuovo valore di volume
				}
				System.out.println();
			}else
				System.out.println("Impossibile impostare un volume negativo!");//se il volume e' negativo
		}

	//metodi interfaccia Brightness
	@Override
	public void brighter(int l) {
		luminosita+=l;//aggiungo il valore passato come parametro
		if (luminosita<=16) {//16 è la luminosita' massima
			System.out.print(getTitolo()+ " luminosita aggiornata: ");
			for (int i = 0; i < luminosita; i++) {
				System.out.print((char)42);//stampa '*' tante volte quanto e' stata impostata la luminosita'
			}
			System.out.println();
		}else
			System.out.println("Luminosita massima raggiunta");//se la luminosita' e' superiore a 16
	}

	@Override
	public void darker(int l) {
		if (l>=0) {//controllo che il parametro sia un intero positivo
			luminosita-=l;//decremento il valore di luminosita'
			System.out.print(getTitolo()+ " luminosita aggiornata: ");
			for (int i = luminosita; i > 0; i--) {
				System.out.print((char)42);//stampo il nuovo valore di luminosita'
			}
			System.out.println();
		}else
			System.out.println("Impossibile impostare una luminosita negativa!");//se la luminosita' e' negativa
	}

	@Override
	public String toString() {
		return super.toString()+"Video [durata=" + durata + ", volume=" + volume + ", luminosita=" + luminosita + "]";
	}

}
