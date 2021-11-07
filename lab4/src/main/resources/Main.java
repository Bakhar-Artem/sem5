import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main implements Runnable {

    //start coefficients
    public static final Double g = 9.81;
    public static final Double m1 = 2.5;
    public static final Double m2 = 3.;
    public static final Double l1 = 1.5;
    public static final Double l2 = 2.;
    public static final Double epsilon = 0.000001;

    public static Double[] ftu(double step, Double[] u) {
        Double[] result = new Double[4];
        result[0] = u[2];
        result[1] = u[3];
        result[2] = (-g * (2 * m1 + m2) * Math.sin(u[0]) - m2 * g * (Math.sin(u[0] - 2 * u[1])) - 2 * m2 * (l1 * Math.pow(u[2], 2) * Math.cos((u[0] - u[1]) + l2 * u[3] * u[3])) * Math.sin(u[0] - u[1])) / (l1 * (2 * m1 + m2 - m2 * Math.cos(2 * (u[0] - u[1]))));
        result[3] = (2 * Math.sin(u[0] - u[1]) * (l1 * (m1 + m2) * Math.pow(u[2], 2) + g * (m1 + m2) * Math.cos(u[0]) + l2 * m2 * Math.pow(u[3], 2) * Math.cos(u[0] - u[1]))) / (l2 * (2 * m1 + m2 - m2 * Math.cos(2 * (u[0] - u[1]))));
        return result;
    }

    public static Double[] methodEuler(Double[] u, double step) {
        Double[] result = new Double[4];
        Double[] vectorF = ftu(step, u);
        for (int i = 0; i < 4; i++) {
            result[i] = u[i] + step * vectorF[i];
        }
        return result;
    }

    public static Double[] methodTrap(Double[] u, double step) {
        Double[] result = new Double[4];
        Double[] tempU = new Double[4];
        Double[] vectorF = ftu(step, u);
        for (int i = 0; i < 4; i++) {
            tempU[i] = u[i] + step * vectorF[i];
        }
        Double[] vectorF2 = ftu(step, tempU);
        for (int i = 0; i < 4; i++) {
            result[i] = tempU[i] + (step / 2) * (vectorF2[i] + vectorF[i]);
        }
        return result;
    }

    public static Double countStepEuler(Double[] u0) {// method Euler p=1
        double startStep = 1.;
        double err1 = 1.;
        double err2 = 1.;
        while (!(Math.abs(err1) < epsilon && Math.abs(err2) < epsilon)) {
            Double[] y1 = methodEuler(u0, startStep);
            Double[] y2 = methodEuler(y1, startStep);
            Double[] y22 = methodEuler(u0, 2 * startStep);
            startStep /= 2;
            err1 = y2[0] - y22[0]; // 2^p-1=1
            err2 = y2[1] - y22[1];
        }
        System.out.println(startStep);
        return startStep;
    }

    public static Double countStepTrap(Double[] u) {
        double startStep = 1.;
        double err1 = 1.;
        double err2 = 1.;
        while (!(Math.abs(err1) < epsilon && Math.abs(err2) < epsilon)) {
            Double[] y1 = methodTrap(u, startStep);
            Double[] y2 = methodTrap(y1, startStep);
            Double[] y22 = methodEuler(u, 2 * startStep);
            startStep /= 2;
            err1 = (y2[0] - y22[0])/31; // 2^p-1=7
            err2 = (y2[1] - y22[1])/31;
        }
        System.out.println(startStep);
        return startStep;
    }

    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    @Override
    public void run() {
        double T = 10.;
        Double[] vectorU = new Double[4];//u0=a1, u1=a2,u2=v,u3=w
        //start values
        vectorU[0] = 3 * Math.PI / 2;
        vectorU[1] = Math.PI / 4;
        vectorU[2] = 2.;
        vectorU[3] = 2.;
        Double[] vectorU2 = {3 * Math.PI / 2, Math.PI / 2, 2., 2.};
/*
        double step = countStepEuler(vectorU);
        System.out.println(T/step);
        List<Double> valuesA1 = new ArrayList<>();
        valuesA1.add(vectorU[0]);
        List<Double> valuesA2 = new ArrayList<>();
        valuesA2.add(vectorU[1]);
        List<Double> steps = new ArrayList<>();
 */      steps.add(0.);
        for (double t = 0.; t < T; t += step) {
            Double[] vectorF = ftu(step, vectorU);
            for (int i = 0; i < 4; i++) {
                vectorU[i] = vectorU[i] + step * vectorF[i];
            }
            valuesA2.add(vectorU[1]);
            valuesA1.add(vectorU[0]);
            steps.add(t + step);
        }
        try (FileWriter writer = new FileWriter("values1.txt", false); FileWriter writer2 = new FileWriter("values2.txt", false); FileWriter writer3 = new FileWriter("steps.txt", false)) {
            writer.write(valuesA1.toString());
            writer2.write(valuesA2.toString());
            writer3.write(steps.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        step = countStepTrap(vectorU2);
/*
        List<Double> valuesA21 = new ArrayList<>();
        valuesA21.add(vectorU2[0]);
        List<Double> valuesA22 = new ArrayList<>();
        valuesA22.add(vectorU2[1]);
        List<Double> steps2 = new ArrayList<>();
        steps2.add(0.);
        System.out.println(T/step);
        for (double t = 0; t <= T; t += step) {
            vectorU2 = methodTrap(vectorU2, step);
            valuesA21.add(vectorU2[0]);
  */          valuesA22.add(vectorU2[1]);
            steps2.add(t + step);
        }
        try (FileWriter writer = new FileWriter("values221.txt", false); FileWriter writer2 = new FileWriter("values222.txt", false); FileWriter writer3 = new FileWriter("steps22.txt", false)) {
            writer.write(valuesA21.toString());
            writer2.write(valuesA22.toString());
            writer3.write(steps2.toString());
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}

