import java.awt.Color;
import java.util.Scanner;
import graphics.Canvas;

public class Program {
    private static Canvas canvas;
    private static Function fSine = new Function() {
        public double calc(double x) { return 200 * Math.sin(Math.PI * x / 360); }
        public Color col() { return Color.red; }
    };
    private static Function fQuadratic = new Function() {
        public double calc(double x) { return (x - 200) * (x + 200) / 250; }
        public Color col() { return Color.blue; }
    };
    private static Function fLog = new Function() {
        public double calc(double x) { return 20 * Math.log(x); }
        public Color col() { return Color.darkGray; }
    };
    private static Function fCubic = new Function() {
        public double calc(double x) { return Math.pow(x, 3) / 200_000; }
        public Color col() { return Color.green; }
    };
    private static Function fStep = new Function() {
        public double calc(double x) { return (x <= -100) ? -100 : (x < 100 ? x : 100); }
        public Color col() { return Color.magenta; }
    };
    private static void plotFunctions(Function... funcs) {
        for(Function f : funcs) {
            for (int x = -360; x <= 360; x++) {
                canvas.setColor(f.col());
                canvas.plot(x, (int)f.calc(x));
            }
        }
    }

    public static void main(String[] args) {
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();

        Scanner input = new Scanner(System.in);
        System.out.print("function?> ");
        String cmd = input.nextLine();
        while(!cmd.isEmpty()) {
            switch(cmd.toUpperCase()) {
            case "S":
                plotFunctions(fSine);
                break;
            case "Q":
                plotFunctions(fQuadratic);
                break;
            case "L":
                plotFunctions(fLog);
                break;
            case "C":
                plotFunctions(fCubic);
                break;
            case "T":
                plotFunctions(fStep);
                break;
            default:
                canvas.clear();
            }
            System.out.print("function: ");
            cmd = input.nextLine();
        }
        
        canvas.close();
    }
}