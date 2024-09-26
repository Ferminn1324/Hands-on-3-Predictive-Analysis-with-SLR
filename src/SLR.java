import java.util.ArrayList;
import java.util.Collections;

public class SLR {

    public static void main(String[] args) {
        ArrayList<DatosT> datos = DatosT.Benetton();

        double bestR2 = -1.0;
        double bestPendiente = 0.0;
        double bestIntercepto = 0.0;

        // Realizar el proceso de segmentación dos veces
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración " + (i + 1));
            // Segmentar datos en 70% entrenamiento y 30% prueba
            ArrayList<DatosT>[] splitData = splitData(datos, 0.7);
            ArrayList<DatosT> trainData = splitData[0];
            ArrayList<DatosT> testData = splitData[1];

            // Ajustar el modelo con los datos de entrenamiento
            double[] coefficients = fit(trainData);
            double pendiente = coefficients[0];
            double intercepto = coefficients[1];

            // Calcular R^2 en los datos de prueba
            double R2 = calculateR2(testData, pendiente, intercepto);
            System.out.println("R^2 = " + R2);

            // Actualizar el mejor modelo si R^2 es mayor
            if (R2 > bestR2) {
                bestR2 = R2;
                bestPendiente = pendiente;
                bestIntercepto = intercepto;
            }
        }

        // Mostrar el mejor modelo encontrado
        System.out.println("Mejor modelo: pendiente = " + bestPendiente + ", intercepto = " + bestIntercepto + ", con R^2 = " + bestR2);
    }

    // Método para dividir los datos en entrenamiento y prueba
    public static ArrayList<DatosT>[] splitData(ArrayList<DatosT> datos, double trainingRatio) {
        int n = datos.size();
        int trainSize = (int) (n * trainingRatio);

        // Mezclar los datos de forma aleatoria
        Collections.shuffle(datos);

        // Crear listas para los conjuntos de entrenamiento y prueba
        ArrayList<DatosT> trainData = new ArrayList<>(datos.subList(0, trainSize));
        ArrayList<DatosT> testData = new ArrayList<>(datos.subList(trainSize, n));

        return new ArrayList[]{trainData, testData};
    }

    // Método para ajustar el modelo y obtener pendiente e intercepto
    public static double[] fit(ArrayList<DatosT> datosd) {
        double sumax = 0, sumay = 0;
        double multxy = 0, cuadradox = 0;
        double n = datosd.size();
        double pendiente;
        double intercepto;

        for (DatosT p : datosd) {
            sumax += p.x;
            sumay += p.y;
            multxy += p.x * p.y;
            cuadradox += p.x * p.x;
        }

        pendiente = (n * multxy - sumax * sumay) / (n * cuadradox - sumax * sumax);
        intercepto = (sumay - pendiente * sumax) / n;

        System.out.println("Pendiente: " + pendiente);
        System.out.println("Intercepto: " + intercepto);

        return new double[]{pendiente, intercepto};
    }

    // Método para calcular el coeficiente de determinación R^2
    public static double calculateR2(ArrayList<DatosT> datos, double pendiente, double intercepto) {
        double totalSumSquares = 0.0;
        double residualSumSquares = 0.0;
        double meanY = 0.0;

        for (DatosT p : datos) {
            meanY += p.y;
        }
        meanY /= datos.size();

        for (DatosT p : datos) {
            double predictedY = pendiente * p.x + intercepto;
            totalSumSquares += Math.pow(p.y - meanY, 2);
            residualSumSquares += Math.pow(p.y - predictedY, 2);
        }

        return 1 - (residualSumSquares / totalSumSquares);
    }
}
