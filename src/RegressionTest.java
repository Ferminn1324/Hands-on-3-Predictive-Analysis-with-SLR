/*import java.util.ArrayList;

public class RegressionTest {

    public static void main(String[] args) {
        // Cargar los datos desde DatosT.Benetton()
        ArrayList<DatosT> datos = DatosT.Benetton();

        double bestR2 = -1.0;
        double bestPendiente = 0.0;
        double bestIntercepto = 0.0;

        // Realizar el proceso de segmentación dos veces
        for (int i = 0; i < 2; i++) {
            System.out.println("Iteración " + (i + 1));

            // Segmentar los datos en 70% entrenamiento y 30% prueba
            ArrayList<DatosT>[] splitData = SLR.splitData(datos, 0.7);
            ArrayList<DatosT> trainData = splitData[0];
            ArrayList<DatosT> testData = splitData[1];

            // Ajustar el modelo con los datos de entrenamiento
            double[] coefficients = SLR.fit(trainData);
            double pendiente = coefficients[0];
            double intercepto = coefficients[1];

            // Calcular R^2 en los datos de prueba
            double R2 = SLR.calculateR2(testData, pendiente, intercepto);
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
}
*/