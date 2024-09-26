import java.util.ArrayList;

public class DatosT {
    double x, y;

    public DatosT(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Método para cargar los datos del conjunto Benetton
    public static ArrayList<DatosT> Benetton() {
        ArrayList<DatosT> datosd = new ArrayList<>();
        datosd.add(new DatosT(108, 95));
        datosd.add(new DatosT(115, 96));
        datosd.add(new DatosT(106, 95));
        datosd.add(new DatosT(97, 97));
        datosd.add(new DatosT(95, 93));
        datosd.add(new DatosT(91, 94));
        datosd.add(new DatosT(97, 95));
        datosd.add(new DatosT(83, 93));
        datosd.add(new DatosT(83, 92));
        datosd.add(new DatosT(78, 86));
        datosd.add(new DatosT(54, 73));
        datosd.add(new DatosT(67, 80));
        datosd.add(new DatosT(56, 65));
        datosd.add(new DatosT(53, 69));
        datosd.add(new DatosT(61, 77));
        datosd.add(new DatosT(115, 96));
        datosd.add(new DatosT(81, 87));
        datosd.add(new DatosT(78, 89));
        datosd.add(new DatosT(30, 60));
        datosd.add(new DatosT(45, 63));
        datosd.add(new DatosT(99, 95));
        datosd.add(new DatosT(32, 61));
        datosd.add(new DatosT(25, 55));
        datosd.add(new DatosT(28, 56));
        datosd.add(new DatosT(90, 94));
        datosd.add(new DatosT(89, 93));

        return datosd;
    }
}
