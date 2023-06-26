public class Test {
    public static void main(String[] args) {

        String[] listaProiezioni = {
            String.valueOf('"') + "Avatar" + String.valueOf('"') + " 3 P 4", 
            String.valueOf('"') + "Guardiani della Galassia 3" + String.valueOf('"') + " 5",
            String.valueOf('"') + "Avengers: Endgame" + String.valueOf('"') + " 10 R 4", 
            String.valueOf('"') + "Cicciogamer: il film" + String.valueOf('"') + " 2 P 10", 
            String.valueOf('"') + "Supermario Bros: il film" + String.valueOf('"') + " 28 R 3", 

        };

        Cartellone c = new Cartellone("Uci cinemas", 30, listaProiezioni);

        c.elencaProiezioniPerGiorno();
        c.elencaProiezioniOrdineAggiunta();




    }
}
