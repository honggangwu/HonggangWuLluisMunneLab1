package prog2.vista;

import java.util.Scanner;
import prog2.model.Camping;
import prog2.vista.ExcepcioCamping;

public class VistaCamping {

    private Camping camping;

    private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_LLISTAR_ALLOTJAMENTS,
        MENU_PRINCIPAL_LLISTAR_ACCESSOS,
        MENU_PRINCIPAL_LLISTAR_TASQUES,
        MENU_PRINCIPAL_AFEGIR_TASCA,
        MENU_PRINCIPAL_COMPLETAR_TASCA,
        MENU_PRINCIPAL_CALCULAR_ACCESSOS_NO_ACCESSIBLES,
        MENU_PRINCIPAL_CALCULAR_METRES_TERRA,
        MENU_PRINCIPAL_GUARDAR,
        MENU_PRINCIPAL_CARREGAR,
        MENU_PRINCIPAL_SORTIR
    }

    private final String[] descMenuPrincipal = {
            "Llistar allotjaments",
            "Llistar accessos",
            "Llistar tasques de manteniment",
            "Afegir tasca de manteniment",
            "Completar tasca de manteniment",
            "Calcular accessos no accessibles",
            "Calcular metres de terra",
            "Guardar dades a fitxer",
            "Carregar dades des de fitxer",
            "Sortir"
    };

    public VistaCamping(String nomCamping) {
        camping = new Camping(nomCamping);
        camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {

        Scanner sc = new Scanner(System.in);

        Menu<OpcionsMenuPrincipal> menu =
                new Menu<>("Menú principal - " + camping.getNomCamping(),
                        OpcionsMenuPrincipal.values());

        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio = null;

        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            try {

                switch (opcio) {

                    case MENU_PRINCIPAL_LLISTAR_ALLOTJAMENTS:

                        System.out.print("Introdueix l'estat (Operatiu / No Operatiu): ");
                        String estatAllotjament = sc.nextLine();

                        System.out.println(camping.llistarAllotjaments(estatAllotjament));
                        break;

                    case MENU_PRINCIPAL_LLISTAR_ACCESSOS:

                        System.out.print("Introdueix l'estat (Obert / Tancat): ");
                        String estatAcces = sc.nextLine();

                        System.out.println(camping.llistarAccessos(estatAcces));
                        break;

                    case MENU_PRINCIPAL_LLISTAR_TASQUES:

                        System.out.println(camping.llistarTasquesManteniment());
                        break;

                    case MENU_PRINCIPAL_AFEGIR_TASCA:

                        System.out.print("Número de la tasca: ");
                        int num = Integer.parseInt(sc.nextLine());

                        System.out.print("Tipus de tasca: ");
                        String tipus = sc.nextLine();

                        System.out.print("ID de l'allotjament: ");
                        String idAllotjament = sc.nextLine();

                        System.out.print("Data: ");
                        String data = sc.nextLine();

                        System.out.print("Dies estimats: ");
                        int dies = Integer.parseInt(sc.nextLine());

                        camping.afegirTascaManteniment(
                                num,
                                tipus,
                                idAllotjament,
                                data,
                                dies
                        );

                        System.out.println("Tasca afegida correctament.");
                        break;

                    case MENU_PRINCIPAL_COMPLETAR_TASCA:

                        System.out.print("Número de la tasca a completar: ");
                        int numTasca = Integer.parseInt(sc.nextLine());

                        camping.completarTascaManteniment(numTasca);

                        System.out.println("Tasca completada correctament.");
                        break;

                    case MENU_PRINCIPAL_CALCULAR_ACCESSOS_NO_ACCESSIBLES:

                        int accessosNoAccessibles =
                                camping.calculaAccessosNoAccessibles();

                        System.out.println(
                                "Nombre d'accessos no accessibles: "
                                        + accessosNoAccessibles
                        );
                        break;

                    case MENU_PRINCIPAL_CALCULAR_METRES_TERRA:

                        float metresTerra = camping.calculaMetresTerra();

                        System.out.println(
                                "Metres totals dels accessos de terra: "
                                        + metresTerra
                        );
                        break;

                    case MENU_PRINCIPAL_GUARDAR:

                        System.out.print("Nom del fitxer on guardar: ");
                        String camiGuardar = sc.nextLine();

                        camping.save(camiGuardar);

                        System.out.println("Dades guardades correctament.");
                        break;

                    case MENU_PRINCIPAL_CARREGAR:

                        System.out.print("Nom del fitxer a carregar: ");
                        String camiCarregar = sc.nextLine();

                        camping = Camping.load(camiCarregar);

                        System.out.println("Dades carregades correctament.");
                        break;

                    case MENU_PRINCIPAL_SORTIR:

                        System.out.println("Fins aviat!");
                        break;
                }

            } catch (ExcepcioCamping e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: has d'introduir un número vàlid.");
            }

            System.out.println();

        } while (opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);

        sc.close();
    }
}